/*
*------------------------------------------------------------------------------
* Copyright 2018 (C) SuaRepublica - UFV
*------------------------------------------------------------------------------
* Republica
*
* Criada em: 11/09/2018
* Equipe 4
* Autor(es): Daniel; Gabriel; Taianne; Vinícius
*
* Versionamento:
* Equipe 4 (1.0)
*------------------------------------------------------------------------------
* Copyright notice:
*------------------------------------------------------------------------------
*/

package com.ufv.suaRepublica.Modelo.Entidade;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@SuppressWarnings("deprecation")
@Entity
@Table(name= "Republica")
public class Republica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "republica_id")
	private int id;
	
	@NotEmpty(message = "*Este campo deve ser preenchido") 
    private String nome;
	
	
    private String imagem;
    
    @Lob
    private String descricao;
    
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private int lotacao;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private int qntQuartos;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private int qntBanheiros;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private int vagaGaragem;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private int qntVagas;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private boolean permiteAnimais;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    private boolean permiteFumantes;
    
    //@NotNull(message = "*Este campo deve ser preenchido") 
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Telefone telefone;
    
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
   	private Endereco endereco;
    
    @NotNull(message = "*Este campo deve ser preenchido") 
    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    @ManyToOne
	@JoinColumn(name="user_id")
	private user user;
    
    @OneToMany
    private List<Vaga> vagas;
    
    public Republica(){
    
    	  this.telefone = new Telefone();
    	  this.endereco= new Endereco();
    }
    
    public Republica(String nome, String imagem, String descricao, 
            int lotacao, int qntQuartos, int qntBanheiros, 
            int vagaGaragem, int qntVagas, boolean permiteAnimais, 
             Genero genero) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.lotacao = lotacao;
        this.qntQuartos = qntQuartos;
        this.qntBanheiros = qntBanheiros;
        this.vagaGaragem = vagaGaragem;
        this.qntVagas = qntVagas;
        this.permiteAnimais = permiteAnimais;
        this.telefone = new Telefone();
        this.endereco= new Endereco();
        this.genero = genero;
    }
    
    
    public String getCidade() {
    	return "cidade";
    }
    public void setCidade(String cidade) {
    	//this.endereco.setCidade(cidade);
    }
    
    public int getQtdVagas() {
    	//retorno vagas.size()
    	return 1;
    }
   
    
     public boolean isPermiteFumantes() {
		return permiteFumantes;
	}

	public void setPermiteFumantes(boolean permiteFumantes) {
		this.permiteFumantes = permiteFumantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	//gets
    public String getNome() {
        return this.nome;
    }
    
    public boolean getPermiteAnimais() {
        return this.permiteAnimais;    
    }
    
    public String getImagem() {
        return this.imagem;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
   
    
    public int getLotacao() {
        return this.lotacao;
    }
    
    public int getQntQuartos() {
        return this.qntQuartos;
    }
    
    public int getQntBanheiros() {
        return this.qntBanheiros;
    }
    
    public int getVagaGaragem() {
        return this.vagaGaragem;
    }
    
    public int getQntVagas() {
        return this.qntVagas;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }
    
    public Endereco getEndereco() {
    	return this.endereco;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    

    //sets 
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPermiteAnimais(boolean permiteAnimais) {
       this.permiteAnimais = permiteAnimais;    
    }
    
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    
    public void setQntQuartos(int qntQuartos) {
        this.qntQuartos = qntQuartos;
    }
    
    public void setQntBanheiros(int qntBanheiros) {
        this.qntBanheiros = qntBanheiros;
    }
    
    public void setVagaGaragem(int vagaGaragem) {
        this.vagaGaragem = vagaGaragem;
    }
    
    public void setQntVagas(int qntVagas) {
        this.qntVagas = qntVagas;
    }

    
    
   

    public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
	public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
	
    public void setTelefoneWhatsapp(String telefone) {
        this.telefone.setTelefoneWhatsapp(telefone);
    }
    
    public void setTelefoneAlternativo1(String telefone) {
        this.telefone.setTelefoneAlternativo1(telefone);
    }
    
    public void setTelefoneAlternativo2(String telefone) {
        this.telefone.setTelefoneAlternativo2(telefone);
    }
    
    public String getTelefoneWhatsapp() {
        return telefone.getTelefoneWhatsapp();
    }
    
    public String getTelefoneAlternativo1() {
        return telefone.getTelefoneAlternativo1();
    }
    
    public String getTelefoneAlternativo2() {
        return telefone.getTelefoneAlternativo2();
    }

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setBairro(String endereco) {
	       this.endereco.setBairro(endereco);
	}
	
	
	public void setComplemento(String endereco) {
	       this.endereco.setComplemento(endereco);
	}
	
	public void setEstado(String endereco) {
	       this.endereco.setEstado(endereco);
	}
	
	public void setLogradouro(String endereco) {
	       this.endereco.setLogradouro(endereco);
	}
	
	public void setMunicipio(String endereco) {
	       this.endereco.setMunicipio(endereco);
	}
	
	public void setNumero(String endereco) {
	      // this.endereco.setNumero(endereco); ????????
	}
	
   public String getBairro() {
	   return endereco.getBairro();
   }
    
   
   public String getComplemento() {
	   return endereco.getComplemento();
   }
   
   public String getEstado() {
	   return endereco.getEstado();
   }
   
   public String getLogradouro() {
	   return endereco.getLogradouro();
   }
   
   public String getMunicipio() {
	   return endereco.getMunicipio();
   }
   
   public int getNumero() {
	   return endereco.getNumero();
   }
   
}
