package com.game;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPlayer extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel pn = new JLabel("Amount of Players:");
	private String numOfPlayers[] = {"Three","Four","Five","Six","Seven"};
	private JComboBox<String> aOP = new JComboBox<>(numOfPlayers);
	private JPanel playerNumber;

	SelectPlayer(){
		playerNumber = new JPanel();
		playerNumber.setLayout(null);
		pn.setBounds(30, 30, 140, 50);
		pn.setFont(new Font("ArialBlack",Font.ITALIC,15));
		
		aOP.setBounds(50, 70, 80, 30);
		
		aOP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(aOP.getSelectedItem() == "Three") {
					dispose();
					PaintPanel.playerNum = 3;
					MapGame.numPlayers = 3;
					MapGame m = null;
					try {
						m = new MapGame();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					m.setVisible(true);
					repaint();
					

				}
				else if(aOP.getSelectedItem() == "Four") {
					dispose();
					PaintPanel.playerNum = 4;
					MapGame.numPlayers = 4;
					MapGame m = null;
					try {
						m = new MapGame();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					m.setVisible(true);
					repaint();
					
					
					
					
				}
				else if(aOP.getSelectedItem() == "Five") {
					dispose();
					PaintPanel.playerNum = 5;
					MapGame.numPlayers = 5;
					MapGame m = null;
					try {
						m = new MapGame();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					m.setVisible(true);
					repaint();
					
					
					
				}
				else if(aOP.getSelectedItem() == "Six") {
					dispose();
					PaintPanel.playerNum = 6;
					MapGame.numPlayers = 6;
					MapGame m = null;
					try {
						m = new MapGame();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					m.setVisible(true);
					repaint();
					
					
				}
				else {
					dispose();
					PaintPanel.playerNum = 7;
					MapGame.numPlayers = 7;
					MapGame m = null;
					try {
						m = new MapGame();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					m.setVisible(true);
					repaint();
					
				}
			}
			
		});
		playerNumber.add(pn);
		playerNumber.add(aOP);
		add(playerNumber);
		setResizable(false);
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	
	}
	
	public void VisOne() {
		this.setVisible(true);
	}

}
