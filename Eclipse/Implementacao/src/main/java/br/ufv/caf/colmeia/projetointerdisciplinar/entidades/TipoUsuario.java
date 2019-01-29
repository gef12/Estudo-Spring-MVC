
package br.ufv.caf.colmeia.projetointerdisciplinar.entidades;



public enum TipoUsuario {
    CIDADAO(0),
    AGENTEOPERACIONAL(1),
    AGENTEADMINISTRATIVO(2);
    
    private final int tipoUsuario;
    


    TipoUsuario(int tipo) {
        this.tipoUsuario = tipo;
    }

    public int getTiposUsuario() {
        return this.tipoUsuario;
    }
    
}
