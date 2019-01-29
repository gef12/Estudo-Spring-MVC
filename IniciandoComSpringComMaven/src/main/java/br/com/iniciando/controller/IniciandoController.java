/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CadastroDAO;
import br.com.iniciando.dominio.Cadastro;
import com.google.gson.Gson;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Acer
 */

@Controller
public class IniciandoController {
   
    //@RequestMapping("/index")
    //public String iniciando(Model model, @RequestParam("nome") String nome){
       // model.addAttribute("retorno",nome);
        //return "index";
    
   //}
    
    @RequestMapping("/index")
    public String iniciando(Model model, Cadastro cadastro){
        
        CadastroDAO dao = new CadastroDAO();
        
        try {
            dao.adiciona(cadastro);
            model.addAttribute("retorno", cadastro.getNome());
        } catch (Exception e) {
            System.out.println("e");
        }
        return "index";
    
   } 
    @RequestMapping("/cadastro")
    public String cadrastro(){
        return "cadastro";
    
    }
    
    @RequestMapping("/lista")
    public String lista(Model model){
//        CadastroDAO dao = new CadastroDAO();
//        
//        try {
//            model.addAttribute("lista", dao.busca());
//        } catch (Exception e) {
//            System.out.println("erro lista");
//        }
    
        return "exibir";
    }
    @RequestMapping("/retorno")
    public @ResponseBody String retorno() throws SQLException{
        CadastroDAO dao = new CadastroDAO();
        Gson gson = new Gson();
        
        String retorno = gson.toJson(dao.busca());
        
    return retorno;
    }
    @RequestMapping("/cadastraProfessor")
    public String cadastroProfessor(){
        
        return "cadastraProfessor";
    
    }
    @RequestMapping("/teste")
    public String teste(){
        
        return "teste";
    
    }
    
}
