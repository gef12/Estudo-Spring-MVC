package com.ufv.suaRepublica.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ufv.suaRepublica.Modelo.Entidade.Vaga;

public interface RepositorioVaga extends JpaRepository<Vaga, Integer>{
	
	@Query(value = "SELECT * FROM vaga", nativeQuery = true)
	Vaga getVagaRepository();
	Vaga findById(int id);
}
