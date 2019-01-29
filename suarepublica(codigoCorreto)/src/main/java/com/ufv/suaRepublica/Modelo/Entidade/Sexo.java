package com.ufv.suaRepublica.Modelo.Entidade;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name= "Sexo")
public enum Sexo {


	FEMININO, 
    MASCULINO, 
    OUTRO;
    /*
    private final String sexo;
    
  
    private Sexo(String sexo) {
        this.sexo = sexo;
    }
    
   
    public String getSexo() {
        return sexo;
    }
    

    @Override    
    public String toString() {
        return sexo;
    }*/
}
