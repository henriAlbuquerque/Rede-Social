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
public class PanelPaginaInicial extends JPanel{
    
    private FrameTweet frameTweet;
    private MyTwitter tweeter;
    private String usuario;
        
    public PanelPaginaInicial(MyTwitter tweeter, String usuario, FrameTweet frameTweet){
        
        this.frameTweet = frameTweet;
        this.tweeter = tweeter;
        this.usuario = usuario;
        
        setLayout(new BorderLayout());
        
        JPanel panelNorth = new JPanel();

        
        JLabel nameUser = new JLabel();
        nameUser.setText(usuario);
        panelNorth.add(nameUser);
        
        JLabel numSeguidores = new JLabel();
        
        int nS = 0;
        
        try {
            nS = this.tweeter.numeroSeguidores(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

        JButton btnPerfil = new JButton("Perfil");
        BtnActionPanelPerfil actionPerfil = new BtnActionPanelPerfil(this.frameTweet, this.usuario);
        btnPerfil.addActionListener(actionPerfil);
        
        JButton btnVoltar = new JButton("Voltar");
        BtnActionVoltar actionBtnVoltar = new BtnActionVoltar(this.frameTweet);
        btnVoltar.addActionListener(actionBtnVoltar);
        
        Vector<Perfil> s = new Vector<Perfil>();
        
        try {
            s = this.tweeter.seguidos(this.usuario);
        } catch (PDException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(PanelPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int nT = s.size();

        
        numSeguidores.setText(" | Seguidores: " + String.valueOf(nS) + " | Seguindo: " + String.valueOf(nT));
        panelNorth.add(numSeguidores);
        panelNorth.add(btnPerfil);
        panelNorth.add(btnVoltar);
        
        add(BorderLayout.NORTH, panelNorth);
        
        
        
        JTextArea textTweetar = new JTextArea();
        textTweetar.setText("Digite seu tweet");
        textTweetar.setRows(5);
        textTweetar.setColumns(20);
        
        
        
        
        JButton btnTweetar = new JButton("Tweetar");
        BtnActionTweetar actionTweetar = new BtnActionTweetar(textTweetar, tweeter , this.frameTweet, this.usuario);
        btnTweetar.addActionListener(actionTweetar);
        
        

        
        Vector<Tweet> timeLine = null;
        
        try {
            timeLine = this.tweeter.timeline(this.usuario);
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
        
        Vector<String> contasParaSeguir = this.tweeter.opcoesParaSeguir(usuario);

        
        for(String conta : contasParaSeguir){
            JPanel p = new JPanel();
            JLabel nameUserRecomendados = new JLabel();
            nameUserRecomendados.setText(conta);
            JButton seguir = new JButton("Seguir");
            
            BtnActionSeguir actionActionSeguir = new BtnActionSeguir(this.usuario, nameUserRecomendados.getText() , this.frameTweet, this.tweeter);
            seguir.addActionListener(actionActionSeguir);
            
            
          
            
            p.add(nameUserRecomendados);
            p.add(seguir);
            panelCenterEast.add(p);
        }
        
        JPanel panelCenter = new JPanel();
        
        JPanel panelCenterCenter = new JPanel();
        
        

        panelCenterCenter.add(textTweetar);
        panelCenterCenter.add(btnTweetar);
        //panelCenterSouth.add(teste);
        
        panelCenter.setLayout(new GridLayout(2, 1));
        panelCenter.add(panelCenterCenter);
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
        this.frameTweet.addVoltar("panelPaginaInicial");
        f.setVisible(true);
        
    }
    
}
