/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class PanelCriarConta extends JPanel{
    
    private JFrame jframe;
    private MyTwitter tweeter;
    private FrameTweet frameTweet;
        
    public PanelCriarConta(MyTwitter tweeter, FrameTweet frameTweet){
        
        this.jframe = jframe;
        this.tweeter = tweeter;
        this.frameTweet = frameTweet;

        
        JLabel l = new JLabel("Nome de Usuario: ");
        add(l);
        
        JTextField t = new JTextField(10);
        add(t);
        
        JButton b = new JButton("Criar");
        JComboBox c = new JComboBox();
        c.addItem("Pessoa Fisica");
        c.addItem("Pessoa Juridica");
        BotaoActionCriarConta actionCriarConta = new BotaoActionCriarConta(t, tweeter, c);
        b.addActionListener(actionCriarConta);
        
        JButton btnVoltar = new JButton("Voltar");
        BtnActionVoltar actionBtnVoltar = new BtnActionVoltar(this.frameTweet);
        btnVoltar.addActionListener(actionBtnVoltar);
        
        
        
        add(b);
        add(c);
        add(btnVoltar);
        
    }
    
    public void push(){
        JFrame f = this.frameTweet.GetFrame();
        this.frameTweet.RemoverComponente(this.frameTweet.GetPaginaAtual());
        f.add(this);
        this.frameTweet.SetPaginaAtual(this);
        this.frameTweet.addVoltar("panelCriarConta");
        f.setVisible(true);
        
    }
    
}
