package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name= "Genero")
public enum  Genero {

	FEMININO  ,
    MASCULINO ,
    MISTO    ,
    OUTRO   ;
   /* 
    private final String genero;
    
   
    private Genero(String genero) {
        this.genero = genero;
    }
    
    
    public String getGenero() {
        return genero;
    }
    
    
    @Override    
    public String toString() {
        return genero;
    }
    */
}
