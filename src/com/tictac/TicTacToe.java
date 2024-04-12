package com.tictac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe  implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JLabel tf = new JLabel();
	JButton[] btn = new JButton[9];
	boolean player1_turn;
	int counter =0;
	
	TicTacToe(){
		
	    frame.setSize(500, 500);
	    frame.setVisible(true);
	    frame.setTitle("welcome to my game TicTacToe!!!");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		tf.setBackground(Color.darkGray);
		tf.setForeground(Color.GREEN);
		tf.setFont(new Font("Ink Free",Font.BOLD,75));
		tf.setHorizontalAlignment(JLabel.CENTER);
		tf.setText("Tic-Tac-Toe");
		tf.setOpaque(true);
		pane1.setLayout(new BorderLayout());
		pane1.setBounds(0,0,800,800);
		pane2.setLayout(new GridLayout(3,3));
		pane2.setBackground(new Color(150,150,150));
		for(int i=0;i<9;i++) {
			btn[i]=new JButton();
			pane2.add(btn[i]);
			btn[i].setFont(new Font("MV Boli",Font.BOLD,120));
			btn[i].setFocusable(false);
			btn[i].addActionListener(this);
		}
		pane1.add(tf);
		frame.add(pane1,BorderLayout.NORTH);
		frame.add(pane2);
		firstTurn();
	}

	public void actionPerformed(ActionEvent e) {
	
		for(int i=0;i<9;i++) {
			if(e.getSource()==btn[i]) {
				if(player1_turn) {
					if(btn[i].getText()=="") {
						btn[i].setForeground(Color.BLUE);
						btn[i].setText("X");
						player1_turn=false;
						tf.setText("O turn");
						check();
						
					}
				}
				else {
					if(btn[i].getText()=="") {
						btn[i].setForeground(Color.cyan);
						btn[i].setText("O");
						player1_turn=true;
						tf.setText("X turn");
                        check();
                        
					}
				}
			counter++;
			}
			
		}
	}
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			tf.setText("X turn");
		}
		else {
			player1_turn=false;
			tf.setText("O turn");
		}
	}
	public void check() {
		if(
			(btn[0].getText()=="X") &&
			(btn[1].getText()=="X") &&
			(btn[2].getText()=="X") 
		){
		xwins(0, 1, 2);	
		}
		if(
				(btn[3].getText()=="X") &&
				(btn[4].getText()=="X") &&
				(btn[5].getText()=="X") 
			){
			xwins(3,4,5);	
		}
		if(
				(btn[6].getText()=="X") &&
				(btn[7].getText()=="X") &&
				(btn[8].getText()=="X") 
			){
			xwins(6,7,8);	
		}
		if(
				(btn[0].getText()=="X") &&
				(btn[3].getText()=="X") &&
				(btn[6].getText()=="X") 
			){
			xwins(0,3,6);	
		}
		if(
				(btn[1].getText()=="X") &&
				(btn[4].getText()=="X") &&
				(btn[7].getText()=="X") 
			){
			xwins(1,4,7);	
		}
		if(
				(btn[2].getText()=="X") &&
				(btn[5].getText()=="X") &&
				(btn[8].getText()=="X") 
			){
			xwins(2,5,8);	
		}
		if(
				(btn[0].getText()=="X") &&
				(btn[4].getText()=="X") &&
				(btn[8].getText()=="X") 
			){
			xwins(0,4,8);	
		}
		if(
				(btn[2].getText()=="X") &&
				(btn[4].getText()=="X") &&
				(btn[6].getText()=="X") 
			){
			xwins(2,4,6);	
		}
		if(
				(btn[0].getText()=="O") &&
				(btn[1].getText()=="O") &&
				(btn[2].getText()=="O") 
			){
			owins(0, 1, 2);	
			}
			if(
					(btn[3].getText()=="O") &&
					(btn[4].getText()=="O") &&
					(btn[5].getText()=="O") 
				){
				owins(3,4,5);	
			}
			if(
					(btn[6].getText()=="O") &&
					(btn[7].getText()=="O") &&
					(btn[8].getText()=="O") 
				){
				owins(6,7,8);	
			}
			if(
					(btn[0].getText()=="O") &&
					(btn[3].getText()=="O") &&
					(btn[6].getText()=="O") 
				){
				owins(0,3,6);	
			}
			if(
					(btn[1].getText()=="O") &&
					(btn[4].getText()=="O") &&
					(btn[7].getText()=="O") 
				){
				owins(1,4,7);	
			}
			if(
					(btn[2].getText()=="O") &&
					(btn[5].getText()=="O") &&
					(btn[8].getText()=="O") 
				){
				owins(2,5,8);	
			}
			if(
					(btn[0].getText()=="O") &&
					(btn[4].getText()=="O") &&
					(btn[8].getText()=="O") 
				){
				owins(0,4,8);	
			}
			if(
					(btn[2].getText()=="O") &&
					(btn[4].getText()=="O") &&
					(btn[6].getText()=="O") 
				){
				owins(2,4,6);	
			}
			if(counter==8) {
				tie();
			}
			
				
			
	}
	
	
	public void xwins(int a,int b,int c) {
		btn[a].setBackground(Color.GREEN);
		btn[b].setBackground(Color.GREEN);
		btn[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			btn[i].setEnabled(false);
			
		}
		tf.setText("X wins");
	}
    public void owins(int a,int b,int c) {
    	btn[a].setBackground(Color.GREEN);
		btn[b].setBackground(Color.GREEN);
		btn[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			btn[i].setEnabled(false);
			
		}
		tf.setText("O wins");
	}
    public void tie() {
    	
    	tf.setText("Match Tie");
    }

}