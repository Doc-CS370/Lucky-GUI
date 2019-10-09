package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String value[] = {"2","3","4","5","6","7","8","9","10"};
	private static String p1[] = {"./images/cards/MurderCard" + value[0] +".png",
									"./images/cards/MurderCard" + value[1] +".png",
									"./images/cards/MurderCard" + value[2] +".png",
									"./images/cards/MurderCard" + value[3] +".png"};
	private static Image playerIcons[] = {new ImageIcon("./images/Player1 Chip.png").getImage(),
											new ImageIcon("./images/Player2 Chip.png").getImage(),
											new ImageIcon("./images/Player3 Chip.png").getImage(),
											new ImageIcon("./images/Player4 Chip.png").getImage(),
											new ImageIcon("./images/Player5 Chip.png").getImage(),
											new ImageIcon("./images/Player 6 Chip.png").getImage(),
											new ImageIcon("./images/Player 7 Chip.png").getImage(),
											new ImageIcon("./images/Dr.Lucky Chip.png").getImage()};
	private static int ArrayCT[][] = {{1000,30},{1150,30},{1000,200},
			{1150,200},{1000,370},{1150,370},{1330,200},
			{1075,530}};
	final private int pawnWidth = 50;
	final private int pawnHeight = 50;
	private Image backImg = new ImageIcon("./images/Map_with_special_rooms.jpg").getImage();
	private static Image cardImg[] = {new ImageIcon(p1[0]).getImage(),
										new ImageIcon(p1[1]).getImage(),
										new ImageIcon(p1[2]).getImage(),
										new ImageIcon(p1[3]).getImage()};
	protected static int playerNum = 0;
	private SetPawnLocation pxy = new SetPawnLocation();
	private int pRoom[] = {0,0,0,0,0,0,0};
	private int dRoom = (int)(Math.random() * 19);
	private static boolean clicks[] = {false,false,false,false,false,false,false};

	PaintPanel(){
		setPlayerLoad();
		setDoctorLoad();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(backImg,10, 10, 1200,600,this);
		for(int i = 0; i<4; i++) {
			
		}

		
		g2d.drawImage(cardImg[0], 250,640,120,145,this);
		g2d.drawImage(cardImg[1], 400,640,120,145,this);
		g2d.drawImage(cardImg[2], 550,640,120,145,this);
		g2d.drawImage(cardImg[3], 700,640,120,145,this);

		
		g2d.fillOval(35,700,80,80);

		g2d.setFont(new Font("ComicSans", Font.PLAIN,15));
		g2d.drawString("Spite Tokens",33,680);
		
	
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
							ArrayCT[0][0] = e.getX() - 30;
							ArrayCT[0][1]= e.getY() - 25;
							GetPawnLocation.getXYCoordinates(ArrayCT[0][0],ArrayCT[0][1]);
							pRoom[0] = GetPawnLocation.getRoom();
							if(pRoom[0] == 3 || pRoom[0] == 5 || pRoom[0] == 1 || pRoom[0] == 20) {
								ArrayCT[0][0] = e.getX() - 30;
								ArrayCT[0][1]= e.getY() - 25;
								GetPawnLocation.getXYCoordinates(ArrayCT[0][0],ArrayCT[0][1]);
								pRoom[0] = GetPawnLocation.getRoom();
								repaint();
								clicks[0] = false;		
							}
							else {
							MapGame.getChatRoom().append("Try Again!"+"\n");
							ArrayCT[0][0] = e.getX() - 30;
							ArrayCT[0][1]= e.getY() - 25;
							GetPawnLocation.getXYCoordinates(ArrayCT[0][0],ArrayCT[0][1]);
							pRoom[0] = GetPawnLocation.getRoom();
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
							ArrayCT[1][0] = e.getX() - 30;
							ArrayCT[1][1]= e.getY() - 25;
							repaint();
							clicks[1] = false;
							
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
							ArrayCT[2][0] = e.getX() - 30;
							ArrayCT[2][1]= e.getY() - 25;
							repaint();
							clicks[2] = false;
							if(dRoom <=19) {
								dRoom++;
								setDoctorLoad();
								repaint();
							}else {
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


		if(playerNum >=4) {
			g2d.drawImage(playerIcons[3],ArrayCT[3][0],ArrayCT[3][1], pawnWidth,pawnHeight,this);

		}
		
		if(playerNum >=5) {
				
			g2d.drawImage(playerIcons[4],ArrayCT[4][0],ArrayCT[4][1], pawnWidth,pawnHeight,this);

		}
		
		if(playerNum >=6) {
			g2d.drawImage(playerIcons[5],ArrayCT[5][0],ArrayCT[5][1], pawnWidth,pawnHeight,this);

		}
		
		if(playerNum >=7) {
				
			g2d.drawImage(playerIcons[6],ArrayCT[6][0],ArrayCT[6][1], pawnWidth,pawnHeight,this);

		}
		
		g2d.drawImage(playerIcons[7],ArrayCT[7][0],ArrayCT[7][1], pawnWidth,pawnHeight,this);

		
		if(clicks[0] == true || clicks[1] == true || clicks[2] == true) {
			if(pRoom[0] == 0 || pRoom[1] == 0 || pRoom[2] == 0) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,125,278,178,false);//Room 3
				g2d.draw3DRect(745,305,160,110,false);//Room 1
				g2d.draw3DRect(310,305,160,110,false);//Room 5
				g2d.draw3DRect(530,380,160,40,false);//Room 20
			}else if(pRoom[0] == 1 || pRoom[1] == 1 || pRoom[2] == 1) {
				g2d.setColor(Color.green);
				g2d.draw3DRect(470,305,270,80,false);//Room 0
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(745,415,160,185,false);//Room 18
				g2d.draw3DRect(900,300,60,190,false);//Room 30
			}else if(pRoom[0] == 2 || pRoom[1] == 2 || pRoom[2] == 2){
				g2d.draw3DRect(745,270,450,30,false);//Room 29
				g2d.draw3DRect(470,125,278,178,false);//Room 3
			}else if(pRoom[0] == 3 || pRoom[1] == 3 || pRoom[2] == 3) {
			//g2d.draw3DRect(745,120,160,150,false);//Room 2
			//g2d.draw3DRect(310,120,160,150,false);//Room 4
			//g2d.draw3DRect(745,270,450,30,false);//Room 29
			//g2d.draw3DRect(20,270,450,30,false);//Room 23
			//g2d.draw3DRect(470,305,270,80,false);//Room 0
			}else if(pRoom[0] == 4 || pRoom[1] == 4 || pRoom[2] == 4) {
			//g2d.draw3DRect(20,270,450,30,false);//Room 23
			//g2d.draw3DRect(470,125,278,178,false);//Room 3
			}else if(pRoom[0] == 5 || pRoom[1] == 5 || pRoom[2] == 5) {
			//g2d.draw3DRect(255,300,60,190,false);//Room 21
			//g2d.draw3DRect(20,270,450,30,false);//Room 23
			//g2d.draw3DRect(470,305,270,80,false);//Room 0
			//g2d.draw3DRect(310,415,160,185,false);//Room 6
			}else if(pRoom[0] == 6 || pRoom[1] == 6 || pRoom[2] == 6) {
				//g2d.draw3DRect(310,305,160,110,false);//Room 5
				//g2d.draw3DRect(20,490,290,110,false);//Room 7
				//g2d.draw3DRect(470,415,278,185,false);//Room 19
			}else if(pRoom[0] == 7 || pRoom[1] == 7 || pRoom[2] == 7) {
				//g2d.draw3DRect(20,410,235,80,false);//Room 22
				//g2d.draw3DRect(255,300,60,190,false);//Room 21
			}else if(pRoom[0] == 8 || pRoom[1] == 8 || pRoom[2] == 8) {
				//g2d.draw3DRect(20,270,450,30,false);//Room 23
				//g2d.draw3DRect(20,410,235,80,false);//Room 22
				//g2d.draw3DRect(255,300,60,190,false);//Room 21
			}else if(pRoom[0] == 9 || pRoom[1] == 9 || pRoom[2] == 9) {
				//g2d.draw3DRect(20,20,230,140,false);//Room 10
				//g2d.draw3DRect(20,160,60,105,false);//Room 24
				//g2d.draw3DRect(250,20,60,140,false);//Room 25
			}else if(pRoom[0] == 10 || pRoom[1] == 10 || pRoom[2] == 10) {
				//g2d.draw3DRect(250,20,60,140,false);//Room 25
				//g2d.draw3DRect(80,160,230,105,false);//Room 9
				//g2d.draw3DRect(20,160,60,105,false);//Room 24
			}else if(pRoom[0] == 11 || pRoom[1] == 11 || pRoom[2] == 11) {
				//g2d.draw3DRect(470,20,278,65,false);//Room 12
				//g2d.draw3DRect(470,90,278,30,false);//Room 26
				//g2d.draw3DRect(250,20,60,140,false);//Room 25
			}else if(pRoom[0] == 12|| pRoom[1] == 12 || pRoom[2] == 12) {
				//g2d.draw3DRect(745,20,160,100,false);//Room 13
				//g2d.draw3DRect(310,20,160,100,false);//Room 11
			}else if(pRoom[0] == 13 || pRoom[1] == 13 || pRoom[2] == 13) {
				//g2d.draw3DRect(900,20,60,140,false);//Room 27
				//g2d.draw3DRect(470,90,278,30,false);//Room 26
				//g2d.draw3DRect(470,20,278,65,false);//Room 12
			}else if(pRoom[0] == 14 || pRoom[1] == 14 || pRoom[2] == 14) {
				//g2d.draw3DRect(900,20,60,140,false);//Room 27
				//g2d.draw3DRect(1140,160,60,105,false);//Room 28
				//g2d.draw3DRect(910,160,230,105,false);Room 15
			}else if(pRoom[0] == 15 || pRoom[1] == 15 || pRoom[2] == 15) {
				//g2d.draw3DRect(1140,160,60,105,false);//Room 28
				//g2d.draw3DRect(960,20,240,140,false);//Room 14
				//g2d.draw3DRect(900,20,60,140,false);//Room 27
			}else if(pRoom[0] == 16 || pRoom[1] == 16 || pRoom[2] == 16) {
				//g2d.draw3DRect(745,270,450,30,false);//Room 29
				//g2d.draw3DRect(900,300,60,190,false);//Room 30
				//g2d.draw3DRect(960,410,235,80,false);//Room 31
			}else if(pRoom[0] == 17 || pRoom[1] == 17 || pRoom[2] == 17) {
				//g2d.draw3DRect(745,415,160,185,false);//Room 18
				//g2d.draw3DRect(900,300,60,190,false);//Room 30
				//g2d.draw3DRect(960,410,235,80,false);//Room 31
			}else if(pRoom[0] == 18 || pRoom[1] == 18 || pRoom[2] == 18) {
				//g2d.draw3DRect(745,305,160,110,false);//Room 1
				//g2d.draw3DRect(470,415,278,185,false);//Room 19
				//g2d.draw3DRect(900,490,290,110,false);//Room 17
			}else if(pRoom[0] == 19 || pRoom[1] == 19 || pRoom[2] == 19) {
				//g2d.draw3DRect(530,380,160,40,false);//Room 20
				//g2d.draw3DRect(745,415,160,185,false);//Room 18
				//g2d.draw3DRect(310,415,160,185,false);//Room 6
			}else if(pRoom[0] == 20 || pRoom[1] == 20 || pRoom[2] == 20) {
				//g2d.draw3DRect(470,305,270,80,false);//Room 0
				//g2d.draw3DRect(470,415,278,185,false);//Room 19
			}else if(pRoom[0] == 21 || pRoom[1] == 21 || pRoom[2] == 21) {
				//g2d.draw3DRect(310,305,160,110,false);//Room 5
				//g2d.draw3DRect(20,300,235,110,false);//Room 8
			}else if(pRoom[0] == 22 || pRoom[1] == 22 || pRoom[2] == 22) {
				//g2d.draw3DRect(20,300,235,110,false);//Room 8
				//g2d.draw3DRect(20,490,290,110,false);//Room 7
			}else if(pRoom[0] == 23 || pRoom[1] == 23 || pRoom[2] == 23) {
				//g2d.draw3DRect(310,120,160,150,false);//Room 4
				//g2d.draw3DRect(310,305,160,110,false);//Room 5
				//g2d.draw3DRect(255,300,60,190,false);//Room 21
				//g2d.draw3DRect(20,300,235,110,false);//Room 8
			}else if(pRoom[0] == 24 || pRoom[1] == 24 || pRoom[2] == 24) {
				//g2d.draw3DRect(20,20,230,140,false);//Room 10
				//g2d.draw3DRect(80,160,230,105,false);//Room 9
				//g2d.draw3DRect(20,270,450,30,false);//Room 23
			}else if(pRoom[0] == 25 || pRoom[1] == 25 || pRoom[2] == 25) {
				//g2d.draw3DRect(310,20,160,100,false);//Room 11
				//g2d.draw3DRect(80,160,230,105,false);//Room 9
				//g2d.draw3DRect(20,20,230,140,false);//Room 10
			}else if(pRoom[0] == 26 || pRoom[1] == 26 || pRoom[2] == 26) {
				//g2d.draw3DRect(470,125,278,178,false);//Room 3
				//g2d.draw3DRect(310,20,160,100,false);//Room 11
				//g2d.draw3DRect(745,20,160,100,false);//Room 13
			}else if(pRoom[0] == 27 || pRoom[1] == 27 || pRoom[2] == 27) {
				//g2d.draw3DRect(910,160,230,105,false);Room 15
				//g2d.draw3DRect(960,20,240,140,false);//Room 14
				//g2d.draw3DRect(745,20,160,100,false);//Room 13
			}else if(pRoom[0] == 28 || pRoom[1] == 28 || pRoom[2] == 28) {
				//g2d.draw3DRect(745,270,450,30,false);//Room 29
				//g2d.draw3DRect(910,160,230,105,false);Room 15
				//g2d.draw3DRect(960,20,240,140,false);//Room 14
			}else if(pRoom[0] == 29 || pRoom[1] == 29 || pRoom[2] == 29) {
				//g2d.draw3DRect(900,300,60,190,false);//Room 30
				//g2d.draw3DRect(745,120,160,150,false);//Room 2
				//g2d.draw3DRect(745,305,160,110,false);//Room 1
				//g2d.draw3DRect(960,300,235,110,false);//Room 16
				//g2d.draw3DRect(1140,160,60,105,false);//Room 28
			}else if(pRoom[0] == 30 || pRoom[1] == 30 || pRoom[2] == 30) {
				//g2d.draw3DRect(900,490,290,110,false);//Room 17
				//g2d.draw3DRect(960,300,235,110,false);//Room 16
				//g2d.draw3DRect(745,305,160,110,false);//Room 1
			}else if(pRoom[0] == 31 || pRoom[1] == 31 || pRoom[2] == 31) {
				//g2d.draw3DRect(900,490,290,110,false);//Room 17
				//g2d.draw3DRect(960,300,235,110,false);//Room 16
			}
		}

	}
	
	public void setPlayerLoad() {
		for(int i = 0; i<7;i++) {
			pxy.getXPawnLocation(pRoom[i]);
			setArray(i);
		}
	}
	
	public void setDoctorLoad() {
		pxy.getXPawnLocation(dRoom);
		ArrayCT[7][0] = pxy.getXP();
		ArrayCT[7][1] = pxy.getYP();
		
	}
	
	public void setArray(int i) {
		ArrayCT[i][0] = pxy.getXP();
		ArrayCT[i][1] = pxy.getYP();
	}
	
	public static void setArray(int num, String file) {
		p1[num] = file;
	}
	
	public static void setBoolArrayStart(boolean cli[]) {
		for(int i=0;i<cli.length;i++) {
			clicks[i] = cli[i];
		}
		
	}
	
	public static String getValue(int num) {
		return value[num];
		
	}
	
	public static String getImageValue(int num) {
		return p1[num];
		
	}
	
	public static void setCardValue(int num, Image lol) {
		cardImg[num] = lol;
	}
	
	public static boolean[] getBoolArrayBack() {
		
		return clicks;
		
	}

	

}