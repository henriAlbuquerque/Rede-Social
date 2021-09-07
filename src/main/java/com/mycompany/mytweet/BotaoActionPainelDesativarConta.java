/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author henri
 */
public class BotaoActionPainelDesativarConta implements ActionListener {
    
    private FrameTweet frameTweet;
    
    public BotaoActionPainelDesativarConta(FrameTweet frameTweet){
        this.frameTweet = frameTweet;
    }

    public void actionPerformed(ActionEvent e) {
        this.frameTweet.PushPanelCancelarConta();
    }
    
}
