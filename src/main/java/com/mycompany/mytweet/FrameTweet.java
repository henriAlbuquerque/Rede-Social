/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author henri
 */
public class FrameTweet{
    
    private JFrame jframe;
    private MyTwitter tweeter;
    private Component paginaAtual;
    private Vector<String> voltar;
    private String usuario;
    private boolean pressVoltar;
    
    public FrameTweet(MyTwitter tweeter){
        
        this.tweeter = tweeter;
        this.paginaAtual = new JPanel();
        this.voltar = new Vector<String>();
        this.usuario = "";
        this.pressVoltar = false;
        
        this.jframe = new JFrame("Tweet");
        
        this.jframe.setTitle("Tweet");
        this.jframe.setSize(1000, 1000);
        this.jframe.setLocation(500, 0);
        this.jframe.setLayout(new BorderLayout());
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
        
        IRepositorioUsuario repositorio = new Repositorio();

        //Perfil usuario = repositorio.buscar("Carlos");
        
        //PushPanelPaginaInicial("Carlos", usuario);      
        
        PushPanelLogin();
        
        this.jframe.setVisible(true);
    }
    
    public void PushPanelLogin(){
        
        
        PanelLogin panelLogin = new PanelLogin(this, this.tweeter);
        panelLogin.push();
        
        
        
    }
    
    public void PushPanelCriarConta(){
        PanelCriarConta panelCriarConta = new PanelCriarConta(this.tweeter, this);
        
        panelCriarConta.push();
    }
    
    public void PushPanelCancelarConta(){
        PanelCanelarConta panelCanelarConta = new PanelCanelarConta(this.tweeter, this);
        
        panelCanelarConta.push();
    }
    
    public void PushPanelPaginaInicial(String usuario){
                
        PanelPaginaInicial panelPaginaInicial = new PanelPaginaInicial(this.tweeter, usuario, this);
        
        panelPaginaInicial.push();
        
    }
    
    public void PushPanelPerfil(String usuario){
        
        
        
        PanelPerfil panelPerfil = new PanelPerfil(this.tweeter, usuario, this);
        
        panelPerfil.push();
        
        
    }
    
    public void btnVoltar(){
        
        this.pressVoltar = true;
        
        this.voltar.remove(this.voltar.size() - 1);
        
        String panelAnterior = this.voltar.lastElement(); 
        

        if(panelAnterior.equals("panelLogin")){
            PushPanelLogin();
        }else if(panelAnterior.equals("panelCriarConta")){
            PushPanelCriarConta();
        }else if(panelAnterior.equals("panelPaginaInicial")){
            PushPanelPaginaInicial(this.usuario);
        }else if(panelAnterior.equals("panelPerfil")){
            PushPanelPerfil(this.usuario);
        }
        

        
    }
    
    public void alterarPressVoltar(){
        this.pressVoltar = true;
    }
    
    public void RemoverComponente(Component comp){
        this.jframe.remove(comp);
    }
    
    public JFrame GetFrame(){
        return this.jframe;
    }
    
    public void SetPaginaAtual(Component c){
        this.paginaAtual = c;
    }
    
    public void SetUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public Component GetPaginaAtual(){
        return this.paginaAtual;
    }
    
    public void addVoltar(String s){
        if(!this.pressVoltar){
            this.voltar.add(s);
        }else{
            this.pressVoltar = false;
        }
    }
}
