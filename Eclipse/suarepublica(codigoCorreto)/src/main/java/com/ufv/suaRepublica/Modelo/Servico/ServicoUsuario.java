package com.ufv.suaRepublica.Modelo.Servico;

import com.ufv.suaRepublica.Modelo.Entidade.*;

public interface ServicoUsuario{
	public user findUserByEmail(String email);
	public user findUserByUsername(String name);
	public void saveUser(user usuario);
	public void editUser(user usuario);
	public void mergeUser(user user);
	public boolean recuperarSenha(String email);
}
