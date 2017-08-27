/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc171.modelo;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel_Nascimento
 */
public class JanelaPedraPapelTesoura extends JFrame{
    private final Random gerador = new Random();
    private final JRadioButton rbPedra = new JRadioButton("Pedra", false);
    private final JRadioButton rbPapel = new JRadioButton("Papel", false);
    private final JRadioButton rbTesoura = new JRadioButton("Tesoura", false);
    private final JButton  calcular = new JButton("Jogar");
    private final JLabel opcaoComputador = new JLabel("O computador escolheu: ");
    private final JTextField campo1 = new JTextField(8);
    private final JLabel placar = new JLabel("Placar: Usuário ");
    private final JTextField campo2 = new JTextField(4);
    private final JLabel e = new JLabel(" e PC ");
    private final JTextField campo3 = new JTextField(4);
    private int rodadas = 0, opcaoUser = 0, opcaoPC = 0, placarA=0, placarB=0, empate=0;
    
    public JanelaPedraPapelTesoura() throws HeadlessException{
        super("Pedra, Papel ou Tesoura");
        setLayout(new FlowLayout());
        add(rbPapel);
        add(rbPedra);
        add(rbTesoura);
        add(calcular);
        add(opcaoComputador);
        add(campo1);
        add(placar);
        add(campo2);
        add(e);
        add(campo3);
        
        rbPapel.addItemListener(new OpcaoRadio(0));
        rbPedra.addItemListener(new OpcaoRadio(1));
        rbTesoura.addItemListener(new OpcaoRadio(2));
        
        botaoClicado botao = new botaoClicado();
        calcular.addActionListener(botao);
        
        if(rodadas == 7){
        if(placarA > placarB){
                JOptionPane.showMessageDialog(null,"O vencedor foi o usuário");   
        }else{
                JOptionPane.showMessageDialog(null, "O vencedor foi a máquina");
           }
       }
    }
    
    private class botaoClicado implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                if(opcaoUser == 0 && opcaoPC == 0){
                    empate++;
                    JOptionPane.showMessageDialog(null, "Empate!");
                }else if(opcaoUser == 0 && opcaoPC == 1){
                    placarA++;
                    campo2.setText(" " + placarA);
                }else if(opcaoUser == 0 && opcaoPC == 2){
                    placarB++;
                    campo3.setText(" " + placarB);
                }else if(opcaoUser == 1 && opcaoPC == 0){
                    placarB++;
                    campo3.setText(" " + placarB);
                }else if(opcaoUser == 1 && opcaoPC == 1){
                    empate++;
                    JOptionPane.showMessageDialog(null, "Empate!");
                }else if(opcaoUser == 1 && opcaoPC == 2){
                    placarB++;
                    campo3.setText(" " + placarB);
                }else if(opcaoUser == 2 && opcaoPC == 0){
                    placarA++;
                    campo2.setText(" " + placarA);
                }else if(opcaoUser == 2 && opcaoPC == 1){
                    placarA++;
                    campo2.setText(" " + placarA);
                }else if(opcaoUser == 2 && opcaoPC == 2){
                    empate++;
                    JOptionPane.showMessageDialog(null, "Empate!");
                }
                rodadas++;
        }
    }
    
    private class OpcaoRadio implements ItemListener {
        public OpcaoRadio(int f){
            opcaoUser = f;
        }
        @Override
        public void itemStateChanged(ItemEvent e){
            opcaoPC = gerador.nextInt(3); 
            if(opcaoPC == 0){
                campo1.setText("Papel");
            }else if(opcaoPC == 1){
                campo1.setText("Pedra");
            }else if(opcaoPC == 2){
                campo1.setText("Tesoura");
            }else{
                campo1.setText("erro!");
            }
        }
    }
    
}
