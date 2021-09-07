/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;


/**
 *
 * @author henri
 */
public class MyTwitter implements ITwitter {

    private IRepositorioUsuario repositorio;
    
    public MyTwitter(IRepositorioUsuario repositorio){
        this.repositorio = repositorio;
    }
    
    public void criarPerfil(Perfil usuario) throws PEException {
        try{
            repositorio.cadastrar(usuario);
        } catch (UJCException err){
            throw new PEException();
        }
        
    }
    
    public void cancelarPerfil(String usuario) throws PDException, PIException {
        Perfil conta = repositorio.buscar(usuario);
        
        if (conta != null){
            if (conta.isAtivo()){
                
                conta.setAtivo(false);
                try {
                    repositorio.atualizar(conta);
                } catch (UNCException ex) {
                    //Logger.getLogger(MyTwitter.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                throw new PDException();
            }
        } else {
            throw new PIException();
        }
    }
    
    public void tweetar(String usuario, String mensagem) throws PIException, MFPException{
        Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null){
            
            if(mensagem.length()> 0 && mensagem.length() <= 140){
                Tweet tweet = new Tweet();

                tweet.setUsuario(usuario);
                tweet.setMensagem(mensagem);

                perfil.addTweet(tweet);
                
                try {
                    repositorio.atualizar(perfil);
                } catch (UNCException ex) {
                    //Logger.getLogger(MyTwitter.class.getName()).log(Level.SEVERE, null, ex);
                }

                Vector<Perfil> seguidoresValidados = null;
                
                try{
                    seguidoresValidados = seguidores(usuario);
                } catch (PDException err) {
                    
                } catch (PIException e){
                    
                }

                for(Perfil conta : seguidoresValidados){
                    conta.addTweet(tweet);
                    try {
                        repositorio.atualizar(conta);
                    } catch (UNCException ex) {
                        //Logger.getLogger(MyTwitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                throw new MFPException();
            }
        } else{
            throw new PIException();
        }
    }
    
    public Vector<Tweet> timeline(String usuario) throws PDException, PIException{
        Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null) {
            if(perfil.isAtivo()){
                return perfil.getTimeline();
            }else{
                throw new PDException();
            }
        } else {
            throw new PIException();
        }
        
    }
    
    public Vector<Tweet> tweets(String usuario) throws PDException, PIException{
        Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null) {
            if(perfil.isAtivo()){
               Vector<Tweet> timeline = perfil.getTimeline();
               Vector<Tweet> tweetsUsuario = new Vector<Tweet>();
               
               for(Tweet tweet : timeline){
                   if(tweet.getUsuario().equals(usuario)){
                       tweetsUsuario.add(tweet);
                   }
               }
               
               return tweetsUsuario;
            }else{
                throw new PDException();
            }
        } else {
            throw new PIException();
        }
    }
    
    public void seguir(String seguidor, String seguido) throws PDException, PIException, SIException{
        
        if (!seguidor.equals(seguido)){
            Perfil perfilSeguidor = repositorio.buscar(seguidor);
            Perfil perfilSeguido = repositorio.buscar(seguido);
            if(perfilSeguidor != null && perfilSeguido != null){
                if(!verificarSeEstaSeguindo(perfilSeguidor.getUsuario(), perfilSeguido.getUsuario())){
                    if(perfilSeguidor.isAtivo() && perfilSeguido.isAtivo()){

                        perfilSeguidor.addSeguido(perfilSeguido);
                        perfilSeguido.addSeguidor(perfilSeguidor);

                        try {
                            repositorio.atualizar(perfilSeguidor);
                            repositorio.atualizar(perfilSeguido);
                        } catch (UNCException ex) {
                            //Logger.getLogger(MyTwitter.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        throw new PDException();
                    }
                }else{
                    System.out.println("Ja esta seguindo");
                }
            
            } else{
                throw new PIException();
            }
        } else {
            throw new SIException();
        }
    }
    
    public int numeroSeguidores(String usuario) throws PDException, PIException{
       Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null) {
            if(perfil.isAtivo()){
                Vector<Perfil> seguidores = perfil.getSeguidores();
                Vector<Perfil> seguidoresValidados = new Vector<Perfil>();
                
                for(Perfil seguidor: seguidores){
                    if(seguidor != null){
                        if(seguidor.isAtivo()){
                            seguidoresValidados.add(seguidor);
                        } else {
                            throw new PDException();
                        }
                    } else {
                        throw new PIException();
                    }
                }
                
                return seguidoresValidados.size();
            }else{
                throw new PDException();
            }
        } else {
            throw new PIException();
        } 
    }
    
    public Vector<Perfil> seguidores(String usuario) throws PDException, PIException{
        Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null) {
            if(perfil.isAtivo()){
                Vector<Perfil> seguidores = perfil.getSeguidores();
                Vector<Perfil> seguidoresValidados = new Vector<Perfil>();
                
                for(Perfil seguidor: seguidores){
                    if(seguidor != null){
                        if(seguidor.isAtivo()){
                            seguidoresValidados.add(seguidor);
                        } else {
                            throw new PDException();
                        }
                    } else {
                        throw new PIException();
                    }
                }
                
                return seguidoresValidados;
            }else{
                throw new PDException();
            }
        } else {
            throw new PIException();
        }        
    }
    
    public Vector<Perfil> seguidos(String usuario) throws PDException, PIException{
        Perfil perfil = repositorio.buscar(usuario);
        
        if(perfil != null) {
            if(perfil.isAtivo()){
                Vector<Perfil> seguidos = perfil.getSeguidos();
                Vector<Perfil> seguidosValidados = new Vector<Perfil>();
                
                for(Perfil seguido: seguidos){
                    if(seguido != null){
                        if(seguido.isAtivo()){
                            seguidosValidados.add(seguido);
                        } else {
                            throw new PDException();
                        }
                    } else {
                        throw new PIException();
                    }
                }
                
                return seguidosValidados;
            }else{
                throw new PDException();
            }
        } else {
            throw new PIException();
        } 
    }

    public boolean verificarSeEstaSeguindo(String seguidor, String seguido){
        Perfil perfilSeguidor = repositorio.buscar(seguidor);
        Perfil perfilSeguido = repositorio.buscar(seguido);
        
        Vector<Perfil> seguidos = perfilSeguidor.getSeguidos();
        
        for(Perfil conta : seguidos){
            if(conta.getUsuario().equals(perfilSeguido.getUsuario())){
                return true;
            }
        }
        
        return false;
    }
    
    
    public Vector<String> opcoesParaSeguir(String seguidor){
        Vector<Perfil> contas = this.repositorio.contasDeUsuario();
        Vector<String> opcoes = new Vector<String>();
        
        for(Perfil conta : contas){
            if(!verificarSeEstaSeguindo(seguidor, conta.getUsuario()) && !seguidor.equals(conta.getUsuario())){
                opcoes.add(conta.getUsuario());
            }
        }
        
        return opcoes;
        
    }
    
    
   

}
