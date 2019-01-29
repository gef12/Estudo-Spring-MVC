package com.ufv.suaRepublica.Modelo.Repositorio;

import org.springframework.data.repository.CrudRepository;

import com.ufv.suaRepublica.Modelo.Entidade.user;

public interface EventosRepository extends CrudRepository<user, String>{
	//Ja usa metodos ja prontos de deletar, inserir, update
	
	
}