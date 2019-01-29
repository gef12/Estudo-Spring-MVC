package com.ufv.suaRepublica.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufv.suaRepublica.Modelo.Entidade.user;

@Repository
public interface RepositorioUsuario extends JpaRepository<user, Long> {
	 user findByEmail(String email);
	 
	 user findByNome(String username);
}
