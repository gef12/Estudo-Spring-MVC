/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.controle.GerenciadorUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Telefone;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.security.Cripto;
import br.ufv.caf.colmeia.projetointerdisciplinar.util.jsf.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@ViewScoped
public class CadastraCidadaoBean implements Serializable {

    private GerenciadorUsuario gerenciadoraCadastro;
    private Usuario usuarioCadastravel;
    private String telefone;

    public CadastraCidadaoBean() {
        gerenciadoraCadastro = new GerenciadorUsuario();
        usuarioCadastravel = new Usuario();
        usuarioCadastravel.setTipoUsuario(TipoUsuario.CIDADAO);
    }

    public void cadastrar() throws IOException {
        Telefone tel1 = new Telefone();
        usuarioCadastravel.getTelefone().setTelefone(telefone);
        usuarioCadastravel.setSenha(Cripto.md5(usuarioCadastravel.getSenha()));
        int acao = 0;
        acao = gerenciadoraCadastro.adicionarUsuario(usuarioCadastravel);
        switch (acao) {
            case 0:
                FacesUtil.addErrorMessage("Usuário Já existente");
                break;
            case 1:
                // Usuário Criado com Sucesso
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?save=sucess");
                break;
        }
    }

    public GerenciadorUsuario getGerenciadoraCadastro() {
        return gerenciadoraCadastro;
    }

    public void setGerenciadoraCadastro(GerenciadorUsuario gerenciadoraCadastro) {
        this.gerenciadoraCadastro = gerenciadoraCadastro;
    }

    public Usuario getUsuarioCadastravel() {
        return usuarioCadastravel;
    }

    public void setUsuarioCadastravel(Usuario usuarioCadastravel) {
        this.usuarioCadastravel = usuarioCadastravel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
