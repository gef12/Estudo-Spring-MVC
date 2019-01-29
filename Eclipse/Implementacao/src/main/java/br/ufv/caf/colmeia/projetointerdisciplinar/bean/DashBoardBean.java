/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gabriel
 */
@Named
@SessionScoped
public class DashBoardBean implements Serializable {
    
    private Date atualizacao = new Date();

    //RECUPERA DATA EM QUE O USUÁRIO EFETOU O LOGIN
    public String getAtualizacao() {
        return  new SimpleDateFormat("dd/MM/yyyy HH:mm").format(atualizacao);
    }

}
