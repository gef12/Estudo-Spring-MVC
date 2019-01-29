/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Denuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gabriel
 */
@Named
@ViewScoped
public class ValidarDenunciaBean implements Serializable {

    private ArrayList<Denuncia> listaDenuncias;
    private Denuncia denunciaSelecionada;
    private String relatoTecnico;
    private String status;

    private DaoDenuncia dao = new DaoDenuncia();
    
    //ADICIONA UM NOVO EVENTO RELACIONADO A ALTERAÇÃO DO STATUS DA DENÚNCIA
    public void executarAlteracaoDenuncia(){
        for(int i=0; i<denunciaSelecionada.getEventos().size(); i++){
            dao.realizaModificacaoDenuncia(denunciaSelecionada.getIdDenuncia(), relatoTecnico, Status.valueOf(status).getStatus());
        }
        relatoTecnico = "";
    }
    
    //RECUPERA O STATUS DA DENÚNCIA
    public String statusDenuncia(Denuncia denuncia){
        return denuncia.getEventos().get(denuncia.getEventos().size()-1).getStatus().name();
    }
    
    //RECUEPRA A DATA DO EVENTO DE UMA DENÚNCIA
    public Date dataDenuncia(Denuncia denuncia){
        return denuncia.getEventos().get(denuncia.getEventos().size()-1).getData();
    }

    public ArrayList<Denuncia> getListaDenuncias() {
        return dao.buscaDenunciasAguardandoAprovacao();
    }

    public Denuncia getDenunciaSelecionada() {
        return denunciaSelecionada;
    }

    public void setDenunciaSelecionada(Denuncia denunciaSelecionada) {
        this.denunciaSelecionada = denunciaSelecionada;
    }

    public String getRelatoTecnico() {
        return relatoTecnico;
    }

    public void setRelatoTecnico(String relatoTecnico) {
        this.relatoTecnico = relatoTecnico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
