/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dominio;

/**
 *
 * @author Acer
 */
import java.util.Date;
  
public class Cliente {
      
     private String nome;
     private String cpf;
     private String rg;
     private String telefone;
     private String endereco;
     private String descricao;
     private String profissao;
     private Date dataNascimento;
     private float salario;
      
     public String getNome() {
          return nome;
     }
      
     public void setNome(String nome) {
          this.nome = nome;
     }
      
     public String getCpf() {
          return cpf;
     }
      
     public void setCpf(String cpf) {
          this.cpf = cpf;
     }
      
     public String getTelefone() {
          return telefone;
     }
      
     public void setTelefone(String telefone) {
          this.telefone = telefone;
     }
      
     public String getEndereco() {
          return endereco;
     }
      
     public void setEndereco(String endereco) {
          this.endereco = endereco;
     }
      
     public String getDescricao() {
          return descricao;
     }
      
     public void setDescricao(String descricao) {
          this.descricao = descricao;
     }
  
     public String getRg() {
          return rg;
     }
  
     public void setRg(String rg) {
          this.rg = rg;
     }
  
     public Date getDataNascimento() {
          return dataNascimento;
     }
  
     public void setDataNascimento(Date dataNascimento) {
          this.dataNascimento = dataNascimento;
     }
  
     public float getSalario() {
          return salario;
     }
  
     public void setSalario(float salario) {
          this.salario = salario;
     }
  
     public String getProfissao() {
          return profissao;
     }
  
     public void setProfissao(String profissao) {
          this.profissao = profissao;
     }
  
}
    

