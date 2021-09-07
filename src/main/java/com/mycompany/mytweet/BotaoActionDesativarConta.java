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
public class BotaoActionDesativarConta implements ActionListener {
    
    private JTextField text;
    private MyTwitter tweeter;
    
    public BotaoActionDesativarConta(JTextField text, MyTwitter tweeter){
        this.text = text;
        this.tweeter = tweeter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.tweeter.cancelarPerfil(this.text.getText());
            JOptionPane.showMessageDialog(null, "Perfil Desativado com sucesso!");
        } catch (PDException ex) {
            Logger.getLogger(BotaoActionDesativarConta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PIException ex) {
            Logger.getLogger(BotaoActionDesativarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
