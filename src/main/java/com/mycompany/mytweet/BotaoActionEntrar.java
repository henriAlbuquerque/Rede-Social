/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class BotaoActionEntrar implements ActionListener {

    private JTextField text;
    private MyTwitter tweeter;
    private FrameTweet frameTweet;
    
    public BotaoActionEntrar(JTextField text, MyTwitter tweeter, FrameTweet frameTweet){
        this.text = text;
        this.tweeter = tweeter;
        this.frameTweet = frameTweet;
    }
    
    public void actionPerformed(ActionEvent e) {
        IRepositorioUsuario repositorio = new Repositorio();

        Perfil usuario = repositorio.buscar(text.getText());
        
        if (usuario != null){
            if(usuario.isAtivo()){
                this.frameTweet.PushPanelPaginaInicial(usuario.getUsuario());
            } else {
                JOptionPane.showMessageDialog(null, "Perfil esta desativado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta nao existe!");
        }
        
       
    }
    
}
