package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "telefone_id")
	private int id;

	private String telefoneAlternativo1;
	private String telefoneAlternativo2;
    private String telefoneWhatsapp;
    
    public Telefone() {
        
    }

	public Telefone(String telefoneAlternativo1, String telefoneAlternativo2, String telefoneWhatsapp) {
		super();
		this.telefoneAlternativo1 = telefoneAlternativo1;
		this.telefoneAlternativo2 = telefoneAlternativo2;
		this.telefoneWhatsapp = telefoneWhatsapp;
	}

	public String getTelefoneAlternativo1() {
		return telefoneAlternativo1;
	}

	public void setTelefoneAlternativo1(String telefoneAlternativo1) {
		this.telefoneAlternativo1 = telefoneAlternativo1;
	}

	public String getTelefoneAlternativo2() {
		return telefoneAlternativo2;
	}

	public void setTelefoneAlternativo2(String telefoneAlternativo2) {
		this.telefoneAlternativo2 = telefoneAlternativo2;
	}

	public String getTelefoneWhatsapp() {
		return telefoneWhatsapp;
	}

	public void setTelefoneWhatsapp(String telefoneWhatsapp) {
		this.telefoneWhatsapp = telefoneWhatsapp;
	}
    
     
}
