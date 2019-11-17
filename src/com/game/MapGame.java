package com.game;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MapGame extends JFrame {

	private ImageIcon larr = new ImageIcon("C:\\Users\\lpare\\Desktop\\leftArrow.png");
	private ImageIcon rarr = new ImageIcon("C:\\Users\\lpare\\Desktop\\rightArrow.png");
	private boolean trueOrFalseClick[] = { false, false, false, false, false, false, false };
	private static int cardValue[] = { 0, 1, 2, 3, 4, 5};
	private static JButton move = new JButton("Move");
	private static JButton draw = new JButton("Draw A Card");
	private static JButton kill = new JButton("Kill");
	private static JButton use = new JButton("Use A Card");
	private JButton leftA = new JButton(larr);                                  
	private JButton rightA = new JButton(rarr);
	private JTextField chatText = new JTextField();
	private static JTextArea chatRoom = new JTextArea();

	private static JButton yes = new JButton("Yes");
	private static JButton no = new JButton("No");
	private static JLabel ques = new JLabel("Is it You?");
	private static String nL = "\n";
	private JPanel mapG = new PaintPanel();
	protected static int countNum = 0;
	protected static int numPlayers = 0;
	protected static boolean useTheCard = false;
	static card[] Card = new card[98];
	static room[] Room = new room[32];
	static player player[] = new player[8];
	static boolean Key = false;
	static int weaponPower = 0;
	static int failureValue = 0;
	static int playerAttack = 0;
	static int targetValue = 0;
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
		player= new player[8];
		
		
		for (int i = 0; i < 8; i++) {
			if(i == 0) {
				player[0] = new player();
				player[0].setAlive();
				player[0].setName("Dr.Lucky");
				player[0].setLocation((int)(Math.random() * 20));
				player[i].print();
			}
			else if(i>=1 && i<=numPlayers) {
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
				player[i].print();
			}
			else {
				player[i] = new player();	
			}
			
		}
		setCardDeck(1);
		player[1].addTurns(1);
		PaintPanel.updateCardImg();
		PaintPanel.updatePlayers(player);
		PaintPanel.updateCards(Card);
		PaintPanel.updateRooms(Room);
		repaint();

		

		mapG.setLayout(null);
		JInternalFrame ifYou = new JInternalFrame();
		ifYou.setSize(200,150);
		ifYou.setVisible(false);
		ifYou.setLayout(null);
		ifYou.setLocation(650, 350);
		yes.setBounds(30, 70, 60, 40);
		no.setBounds(100, 70, 60, 40);
		ques.setBounds(70, 20, 60, 40);
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				targetValue=countNum + 1;
				eventHandler.useRoomCard(Room, Card, player, GetCardLocation.currentCardNumber, countNum+1, targetValue);
				chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
						+",Room Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
				PaintPanel.setPRoom(countNum,player[countNum+1].getLocation());
				PaintPanel.resetPlayerRoom(countNum);
				setCardDeck(countNum+1);
				PaintPanel.setPlayerLoad();
				PaintPanel.updatePlayers(player);
				PaintPanel.updateCardImg();
				use.setEnabled(false);
				ifYou.setVisible(false);
				repaint();
			}
			
		});
		
		no.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				targetValue = 0;
				eventHandler.useRoomCard(Room, Card, player, GetCardLocation.currentCardNumber,  targetValue,countNum+1);
				chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
						+",Room Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
				PaintPanel.setDRoom(player[0].getLocation());
				PaintPanel.setDoctorLoad();
				System.out.println("Doctor Lucky:" + PaintPanel.getDRoom());
				MapGame.getChatRoom().append("Doctor Lucky has moved to " + Room[PaintPanel.getDRoom()].getRoomFlavor() + nL);
				setCardDeck(countNum+1);
				PaintPanel.updatePlayers(player);
				PaintPanel.updateCardImg();
				use.setEnabled(false);
				ifYou.setVisible(false);
				repaint();
			}
			
		});
		
		
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
				if (cardValue[5] < 9) {
					cardValue[0] += 1;
					cardValue[1] += 1;
					cardValue[2] += 1;
					cardValue[3] += 1;
					cardValue[4] += 1;
					cardValue[5] += 1;
					for(int i = 0;i<6;i++) {
						PaintPanel.setArray(i, PaintPanel.getFileLocat() + "Cards//"
								+ PaintPanel.getP1Value(cardValue[i]) + ".png");
						PaintPanel.setCardValue(i, new ImageIcon(PaintPanel.getImageValue(i)).getImage());
						
					}

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
					//for loop
					for(int i = 0;i<6;i++) {
						PaintPanel.setArray(i, PaintPanel.getFileLocat() + "Cards//"
								+ PaintPanel.getP1Value(cardValue[i]) + ".png");
						PaintPanel.setCardValue(i, new ImageIcon(PaintPanel.getImageValue(i)).getImage());
						
					}
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
				player[countNum+1].endTurn();
				repaint();
				move.setEnabled(false);
			}

		});
		
		kill.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(GetCardLocation.currentCardNumber >= 44 && GetCardLocation.currentCardNumber <= 63) {
					playerAttack = countNum;
					eventHandler.useWeaponCard(player, countNum+1, Card, 
							GetCardLocation.currentCardNumber, true);
					chatRoom.append("You used the weapon card number " + 
							GetCardLocation.currentCardNumber + nL + "Weapon Value: " + 
							Card[GetCardLocation.currentCardNumber].getCardValue()+nL);
					setCardDeck(countNum+1);
					weaponPower = Card[GetCardLocation.currentCardNumber].getCardValue();
					
					countNum++;
					chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
							+player[countNum+1].getName() + ",get a Failure card to counterattack" + nL);
					setCardDeck(countNum+1);
					PaintPanel.updateCardImg();
					repaint();
					printAllPlayers();
					move.setEnabled(false);
					kill.setEnabled(false);
					draw.setEnabled(false);
					use.setEnabled(true);
					Key = true;
					MapGame.useTheCard = false;
					
					//eventHandler.killDoctorLucky(countNum+1,Card[GetCardLocation.currentCardNumber].getCardValue(), Card, player, Room);
				
				}else{
					chatRoom.append("You can't use this card. Not a weapon card." + nL);
					repaint();
					MapGame.useTheCard = false;
				}
			}
			
		});

		use.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Key == false) {
					if(GetCardLocation.currentCardNumber >= 1 && GetCardLocation.currentCardNumber <= 43) {
						eventHandler.useFailureCard(player,countNum+1, Card, GetCardLocation.currentCardNumber);
						chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
										+",Failure Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						MapGame.useTheCard = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 44 && GetCardLocation.currentCardNumber <= 63) {
						eventHandler.useWeaponCard(player, countNum+1, Card, GetCardLocation.currentCardNumber, true);
						chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
								+",Weapon Card." + nL +"The weapon is " +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						MapGame.useTheCard = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 64 && GetCardLocation.currentCardNumber <= 77) {
						eventHandler.useMoveCard(Card, player, GetCardLocation.currentCardNumber, countNum+1);
						
						chatRoom.append("You used card number " + Card[GetCardLocation.currentCardNumber].getCardNumber() 
								+",Move Card." + nL +Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL + "You have " 
								+ Card[GetCardLocation.currentCardNumber].getCardValue() + " turns left." +nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						System.out.println("Turns: " + player[1].getTurnsLeft());
						move.setEnabled(true);
						MapGame.useTheCard = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 78 && GetCardLocation.currentCardNumber <= 97) {
						ifYou.setVisible(true);	
						MapGame.useTheCard = false;
						
					}
				}
				
				if(Key == true) {
					if(GetCardLocation.currentCardNumber >= 1 && GetCardLocation.currentCardNumber <= 43) {
						failureValue += eventHandler.useFailureCard(player, countNum +1, Card, GetCardLocation.currentCardNumber);
						chatRoom.append("You used Failure Card. Value: " + 
										Card[GetCardLocation.currentCardNumber].getCardValue() + nL);
						printKillPlayerLoop();
						if (countNum < PaintPanel.playerNum-1) {
							
							if(playerAttack == countNum) {
								chatRoom.append(player[countNum+1].getName() + ",your turn." + nL);
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								repaint();
								printAllPlayers();
								MapGame.useTheCard = false;
								if(eventHandler.killDoctorLucky(playerAttack+1, weaponPower, Card, player, Room) == false) {
									chatRoom.append("You failed to Kill Doctor Lucky"+nL);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(true);
									Key = false;
									
								}else {
									chatRoom.append("You win!"+nL);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(false);
									
							}}else {
								countNum++;
								chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
										+player[countNum+1].getName() + ",get a failure card to counterattack." + nL);
								
								
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								MapGame.useTheCard = false;
								repaint();
								printAllPlayers();
								move.setEnabled(false);
								kill.setEnabled(false);
								draw.setEnabled(false);
								use.setEnabled(true);
							}
							
							
						}else {
							
							//cout = 0;
							countNum = 0;
							
							if(playerAttack == countNum) {
								chatRoom.append(player[countNum+1].getName() + ",your turn." + nL);
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								MapGame.useTheCard = false;
								repaint();
								printAllPlayers();
								if(eventHandler.killDoctorLucky(playerAttack+1, weaponPower, Card, player, Room) == false) {
									chatRoom.append("You failed to Kill Doctor Lucky"+nL);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(true);
									Key = false;
									
								}else {
									chatRoom.append("You win!"+nL);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(false);
									
							}}else {
							setCardDeck(countNum + 1);
							
							PaintPanel.updateCardImg();
							printAllPlayers();
							chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
									+player[countNum+1].getName() + ",please use a failure card to counterattack." + nL);
							MapGame.useTheCard = false;
							repaint();
							move.setEnabled(false);
							kill.setEnabled(false);
							draw.setEnabled(false);
							use.setEnabled(true);
							repaint();
							}
					}
					}else
						chatRoom.append("You can't use this card. Not a failure card" + nL);
						
						repaint();
				}
			}
				/*
				int selectedCard = 5;
				int type = Card[selectedCard].getCardNumber();
				switch (type) {

				}
				*/
			});
		
		draw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (countNum < PaintPanel.playerNum-1) {
					eventHandler.drawCard(Card, player, countNum+1);
					player[countNum+1].addTurns(1);
					countNum++;
					chatRoom.append(player[countNum+1].getName() + ",your turn." + nL
							+player[countNum+1].getName() + ",you are in the "
							+Room[player[countNum+1].getLocation()].getRoomFlavor() + nL);
					
					
					setCardDeck(countNum+1);
					PaintPanel.updateCardImg();
					PaintPanel.updatePlayers(player);
					repaint();
					printAllPlayers();
					move.setEnabled(true);
					use.setEnabled(true);
					
					
				}else {
					
					
					//cout = 0;
					eventHandler.drawCard(Card, player, countNum+1);
					
					countNum = 0;
					setCardDeck(countNum + 1);
					player[countNum+1].addTurns(1);
					PaintPanel.updatePlayers(player);
					
					PaintPanel.updateCardImg();
					printAllPlayers();
					if(PaintPanel.getDRoom() <=19) {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(PaintPanel.getDRoom()+1);
						player[countNum].setLocation(PaintPanel.getDRoom());
						PaintPanel.setDoctorLoad();
						MapGame.getChatRoom().append("Doctor Lucky has moved to " + Room[PaintPanel.getDRoom()].getRoomFlavor() + nL);
						repaint();
					}else {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(0);
						player[countNum].setLocation(PaintPanel.getDRoom());
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
		
		
		ifYou.add(yes);
		ifYou.add(no);
		ifYou.add(ques);
		mapG.add(leftA);
		mapG.add(rightA);
		mapG.add(move);
		mapG.add(draw);
		mapG.add(kill);
		mapG.add(use);
		mapG.add(chatText);
		mapG.add(scroll);
		mapG.add(ifYou);

		add(mapG);
		
		setResizable(false);
		setSize(1530,830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		PaintPanel.updatePlayers(player);
		PaintPanel.updateCards(Card);
		PaintPanel.updateRooms(Room);

	}
	
	public static int getCardValue(int n) {
		return cardValue[n];
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
	
	public static void setCardDeck(int num) {
		for(int j = 0; j < player[num].getPlayerHand().length;j++) {
			int[] playerHand = player[num].getPlayerHand();
			PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));	
		}
	}
	
	public static void printAllPlayers() {
		for(int j = 0; j >numPlayers;j++) {
			player[j].print();
		}
	}
	
	public static int getCountNum() {
		return countNum;
	}
	
	public static void printKillPlayerLoop() {
		System.out.println("Player turn who is trying to kill: "+ playerAttack);
		System.out.println("CountNum: " + countNum);
	}

}
