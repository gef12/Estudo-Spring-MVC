/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.security;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author danilo
 */
public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        DaoUsuario recuperaUsuario = new DaoUsuario();
        Usuario usuario = recuperaUsuario.buscar(username,"email");
        UsuarioSistema user = null;
        
        if(usuario != null){
            user = new UsuarioSistema(usuario, getGrupos(usuario));
        }
        
        return user;
    }
    
    private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario){
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        System.out.println(usuario.getTipoUsuario());
        
        if (usuario.getTipoUsuario().equals(TipoUsuario.CIDADAO)){
            authorities.add(new SimpleGrantedAuthority("CIDADAO"));   
        }
        else{
            if (usuario.getTipoUsuario().equals(TipoUsuario.AGENTEADMINISTRATIVO)){
                 authorities.add(new SimpleGrantedAuthority("AGENTEADMINISTRATIVO"));   
            }
            else{
                if (usuario.getTipoUsuario().equals(TipoUsuario.AGENTEOPERACIONAL)){
                    authorities.add(new SimpleGrantedAuthority("AGENTEOPERACIONAL"));       
                }
            }
        }
        return authorities;
    }
    
}