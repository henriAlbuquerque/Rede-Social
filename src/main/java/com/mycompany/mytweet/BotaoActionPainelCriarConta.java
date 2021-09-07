/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author henri
 */
public class BotaoActionPainelCriarConta implements ActionListener {
    
    FrameTweet frameTweet;
    
    public BotaoActionPainelCriarConta(FrameTweet frameTweet){
        this.frameTweet = frameTweet;
    }

    
    public void actionPerformed(ActionEvent e) {
        this.frameTweet.PushPanelCriarConta();
    }
    
}
