package com.game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MapGame extends JFrame {

	private ImageIcon larr = new ImageIcon("C:\\Users\\lpare\\Desktop\\leftArrow.png");
	private ImageIcon rarr = new ImageIcon("C:\\Users\\lpare\\Desktop\\rightArrow.png");
	private boolean trueOrFalseClick[] = { false, false, false, false, false, false, false };
	private int numberValue[] = { 2, 2, 2, 2, 2, 2};
	private int cardValue[] = { 0, 1, 2, 3, 4, 5};
	private static JButton move = new JButton("Move");
	private static JButton draw = new JButton("Draw A Card");
	private static JButton kill = new JButton("Kill");
	private static JButton use = new JButton("Use A Card");
	private JButton leftA = new JButton(larr);
	                                      
	private JButton rightA = new JButton(rarr);
	private JTextField chatText = new JTextField();
	private static JTextArea chatRoom = new JTextArea();

	private static String nL = "\n";
	private JPanel mapG = new PaintPanel();
	private int countNum = 0;
	protected static int numPlayers = 0;
	protected static boolean useTheCard = false;
	static card[] Card = new card[98];
	static room[] Room = new room[32];
	static player player[] = new player[8];
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MapGame() {
		//Merge Code
	
		try {
			Card = loadCards.compileDeck();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Room = loadRooms.compileMansion();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		////////
		// Set up players
		System.out.println("The number players selected are " + numPlayers);
		player= new player[numPlayers+1];
		
		
		for (int i = 0; i <= numPlayers; i++) {
			if(i == 0) {
				player[0] = new player();
				player[0].setAlive();
				player[0].setName("Dr.Lucky");
				player[0].setLocation((int)(Math.random() * 20));
			}else {
			player[i] = new player();
			player[i].setAlive();
			player[i].setName("Player " + Integer.toString(i));
			player[i].setLocation(0);

			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			eventHandler.drawCard(Card, player, i);
			
			}
			player[i].print();
		}
		
		
		for(int j = 0; j < player[1].getPlayerHand().length;j++) {
			int[] playerHand = player[1].getPlayerHand();
			PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
			
		}
		PaintPanel.updateCardImg();
		repaint();
		PaintPanel.updatePlayers(player);
		PaintPanel.updateCards(Card);
		PaintPanel.updateRooms(Room);
		

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
		kill.setEnabled(false);
		rightA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cardValue[5] < 9) {
					cardValue[0] += 1;
					cardValue[1] += 1;
					cardValue[2] += 1;
					cardValue[3] += 1;
					cardValue[4] += 1;
					cardValue[5] += 1;
					numberValue[0] = numberValue[1];
					numberValue[1] = numberValue[2];
					numberValue[2] = numberValue[3];
					numberValue[3] = numberValue[4];
					numberValue[4] = numberValue[5];
					numberValue[5] = numberValue[0];

					PaintPanel.setArray(0, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[0]) + ".png");
					PaintPanel.setArray(1, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[1]) + ".png");
					PaintPanel.setArray(2, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[2]) + ".png");
					PaintPanel.setArray(3, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[3]) + ".png");
					PaintPanel.setArray(4, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[4]) + ".png");
					PaintPanel.setArray(5, PaintPanel.getFileLocat() + "Cards//"
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
					PaintPanel.setArray(0, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[0]) + ".png");
					PaintPanel.setArray(1, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[1]) + ".png");
					PaintPanel.setArray(2, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[2]) + ".png");
					PaintPanel.setArray(3, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[3]) + ".png");
					PaintPanel.setArray(4, PaintPanel.getFileLocat() + "Cards//"
							+ PaintPanel.getP1Value(cardValue[4]) + ".png");
					PaintPanel.setArray(5, PaintPanel.getFileLocat() + "Cards//"
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
					PaintPanel.setCountClick(countNum);
					trueOrFalseClick[countNum] = true;
					PaintPanel.setBoolArrayStart(trueOrFalseClick);
					//cout++;
					trueOrFalseClick = PaintPanel.getBoolArrayBack();
					repaint();
					move.setEnabled(false);
			}

		});
		
		kill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		use.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(GetCardLocation.currentCardNumber >= 1 && GetCardLocation.currentCardNumber <= 43) {
					eventHandler.useFailureCard(player,1, Card, GetCardLocation.currentCardNumber);
					chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
									+",Failure Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					PaintPanel.updateCardImg();
					use.setEnabled(false);
					repaint();
				}
				else if(GetCardLocation.currentCardNumber >= 44 && GetCardLocation.currentCardNumber <= 63) {
					eventHandler.useWeaponCard(player, 1, Card, GetCardLocation.currentCardNumber, true);
					chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
							+",Weapon Card." + nL +"The weapon is " +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					PaintPanel.updateCardImg();
					use.setEnabled(false);
					repaint();
				}
				else if(GetCardLocation.currentCardNumber >= 64 && GetCardLocation.currentCardNumber <= 77) {
					eventHandler.useMoveCard(Card, player, GetCardLocation.currentCardNumber, 1);
					
					chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
							+",Move Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL + "You have " 
							+ Card[GetCardLocation.currentCardNumber].getCardValue() + " turns left." +nL);
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					PaintPanel.updateCardImg();
					use.setEnabled(false);
					repaint();
				}
				else if(GetCardLocation.currentCardNumber >= 78 && GetCardLocation.currentCardNumber <= 97) {
					JOptionPane.showMessageDialog(null, "You or Doctor Lucky?");
					eventHandler.useRoomCard(Room, Card, player, GetCardLocation.currentCardNumber, 1, 1);
					chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
							+",Room Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
					PaintPanel.setPRoom(0,player[1].getLocation());
					PaintPanel.resetPlayerRoom(0);
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					PaintPanel.setPlayerLoad();
					PaintPanel.updatePlayers(player);
					PaintPanel.updateCardImg();
					use.setEnabled(false);
					repaint();
				}
				
				/*
				int selectedCard = 5;
				int type = Card[selectedCard].getCardNumber();
				switch (type) {

				}
				*/
			}
		}

		);
		
		draw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (countNum < PaintPanel.playerNum-1) {
					countNum++;
					chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
							+player[countNum+1].getName() + ",you are in the "
							+Room[player[countNum+1].getLocation()].getRoomFlavor() + nL);
					eventHandler.drawCard(Card, player, 1);
					System.out.println(Arrays.toString(player[1].getPlayerHand()));
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					
					PaintPanel.updateCardImg();
					repaint();
					move.setEnabled(true);
					use.setEnabled(true);
					
					
				} else {
					
					//cout = 0;
					eventHandler.drawCard(Card, player, 1);
					System.out.println(Arrays.toString(player[1].getPlayerHand()));
					for(int j = 0; j < player[1].getPlayerHand().length;j++) {
						int[] playerHand = player[1].getPlayerHand();
						PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));
						
					}
					
					PaintPanel.updateCardImg();
					countNum = 0;
					if(PaintPanel.getDRoom() <=19) {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(PaintPanel.getDRoom()+1);
						player[0].setLocation(PaintPanel.getDRoom());
						PaintPanel.setDoctorLoad();
						MapGame.getChatRoom().append("Doctor Lucky has moved to " + Room[PaintPanel.getDRoom()].getRoomFlavor() + nL);
						repaint();
					}else {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(0);
						player[0].setLocation(PaintPanel.getDRoom());
						PaintPanel.setDoctorLoad();
						MapGame.getChatRoom().append("Doctor Lucky has moved to " + Room[PaintPanel.getDRoom()].getRoomFlavor() + MapGame.getNextLine());

						repaint();
					}
					chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
							+player[countNum+1].getName() + ",you are in the "
							+Room[player[countNum+1].getLocation()].getRoomFlavor() + nL);
					repaint();
					move.setEnabled(true);
					use.setEnabled(true);
					
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

		add(mapG);
		setResizable(false);
		setSize(1530,830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		PaintPanel.updatePlayers(player);
		PaintPanel.updateCards(Card);
		PaintPanel.updateRooms(Room);

	}

	public static JTextArea getChatRoom() {
		return chatRoom;
	}

	public static String getNextLine() {
		return nL;
	}

	public static JButton getMoveJButton() {
		return move;
	}
	
	public static JButton getUseJButton() {
		return use;
	}
	
	public static JButton getKillJButton() {
		return kill;
	}
	
	public static JButton getDrawJButton() {
		return draw;
	}

	public static void setNumPlayers(int newNum) {
		System.out.println("PORTED VALUE: " + newNum);
		numPlayers = newNum;

	}
	
	public static player[] getPlayer() {
		return player;
	}
	
	public static card[] getCard() {
		return Card;
	}
	public static room[] getRoom() {
		return Room;
	}

}
