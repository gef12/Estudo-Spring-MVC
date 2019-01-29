package com.ufv.suaRepublica.Modelo.Servico;

import com.ufv.suaRepublica.Modelo.Entidade.Republica;
import com.ufv.suaRepublica.Modelo.Entidade.Vaga;
import com.ufv.suaRepublica.Modelo.Repositorio.RepositorioVaga;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoVagaImpl implements ServicoVaga{
	
	@Autowired
	private RepositorioVaga vagaRepository;
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
	public Vaga findVagaById(int id) {
		return vagaRepository.findById(id);
	}
	
	

	@Override
	public void saveVaga(Vaga vaga) {
		
		vagaRepository.save(vaga);
	}
	
	@Override
	@Transactional
	public void editVaga(Vaga vaga) {
	
		entityManager.merge(vaga);
	}
	
}
