package com.game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class MapGame extends JFrame{

	private ImageIcon larr = new ImageIcon("C:\\Users\\lpare\\Desktop\\leftArrow.png");
	private ImageIcon rarr = new ImageIcon("C:\\Users\\lpare\\Desktop\\rightArrow.png");
	private boolean trueOrFalseClick[] = {false,false,false,false,false,false,false};
	private int cardValue[] = {0,1,2,3,4,5,6,7,8,9,10,11};
	
	private static JButton move = new JButton("Move");
	private JButton draw = new JButton("Draw A Card");
	private JButton kill = new JButton("Kill");
	private JButton use = new JButton("Use A Card");
	private JButton leftA = new JButton(larr);
	private JButton rightA = new JButton(rarr);
	private JTextField chatText = new JTextField();
	private static JTextArea chatRoom = new JTextArea();
	
	private int cout = 0;
	private String nL = "\n";
	private JPanel mapG = new PaintPanel();
	private int countNum = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MapGame(){
		setLayout(new BorderLayout());
		mapG.setLayout(null);
		//chatRoom.setBounds(1230, 20,270,550);
		JScrollPane scroll = new JScrollPane(chatRoom);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(1230,21,270,550);
		chatRoom.setEditable(false);
		chatRoom.setVisible(true);
		chatText.setBounds(1230, 580, 270, 30);
		chatText.setVisible(true);
		chatText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txt = chatText.getText();
				chatRoom.append(txt + nL);
				chatText.selectAll();
				
				chatRoom.setCaretPosition(chatRoom.getDocument().getLength());
				
				
				
			}
			
		});
		move.setBounds(1150,660,160,50);
		move.setFont(new Font("Arial",Font.BOLD,25));
		draw.setBounds(1340,720,160,50);
		draw.setFont(new Font("Arial",Font.BOLD,20));
		kill.setBounds(1340,660,160,50);
		kill.setFont(new Font("Arial",Font.BOLD,25));
		use.setBounds(1150,720,160,50);
		use.setFont(new Font("Arial",Font.BOLD,20));
		leftA.setBounds(130,650,50,110);
		rightA.setBounds(1050,650,50,110);
		rightA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					cardValue[0] += 1;
					cardValue[1] += 1;
					cardValue[2] += 1;
					cardValue[3] += 1;
					cardValue[4] += 1;
					cardValue[5] += 1;
					PaintPanel.setArray(0,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[0]) +".png");
					PaintPanel.setArray(1,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[1]) +".png");	
					PaintPanel.setArray(2,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[2]) +".png");	
					PaintPanel.setArray(3,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[3]) +".png");	
					PaintPanel.setArray(4,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[4]) +".png");	
					PaintPanel.setArray(5,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[5]) +".png");	

					PaintPanel.setCardValue(0,new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1,new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2,new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3,new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					PaintPanel.setCardValue(4,new ImageIcon(PaintPanel.getImageValue(4)).getImage());
					PaintPanel.setCardValue(5,new ImageIcon(PaintPanel.getImageValue(5)).getImage());
					repaint();
				
				
			}
			
		});
		leftA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					cardValue[0] -= 1;
					cardValue[1] -= 1;
					cardValue[2] -= 1;
					cardValue[3] -= 1;
					cardValue[4] -= 1;
					cardValue[5] -= 1;
					PaintPanel.setArray(0,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[0]) +".png");
					PaintPanel.setArray(1,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[1]) +".png");	
					PaintPanel.setArray(2,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[2]) +".png");	
					PaintPanel.setArray(3,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[3]) +".png");	
					PaintPanel.setArray(4,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[4]) +".png");
					PaintPanel.setArray(5,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(cardValue[5]) +".png");
					
					PaintPanel.setCardValue(0,new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1,new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2,new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3,new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					PaintPanel.setCardValue(4,new ImageIcon(PaintPanel.getImageValue(4)).getImage());
					PaintPanel.setCardValue(5,new ImageIcon(PaintPanel.getImageValue(5)).getImage());
					repaint();
					
				
			}
			
		});
		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cout<3) {
					PaintPanel.setCountClick(countNum);
					trueOrFalseClick[cout] = true;
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					cout++;
					
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
					move.setEnabled(false);
					countNum++;
				}
				else {
					countNum = 0;
					PaintPanel.setCountClick(countNum);
					countNum++;
					cout = 0;
					trueOrFalseClick[cout] = true;	
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					cout++;
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
				}
			}
			
		});
		
		mapG.add(leftA);
		mapG.add(rightA);
		mapG.add(move);
		mapG.add(draw);
		mapG.add(kill);
		mapG.add(use);
		mapG.add(chatText);
		mapG.add(scroll);
		
		add(mapG,BorderLayout.CENTER);
		setResizable(false);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static JTextArea getChatRoom() {
		return chatRoom;
	}
	
	public static JButton getJButton() {
		return move;
	}
	
	
}
