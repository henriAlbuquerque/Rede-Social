/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

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
public class PanelCanelarConta extends JPanel {
    private JFrame jframe;
    private MyTwitter tweeter;
    private FrameTweet frameTweet;
        
    public PanelCanelarConta(MyTwitter tweeter, FrameTweet frameTweet){
        
        this.jframe = jframe;
        this.tweeter = tweeter;
        this.frameTweet = frameTweet;

        
        JLabel l = new JLabel("Nome de Usuario: ");
        add(l);
        
        JTextField t = new JTextField(10);
        add(t);
        
        JButton b = new JButton("Desativar");
        BotaoActionDesativarConta  actionDesativarConta = new BotaoActionDesativarConta(t, tweeter);
        b.addActionListener(actionDesativarConta);
        
        JButton btnVoltar = new JButton("Voltar");
        BtnActionVoltar actionBtnVoltar = new BtnActionVoltar(this.frameTweet);
        btnVoltar.addActionListener(actionBtnVoltar);
        
        
        
        add(b);
        add(btnVoltar);
        
    }
    
    public void push(){
        System.out.println("carrega");
        JFrame f = this.frameTweet.GetFrame();
        this.frameTweet.RemoverComponente(this.frameTweet.GetPaginaAtual());
        f.add(this);
        this.frameTweet.SetPaginaAtual(this);
        this.frameTweet.addVoltar("panelCanelarConta");
        f.setVisible(true);
        
    }
}
