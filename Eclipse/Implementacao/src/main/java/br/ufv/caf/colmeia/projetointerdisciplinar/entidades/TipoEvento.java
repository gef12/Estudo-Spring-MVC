package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

public enum TipoEvento {
    CRIACAO(0),
    MODIFICACAO(1),
    ENDOSSAMENTO(2);
    
    private final int tipoEvento;

    TipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getTipoEvento() {
        return this.tipoEvento;
    }
}
