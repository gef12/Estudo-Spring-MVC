package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;

import java.io.Serializable;

public enum Status implements Serializable {
    AGUARDANDO_APROVACAO(0),
    APROVADA(1),
    EM_ANDAMENTO(2),
    ATENDIDA(3),
    REPROVADA(4),
    CANCELADA(5);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
