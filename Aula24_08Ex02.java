/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc171;

import br.ufjf.dcc171.modelo.JanelaPedraPapelTesoura;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel_Nascimento
 */
public class Aula24_08Ex02 {
    public static void main(String[] args) {
        JanelaPedraPapelTesoura janela = new JanelaPedraPapelTesoura();
        janela.setSize(320,140);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
