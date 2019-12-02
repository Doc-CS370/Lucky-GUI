package com.game;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MapGame extends JFrame{

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
	
	private static JButton resume = new JButton("Resume");
	private static JButton saveGame = new JButton("Save Game");
	private static JButton exit = new JButton("Exit");
	private static JButton startOver = new JButton("Start Over");
	private static JButton mainMenu = new JButton("Main Menu");
	private static String nL = "\n";
	private JPanel mapG = new PaintPanel();
	protected static int countNum = 0;
	protected static int numPlayers = 0;
	protected static boolean useTheCard = false;
	static boolean Key = false;
	static int weaponPower = 0;
	static int failureValue = 0;
	static int playerAttack = 0;
	static int targetValue = 0;
	static GlobalValues map = GlobalValues.GlobalValues();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MapGame() {
		//Merge Code

		////////
		// Set up players
		System.out.println("The number players selected are " + numPlayers);
		map.Player= new player[8];
		
		
		for (int i = 0; i < 8; i++) {
			if(i == 0) {
				map.Player[0] = new player();
				map.Player[0].setAlive();
				map.Player[0].setName("Dr.Lucky");
				map.Player[0].setLocation((int)(Math.random() * 20));
				map.Player[0].print();
			}
			else if(i>=1 && i<=numPlayers) {
				map.Player[i] = new player();
				map.Player[i].setAlive();
				map.Player[i].setName("Player " + Integer.toString(i));
				map.Player[i].setLocation(0);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				eventHandler.drawCard(map.Card, map.Player, i);
				map.Player[i].print();
			}
			else {
				map.Player[i] = new player();	
			}
			
		}
		map.Player[1].addTurns(1);
		setCardDeck(1);
		PaintPanel.updateCardImg();
		repaint();
		mapG.setLayout(null);
		mapG.setFocusable(true);
		JInternalFrame ifYou = new JInternalFrame();
		ifYou.setSize(200,150);
		ifYou.setVisible(false);
		ifYou.setLayout(null);
		ifYou.setLocation(650, 350);
		
		JInternalFrame pause = new JInternalFrame();
		pause.setLayout(null);
		pause.setSize(200,200);
		pause.setLocation(650,350);
		pause.setVisible(false);
		JInternalFrame endGame = new JInternalFrame();
		endGame.setLayout(null);
		endGame.setSize(200,200);
		endGame.setLocation(650,350);
		endGame.setVisible(false);
		startOver.setBounds(45,30,100,40);
		mainMenu.setBounds(45,90,100,40);
		resume.setBounds(45, 10, 100, 40);
		saveGame.setBounds(45, 60, 100, 40);
		exit.setBounds(45, 110, 100, 40);
		yes.setBounds(30, 70, 60, 40);
		no.setBounds(100, 70, 60, 40);
		ques.setBounds(70, 20, 60, 40);
		
		mapG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Key is Pressed");
					pause.setVisible(true);
					repaint();
				}
			}
			
		});
		startOver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				SelectPlayer y = new SelectPlayer();
				y.setVisible(true);
				repaint();
			}
			
		});
		
		mainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				MainMenu u = new MainMenu();
				u.setVisible(true);
				repaint();
			}
			
		});
		resume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pause.setVisible(false);
				repaint();
			}
			
		});
		
		saveGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				MainMenu m = new MainMenu();
				m.setVisible(true);
			}
			
		});
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
				targetValue=countNum + 1;
				eventHandler.useRoomCard(map.Room, map.Card, map.Player, GetCardLocation.currentCardNumber, targetValue,countNum+1);
				chatRoom.append("You used card number " + map.Card[GetCardLocation.currentCardNumber].getCardNumber() 
						+",Room Card." + nL + map.Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
				PaintPanel.setPRoom(countNum,map.Player[countNum+1].getLocation());
				PaintPanel.resetPlayerRoom(countNum);
				setCardDeck(countNum+1);
				PaintPanel.setPlayerLoad();
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
				//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
				targetValue = 0;
				eventHandler.useRoomCard(map.Room, map.Card, map.Player, GetCardLocation.currentCardNumber,  targetValue,countNum+1);
				chatRoom.append("You used card number " + map.Card[GetCardLocation.currentCardNumber].getCardNumber() 
						+",Room Card." + nL + map.Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
				PaintPanel.setDRoom(map.Player[0].getLocation());
				PaintPanel.setDoctorLoad();
				System.out.println("Doctor Lucky:" + PaintPanel.getDRoom());
				MapGame.getChatRoom().append("Doctor Lucky has moved to " + map.Room[PaintPanel.getDRoom()].getRoomFlavor() + nL);
				setCardDeck(countNum+1);
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
						PaintPanel.setArray(i, PaintPanel.getFileLocat() + "Cards/"
								+ PaintPanel.getP1Value(cardValue[i]) + ".png");
						PaintPanel.setCardValue(i, new ImageIcon(PaintPanel.getImageValue(i)).getImage());
						GetCardLocation.updatePlayerHand(i);
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
						PaintPanel.setArray(i, PaintPanel.getFileLocat() + "Cards/"
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
				repaint();
				move.setEnabled(false);
			}

		});
		
		kill.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(GetCardLocation.currentCardNumber >= 44 && GetCardLocation.currentCardNumber <= 63 && 
						map.Player[countNum+1].getLocation() == map.Player[0].getLocation() && 
						!witnessCheck.checkForWitness(map.Room, map.Player, countNum+1)) {
					playerAttack = countNum;
					//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
					eventHandler.useWeaponCard(map.Player, countNum+1, map.Card, 
							GetCardLocation.currentCardNumber, true);
					chatRoom.append("You used the weapon card number " + 
							GetCardLocation.currentCardNumber + nL + "Weapon Value: " + 
							map.Card[GetCardLocation.currentCardNumber].getCardValue()+nL);
					setCardDeck(countNum+1);
					weaponPower = map.Card[GetCardLocation.currentCardNumber].getCardValue();
					
					countNum++;
					chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL
							+map.Player[countNum+1].getName() + ",get a Failure card to counterattack" + nL);
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
					if(!witnessCheck.checkForWitness(map.Room,map.Player,countNum+1))
						chatRoom.append("You can't use this card." + nL);
						chatRoom.append("Witnesses: " + map.Room[map.Player[countNum + 1].getLocation()].getNumberOfOccupants()+nL);
					if(map.Player[countNum+1].getLocation() == map.Player[0].getLocation()){
						chatRoom.append("You can't use this card." + nL);
						chatRoom.append("You are not in the same location as Doctor Lucky."+nL);
					}
					if(GetCardLocation.currentCardNumber <=43 && GetCardLocation.currentCardNumber >=64) {
						chatRoom.append("You can't use this card." + nL + "Not a weapon card." + nL);
					}
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
						//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
						eventHandler.useFailureCard(map.Player,countNum+1, map.Card, GetCardLocation.currentCardNumber);
						chatRoom.append("You used card number " + map.Card[GetCardLocation.currentCardNumber].getCardNumber() 
										+",Failure Card." + nL +map.Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						MapGame.useTheCard = false;
						//GetCardLocation.isEnabled = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 44 && GetCardLocation.currentCardNumber <= 63) {
						//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
						eventHandler.useWeaponCard(map.Player, countNum+1, map.Card, GetCardLocation.currentCardNumber, true);
						chatRoom.append("You used card number " + map.Card[GetCardLocation.currentCardNumber].getCardNumber() 
								+",Weapon Card." + nL +"The weapon is " + map.Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						MapGame.useTheCard = false;
						//GetCardLocation.isEnabled = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 64 && GetCardLocation.currentCardNumber <= 77) {
						//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
						eventHandler.useMoveCard(map.Card, map.Player, GetCardLocation.currentCardNumber, countNum+1);
						chatRoom.append("You used card number " + map.Card[GetCardLocation.currentCardNumber].getCardNumber() 
								+",Move Card." + nL +map.Card[GetCardLocation.currentCardNumber].getCardFlavor() + nL + "You have " 
								+ map.Player[countNum+1].getTurnsLeft() + " turns left." +nL);
						setCardDeck(countNum+1);
						PaintPanel.updateCardImg();
						use.setEnabled(false);
						move.setEnabled(true);
						MapGame.useTheCard = false;
						//GetCardLocation.isEnabled = false;
						repaint();
					}
					else if(GetCardLocation.currentCardNumber >= 78 && GetCardLocation.currentCardNumber <= 97) {
						ifYou.setVisible(true);	
						MapGame.useTheCard = false;
						//GetCardLocation.isEnabled = false;
						
					}
				}
				
				if(Key == true) {
					if(GetCardLocation.currentCardNumber >= 1 && GetCardLocation.currentCardNumber <= 43) {
						//SoundEffect.play(map.Card, GetCardLocation.currentCardNumber);
						failureValue += eventHandler.useFailureCard(map.Player, countNum +1, map.Card, GetCardLocation.currentCardNumber);
						chatRoom.append("You used Failure Card. Value: " + 
										map.Card[GetCardLocation.currentCardNumber].getCardValue() + nL);
						printKillPlayerLoop();
						if (countNum < PaintPanel.playerNum-1) {
							
							if(playerAttack == countNum) {
								chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL);
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								repaint();
								printAllPlayers();
								MapGame.useTheCard = false;
								//GetCardLocation.isEnabled = false;
								if(eventHandler.killDoctorLucky(playerAttack+1, weaponPower, map.Card, map.Player, map.Room) == false) {
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
								chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL
										+map.Player[countNum+1].getName() + ",get a failure card to counterattack." + nL);
								
								
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								MapGame.useTheCard = false;
								//GetCardLocation.isEnabled = false;
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
								chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL);
								setCardDeck(countNum+1);
								PaintPanel.updateCardImg();
								MapGame.useTheCard = false;
								repaint();
								printAllPlayers();
								if(eventHandler.killDoctorLucky(playerAttack+1, weaponPower, map.Card, map.Player, map.Room) == false) {
									chatRoom.append("You failed to Kill Doctor Lucky"+nL);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(true);
									Key = false;
									
								}else {
									chatRoom.append("You win!"+nL);
									endGame.setVisible(true);
									use.setEnabled(false);
									move.setEnabled(false);
									kill.setEnabled(false);
									draw.setEnabled(false);
									
							}}else {
							setCardDeck(countNum + 1);
							
							PaintPanel.updateCardImg();
							printAllPlayers();
							chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL
									+map.Player[countNum+1].getName() + ",please use a failure card to counterattack." + nL);
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
					countNum++;
					printAllPlayers();
					eventHandler.drawCard(map.Card, map.Player, countNum+1);
					map.Player[countNum+1].addTurns(1);
					
					chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL
							+map.Player[countNum+1].getName() + ",you are in the "
							+map.Room[map.Player[countNum+1].getLocation()].getRoomFlavor() + nL
							+"Turns: " +map.Player[countNum+1].getTurnsLeft() + nL);
					
					GetCardLocation.printPlayerHand();
					setCardDeck(countNum+1);
					PaintPanel.updateCardImg();
					repaint();
					printAllPlayers();
					move.setEnabled(true);
					use.setEnabled(true);
					
					
					
				}else {
					
					
					//cout = 0;
					eventHandler.drawCard(map.Card, map.Player, countNum+1);
					printAllPlayers();
					countNum = 0;
					setCardDeck(countNum + 1);
					map.Player[countNum+1].addTurns(1);
					PaintPanel.updateCardImg();
					GetCardLocation.printPlayerHand();
					printAllPlayers();
					if(PaintPanel.getDRoom() <=19) {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(PaintPanel.getDRoom()+1);
						map.Player[countNum].setLocation(PaintPanel.getDRoom());
						PaintPanel.setDoctorLoad();
						MapGame.getChatRoom().append("Doctor Lucky has moved to " + map.Room[PaintPanel.getDRoom()].getRoomFlavor() + nL);
						repaint();
					}else {
						PaintPanel.setCountClick(0);
						PaintPanel.setDRoom(0);
						map.Player[countNum].setLocation(PaintPanel.getDRoom());
						PaintPanel.setDoctorLoad();
						MapGame.getChatRoom().append("Doctor Lucky has moved to " + map.Room[PaintPanel.getDRoom()].getRoomFlavor() + MapGame.getNextLine());
						repaint();
					}
					chatRoom.append(map.Player[countNum+1].getName() + ",your turn." + nL
							+map.Player[countNum+1].getName() + ",you are in the "
							+map.Room[map.Player[countNum+1].getLocation()].getRoomFlavor() + nL
							+"Turns: " +map.Player[countNum+1].getTurnsLeft() + nL);
					repaint();
					move.setEnabled(true);
					use.setEnabled(true);				
				}
				
				
			}
			
		});
		
		
		ifYou.add(yes);
		ifYou.add(no);
		ifYou.add(ques);
		pause.add(exit);
		pause.add(resume);
		pause.add(saveGame);
		endGame.add(startOver);
		endGame.add(mainMenu);
		mapG.add(leftA);
		mapG.add(rightA);
		mapG.add(move);
		mapG.add(draw);
		mapG.add(kill);
		mapG.add(use);
		mapG.add(chatText);
		mapG.add(scroll);
		mapG.add(ifYou);
		mapG.add(pause);
		mapG.add(endGame);
		add(mapG);
		
		setResizable(false);
		setSize(1530,830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

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
	
	public static void setCardDeck(int num) {
		for(int j = 0; j < map.Player[num].getPlayerHand().length;j++) {
			int[] playerHand = map.Player[num].getPlayerHand();
			PaintPanel.setP1Value(j,Integer.toString(playerHand[j]));	
		}
		for(int i = 0; i<6;i++) {
			GetCardLocation.updatePlayerHand(i);
		}
	}
	
	public static void printAllPlayers() {
		for(int j = 0; j >numPlayers;j++) {
			map.Player[j].print();
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
