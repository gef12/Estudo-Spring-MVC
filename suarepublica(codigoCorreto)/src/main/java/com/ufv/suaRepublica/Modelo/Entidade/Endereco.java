package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Endereco")
public class Endereco {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "endereco_id")
		private int id;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	 	private String estado;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	    private String municipio;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	    private String bairro;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	    private String logradouro;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	    private int numero;
		
		@NotNull(message = "*Este campo deve ser preenchido") 
	    private String complemento;
		

	    public Endereco() {}

	    public Endereco(String estado, String municipio, String bairro,
	                    String logradouro, int numero, String complemento) {
	        this.estado = estado;
	        this.municipio = municipio;
	        this.bairro = bairro;
	        this.logradouro = logradouro;
	        this.numero = numero;
	        this.complemento = complemento;
	        
	    }

	    //Gets
	    public String getEstado() { return this.estado; }
	    public String getMunicipio() { return this.municipio; }
	    public String getBairro() { return this.bairro; }
	    public String getLogradouro() { return this.logradouro; }
	    public int getNumero() { return this.numero; }
	    public String getComplemento() { return this.complemento; }
	    

	    //Sets
	    public void setEstado(String estado) { this.estado = estado; }
	    public void setMunicipio(String municipio) { this.municipio = municipio; }
	    public void setBairro(String bairro) { this.bairro = bairro; }
	    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
	    public void setNumero(int numero) { this.numero = numero; }
	    public void setComplemento(String complemento) { this.complemento = complemento; }
	  

}
