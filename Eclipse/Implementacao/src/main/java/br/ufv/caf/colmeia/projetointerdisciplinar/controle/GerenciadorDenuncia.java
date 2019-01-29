/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.controle;

/**
 *
 * @author danilo
 */
import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Denuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Local;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Prioridade;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Status;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoEvento;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Visibilidade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GerenciadorDenuncia {
    
    private static long ID_COUNT;
    private DaoDenuncia dao;
    
    public GerenciadorDenuncia() {
        dao = new DaoDenuncia();
    }
    
    static {
        ID_COUNT = 0;
    }
    
    public boolean criarDenuncia(Local local, String descricaoDenuncia, TipoEvento tipoEvento, Usuario usuario, Date dataEvento, String descricaoEvento, Status status) {
        ID_COUNT++;
        Denuncia denuncia = new Denuncia();
        denuncia.setIdDenuncia(ID_COUNT);
        denuncia.setDescricao(descricaoDenuncia);
        denuncia.setVisibilidade(Visibilidade.PRIVADA);
        denuncia.setLocal(local);
        denuncia.criarEvento(tipoEvento, usuario, dataEvento, descricaoEvento, status);
        
        dao.criarDenuncia(denuncia);
        // PersistenciaDenuncia.salvaDenuncia(d); DAO
        return true;
    }
    
    public boolean excluirDenuncia(long idDenuncia) {
        Denuncia d = null;// DAO = PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (d == null) {
            return false;
        }

        //  return PersistenciaDenuncia.removeDenuncia(d);
        return false;
    }

    //Checar
    public boolean atualizarDenuncia(long idDenuncia, String cpf, String descricao, Status status, Visibilidade visibilidade) {
        Denuncia d = null;//= PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (d == null) {
            return false;
        }
        
        d.setVisibilidade(visibilidade);
        criarEventoPorDenuncia(idDenuncia, TipoEvento.CRIACAO, cpf, Calendar.getInstance().getTime(), descricao, status);
        return true;
    }
    
    public Denuncia consultarDenuncia(long idDenuncia) {
        //      return PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        return null;
    }
    
    public ArrayList<Denuncia> consultarDenuncias(String cpf) {
        //     return PersistenciaDenuncia.listaDenunciaPorUsuario(cpf);
        return null;
    }
    
    public ArrayList<Denuncia> consultarDenunciasValidadas() {
        //       return PersistenciaDenuncia.listaDenunciaValidadas();
        return null;
    }
    
    public ArrayList<Denuncia> consultarDenunciasNaoValidadas() {
//        return PersistenciaDenuncia.listaDenunciaNaoValidadas();
        return null;
    }
    
    private boolean criarEventoPorDenuncia(long idDenuncia, TipoEvento tipoEvento, String cpfUsuario, Date dataEvento, String descricao, Status status) {
        Usuario u = null;// = PersistenciaUsuario.buscaUsuario(cpfUsuario);
        Denuncia d = null; //= PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (u == null || d == null) {
            return false;
        }

        //d.criarEvento(tipoEvento, u, dataEvento, descricao, status);
        return true;
    }
    
    public boolean atualizarDenuncia(long idDenuncia, String cpf, String descricao, Status status) {
        Denuncia d = null;//= PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (d == null) {
            return false;
        }
        criarEventoPorDenuncia(idDenuncia, TipoEvento.MODIFICACAO, cpf, Calendar.getInstance().getTime(), descricao, status);
        return true;
    }
    
    public boolean atualizarDenuncia(long idDenuncia, String cpf, String descricao, Status status, Visibilidade visibilidade, Prioridade prioridade) {
        Denuncia d = null; //= PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (d == null) {
            return false;
        }
        d.setVisibilidade(visibilidade);
        criarEventoPorDenuncia(idDenuncia, TipoEvento.MODIFICACAO, cpf, Calendar.getInstance().getTime(), descricao, status);
        //PersistenciaDenuncia.buscaUltimoEvento(idDenuncia).setPrioridade(prioridade);
        return true;
    }
    
    public boolean atualizarDenuncia(long idDenuncia, String cpf, String descricao, Status status, Prioridade prioridade) {
        Denuncia d = null;// = PersistenciaDenuncia.buscaDenuncia(idDenuncia);
        if (d == null) {
            return false;
        }
        criarEventoPorDenuncia(idDenuncia, TipoEvento.MODIFICACAO, cpf, Calendar.getInstance().getTime(), descricao, status);
        //   PersistenciaDenuncia.buscaUltimoEvento(idDenuncia).setPrioridade(prioridade);
        return true;
    }
}
