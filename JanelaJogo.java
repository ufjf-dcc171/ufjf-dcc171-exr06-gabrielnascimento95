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
public class JanelaJogo extends JFrame{
    private final Random gerador = new Random();
    private final JRadioButton rbPedra = new JRadioButton("Pedra", false);
    private final JRadioButton rbPapel = new JRadioButton("Papel", false);
    private final JRadioButton rbTesoura = new JRadioButton("Tesoura", false);
    private final JLabel rodada = new JLabel("Rodada: ");
    private final JTextField campo1 = new JTextField(2);
    private final JLabel usuario = new JLabel("Usuário: ");
    private final JTextField campo2 = new JTextField(2);
    private final JLabel pc = new JLabel("Computador: ");
    private final JTextField campo3 = new JTextField(2);
    private final JLabel empateView = new JLabel("Empates: ");
    private final JTextField campo4 = new JTextField(2);
    private final JLabel UserView = new JLabel("Usuário: ");
    private final JTextField campo5 = new JTextField(8);
    private final JLabel pcView = new JLabel("Vs. PC: ");
    private final JTextField campo6 = new JTextField(8);
    private final JButton  calcular = new JButton("Jogar");
    private int rodadas = 0, opcaoUser = 0, opcaoPC = 0, placarA=0, placarB=0, empate=0;
    
    public JanelaJogo() throws HeadlessException{
        super("Pedra, Papel ou Tesoura");
        setLayout(new FlowLayout());
        add(rodada);
        add(campo1);
        add(usuario);
        add(campo2);
        add(pc);
        add(campo3);
        add(empateView);
        add(campo4);
        add(rbPapel);
        add(rbPedra);
        add(rbTesoura);
        add(calcular);
        add(UserView);
        add(campo5);
        add(pcView);
        add(campo6);
        
        
        rbPapel.addItemListener(new JanelaJogo.OpcaoRadio(0));
        rbPedra.addItemListener(new JanelaJogo.OpcaoRadio(1));
        rbTesoura.addItemListener(new JanelaJogo.OpcaoRadio(2));
      
        botaoClicado botao = new botaoClicado();
        calcular.addActionListener(botao);
        
        
        
    }
    
     private class botaoClicado implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                if(rodadas < 7){
                    rodadas++;
                    campo1.setText("" + rodadas);
                    campo2.setText("" + placarA);
                    campo3.setText("" + placarB);
                    campo4.setText("" + empate);
                    
                    if(opcaoPC == 0){
                        campo5.setText("Papel");
                    }else if(opcaoPC == 1){
                        campo5.setText("Pedra");
                    }else if(opcaoPC == 2){
                        campo5.setText("Tesoura");
                    }
                    
                    if(opcaoUser == 0){
                        campo6.setText("Papel");
                    }else if(opcaoUser == 1){
                        campo6.setText("Pedra");
                    }else if(opcaoUser == 2){
                        campo6.setText("Tesoura");
                    }
                }
                if(rodadas == 7){ 
                    if (placarA > placarB) {
                        JOptionPane.showMessageDialog(null, "O vencedor foi o usuário");
                    } else {
                        JOptionPane.showMessageDialog(null, "O vencedor foi a máquina");
                    }
                }
        }
     }
     
     private class OpcaoRadio implements ItemListener {
        public OpcaoRadio(int f){
            opcaoUser = f;
        }
        @Override
        public void itemStateChanged(ItemEvent e){
            opcaoPC = gerador.nextInt(3);
            if(opcaoUser == 0 && opcaoPC == 0){
                    empate++;
                }else if(opcaoUser == 0 && opcaoPC == 1){
                    placarA++;
                }else if(opcaoUser == 0 && opcaoPC == 2){
                    placarB++;
                }else if(opcaoUser == 1 && opcaoPC == 0){
                    placarB++;
                }else if(opcaoUser == 1 && opcaoPC == 1){
                    empate++;
                }else if(opcaoUser == 1 && opcaoPC == 2){
                    placarB++;
                }else if(opcaoUser == 2 && opcaoPC == 0){
                    placarA++;
                }else if(opcaoUser == 2 && opcaoPC == 1){
                    placarA++;
                }else if(opcaoUser == 2 && opcaoPC == 2){
                    empate++;
                }
        }
    }
}
