package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("deprecation")
@Entity
@Table(name= "Vaga")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vaga_id")
	private int id;
	
	@Lob
	private String descricao;
	
	@NotNull(message = "*Este campo deve ser preenchido") 
    private boolean suite;
	
	@NotNull(message = "*Este campo deve ser preenchido") 
    private float valorDespesas;
	
	@NotNull(message = "*Este campo deve ser preenchido") 
    private int qtdVagasGaragem;
	
	
    private TipoDivisao divisao;
	
	
    public Vaga() {}

    public Vaga(String descricao, boolean suite, float valorDespesas,
                int qtdVagasGaragem, TipoDivisao divisao) {
        this.descricao = descricao;
        this.suite = suite;
        this.valorDespesas = valorDespesas;
        this.qtdVagasGaragem = qtdVagasGaragem;
        this.divisao = divisao;
    }

    //gets
    public String getDescricao() { return this.descricao; }
    public boolean getSuite() { return this.suite; }
    public float getValorDespesas() { return this.valorDespesas; }
    public int getQtdVagasGaragem() { return this.qtdVagasGaragem; }
    public TipoDivisao getDivisao() { return this.divisao; }

    //sets
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setSuite(boolean suite) { this.suite = suite; }
    public void setValorDespesas(float valorDespesas) { this.valorDespesas = valorDespesas; }
    public void setQtdVagasGaragem(int qtdVagasGaragem) { this.qtdVagasGaragem = qtdVagasGaragem; }
    public void setDivisao(TipoDivisao divisao) { this.divisao = divisao; }
}
