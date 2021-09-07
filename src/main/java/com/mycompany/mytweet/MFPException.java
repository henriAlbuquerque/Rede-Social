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
public class MFPException extends Exception {
    
    public MFPException(){
        super("Qtd de caracteres deve estar entre 1 e 140");
    }
    
}
