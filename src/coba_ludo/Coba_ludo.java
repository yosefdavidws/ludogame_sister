/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba_ludo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Coba_ludo {

    public static void main(String[] args) {
        String txt1 = JOptionPane.showInputDialog("Masukan nama Player 1?");
        String txt2 = JOptionPane.showInputDialog("Masukan nama Player 2?");
        String txt3 = JOptionPane.showInputDialog("Masukan nama Player 3?");
        String txt4 = JOptionPane.showInputDialog("Masukan nama Player 4?");
	        JFrame jframe = new JFrame();
	        jframe.setBounds(10,10,1000,600);
	        jframe.setTitle("LUDO");
	        jframe.setResizable(false);
	        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        coba_ludo.GameMoves gm = new coba_ludo.GameMoves();
                gm.namapemain(txt1, txt2, txt3, txt4);
                //coba_ludo.Layout ly = new Layout();
	        gm.setFocusable(true);
	        gm.addKeyListener(gm);
	        gm.addMouseListener(gm);
	        jframe.add(gm);
	        jframe.setVisible(true);
               
    }
    
}
