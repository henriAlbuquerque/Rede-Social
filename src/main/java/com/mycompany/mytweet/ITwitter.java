/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.util.Vector;


/**
 *
 * @author henri
 */
public interface ITwitter {
    
    public void criarPerfil(Perfil usuario) throws PEException;
    public void cancelarPerfil(String usuario) throws PDException, PIException;
    public void tweetar(String usuario, String mensagem) throws PIException, MFPException;
    public Vector<Tweet> timeline(String usuario) throws PDException, PIException;
    public Vector<Tweet> tweets(String usuario) throws PDException, PIException;
    public void seguir(String seguidor, String seguido) throws PDException, PIException, SIException;
    public int numeroSeguidores(String usuario) throws PDException, PIException;
    public Vector<Perfil> seguidores(String usuario) throws PDException, PIException;
    public Vector<Perfil> seguidos(String usuario) throws PDException, PIException;
    
}
