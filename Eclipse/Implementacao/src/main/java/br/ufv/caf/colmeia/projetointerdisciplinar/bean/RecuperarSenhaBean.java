/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.controle.GerenciadorUsuario;
import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
public class RecuperarSenhaBean implements Serializable {

    private String enderecoEmail;
    GerenciadorUsuario envioEmail;

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public RecuperarSenhaBean() {
        envioEmail = new GerenciadorUsuario();

    }

    public void sendMail() {
        String novaSenha;
        novaSenha = envioEmail.recuperarSenha(enderecoEmail);

    }

}
