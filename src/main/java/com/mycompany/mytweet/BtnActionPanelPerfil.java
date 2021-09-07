/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author henri
 */
public class BtnActionPanelPerfil implements ActionListener{
    
    private FrameTweet frameTweet;
    private String usuario;
    
    public BtnActionPanelPerfil(FrameTweet frameTweet, String usuario){
        
        this.frameTweet = frameTweet;
        this.usuario = usuario;

        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        this.frameTweet.PushPanelPerfil(usuario);
        
    }
    
}
