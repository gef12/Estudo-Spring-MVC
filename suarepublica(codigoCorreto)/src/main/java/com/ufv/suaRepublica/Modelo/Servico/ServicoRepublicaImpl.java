package com.ufv.suaRepublica.Modelo.Servico;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufv.suaRepublica.Modelo.Entidade.Republica;
import com.ufv.suaRepublica.Modelo.Entidade.Role;
import com.ufv.suaRepublica.Modelo.Entidade.user;
import com.ufv.suaRepublica.Modelo.Repositorio.RepositorioRepublica;
import com.ufv.suaRepublica.Modelo.Repositorio.RepositorioUsuario;
import com.ufv.suaRepublica.Modelo.Repositorio.RoleRepository;

@Service
public class ServicoRepublicaImpl implements ServicoRepublica{

	@Autowired
	private RepositorioRepublica republicaRepository;
    
    @Autowired
    private EntityManager entityManager;
	
    
	@Override
	public Republica findRepublicaById(int id) {
		return republicaRepository.findById(id);
	}
	
	

	@Override
	public void saveRepublica(Republica republica) {
		
		republicaRepository.save(republica);
	}
	
	@Override
	@Transactional
	public void editRepublica(Republica republica) {
	
		entityManager.merge(republica);
	}

}	
	