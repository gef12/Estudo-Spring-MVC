
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Cadastro;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Acer
 */
public class CadastroDAO {
    
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("IniciandoComSpringPU");
        return factory.createEntityManager();
    
    }
    
    public void adiciona(Cadastro cadastro) throws SQLException{
        
//        Conexao conn= new Conexao();
//        String sql = "insert into cadastro(nome, endereco, telefone, email) values(?,?,?,?)";
//        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
//        
//        ps.setString(1, cadastro.getNome());
//        ps.setString(2, cadastro.getEndereco());
//        ps.setInt(3, cadastro.getTelefone());
//        ps.setString(4, cadastro.getEmail());
//        
//        ps.execute();
          EntityManager em = getEM();
          
          em.getTransaction().begin();
          em.persist(cadastro);
          em.getTransaction().commit();
          em.close();
    }
    public List<Cadastro> busca() throws SQLException{
        //List<Cadastro> lista = new ArrayList();
        new ArrayList<>();
//        Conexao conn = new Conexao();
//        
//        String sql = "select * from cadastro";
//        
//        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
//        
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            Cadastro cadastro = new Cadastro();
//            cadastro.setNome(rs.getString("nome"));
//            cadastro.setEndereco(rs.getString("endereco"));
//            cadastro.setTelefone(rs.getInt("telefone"));
//            cadastro.setEmail(rs.getString("email"));
//            lista.add(cadastro);
//        }
          EntityManager em = getEM();
          
          CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
          criteria.select(criteria.from(Cadastro.class));
          List<Cadastro> lista = em.createQuery(criteria).getResultList();
        return lista;
    
    }
    
    
    
}
