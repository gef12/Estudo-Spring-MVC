package com.ufv.suaRepublica.Modelo.Servico;

import com.ufv.suaRepublica.Modelo.Entidade.Vaga;

public interface ServicoVaga {
	public Vaga findVagaById(int id);
	public void saveVaga(Vaga republica);
	public void editVaga(Vaga republica);
}
