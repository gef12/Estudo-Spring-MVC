/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.controle.GerenciadorDenuncia;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Local;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Status;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.TipoEvento;
import br.ufv.caf.colmeia.projetointerdisciplinar.util.address.buscaCEP;
import br.ufv.caf.colmeia.projetointerdisciplinar.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

@Named
@ViewScoped
public class RealizarDenunciaBean implements Serializable {

    private Local local = new Local();
    private String informacaoAdicional;
    private String informacaoEndossar;
    private String cpf;
    private boolean endossar = false;
    private boolean criar = false;
    private int idDenuncia;
    private DaoDenuncia dao;
    
    
    public RealizarDenunciaBean(){
        dao = new DaoDenuncia();
    }
    
    
    public void atualizarLocalizacao(PointSelectEvent evento) {
        LatLng localizacao = evento.getLatLng();
        local.setLatitude((float) localizacao.getLat());
        local.setLongitude((float) localizacao.getLng());
    }

    public void buscaEndereco() {
        System.out.println("Here");
        idDenuncia = new DaoDenuncia().verificaEndereco(local);
        System.out.println(idDenuncia);
        if (idDenuncia != -1) {
            cpf =    new Seguranca().getUsuario().getCpf();
            System.out.println(cpf);
            System.out.println("Endossar");
            endossar = true;
            criar = false;
        } else {
            endossar = false;
            criar = true;
        }
    }

    public void cadastrarDenuncia() {
        new GerenciadorDenuncia().criarDenuncia(local, informacaoAdicional, TipoEvento.CRIACAO, new Seguranca().getUsuario(), new Date(), informacaoAdicional, Status.AGUARDANDO_APROVACAO);
        local = new Local();
        informacaoAdicional = "";
        endossar = false;
        criar = false;
        FacesUtil.addInfoMessage("Denúncia cadastrada com sucesso");
    }

    public void buscaViaCep() {
        ArrayList<String> dadosEndereco = new ArrayList<>();
        String cep = local.getEndereco().getCep();
        System.out.println(cep);
        dadosEndereco = buscaCEP.getEndereco(cep);
        if (dadosEndereco == null) {
            FacesUtil.addErrorMessage("CEP inválido!");
        } else {
            local.getEndereco().setLogradouro(dadosEndereco.get(1));
            local.getEndereco().setBairro(dadosEndereco.get(2));
            local.getEndereco().setCidade(dadosEndereco.get(3));
            local.getEndereco().setEstado(dadosEndereco.get(4));

            for (int i = 0; i < dadosEndereco.size(); i++) {
                System.out.println(dadosEndereco.get(i));
            }
        }

    }

    public void endossar(){
        System.out.println("É hora de Endossar :D "+idDenuncia);
        dao.endossarDenuncia(idDenuncia,informacaoEndossar, cpf);
    }
    
    
    public void naoEndossar(){
        System.out.println("Não vai endossar ");
    }
    
    
    
    
    
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public boolean isEndossar() {
        return endossar;
    }

    public boolean isCriar() {
        return criar;
    }

    public String getInformacaoEndossar() {
        return informacaoEndossar;
    }

    public void setInformacaoEndossar(String informacaoEndossar) {
        this.informacaoEndossar = informacaoEndossar;
    }
    
    
    
    
    

}
