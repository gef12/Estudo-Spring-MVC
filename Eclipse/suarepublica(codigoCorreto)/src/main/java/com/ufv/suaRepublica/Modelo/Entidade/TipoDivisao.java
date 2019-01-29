package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name= "TipoDivisao")
public enum TipoDivisao {
	
	INDIVIDUAL,
    DUPLA,
    TRIO,
    QUARTETO,
    QUINTETO;

   /* private String tipoDivisao;
    private int tipoDivisaoNumber;

    private TipoDivisao(String tipoDivisao, int tipoDivisaoNumber) {
        this.tipoDivisao = tipoDivisao;
        this.tipoDivisaoNumber = tipoDivisaoNumber;
    }
   
    //get
    public int getTipoDivisao() { return this.tipoDivisaoNumber; }

    public String toString() { return this.tipoDivisao; } 
    */
}
