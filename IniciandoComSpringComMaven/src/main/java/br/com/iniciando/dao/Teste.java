/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Cadastro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Teste {
    
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        CadastroDAO dao = new CadastroDAO();
        
        cadastro.setNome("gerferson");
        cadastro.setEndereco("eda");
        cadastro.setTelefone(12345);
        cadastro.setEmail("eda@gmail");
        
        try {
            dao.adiciona(cadastro);
        } catch (SQLException e) {
            System.out.println("erro");
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
