package com.game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MapGame extends JFrame {

	private ImageIcon larr = new ImageIcon("C:\\Users\\lpare\\Desktop\\leftArrow.png");
	private ImageIcon rarr = new ImageIcon("C:\\Users\\lpare\\Desktop\\rightArrow.png");
	private boolean trueOrFalseClick[] = { false, false, false, false, false, false, false };
	private int numberValue[] = { 2, 2, 2, 3, 3, 3 };
	private int cardValue[] = { 0, 1, 2, 3, 4, 5 };
	private static JButton move = new JButton("Move");
	private JButton draw = new JButton("Draw A Card");
	private JButton kill = new JButton("Kill");
	private JButton use = new JButton("Use A Card");
	private JButton leftA = new JButton(larr);
	                                      
	private JButton rightA = new JButton(rarr);
	private JTextField chatText = new JTextField();
	private static JTextArea chatRoom = new JTextArea();

	private static String nL = "\n";
	private JPanel mapG = new PaintPanel();
	private int countNum = 0;
	private int cout = 0;
	static int numPlayers = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MapGame() {
		/*Merge Code
		card[] Card = new card[98];
		try {
			Card = loadCards.compileDeck();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			room[] Room = loadRooms.compileMansion();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		////////
		// Set up players
		System.out.println("The number players selected are " + numPlayers);
		player player[] = new player[numPlayers+1];
	
		player[0] = new player();
		player[0].setAlive();
		player[0].setName("Dr.Lucky");
		player[0].setLocation((int) Math.random() * 20);

		for (int i = 1; i <= numPlayers; i++) {

			player[i] = new player();
			player[i].setAlive();
			player[i].setName("THE PLAYA'");
			player[i].setLocation(0);

			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);

		}

		//player[0].print();
		//player[1].print();
		//player[2].print();
		//player[3].print();
		//player[4].print();
		//player[5].print();
		//player[6].print();
		//player[7].print();

		int[] playerHand = player[3].getPlayerHand();
		*/
		setLayout(new BorderLayout());
		mapG.setLayout(null);
		JScrollPane scroll = new JScrollPane(chatRoom);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(1230, 21, 270, 550);
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
		move.setBounds(1150, 660, 160, 50);
		move.setFont(new Font("Arial", Font.BOLD, 25));
		draw.setBounds(1340, 720, 160, 50);
		draw.setFont(new Font("Arial", Font.BOLD, 20));
		kill.setBounds(1340, 660, 160, 50);
		kill.setFont(new Font("Arial", Font.BOLD, 25));
		use.setBounds(1150, 720, 160, 50);
		use.setFont(new Font("Arial", Font.BOLD, 20));
		leftA.setBounds(130, 650, 50, 110);
		rightA.setBounds(1050, 650, 50, 110);
		rightA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cardValue[5] < 7) {
					cardValue[0] += 1;
					cardValue[1] += 1;
					cardValue[2] += 1;
					cardValue[3] += 1;
					cardValue[4] += 1;
					cardValue[5] += 1;
					PaintPanel.setArray(0, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[0])
							+ PaintPanel.getP1Value(cardValue[0]) + ".png");
					PaintPanel.setArray(1, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[1])
							+ PaintPanel.getP1Value(cardValue[1]) + ".png");
					PaintPanel.setArray(2, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[2])
							+ PaintPanel.getP1Value(cardValue[2]) + ".png");
					PaintPanel.setArray(3, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[3])
							+ PaintPanel.getP1Value(cardValue[3]) + ".png");
					PaintPanel.setArray(4, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[4])
							+ PaintPanel.getP1Value(cardValue[4]) + ".png");
					PaintPanel.setArray(5, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[5])
							+ PaintPanel.getP1Value(cardValue[5]) + ".png");

					PaintPanel.setCardValue(0, new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1, new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2, new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3, new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					PaintPanel.setCardValue(4, new ImageIcon(PaintPanel.getImageValue(4)).getImage());
					PaintPanel.setCardValue(5, new ImageIcon(PaintPanel.getImageValue(5)).getImage());

					repaint();
					numberValue[0] = numberValue[1];
					numberValue[1] = numberValue[2];
					numberValue[2] = numberValue[3];
					numberValue[3] = numberValue[4];
					numberValue[4] = numberValue[5];
					numberValue[5] = numberValue[0];

				}
			}

		});
		leftA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cardValue[0] > 0) {
					cardValue[0] -= 1;
					cardValue[1] -= 1;
					cardValue[2] -= 1;
					cardValue[3] -= 1;
					cardValue[4] -= 1;
					cardValue[5] -= 1;
					PaintPanel.setArray(0, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[0])
							+ PaintPanel.getP1Value(cardValue[0]) + ".png");
					PaintPanel.setArray(1, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[1])
							+ PaintPanel.getP1Value(cardValue[1]) + ".png");
					PaintPanel.setArray(2, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[2])
							+ PaintPanel.getP1Value(cardValue[2]) + ".png");
					PaintPanel.setArray(3, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[3])
							+ PaintPanel.getP1Value(cardValue[3]) + ".png");
					PaintPanel.setArray(4, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[4])
							+ PaintPanel.getP1Value(cardValue[4]) + ".png");
					PaintPanel.setArray(5, PaintPanel.getFileLocat() + PaintPanel.getCardValue(numberValue[5])
							+ PaintPanel.getP1Value(cardValue[5]) + ".png");

					PaintPanel.setCardValue(0, new ImageIcon(PaintPanel.getImageValue(0)).getImage());
					PaintPanel.setCardValue(1, new ImageIcon(PaintPanel.getImageValue(1)).getImage());
					PaintPanel.setCardValue(2, new ImageIcon(PaintPanel.getImageValue(2)).getImage());
					PaintPanel.setCardValue(3, new ImageIcon(PaintPanel.getImageValue(3)).getImage());
					PaintPanel.setCardValue(4, new ImageIcon(PaintPanel.getImageValue(4)).getImage());
					PaintPanel.setCardValue(5, new ImageIcon(PaintPanel.getImageValue(5)).getImage());
					repaint();
				}

			}

		});
		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (countNum < PaintPanel.playerNum) {
					PaintPanel.setCountClick(countNum);
					trueOrFalseClick[countNum] = true;
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					//cout++;
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
					move.setEnabled(false);
					countNum++;
				} else {
					countNum = 0;
					//cout = 0;
					PaintPanel.setCountClick(countNum);
					
					trueOrFalseClick[countNum] = true;
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					//cout++;
					countNum++;
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
				}
			}

		});

		use.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				int selectedCard = 5;
				int type = Card[selectedCard].getCardNumber();
				switch (type) {

				}
				*/
			}
		}

		);

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

	public static String getNextLine() {
		return nL;
	}

	public static JButton getJButton() {
		return move;
	}

	public static void setNumPlayers(int newNum) {
		System.out.println("PORTED VALUE: " + newNum);
		numPlayers = newNum;

	}

}
