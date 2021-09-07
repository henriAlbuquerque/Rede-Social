/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class PanelLogin extends JPanel{
    
    private FrameTweet frameTweet;
    private MyTwitter tweeter;
    
    public PanelLogin(FrameTweet frameTweet, MyTwitter tweeter){
        
        this.frameTweet = frameTweet;
        
        JLabel l = new JLabel("Nome de Usuario: ");
        add(l);
        
        JTextField t = new JTextField(10);
        add(t);
        
        JButton entrar = new JButton("Entrar");
        BotaoActionEntrar actionEntrar = new BotaoActionEntrar(t, tweeter , frameTweet);
        entrar.addActionListener(actionEntrar);
        add(entrar);
        
        JButton criarConta = new JButton("Criar Conta");
        BotaoActionPainelCriarConta actionPainelCriarConta = new BotaoActionPainelCriarConta(this.frameTweet);
        criarConta.addActionListener(actionPainelCriarConta);
        add(criarConta);
        
        JButton desativarConta = new JButton("Desativar Conta");
        BotaoActionPainelDesativarConta actionPainelDesativarConta = new BotaoActionPainelDesativarConta(this.frameTweet);
        desativarConta.addActionListener(actionPainelDesativarConta);
        add(desativarConta);
    }

    public void push(){
        JFrame f = this.frameTweet.GetFrame();
        this.frameTweet.RemoverComponente(this.frameTweet.GetPaginaAtual());
        f.add(this);
        this.frameTweet.SetPaginaAtual(this);
        this.frameTweet.addVoltar("panelLogin");
        f.setVisible(true);
        
    }
   
}
