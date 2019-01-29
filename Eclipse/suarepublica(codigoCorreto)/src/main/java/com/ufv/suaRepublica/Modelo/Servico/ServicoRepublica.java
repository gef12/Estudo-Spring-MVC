package com.ufv.suaRepublica.Modelo.Servico;

import com.ufv.suaRepublica.Modelo.Entidade.Republica;
import com.ufv.suaRepublica.Modelo.Entidade.user;

public interface ServicoRepublica {

	public Republica findRepublicaById(int id);
	public void saveRepublica(Republica republica);
	public void editRepublica(Republica republica);
}
