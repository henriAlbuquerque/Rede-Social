/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class PanelPerfil extends JPanel{
    
    private FrameTweet frameTweet;
    private MyTwitter tweeter;
    private String usuario;
        
    public PanelPerfil(MyTwitter tweeter, String usuario, FrameTweet frameTweet){
        
        this.frameTweet = frameTweet;
        this.tweeter = tweeter;
        this.usuario = usuario;
        
        setLayout(new BorderLayout());
        
        JPanel panelNorth = new JPanel();

        
        JLabel nameUser = new JLabel();
        nameUser.setText(usuario);
        panelNorth.add(nameUser);
        
        JButton btnVoltar = new JButton("Voltar");
        BtnActionVoltar actionBtnVoltar = new BtnActionVoltar(this.frameTweet);
        btnVoltar.addActionListener(actionBtnVoltar);
        
        JLabel numSeguidores = new JLabel();
        
        int nS = 0;
        
        try {
            nS = this.tweeter.numeroSeguidores(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Vector<Perfil> sT = new Vector<Perfil>();

        try {
            sT = this.tweeter.seguidos(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int nT = sT.size();
        
        numSeguidores.setText(" | Seguidores: " + String.valueOf(nS) + " | Seguindo: " + String.valueOf(nT));
        panelNorth.add(numSeguidores);
        panelNorth.add(btnVoltar);
        
        add(BorderLayout.NORTH, panelNorth);
        add(BorderLayout.NORTH, panelNorth);
        
        
        
        

        
        Vector<Tweet> timeLine = new Vector<Tweet>();
        
        try {
            timeLine = this.tweeter.tweets(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JPanel panelCenterSouth = new JPanel();
        panelCenterSouth.setLayout(new GridLayout(6, 1));

        
        for(Tweet tweet : timeLine){
            JPanel p = new JPanel();
            JLabel timeLineUser = new JLabel();
            timeLineUser.setText(tweet.getUsuario() + ": " + tweet.getMensagem());
            
            p.add(timeLineUser);
            panelCenterSouth.add(p);
        }
        
        JPanel panelCenterEast = new JPanel();
        panelCenterEast.setLayout(new GridLayout(8, 1));

        
        JPanel panelCenter = new JPanel();
        
        JPanel panelCenterCenter = new JPanel();
        JPanel panelCenterCenter2 = new JPanel();
        
        Vector<Perfil> seguidores = new Vector<Perfil>();
        Vector<Perfil> seguidos = new Vector<Perfil>();
        try {
            seguidores = this.tweeter.seguidores(this.usuario);
            seguidos = this.tweeter.seguidos(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String s = "";
        String t = "";
        
        for(Perfil seguidor : seguidores){
            
            s += seguidor.getUsuario() + "  "; 
            
        }
        
        for(Perfil seguido : seguidos){
            
            t += seguido.getUsuario() + "  "; 
            
        }
        
        JPanel panelSeguidoresUser = new JPanel();
        JLabel seguidoresUser = new JLabel();
        seguidoresUser.setText("Seguidores: " + s + " |   " + "Seguindo: " + t);
        panelSeguidoresUser.add(seguidoresUser);
        panelCenterCenter2.add(panelSeguidoresUser);
        
      
        
        
        panelCenter.setLayout(new GridLayout(3, 1));
        panelCenter.add(panelCenterCenter);
        panelCenter.add(panelCenterCenter2);
        panelCenter.add(panelCenterSouth);
        
        add(BorderLayout.CENTER, panelCenter);
        add(BorderLayout.EAST, panelCenterEast);
        

    }
    
    public void push(){
        JFrame f = this.frameTweet.GetFrame();
        this.frameTweet.SetUsuario(this.usuario);
        this.frameTweet.RemoverComponente(this.frameTweet.GetPaginaAtual());
        f.add(this);
        this.frameTweet.SetPaginaAtual(this);
        this.frameTweet.addVoltar("panelPerfil");
        f.setVisible(true);
        
    }
    
}
