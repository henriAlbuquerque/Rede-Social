/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;

/**
 *
 * @author henri
 */
public class BtnActionVoltar implements java.awt.event.ActionListener{
    
    private FrameTweet frameTweet;
    
    public BtnActionVoltar(FrameTweet frameTweet){
        this.frameTweet = frameTweet;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.frameTweet.btnVoltar();
    }
    
}
