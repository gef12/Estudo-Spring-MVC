/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gabriel
 */
@Named
@RequestScoped
public class ControlePaginasBean implements Serializable {

    @Inject
    ExternalContext externalContext;

    //FAZ COM QUE O ESTILO CSS SEJA APLICADO DE FORMA CORRETA NO MENU LATERAL DE ACORDO COM A PÁGINA QUE FOI SELECIONADA
    public String getItemCssClass(String viewId) {
        FacesContext context = FacesContext.getCurrentInstance();
        String currentViewId = context.getViewRoot().getViewId();

        viewId = "/" + viewId + ".xhtml";

        return currentViewId.equals(viewId) ? "is-selected" : null;
    }

    public boolean isCidadao() {
        return externalContext.isUserInRole("CIDADAO");
    }

    public boolean isAgenteOperacional() {
        return externalContext.isUserInRole("AGENTEOPERACIONAL");
    }

    public boolean isAgenteAdministrativo() {
        return externalContext.isUserInRole("AGENTEADMINISTRATIVO");
    }

}
