package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

public enum Visibilidade {
    PUBLICA(1),
    PRIVADA(2);
    
    private final int visibilidade;
    
    Visibilidade(int visibilidade){
        this.visibilidade = visibilidade;
    }

    public int getVisibilidade() {
        return visibilidade;
    }
}
