package com.game;

import com.game.client.ChatRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MapGame extends JFrame {

	private ImageIcon larr = new ImageIcon("C:\\Users\\lpare\\Desktop\\leftArrow.png");
	private ImageIcon rarr = new ImageIcon("C:\\Users\\lpare\\Desktop\\rightArrow.png");
	private boolean trueOrFalseClick[] = {false,false,false,false,false,false,false};
	
	
	
	private JButton move = new JButton("Move");
	private JButton draw = new JButton("Draw A Card");
	private JButton kill = new JButton("Kill");
	private JButton use = new JButton("Use A Card");
	private JButton leftA = new JButton(larr);
	private JButton rightA = new JButton(rarr);
	private JTextField chatText = new JTextField();
	private static JTextArea chatRoom = new JTextArea();
	
	private int count = 1;
	private int cout = 0;
	private String nL = "\n";
	private JPanel mapG = new PaintPanel();
	
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
		/**
		 * chatText.addActionListener(new ActionListener() {
		 *
		 *                        @Override
		 *            public void actionPerformed(ActionEvent e) {
		 * 				// TODO Auto-generated method stub
		 * 				/**
		 * 				 * String txt = chatText.getText();
		 * 				 * 				chatRoom.append(txt + nL);
		 * 				 * 				chatText.selectAll();
		 * 				 *
		 * 				 * 				chatRoom.setCaretPosition(chatRoom.getDocument().getLength());
		 *
		 *
		 *
		 *
		 *
		 * 			}
		 *
		 */


		ChatRunnable chatRunnable = new ChatRunnable(chatRoom);
		Thread chat = new Thread(chatRunnable);
		chat.start();
		move.setBounds(970,660,110,50);
		draw.setBounds(1100,720,110,50);
		kill.setBounds(1100,660,110,50);
		use.setBounds(970,720,110,50);
		leftA.setBounds(130,650,100,120);
		rightA.setBounds(840,650,100,120);
		rightA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(count <8) {
					PaintPanel.setArray(0,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(4) +".png");
					PaintPanel.setArray(1,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(5) +".png");	
					PaintPanel.setArray(2,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(6) +".png");	
					PaintPanel.setArray(3,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(7) +".png");	
				
					PaintPanel.setCardValue(0,new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1,new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2,new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3,new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					count++;
					repaint();
				}
				
			}
			
		});
		leftA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(count >0) {
					PaintPanel.setArray(0,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(1) +".png");
					PaintPanel.setArray(1,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(2) +".png");	
					PaintPanel.setArray(2,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(3) +".png");	
					PaintPanel.setArray(3,"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + PaintPanel.getValue(4) +".png");	
				
					PaintPanel.setCardValue(0,new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1,new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2,new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3,new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					repaint();
					count--;
					
				}
			}
			
		});
		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cout<3) {
					trueOrFalseClick[cout] = true;
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					cout++;
					
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
				}
				else {
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
		
		add(mapG, BorderLayout.CENTER);
		setResizable(false);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static JTextArea getChatRoom() {
		return chatRoom;
	}
	
	
	
}
