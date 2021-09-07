/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author henri
 */
public class Main {
    public static void main(String[] args){
                
        IRepositorioUsuario repositorio = new Repositorio();
        
        MyTwitter twitter = new MyTwitter(repositorio);
        
        new FrameTweet(twitter);
        
        
        
    }
}
