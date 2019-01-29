package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private Connection conn;
    private void conectar(){
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/iniciandospring", "root", "12071993");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada. Adicione o driver nas bibliotecas.");
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);;
        } catch(SQLException e){
            System.out.println("Erro de SQL: " + e);
        }
    }
    public java.sql.Connection getConexao(){
        conectar();
        return conn;
    }
}
