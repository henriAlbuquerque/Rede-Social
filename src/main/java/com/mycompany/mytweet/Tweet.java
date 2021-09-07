/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

/**
 *
 * @author henri
 */

public class Tweet{
    private String usuario;
    private String mensagem;



    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }

}
