package com.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	/**
	 * 
	 */
	private static String fileLocat = "C:\\Users\\lpare\\Desktop\\";
	
	private static final long serialVersionUID = 1L;
	private static String p1value[] = {Integer.toString((int) (Math.random() * 14)+64),
			Integer.toString((int) (Math.random() * 14)+64),Integer.toString((int) (Math.random() * 14)+64),
			Integer.toString((int) (Math.random() * 14)+64),Integer.toString((int) (Math.random() * 14)+64),
			Integer.toString((int) (Math.random() * 14)+64),Integer.toString((int) (Math.random() * 14)+64),"0","0","0"};
	private static String p2value[] = {Integer.toString((int) (Math.random() * 20)+78),
			Integer.toString((int) (Math.random() * 20)+78),Integer.toString((int) (Math.random() * 20)+78),
			Integer.toString((int) (Math.random() * 20)+78),Integer.toString((int) (Math.random() * 20)+78),
			Integer.toString((int) (Math.random() * 20)+78),Integer.toString((int) (Math.random() * 20)+78),"0","0","0"};
	private static String p3value[] = {Integer.toString((int) (Math.random() * 14)+64),
			Integer.toString((int) (Math.random() * 14)+64),Integer.toString((int) (Math.random() * 14)+64),
			Integer.toString((int) (Math.random() * 20)+78),Integer.toString((int) (Math.random() * 20)+78),
			Integer.toString((int) (Math.random() * 20)+78),Integer.toString((int) (Math.random() * 20)+78),"0","0","0"};
	private static String p1[] = {fileLocat+"Cards//" + p1value[0] +".png", 
									fileLocat + "Cards//" + p1value[1] +".png",
									fileLocat + "Cards//"+ p1value[2] +".png",
									fileLocat +"Cards//" + p1value[3] +".png",
									fileLocat +"Cards//" + p1value[4] +".png",
									fileLocat + "Cards//"+ p1value[5] +".png"};
	private static Image playerIcons[] = {new ImageIcon(fileLocat + "Dr.Lucky Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player1 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player2 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player3 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player4 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player5 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player6 Chip.png").getImage(),
											new ImageIcon(fileLocat + "Player7 Chip.png").getImage(),
											};
	//x and y coordinates for each player
	private static int ArrayCT[][] = {{1075,530},{1000,30},{1150,30},{1000,200},{1150,200},{1000,370},
									{1150,370},{1330,200}};
	final private int pawnWidth = 35;
	final private int pawnHeight = 35;

	private Image backImg = new ImageIcon(fileLocat + "Map_with_special_rooms.png").getImage();
	//cardImg
	private static Image cardImg[] = {new ImageIcon(p1[0]).getImage(),
										new ImageIcon(p1[1]).getImage(),
										new ImageIcon(p1[2]).getImage(),
										new ImageIcon(p1[3]).getImage(),
										new ImageIcon(p1[4]).getImage(),
										new ImageIcon(p1[5]).getImage()};
	//
	protected static int playerNum = 0;
	private static SetPawnLocation pxy = new SetPawnLocation();
	//Player Rooms
	private static int pRoom[] = {0,0,0,0,0,0,0};
	//Doctor Lucky Rooms
	private static int dRoom = (int)(Math.random() * 20);
	private static boolean clicks[] = {false,false,false,false,false,false,false};
	private static int countClick = 0;
	static card[] Card = new card[98];
	static room[] Room = new room[32];
	static player[] player = new player[8];
	static boolean goHighlights = false;
	
	
	PaintPanel(){
		updatePlayers(MapGame.player);
		
		setDoctorLoad();
		setPlayerLoad();
		MapGame.getChatRoom().append("Welcome to Doctor Lucky!" + MapGame.getNextLine());
		MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
 		//Map drawn
		g2d.drawImage(backImg,10, 10, 1200,600,this);
		
		//Image drawn
		g2d.drawImage(cardImg[0], 220,640,120,145,this);
		
		g2d.drawImage(cardImg[1], 360,640,120,145,this);
		
		g2d.drawImage(cardImg[2], 500,640,120,145,this);
		
		g2d.drawImage(cardImg[3], 640,640,120,145,this);
		
		g2d.drawImage(cardImg[4], 780,640,120,145,this);
		
		g2d.drawImage(cardImg[5], 920,640,120,145,this);
		
		//Spite Token
		g2d.setColor(Color.black);
		g2d.fillOval(35,700,80,80);
		g2d.setFont(new Font("ComicSans",Font.PLAIN,15));
		g2d.drawString("Spite Tokens",33,680);
		
		//Doctor Lucky
		g2d.drawImage(playerIcons[0],ArrayCT[0][0],ArrayCT[0][1], pawnWidth,pawnHeight,this);
		
		//Player 1,2,3 Drawn
		if(playerNum >= 3) {
			
				//Player 1 Token
				g2d.drawImage(playerIcons[1],ArrayCT[1][0],ArrayCT[1][1], pawnWidth,pawnHeight,this);
				this.addMouseListener(new MouseAdapter() {	
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[0] == true) {
							
							ArrayCT[1][0] = e.getX() - 12;
							ArrayCT[1][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[1][0],ArrayCT[1][1]);
							pRoom[0] = GetPawnLocation.getRoom();
							player[1].setLocation(pRoom[0]);
							player[1].print();
							repaint();
							clicks[0] = false;
							System.out.println(pRoom[0]);
							MapGame.getMoveJButton().setEnabled(true);
							MapGame.getDrawJButton().setEnabled(true);
							MapGame.getChatRoom().append("Player 2, your turn." + MapGame.getNextLine());
							
						}
						
					}

				});
				//Player 2 Token
				g2d.drawImage(playerIcons[2],ArrayCT[2][0],ArrayCT[2][1], pawnWidth,pawnHeight,this);

				this.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[1] == true) {
							ArrayCT[2][0] = e.getX() - 12;
							ArrayCT[2][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[2][0],ArrayCT[2][1]);
							pRoom[1] = GetPawnLocation.getRoom();
							player[2].setLocation(pRoom[1]);
							repaint();
							
							clicks[1] = false;
							MapGame.getDrawJButton().setEnabled(true);
							MapGame.getMoveJButton().setEnabled(true);
							MapGame.getChatRoom().append("Player 3, your turn." + MapGame.getNextLine());
							
						}
						
					}

		
					
				});
				//Player 3 Token
				g2d.drawImage(playerIcons[3],ArrayCT[3][0],ArrayCT[3][1], pawnWidth,pawnHeight,this);

				
				this.addMouseListener(new MouseAdapter() {


					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[2] == true) {
							ArrayCT[3][0] = e.getX() - 12;
							ArrayCT[3][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[3][0],ArrayCT[3][1]);
							pRoom[2] = GetPawnLocation.getRoom();
							player[3].setLocation(pRoom[2]);
							
							repaint();
							clicks[2] = false;
							MapGame.getMoveJButton().setEnabled(true);
							MapGame.getDrawJButton().setEnabled(true);
							
							if(playerNum==3) {
								if(dRoom <=19) {
									MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
									MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
									countClick=0;
									dRoom++;
									player[0].setLocation(dRoom);
									setDoctorLoad();
									repaint();
								}else {
									MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
									MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
									countClick=0;
									dRoom = 0;
									player[0].setLocation(dRoom);
									setDoctorLoad();
									repaint();
								}
							}
							else {
								MapGame.getChatRoom().append("Player 4, your turn." + MapGame.getNextLine());
							}
							
						}
						
					}

				});
			
				
		}

		//Player 4 Drawn
		if(playerNum >=4) {
			//Player 4 Token
			g2d.drawImage(playerIcons[4],ArrayCT[4][0],ArrayCT[4][1], pawnWidth,pawnHeight,this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if(clicks[3] == true) {
						ArrayCT[4][0] = e.getX() - 12;
						ArrayCT[4][1]= e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[4][0],ArrayCT[4][1]);
						pRoom[3] = GetPawnLocation.getRoom();
						player[4].setLocation(pRoom[3]);
						
						repaint();
						clicks[3] = false;
						MapGame.getMoveJButton().setEnabled(true);
						MapGame.getDrawJButton().setEnabled(true);
						if(playerNum==4) {
							if(dRoom <=19) {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom++;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}else {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom = 0;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}
							
						}
						else {
							MapGame.getChatRoom().append("Player 5, your turn." + MapGame.getNextLine());
						}
						
					}
					
				}
				
			});

		}
		//Player 5
		if(playerNum >=5) {
			//Player 5 Token
			g2d.drawImage(playerIcons[5],ArrayCT[5][0],ArrayCT[5][1], pawnWidth,pawnHeight,this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if(clicks[4] == true) {
						ArrayCT[5][0] = e.getX() - 12;
						ArrayCT[5][1]= e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[5][0],ArrayCT[5][1]);
						pRoom[4] = GetPawnLocation.getRoom();
						player[5].setLocation(pRoom[4]);
						
						repaint();
						clicks[4] = false;
						MapGame.getMoveJButton().setEnabled(true);
						MapGame.getDrawJButton().setEnabled(true);
						if(playerNum==5) {
							if(dRoom <=19) {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom++;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}else {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom = 0;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}
						}else {
							MapGame.getChatRoom().append("Player 6, your turn." + MapGame.getNextLine());
						}
						
					}
					
				}
				
			});

		}
		//Player 6
		if(playerNum >=6) {
			//Player 6 Token
			g2d.drawImage(playerIcons[6],ArrayCT[6][0],ArrayCT[6][1], pawnWidth,pawnHeight,this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if(clicks[5] == true) {
						ArrayCT[6][0] = e.getX() - 12;
						ArrayCT[6][1]= e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[6][0],ArrayCT[6][1]);
						pRoom[5] = GetPawnLocation.getRoom();
						player[6].setLocation(pRoom[5]);
						
						repaint();
						clicks[5] = false;
						MapGame.getMoveJButton().setEnabled(true);
						MapGame.getDrawJButton().setEnabled(true);
						if(playerNum==6) {
							if(dRoom <=19) {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom++;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}else {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom = 0;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}
						}else {
							MapGame.getChatRoom().append("Player 7"+ ", your turn." + MapGame.getNextLine());
						}
						
					}
					
				}
				
			});

		}
		//Player 7
		if(playerNum >=7) {
			//Player 7 Token
			g2d.drawImage(playerIcons[7],ArrayCT[7][0],ArrayCT[7][1], pawnWidth,pawnHeight,this);
			this.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if(clicks[6] == true) {
						ArrayCT[7][0] = e.getX() - 12;
						ArrayCT[7][1]= e.getY() - 8;
						GetPawnLocation.getXYCoordinates(ArrayCT[7][0],ArrayCT[7][1]);
						pRoom[6] = GetPawnLocation.getRoom();
						player[7].setLocation(pRoom[6]);
						
						repaint();
						clicks[6] = false;
						MapGame.getMoveJButton().setEnabled(true);
						MapGame.getDrawJButton().setEnabled(true);
						if(playerNum==7) {
							if(dRoom <=19) {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom++;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}else {
								MapGame.getChatRoom().append("Doctor Lucky has moved" + MapGame.getNextLine());
								MapGame.getChatRoom().append("Player 1, your turn." + MapGame.getNextLine());
								countClick=0;
								dRoom = 0;
								player[0].setLocation(dRoom);
								setDoctorLoad();
								repaint();
							}
						}
						
					}
					
				}

				
			});

		}


		
		//When move button is pressed, it sets clicks to true to allow the player
		//to mouseclick to a room. This enables the player to show the green rectangles for the player
		//to click to
		HighlightRooms.paintHighlights(g2d);
		//Highlight Cards
		
		
		HighlightCards.paintHighlights(g2d);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetCardLocation.CheckForCardLocation(e.getX(), e.getY(), g2d);
				repaint();
				MapGame.useTheCard = true;
			}
			
		});
		
		
	}
	public static void setPRoom(int num,int Room) {
		pRoom[num] = Room;
	}
	//Updates a specific
	public static void resetPlayerRoom(int num) {
		pxy.getXPawnLocation(pRoom[num]);
		ArrayCT[num+1][0] = pxy.getXP();
		ArrayCT[num+1][1] = pxy.getYP();
	}
	
	public static void setDRoom(int Room) {
		dRoom = Room;
	}
	//Loads the player location 
	public static void setPlayerLoad() {
		for(int i = 1; i<7;i++) {
			pxy.getXPawnLocation(pRoom[i-1]);
			ArrayCT[i][0] = pxy.getXP();
			ArrayCT[i][1] = pxy.getYP();
			setArray(i);
		
		}
	}
	//Load the Doctor Lucky's location
	public static void setDoctorLoad() {
		pxy.getXPawnLocation(dRoom);
		ArrayCT[0][0] = pxy.getXP();
		ArrayCT[0][1] = pxy.getYP();
	}
	
	//Set the player x and y coordinates when the player clicks to a specific coordinate
	public static void setArray(int i) {
		
	}
	//Sets the cards for the players
	public static void setArray(int num, String file) {
		p1[num] = file;
	}
	//This is send back to MapGame class to keep track of the clicks 
	//and to also make sure that it goes all the around
	public static void setBoolArrayStart(boolean cli[]) {
		for(int i=0;i<cli.length;i++) {
			clicks[i] = cli[i];
		}
		
	}
	
	//The string value for Player 1 deck
	public static String getP1Value(int num) {
		return p1value[num];
		
	}
	
	public static void setP1Value(int num,String numb) {
		p1value[num] = numb;
		
	}
	
	public static void printP1Value() {
		System.out.println(Arrays.toString(p1value));
	}
	//The string value for Player 2 deck
	public static String getP2Value(int num) {
		return p2value[num];
		
	}
	//The string value for Player 3 deck
	public static String getP3Value(int num) {
		return p3value[num];
		
	}
	
	
	public static String getFileLocat() {
		return fileLocat;
		
	}
	//The string for the image file location
	public static String getImageValue(int num) {
		return p1[num];
		
	}
	
	
	//Sets the card file 
	public static void setCardValue(int num, Image lol) {
		cardImg[num] = lol;
	}
	
	//Returns the click array to MapGame class
	public static boolean[] getBoolArrayBack() {
		
		return clicks;
		
	}
	//Sets the next player turn
	public static void setCountClick(int n) {
		countClick = n;
	}
	
	public static int getPlayerNum() {
		return playerNum;
	}
	
	public static boolean getClick(int n) {
		return clicks[n];
		
	}
	
	public static int getCountClick() {
		return countClick;
	}
	
	public static int getPRoom(int num) {
		return pRoom[num];
	}
	
	public static int getDRoom() {
		
		return dRoom;
	}
	public static void updatePlayers(player[] p) {
		player=p;
		
	}
	public static void updateCards(card[] c) {
		
		Card=c;
	}
	public static void updateRooms(room[] r) {
	
		Room=r;
	}
	public static void updateCardImg() {
		PaintPanel.setArray(0, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(0) + ".png");
		PaintPanel.setArray(1, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(1) + ".png");
		PaintPanel.setArray(2, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(2) + ".png");
		PaintPanel.setArray(3, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(3) + ".png");
		PaintPanel.setArray(4, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(4) + ".png");
		PaintPanel.setArray(5, PaintPanel.getFileLocat() + "Cards//"
				+ PaintPanel.getP1Value(5) + ".png");

		PaintPanel.setCardValue(0, new ImageIcon(PaintPanel.getImageValue(0)).getImage());
		PaintPanel.setCardValue(1, new ImageIcon(PaintPanel.getImageValue(1)).getImage());
		PaintPanel.setCardValue(2, new ImageIcon(PaintPanel.getImageValue(2)).getImage());
		PaintPanel.setCardValue(3, new ImageIcon(PaintPanel.getImageValue(3)).getImage());
		PaintPanel.setCardValue(4, new ImageIcon(PaintPanel.getImageValue(4)).getImage());
		PaintPanel.setCardValue(5, new ImageIcon(PaintPanel.getImageValue(5)).getImage());
	}

}