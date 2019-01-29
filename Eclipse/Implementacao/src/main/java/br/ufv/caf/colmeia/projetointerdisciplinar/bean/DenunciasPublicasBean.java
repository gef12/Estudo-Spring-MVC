/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Denuncia;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gabriel
 */
@Named
@ViewScoped
public class DenunciasPublicasBean implements Serializable {

    private List<Denuncia> listaDenuncias;
    private Denuncia denunciaSelecionada;
    
    private DaoDenuncia dao = new DaoDenuncia();
    
    //RECUPERA O STATUS DA DENÚNCIA
    public String statusDenuncia(Denuncia denuncia){
        return denuncia.getEventos().get(denuncia.getEventos().size()-1).getStatus().name();
    }
    
    //RECUEPRA A DATA DO EVENTO QUE GEROU DETERMINADA DENÚNCIA
    public Date dataDenuncia(Denuncia denuncia){
        return denuncia.getEventos().get(0).getData();
    }

    public List<Denuncia> getListaDenuncias() {
        return listaDenuncias = dao.buscaDenunciasPublicas();
    }

    public Denuncia getDenunciaSelecionada() {
        return denunciaSelecionada;
    }

    public void setDenunciaSelecionada(Denuncia denunciaSelecionada) {
        this.denunciaSelecionada = denunciaSelecionada;
    }

}
