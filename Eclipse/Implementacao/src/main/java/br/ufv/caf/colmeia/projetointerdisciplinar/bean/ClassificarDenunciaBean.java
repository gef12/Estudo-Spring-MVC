/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Denuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Status;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ClassificarDenunciaBean implements Serializable {

    private List<Denuncia> listaDenuncias;
    private Denuncia denunciaSelecionada;
    private String relatoTecnico = "";
    private String prioridade = "";
    private String status = "";

    private DaoDenuncia dao = new DaoDenuncia();
    
    
    
    
    //ADICIONA UM NOVO EVENTO RELACIONADO A ALTERAÇÃO DO STATUS DA DENÚNCIA
    public void classificaDenuncia() {
        dao.realizaModificacaoDenuncia(this.denunciaSelecionada.getIdDenuncia(), this.relatoTecnico, 2, prioridade);
        relatoTecnico = "";
        prioridade = "";
        status = "";
    }
    
    //ADICIONA UM NOVO EVENTO RELACIONADO A ALTERAÇÃO DO STATUS DA DENÚNCIA
    public void executarAlteracaoDenuncia(){
        System.out.println(denunciaSelecionada.getIdDenuncia());
        
        dao.realizaModificacaoDenuncia(denunciaSelecionada.getIdDenuncia(), relatoTecnico, Status.valueOf(status).getStatus());
    
        relatoTecnico = "";
        
    }

    //RECUPERA O STATUS DA DENÚNCIA
    public String statusDenuncia(Denuncia denuncia) {
        return denuncia.getEventos().get(denuncia.getEventos().size() - 1).getStatus().name();
    }

    //RECUPERA O STATUS DA DENÚNCIA
    public String statusDenuncia() {
        if (denunciaSelecionada == null) {
            return "";
        }
        return denunciaSelecionada.getEventos().get(denunciaSelecionada.getEventos().size() - 1).getStatus().name();
    }

    //RECUEPRA A DATA DO EVENTO DE UMA DENÚNCIA
    public Date dataDenuncia(Denuncia denuncia) {
        
       
        
        return denuncia.getEventos().get(denuncia.getEventos().size() - 1).getData();
        
    }

    public List<Denuncia> getListaDenuncias() {
        return dao.buscaTodasDenuncias();
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
