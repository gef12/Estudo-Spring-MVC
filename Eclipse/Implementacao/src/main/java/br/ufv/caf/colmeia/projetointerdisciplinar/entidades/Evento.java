package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {

    private Date data;
    private String descricao;
    private Status status;
    private Usuario usuario;
    private Prioridade prioridade;
    private TipoEvento tipoEvento;

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
