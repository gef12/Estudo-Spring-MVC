package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Denuncia implements Serializable {

    private long idDenuncia;
    private String descricao;
    private Visibilidade visibilidade;
    private Local local;
    private ArrayList<Evento> eventos = new ArrayList();
    
    public void criarEvento(TipoEvento tipoEvento, Usuario usuario, Date dataEvento, String descricao, Status status){
        Evento evento = new Evento();
        evento.setTipoEvento(tipoEvento);
        evento.setUsuario(usuario);
        evento.setData(dataEvento);
        evento.setDescricao(descricao);
        evento.setStatus(status);
        
        eventos.add(evento);
    }

    public long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Visibilidade getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Visibilidade visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.idDenuncia ^ (this.idDenuncia >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Denuncia other = (Denuncia) obj;
        if (this.idDenuncia != other.idDenuncia) {
            return false;
        }
        return true;
    }

    
}
