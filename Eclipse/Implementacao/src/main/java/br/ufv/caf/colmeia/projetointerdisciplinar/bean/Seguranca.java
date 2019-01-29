/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.security.UsuarioSistema;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author gabriel
 */
@Named
@RequestScoped
public class Seguranca implements Serializable {
    
    private Usuario usuario;

    public Usuario getUsuario() {
        usuario = null;

        UsuarioSistema usuarioLogado = getUsuarioLogado();

        if (usuarioLogado != null) {
            usuario = usuarioLogado.getUsuario();
        }

        return usuario;
    }

    private UsuarioSistema getUsuarioLogado() {
        UsuarioSistema user = null;

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

        if (auth != null && auth.getPrincipal() != null) {
            user = (UsuarioSistema) auth.getPrincipal();
        }

        return user;
    }

}
