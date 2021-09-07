/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.StreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henri
 */
public class Repositorio implements IRepositorioUsuario {
    
    private XStream xstream;
    public Vector<Perfil> contasUsuarios;
    private File file;
    
    public Repositorio(){
        
        this.file = new File("C:\\Users\\henri\\Desktop\\POO\\Projetos\\mytweet\\repositorio\\repositorio.xml");

        this.xstream = new XStream(new DomDriver());
        
        
        this.contasUsuarios = new Vector<Perfil>();
        
        String[] types = {"com.mycompany.mytweet.PessoaFisica", "com.mycompany.mytweet.PessoaJuridica", "com.mycompany.mytweet.Tweet"};

        
        xstream.alias("PessoaFisica", PessoaFisica.class);
        xstream.alias("PessoaJuridica", PessoaJuridica.class);
        xstream.alias("ContasUsuarios", Vector.class);
        xstream.alias("Tweet", Tweet.class);

        xstream.allowTypes(types);
        
        try{
            this.contasUsuarios = (Vector<Perfil>)  xstream.fromXML(file);
        } catch (StreamException err){
                        
            if (err.hashCode() == 107241811){
                System.out.println("Repositorio Vazio");
            } else {
                System.out.println("Algum outro erro fatal");
                Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, err);
            }
        }
        
        
    }
    
    public void cadastrar(Perfil usuario) throws UJCException{
        
        Perfil isUserExist = buscar(usuario.getUsuario());
        
        if(isUserExist == null){
        
        
            //if(usuario instanceof PessoaFisica){
            xstream.alias("PessoaFisica", PessoaFisica.class);

            //} else if (usuario instanceof PessoaJuridica){
            xstream.alias("PessoaJuridica", PessoaJuridica.class);
            //}

            xstream.alias("ContasUsuarios", Vector.class);




            contasUsuarios.add(usuario);





            String xml = xstream.toXML(this.contasUsuarios);

            PrintWriter print = null;
            try {
                print = new PrintWriter(this.file);
                print.write(xml);
                print.flush();
                print.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                print.close();
            }
            
        } else {
            throw new UJCException();
        }
         
                
    }
    
    public Perfil buscar(String usuario){
        
        for(Perfil conta : this.contasUsuarios){

            if(conta.getUsuario().equals(usuario)){
                return conta;
            }
        }
        
        return null;
    
    }
    
    public void atualizar(Perfil usuario) throws UNCException{
        Perfil conta = buscar(usuario.getUsuario());
        
        if(conta != null){
            this.contasUsuarios.remove(conta);
            this.contasUsuarios.add(usuario);
            
            
            
            String xml = xstream.toXML(this.contasUsuarios);
            
            PrintWriter print = null;
            try {
                print = new PrintWriter(this.file);
                print.write(xml);
                print.flush();
                print.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                print.close();
            }
            
        } else {
            throw new UNCException();
        }
        
    }
    
    public Vector<Perfil> contasDeUsuario(){
        return this.contasUsuarios;
    }
    
}
