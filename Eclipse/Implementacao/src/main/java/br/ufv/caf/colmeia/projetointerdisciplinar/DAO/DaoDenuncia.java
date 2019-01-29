package br.ufv.caf.colmeia.projetointerdisciplinar.DAO;

import br.ufv.caf.colmeia.projetointerdisciplinar.bean.Seguranca;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Denuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Endereco;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Evento;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Local;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Prioridade;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Status;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Telefone;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoEvento;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Visibilidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class DaoDenuncia {

    private Connection conexao;
    private int idUsuario;
    private int idTelefone;

    public DaoDenuncia() {
        conexao = new ConnectionFactory().getConnection();
    }

    //RECUPERA LISTA DE EVENTOS DE UMA DETERMINADA DENÚNCIA
    public ArrayList<Evento> listaEventos(long idDenuncia) {
        ArrayList<Evento> eventos = new ArrayList();
        try {//                         1                       2                           3               4                  5                 6                 7                    8                          9                 10         11               12         
            String query = "select FK_Denuncia_IDDenuncia, TB_Usuario.TipoUsuario, TB_Usuario.Nome, TB_Usuario.PK_CPF, TB_Usuario.Email, TB_Usuario.Senha, TB_Usuario.Telefone, TB_Prioridade.Prioridade, TB_TipoEvento.TipoEvento, Data, TB_Evento.Descricao, TB_Status.Descricao from TB_Evento join TB_Status on FK_Status_IDStatus = PK_IDStatus join TB_Usuario on FK_Usuario_CPFUsuario = PK_CPF join TB_Prioridade on FK_Prioridade_IDPrioridade = PK_IDPrioridade join TB_TipoEvento on FK_TipoEvento_IDTipoEvento = PK_IDTipoEvento where FK_Denuncia_IDDenuncia = :idDenuncia";
            query = query.replace(":idDenuncia", Long.toString(idDenuncia));
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next() != false) {
                //USUARIO
                Usuario usuario = new Usuario();
                usuario.setTipoUsuario(TipoUsuario.valueOf(resultado.getString(2)));
                usuario.setNome(resultado.getString(3));
                usuario.setCpf(resultado.getString(4));
                usuario.setEmail(resultado.getString(5));
                usuario.setSenha(resultado.getString(6));
                //TELEFONE
                Telefone telefone = new Telefone();
                telefone.setTelefone(resultado.getString(7));
                //USUARIO
                usuario.setTelefone(telefone);

                //EVENTO
                Evento evento = new Evento();
                evento.setPrioridade(Prioridade.valueOf(resultado.getString(8)));
                evento.setTipoEvento(TipoEvento.valueOf(resultado.getString(9)));
                evento.setData(resultado.getDate(10));
                evento.setDescricao(resultado.getString(11));
                evento.setUsuario(usuario);
                evento.setStatus(Status.valueOf(resultado.getString(12)));

                eventos.add(evento);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }

    //RECUPERA TODAS AS DENÚNCIAS
    public ArrayList<Denuncia> buscaTodasDenuncias() {
        ArrayList<Denuncia> denuncias = new ArrayList();
        try {//                         1               2                           3                         4       5       6       7       8     9        10         11         12        13
            String query = "select PK_IDDenuncia, TB_Denuncia.Descricao, TB_Visibilidade.Visibilidade, Logradouro, Numero, Bairro, Cidade, Estado, Cep, Complemento, Referencia, Longitude, Latitude from TB_Denuncia join TB_Visibilidade on TB_Denuncia.FK_Visibilidade_IDVisibilidade = PK_IDVisibilidade join TB_Local on FK_Local_IDLocal = PK_IDLocal join TB_Endereco on FK_Endereco_IDEndereco = PK_IDEndereco";
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next() != false) {
                //ENDERECO
                Endereco endereco = new Endereco();
                endereco.setLogradouro(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setBairro(resultado.getString(6));
                endereco.setCidade(resultado.getString(7));
                endereco.setEstado(resultado.getString(8));
                endereco.setCep(resultado.getString(9));
                endereco.setComplemento(resultado.getString(10));

                //LOCAL
                Local local = new Local();
                local.setEndereco(endereco);
                local.setReferencia(resultado.getString(11));
                local.setLongitude(resultado.getFloat(12));
                local.setLatitude(resultado.getFloat(13));

                Denuncia denuncia = new Denuncia();
                denuncia.setIdDenuncia(resultado.getLong(1));
                denuncia.setDescricao(resultado.getString(2));
                denuncia.setVisibilidade(Visibilidade.valueOf(resultado.getString(3)));
                denuncia.setEventos(listaEventos(denuncia.getIdDenuncia()));
                denuncia.setLocal(local);

                denuncias.add(denuncia);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return denuncias;
    }

    //RECUPERA TODAS DENÚNCIAS QUE ESTÃO COM STATUS AGUARDANDO_APROVAÇÃO
    public ArrayList<Denuncia> buscaDenunciasAguardandoAprovacao() {
        ArrayList<Denuncia> denuncias = new ArrayList();
        try {//                         1               2                           3                         4       5       6       7       8     9        10         11         12        13
            String query = "select PK_IDDenuncia, TB_Denuncia.Descricao, TB_Visibilidade.Visibilidade, Logradouro, Numero, Bairro, Cidade, Estado, Cep, Complemento, Referencia, Longitude, Latitude from TB_Denuncia join TB_Visibilidade on TB_Denuncia.FK_Visibilidade_IDVisibilidade = PK_IDVisibilidade join TB_Local on FK_Local_IDLocal = PK_IDLocal join TB_Endereco on FK_Endereco_IDEndereco = PK_IDEndereco";
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next() != false) {
                //ENDERECO
                Endereco endereco = new Endereco();
                endereco.setLogradouro(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setBairro(resultado.getString(6));
                endereco.setCidade(resultado.getString(7));
                endereco.setEstado(resultado.getString(8));
                endereco.setCep(resultado.getString(9));
                endereco.setComplemento(resultado.getString(10));

                //LOCAL
                Local local = new Local();
                local.setEndereco(endereco);
                local.setReferencia(resultado.getString(11));
                local.setLongitude(resultado.getFloat(12));
                local.setLatitude(resultado.getFloat(13));

                Denuncia denuncia = new Denuncia();
                denuncia.setIdDenuncia(resultado.getLong(1));
                denuncia.setDescricao(resultado.getString(2));
                denuncia.setVisibilidade(Visibilidade.valueOf(resultado.getString(3)));
                denuncia.setEventos(listaEventos(denuncia.getIdDenuncia()));
                denuncia.setLocal(local);

                int cont = 0;
                for (int i = 0; i < denuncia.getEventos().size(); i++) {
                    if (denuncia.getEventos().get(i).getStatus().getStatus() != Status.AGUARDANDO_APROVACAO.getStatus()) {
                        cont++;
                    }
                }
                
                if (cont == 0) {
                    denuncias.add(denuncia);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return denuncias;
    }

    //RECUPERA TODOS AS DENÚNCIAS DE UM DETERMINADO USUÁRIO
    public ArrayList<Denuncia> buscaDenunciaPorUsuario(String cpfUsuario) {
        ArrayList<Denuncia> denuncias = new ArrayList();
        try {//                         1               2                           3                         4       5       6       7       8     9        10         11         12        13
            String query = "select PK_IDDenuncia, TB_Denuncia.Descricao, TB_Visibilidade.Visibilidade, Logradouro, Numero, Bairro, Cidade, Estado, Cep, Complemento, Referencia, Longitude, Latitude from TB_Denuncia join TB_Visibilidade on TB_Denuncia.FK_Visibilidade_IDVisibilidade = PK_IDVisibilidade join TB_Local on FK_Local_IDLocal = PK_IDLocal join TB_Endereco on FK_Endereco_IDEndereco = PK_IDEndereco";
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next() != false) {
                //ENDERECO
                Endereco endereco = new Endereco();
                endereco.setLogradouro(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setBairro(resultado.getString(6));
                endereco.setCidade(resultado.getString(7));
                endereco.setEstado(resultado.getString(8));
                endereco.setCep(resultado.getString(9));
                endereco.setComplemento(resultado.getString(10));

                //LOCAL
                Local local = new Local();
                local.setEndereco(endereco);
                local.setReferencia(resultado.getString(11));
                local.setLongitude(resultado.getFloat(12));
                local.setLatitude(resultado.getFloat(13));

                Denuncia denuncia = new Denuncia();
                denuncia.setIdDenuncia(resultado.getLong(1));
                denuncia.setDescricao(resultado.getString(2));
                denuncia.setVisibilidade(Visibilidade.valueOf(resultado.getString(3)));
                denuncia.setEventos(listaEventos(denuncia.getIdDenuncia()));
                denuncia.setLocal(local);

                for (int i = 0; i < denuncia.getEventos().size(); i++) {
                    if (denuncia.getEventos().get(i).getUsuario().getCpf().equals(cpfUsuario)) {
                        denuncias.add(denuncia);
                        break;
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return denuncias;
    }

    //RECUPERA TODAS AS DENÚNCIAS PÚBLICAS
    public ArrayList<Denuncia> buscaDenunciasPublicas() {
        ArrayList<Denuncia> denuncias = new ArrayList();
        try {//                         1               2                           3                         4       5       6       7       8     9        10         11         12        13
            String query = "select PK_IDDenuncia, TB_Denuncia.Descricao, TB_Visibilidade.Visibilidade, Logradouro, Numero, Bairro, Cidade, Estado, Cep, Complemento, Referencia, Longitude, Latitude from TB_Denuncia join TB_Visibilidade on TB_Denuncia.FK_Visibilidade_IDVisibilidade = PK_IDVisibilidade join TB_Local on FK_Local_IDLocal = PK_IDLocal join TB_Endereco on FK_Endereco_IDEndereco = PK_IDEndereco where FK_Visibilidade_IDVisibilidade = 1";
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next() != false) {
                //ENDERECO
                Endereco endereco = new Endereco();
                endereco.setLogradouro(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setBairro(resultado.getString(6));
                endereco.setCidade(resultado.getString(7));
                endereco.setEstado(resultado.getString(8));
                endereco.setCep(resultado.getString(9));
                endereco.setComplemento(resultado.getString(10));

                //LOCAL
                Local local = new Local();
                local.setEndereco(endereco);
                local.setReferencia(resultado.getString(11));
                local.setLongitude(resultado.getFloat(12));
                local.setLatitude(resultado.getFloat(13));

                Denuncia denuncia = new Denuncia();
                denuncia.setIdDenuncia(resultado.getLong(1));
                denuncia.setDescricao(resultado.getString(2));
                denuncia.setVisibilidade(Visibilidade.valueOf(resultado.getString(3)));
                denuncia.setEventos(listaEventos(denuncia.getIdDenuncia()));
                denuncia.setLocal(local);

                denuncias.add(denuncia);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return denuncias;
    }

    public ArrayList<Date> buscaDatasDenuncias() {
        ArrayList<Date> listaDatas = new ArrayList();

        String comando = "SELECT E.Data FROM TB_Denuncia AS D LEFT JOIN TB_Evento AS E ON D.PK_IDDenuncia = E.FK_Denuncia_IDDenuncia WHERE E.FK_TipoEvento_IDTipoEvento = 1";
        PreparedStatement stmt;

        try {
            stmt = conexao.prepareStatement(comando);

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                //Endereco endereco = new Endereco(resultado.getString(10), resultado.getInt(11),resultado.getString(12), resultado.getString(13), resultado.getString(14), resultado.getString(15));

                listaDatas.add(resultado.getDate(1));
                //resultado.next();
            }
            // total = resultado.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDatas;

    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void realizaModificacaoDenuncia(long IDDenuncia, String descricao, int status) {

        //GregorianCalendar calendario = new GregorianCalendar();
        //  Date data = new Date(System.currentTimeMillis());
        try {
            String comando = "INSERT INTO TB_Evento (FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) VALUES (" + status + ", '" + new Seguranca().getUsuario().getCpf() + "', 5, 2, " + IDDenuncia + ", '" + getDateTime() + "', '" + descricao + "')";
            //String comando = "INSERT INTO TB_Evento (FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) VALUES (1, '123.456.789-00', 5, 2, 1, '2020-08-29', 'testando')";

            PreparedStatement stmt;
            stmt = conexao.prepareStatement(comando);

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void realizaModificacaoDenuncia(long IDDenuncia, String descricao, int status, String prioridade) {

        //GregorianCalendar calendario = new GregorianCalendar();
        //  Date data = new Date(System.currentTimeMillis());
        String comando = "INSERT INTO TB_Evento (FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) VALUES (" + status + ", '" + new Seguranca().getUsuario().getCpf() + "'," + prioridade + ", 2, " + IDDenuncia + ", '" + getDateTime() + "', '" + descricao + "')";
        //String comando = "INSERT INTO TB_Evento (FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) VALUES (1, '123.456.789-00', 5, 2, 1, '2020-08-29', 'testando')";

        PreparedStatement stmt;

        try {
            stmt = conexao.prepareStatement(comando);

            stmt.execute();

            // total = resultado.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean endossarDenuncia(int idDenuncia, String Descricao, String cpf) {
        int FK_Prioridade_IDPrioridade = -1, FK_Status_IDStatus = -1;
        try {
            String query = "SELECT FK_Status_IDStatus, FK_Prioridade_IDPrioridade "
                    + " FROM TB_Denuncia JOIN TB_Evento ON PK_IDDenuncia = FK_Denuncia_IDDenuncia "
                    + " WHERE Data = (SELECT MAX(Data) "
                    + " FROM TB_Denuncia JOIN TB_Evento ON PK_IDDenuncia = FK_Denuncia_IDDenuncia "
                    + " WHERE PK_IDDenuncia = :iddenuncia );";
            query = query.replace(":iddenuncia", Integer.toString(idDenuncia));
            PreparedStatement statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                FK_Status_IDStatus = resultado.getInt(1);
                FK_Prioridade_IDPrioridade = resultado.getInt(2);
            }

            String query2 = "INSERT INTO TB_Evento(FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) "
            + " VALUES(:idstatus, ':idusuario', :idprioridade, 3, :iddenuncia, ':data', ':descricao') ;";
            query2 = query2.replace(":idstatus", Integer.toString(FK_Status_IDStatus));
            query2 = query2.replace(":idusuario", cpf);
            query2 = query2.replace(":idprioridade", Integer.toString(FK_Prioridade_IDPrioridade));
            query2 = query2.replace(":iddenuncia", Integer.toString(idDenuncia));
            query2 = query2.replace(":data", getDateTime());
            query2 = query2.replace(":descricao", Descricao);
            PreparedStatement statement2 = conexao.prepareStatement(query2);
            statement2.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean criarDenuncia(Denuncia denuncia) {
        int idEndereco = -1;
        int idLocal = -1;
        int idDenuncia = -1;
        ResultSet resultado;
        try {
            String query = "INSERT INTO TB_Endereco (Logradouro, Numero, Bairro, Cidade, Estado, Cep, Complemento) "
                    + "VALUES (':logradouro', :numero, ':bairro', ':cidade', ':estado', ':cep', ':complemento') ;";
            query = query.replace(":logradouro", denuncia.getLocal().getEndereco().getLogradouro());
            query = query.replace(":numero", Integer.toString(denuncia.getLocal().getEndereco().getNumero()));
            query = query.replace(":bairro", denuncia.getLocal().getEndereco().getBairro());
            query = query.replace(":cidade", denuncia.getLocal().getEndereco().getCidade());
            query = query.replace(":estado", denuncia.getLocal().getEndereco().getEstado());
            query = query.replace(":cep", denuncia.getLocal().getEndereco().getCep());
            query = query.replace(":complemento", denuncia.getLocal().getReferencia());
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            statement.executeUpdate();

            String query2 = "SELECT MAX(PK_IDEndereco) FROM TB_Endereco;";
            PreparedStatement statement2;
            statement2 = conexao.prepareStatement(query2);
            resultado = statement2.executeQuery();
            while (resultado.next()) {
                idEndereco = resultado.getInt(1);
            }

            String query3 = "INSERT INTO TB_Local (FK_Endereco_IDEndereco, Referencia, Longitude, Latitude) "
                    + " VALUES (:idendereco, ':referencia', :longitude, :latitude) ;";
            query3 = query3.replace(":idendereco", Integer.toString(idEndereco));
            query3 = query3.replace(":referencia", denuncia.getLocal().getReferencia());
            query3 = query3.replace(":longitude", Float.toString(denuncia.getLocal().getLongitude()));
            query3 = query3.replace(":latitude", Float.toString(denuncia.getLocal().getLatitude()));

            PreparedStatement statement3;
            statement3 = conexao.prepareStatement(query3);
            statement3.executeUpdate();

            String query4 = "SELECT MAX(PK_IDLocal) FROM TB_Local;";
            PreparedStatement statement4 = conexao.prepareStatement(query4);
            resultado = statement4.executeQuery();
            while (resultado.next()) {
                idLocal = resultado.getInt(1);
            }

            String query5 = "INSERT INTO TB_Denuncia (FK_Local_IDLocal, FK_Visibilidade_IDVisibilidade, Descricao) "
                    + " VALUES (:idlocal, :visibilidade, ':descricao') ;";
            query5 = query5.replace(":idlocal", Integer.toString(idLocal));
            query5 = query5.replace(":visibilidade", Integer.toString(denuncia.getVisibilidade().getVisibilidade()));
            query5 = query5.replace(":descricao", denuncia.getDescricao());
            PreparedStatement statement5 = conexao.prepareStatement(query5);
            statement5.executeUpdate();

            String query6 = "SELECT MAX(PK_IDDenuncia) FROM TB_Denuncia;";
            PreparedStatement statement6 = conexao.prepareStatement(query6);
            resultado = statement6.executeQuery();
            while (resultado.next()) {
                idDenuncia = resultado.getInt(1);
            }

            String query7 = "INSERT INTO TB_Evento(FK_Status_IDStatus, FK_Usuario_CPFUsuario, FK_Prioridade_IDPrioridade, FK_TipoEvento_IDTipoEvento, FK_Denuncia_IDDenuncia, Data, Descricao) "
                    + " VALUES (0,':cpfusuario', 5,1, :iddenuncia, ':data', ':descricao') ;";
            query7 = query7.replace(":cpfusuario", denuncia.getEventos().get(denuncia.getEventos().size() - 1).getUsuario().getCpf());
            query7 = query7.replace(":iddenuncia", Integer.toString(idDenuncia));
            query7 = query7.replace(":data", getDateTime());
            query7 = query7.replace(":descricao", denuncia.getDescricao());
            PreparedStatement statement7 = conexao.prepareStatement(query7);
            statement7.executeUpdate();
            return true;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public int verificaEndereco(Local l) {
        int idDenuncia = -1;
        try {
            String query = "SELECT PK_IDDenuncia "
                    + "FROM TB_Local "
                    + "JOIN TB_Denuncia ON FK_Local_IDLocal = PK_IDLocal "
                    + "JOIN TB_Endereco ON FK_Endereco_IDEndereco = PK_IDEndereco "
                    + "WHERE Logradouro = ':logradouro' "
                    + "AND Numero = :numero "
                    + "AND Bairro = ':bairro' "
                    + "AND Cidade = ':cidade' "
                    + "AND Estado = ':estado' "
                    + "AND Cep = ':cep'  ;";

            query = query.replace(":logradouro", l.getEndereco().getLogradouro());
            query = query.replace(":numero", Integer.toString(l.getEndereco().getNumero()));
            query = query.replace(":bairro", l.getEndereco().getBairro());
            query = query.replace(":cidade", l.getEndereco().getCidade());
            query = query.replace(":estado", l.getEndereco().getEstado());
            query = query.replace(":cep", l.getEndereco().getCep());
            System.out.println(query);
            PreparedStatement statement;
            statement = conexao.prepareStatement(query);
            ResultSet response = statement.executeQuery();
            if (response.next() != false) {
                System.out.println(response.getInt("PK_IDDenuncia"));
                idDenuncia = response.getInt("PK_IDDenuncia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idDenuncia;
    }
}
