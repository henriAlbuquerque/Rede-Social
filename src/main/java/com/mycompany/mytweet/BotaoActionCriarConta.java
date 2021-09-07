/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class BotaoActionCriarConta implements ActionListener {
    
    private JTextField text;
    private MyTwitter tweeter;
    private JComboBox comboBox; 
    
    public BotaoActionCriarConta(JTextField text, MyTwitter tweeter, JComboBox comboBox){
        this.text = text;
        this.tweeter = tweeter;
        this.comboBox = comboBox;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Perfil usuario = null;
                
        if(this.comboBox.getSelectedItem().equals("Pessoa Fisica")){
            usuario = new PessoaFisica(this.text.getText());
        } else if (this.comboBox.getSelectedItem().equals("Pessoa Juridica")){
            usuario = new PessoaJuridica(this.text.getText());
        }
        
        
        
        try {
            this.tweeter.criarPerfil(usuario);
            JOptionPane.showMessageDialog(null, "Perfil Criado com sucesso!");
        } catch (PEException ex) {
            JOptionPane.showMessageDialog(null, "Perfil Ja Existe!");
        }

        
        
    }
}
