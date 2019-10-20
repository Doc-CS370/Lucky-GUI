package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String value[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private static String p1[] = {"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[0] +".png",
									"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[1] +".png",
									"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[2] +".png",
									"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[3] +".png",
									"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[4] +".png",
									"C:\\Users\\lpare\\Desktop\\Cards\\MurderCard" + value[5] +".png"};
	private static Image playerIcons[] = {new ImageIcon("C:\\Users\\lpare\\Desktop\\Player1 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player2 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player3 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player4 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player5 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player 6 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Player 7 Chip.png").getImage(),
											new ImageIcon("C:\\Users\\lpare\\Desktop\\Dr.Lucky Chip.png").getImage()};
	private static int ArrayCT[][] = {{1000,30},{1150,30},{1000,200},
			{1150,200},{1000,370},{1150,370},{1330,200},
			{1075,530}};
	final private int pawnWidth = 35;
	final private int pawnHeight = 35;
	private Image backImg = new ImageIcon("C:\\Users\\lpare\\Desktop\\Map_with_special_rooms.png").getImage();
	private static Image cardImg[] = {new ImageIcon(p1[0]).getImage(),
										new ImageIcon(p1[1]).getImage(),
										new ImageIcon(p1[2]).getImage(),
										new ImageIcon(p1[3]).getImage(),
										new ImageIcon(p1[4]).getImage(),
										new ImageIcon(p1[5]).getImage()};
	protected static int playerNum = 0;
	private SetPawnLocation pxy = new SetPawnLocation();
	private int pRoom[] = {0,0,0,0,0,0,0};
	private int dRoom = (int)(Math.random() * 19);
	private static boolean clicks[] = {false,false,false,false,false,false,false};
	private static int countClick = 0;
	
	PaintPanel(){
		setPlayerLoad();
		setDoctorLoad();
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
		g2d.fillOval(35,700,80,80);
		g2d.setFont(new Font("ComicSans",Font.PLAIN,15));
		g2d.drawString("Spite Tokens",33,680);
		
		//Player 1,2,3
		if(playerNum >= 3) {
				
				g2d.drawImage(playerIcons[0],ArrayCT[0][0],ArrayCT[0][1], pawnWidth,pawnHeight,this);
				this.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[0] == true) {
							ArrayCT[0][0] = e.getX() - 12;
							ArrayCT[0][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[0][0],ArrayCT[0][1]);
							pRoom[0] = GetPawnLocation.getRoom();
							repaint();
							clicks[0] = false;
							System.out.println(pRoom[0]);
							MapGame.getJButton().setEnabled(true);
							
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				g2d.drawImage(playerIcons[1],ArrayCT[1][0],ArrayCT[1][1], pawnWidth,pawnHeight,this);

				this.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[1] == true) {
							ArrayCT[1][0] = e.getX() - 12;
							ArrayCT[1][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[1][0],ArrayCT[1][1]);
							pRoom[1] = GetPawnLocation.getRoom();
							repaint();
							clicks[1] = false;
							MapGame.getJButton().setEnabled(true);
							
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				g2d.drawImage(playerIcons[2],ArrayCT[2][0],ArrayCT[2][1], pawnWidth,pawnHeight,this);

				
				this.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(clicks[2] == true) {
							ArrayCT[2][0] = e.getX() - 12;
							ArrayCT[2][1]= e.getY() - 8;
							GetPawnLocation.getXYCoordinates(ArrayCT[2][0],ArrayCT[2][1]);
							pRoom[2] = GetPawnLocation.getRoom();
							repaint();
							clicks[2] = false;
							MapGame.getJButton().setEnabled(true);
							if(dRoom <=19) {
								countClick=0;
								dRoom++;
								setDoctorLoad();
								repaint();
							}else {
								countClick=0;
								dRoom = 0;
								setDoctorLoad();
								repaint();
							}
							
							
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
			
				
		}

		//Player 4
		if(playerNum >=4) {
			g2d.drawImage(playerIcons[3],ArrayCT[3][0],ArrayCT[3][1], pawnWidth,pawnHeight,this);

		}
		//Player 5
		if(playerNum >=5) {
				
			g2d.drawImage(playerIcons[4],ArrayCT[4][0],ArrayCT[4][1], pawnWidth,pawnHeight,this);

		}
		//Player 6
		if(playerNum >=6) {
			g2d.drawImage(playerIcons[5],ArrayCT[5][0],ArrayCT[5][1], pawnWidth,pawnHeight,this);

		}
		//Player 7
		if(playerNum >=7) {
				
			g2d.drawImage(playerIcons[6],ArrayCT[6][0],ArrayCT[6][1], pawnWidth,pawnHeight,this);

		}
		//Doctor Lucky
		g2d.drawImage(playerIcons[7],ArrayCT[7][0],ArrayCT[7][1], pawnWidth,pawnHeight,this);

		//When move button is pressed, it sets clicks to true to allow the player
		//to mouseclick to a room. This enables the player to show the green rectangles for the player
		//to click to
		if(clicks[countClick] == true ) {
			//This checks where the player is at to show the nearby rooms the player can go to
			//by the green rectangles
			if(pRoom[countClick] == 0) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,125,278,178,false);//Room 3
				g2d.draw3DRect(745,305,160,110,false);//Room 1
				g2d.draw3DRect(310,305,160,110,false);//Room 5
				g2d.draw3DRect(530,380,160,40,false);//Room 20
			}else if(pRoom[countClick] == 1) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,305,270,80,false);//Room 0
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(745,415,160,185,false);//Room 18
				g2d.draw3DRect(900,300,60,190,false);//Room 30
			}else if(pRoom[countClick] == 2){
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(470,125,278,178,false);//Room 3
			}else if(pRoom[countClick] == 3) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,120,160,150,false);//Room 2
				g2d.draw3DRect(310,120,160,150,false);//Room 4
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(20,270,450,30,false);//Room 23
				g2d.draw3DRect(470,305,270,80,false);//Room 0
			}else if(pRoom[countClick] == 4) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,270,450,30,false);//Room 23
				g2d.draw3DRect(470,125,278,178,false);//Room 3
			}else if(pRoom[countClick] == 5) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(255,300,60,190,false);//Room 21
				g2d.draw3DRect(20,270,450,30,false);//Room 23
				g2d.draw3DRect(470,305,270,80,false);//Room 0
				g2d.draw3DRect(310,415,160,185,false);//Room 6
			}else if(pRoom[countClick] == 6) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(310,305,160,110,false);//Room 5
				g2d.draw3DRect(20,490,290,110,false);//Room 7
				g2d.draw3DRect(470,415,278,185,false);//Room 19
			}else if(pRoom[countClick] == 7) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,410,235,80,false);//Room 22
				g2d.draw3DRect(255,300,60,190,false);//Room 21
			}else if(pRoom[countClick] == 8) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,270,450,30,false);//Room 23
				g2d.draw3DRect(20,410,235,80,false);//Room 22
				g2d.draw3DRect(255,300,60,190,false);//Room 21
			}else if(pRoom[countClick] == 9) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,20,230,140,false);//Room 10
				g2d.draw3DRect(20,160,60,105,false);//Room 24
				g2d.draw3DRect(250,20,60,140,false);//Room 25
			}else if(pRoom[countClick] == 10) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(250,20,60,140,false);//Room 25
				g2d.draw3DRect(80,160,230,105,false);//Room 9
				g2d.draw3DRect(20,160,60,105,false);//Room 24
			}else if(pRoom[countClick] == 11) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,20,278,65,false);//Room 12
				g2d.draw3DRect(470,90,278,30,false);//Room 26
				g2d.draw3DRect(250,20,60,140,false);//Room 25
			}else if(pRoom[countClick] == 12) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,20,160,100,false);//Room 13
				g2d.draw3DRect(310,20,160,100,false);//Room 11
			}else if(pRoom[countClick] == 13) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(900,20,60,140,false);//Room 27
				g2d.draw3DRect(470,90,278,30,false);//Room 26
				g2d.draw3DRect(470,20,278,65,false);//Room 12
			}else if(pRoom[countClick] == 14) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(900,20,60,140,false);//Room 27
				g2d.draw3DRect(1140,160,60,105,false);//Room 28
				g2d.draw3DRect(910,160,230,105,false);//Room 15
			}else if(pRoom[countClick] == 15) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(1140,160,60,105,false);//Room 28
				g2d.draw3DRect(960,20,240,140,false);//Room 14
				g2d.draw3DRect(900,20,60,140,false);//Room 27
			}else if(pRoom[countClick] == 16) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(900,300,60,190,false);//Room 30
				g2d.draw3DRect(960,410,235,80,false);//Room 31
			}else if(pRoom[countClick] == 17) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,415,160,185,false);//Room 18
				g2d.draw3DRect(900,300,60,190,false);//Room 30
				g2d.draw3DRect(960,410,235,80,false);//Room 31
			}else if(pRoom[countClick] == 18) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,305,160,110,false);//Room 1
				g2d.draw3DRect(470,415,278,185,false);//Room 19
				g2d.draw3DRect(900,490,290,110,false);//Room 17
			}else if(pRoom[countClick] == 19) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(530,380,160,40,false);//Room 20
				g2d.draw3DRect(745,415,160,185,false);//Room 18
				g2d.draw3DRect(310,415,160,185,false);//Room 6
			}else if(pRoom[countClick] == 20) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,305,270,80,false);//Room 0
				g2d.draw3DRect(470,415,278,185,false);//Room 19
			}else if(pRoom[countClick] == 21) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(310,305,160,110,false);//Room 5
				g2d.draw3DRect(20,300,235,110,false);//Room 8
			}else if(pRoom[countClick] == 22) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,300,235,110,false);//Room 8
				g2d.draw3DRect(20,490,290,110,false);//Room 7
			}else if(pRoom[countClick] == 23) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(310,120,160,150,false);//Room 4
				g2d.draw3DRect(310,305,160,110,false);//Room 5
				g2d.draw3DRect(255,300,60,190,false);//Room 21
				g2d.draw3DRect(20,300,235,110,false);//Room 8
			}else if(pRoom[countClick] == 24) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(20,20,230,140,false);//Room 10
				g2d.draw3DRect(80,160,230,105,false);//Room 9
				g2d.draw3DRect(20,270,450,30,false);//Room 23
			}else if(pRoom[countClick] == 25) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(310,20,160,100,false);//Room 11
				g2d.draw3DRect(80,160,230,105,false);//Room 9
				g2d.draw3DRect(20,20,230,140,false);//Room 10
			}else if(pRoom[countClick] == 26) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,125,278,178,false);//Room 3
				g2d.draw3DRect(310,20,160,100,false);//Room 11
				g2d.draw3DRect(745,20,160,100,false);//Room 13
			}else if(pRoom[countClick] == 27) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(910,160,230,105,false);//Room 15
				g2d.draw3DRect(960,20,240,140,false);//Room 14
				g2d.draw3DRect(745,20,160,100,false);//Room 13
			}else if(pRoom[countClick] == 28) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(910,160,230,105,false);//Room 15
				g2d.draw3DRect(960,20,240,140,false);//Room 14
			}else if(pRoom[countClick] == 29) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(900,300,60,190,false);//Room 30
				g2d.draw3DRect(745,120,160,150,false);//Room 2
				g2d.draw3DRect(745,305,160,110,false);//Room 1
				g2d.draw3DRect(960,300,235,110,false);//Room 16
				g2d.draw3DRect(1140,160,60,105,false);//Room 28
			}else if(pRoom[countClick] == 30) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(900,490,290,110,false);//Room 17
				g2d.draw3DRect(960,300,235,110,false);//Room 16
				g2d.draw3DRect(745,305,160,110,false);//Room 1
			}else if(pRoom[countClick] == 31) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(900,490,290,110,false);//Room 17
				g2d.draw3DRect(960,300,235,110,false);//Room 16
			}
		}

	}
	//Loads the player location 
	public void setPlayerLoad() {
		for(int i = 0; i<7;i++) {
			pxy.getXPawnLocation(pRoom[i]);
			setArray(i);
		}
	}
	//Load the Doctor Lucky's location
	public void setDoctorLoad() {
		pxy.getXPawnLocation(dRoom);
		ArrayCT[7][0] = pxy.getXP();
		ArrayCT[7][1] = pxy.getYP();
		
	}
	
	//Set the player x and y coordinates when the player clicks to a specific coordinate
	public void setArray(int i) {
		ArrayCT[i][0] = pxy.getXP();
		ArrayCT[i][1] = pxy.getYP();
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
	
	//The string value for number card
	public static String getValue(int num) {
		return value[num];
		
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

	

}