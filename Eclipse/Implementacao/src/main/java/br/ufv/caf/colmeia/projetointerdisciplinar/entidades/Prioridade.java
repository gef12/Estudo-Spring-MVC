package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

public enum Prioridade {
    BAIXA(5),
    MEDIA(15),
    ALTA(30);
    
    private final int prioridade;

    Prioridade(int nivelPrioridade) {
        this.prioridade = nivelPrioridade;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

}
