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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class BtnActionTweetar implements ActionListener{
    
    private JTextArea textTweetar;
    private MyTwitter tweeter;
    private FrameTweet frameTweet;
    private String usuario;
    private Perfil perfil;
    
    public BtnActionTweetar(JTextArea textTweetar , MyTwitter tweeter, FrameTweet frameTweet, String usuario){
        this.textTweetar = textTweetar;
        this.tweeter = tweeter;
        this.frameTweet = frameTweet;
        this.usuario = usuario;
        this.perfil = perfil;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            this.tweeter.tweetar(this.usuario, this.textTweetar.getText());
            this.frameTweet.alterarPressVoltar();
            this.frameTweet.PushPanelPaginaInicial(this.usuario);
        } catch (PIException ex) {
            Logger.getLogger(BtnActionTweetar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MFPException ex) {
            Logger.getLogger(BtnActionTweetar.class.getName()).log(Level.SEVERE, null, ex);
        }

        //JOptionPane.showMessageDialog(null, this.textTweetar.getText());
    }
    
}
