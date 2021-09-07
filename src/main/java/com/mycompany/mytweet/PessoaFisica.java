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

public class PessoaFisica extends Perfil{

    private long cpf;

    public PessoaFisica(String usuario){
        super(usuario);
    }

    public void setCpf(long cpf){
        this.cpf = cpf;
    }

    public float getCpf(){
        return this.cpf;
    }
    
}