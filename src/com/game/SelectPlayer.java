package com.game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel playerNum;

	SelectPlayer(){
		playerNum = new JPanel();
		playerNum.setLayout(null);
		pn.setBounds(30, 30, 140, 50);
		pn.setFont(new Font("ArialBlack",Font.ITALIC,15));
		
		aOP.setBounds(50, 70, 80, 30);
		
		aOP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(aOP.getSelectedItem() == "Three") {
					setVisible(false);
					MapGame m = new MapGame();
					m.setVisible(true);
					PaintPanel.playerNum = 3;
				}
				else if(aOP.getSelectedItem() == "Four") {
					setVisible(false);
					MapGame m = new MapGame();
					m.setVisible(true);
					PaintPanel.playerNum = 4;
					
				}
				else if(aOP.getSelectedItem() == "Five") {
					setVisible(false);
					MapGame m = new MapGame();
					m.setVisible(true);
					PaintPanel.playerNum = 5;
					
				}
				else if(aOP.getSelectedItem() == "Six") {
					setVisible(false);
					MapGame m = new MapGame();
					m.setVisible(true);
					PaintPanel.playerNum = 6;
				}
				else {
					setVisible(false);
					MapGame m = new MapGame();
					m.setVisible(true);
					PaintPanel.playerNum = 7;
				}
			}
			
		});
		playerNum.add(pn);
		playerNum.add(aOP);
		add(playerNum);
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
