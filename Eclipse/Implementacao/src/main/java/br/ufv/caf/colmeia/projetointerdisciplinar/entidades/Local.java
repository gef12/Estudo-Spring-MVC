package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

import java.io.Serializable;

public class Local implements Serializable {

    private String referencia;
    private float longitude;
    private float latitude;
    private Endereco endereco = new Endereco();

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
