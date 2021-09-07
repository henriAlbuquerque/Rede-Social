/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class BtnActionSeguir implements ActionListener {
    
    private MyTwitter tweeter;
    private FrameTweet frameTweet;
    private String usuario;
    private String nameUserRecomendados;
    
    public BtnActionSeguir(String usuario, String nameUserRecomendados, FrameTweet frameTweet, MyTwitter tweeter){
        this.usuario = usuario;
        this.tweeter = tweeter;
        this.frameTweet = frameTweet;
        this.nameUserRecomendados = nameUserRecomendados;
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println(this.usuario + " " + nameUserRecomendados);
            this.tweeter.seguir(this.usuario, nameUserRecomendados);
            this.frameTweet.alterarPressVoltar();
            this.frameTweet.PushPanelPaginaInicial(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(BtnActionSeguir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(BtnActionSeguir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SIException ex) {
            Logger.getLogger(BtnActionSeguir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
