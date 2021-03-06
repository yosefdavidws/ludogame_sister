package coba_ludo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GameMoves extends JPanel implements KeyListener, ActionListener,MouseListener{
//	private static InterfaceRMI look_up;
//	private static final long serialVersionUID = 1L;
	Layout la;
	Build_Player bp;
//	Timer time;
//	int delay=10;
	int current_player,dice;
	int flag=0,roll,kill=0;
        String txt1f ;
         String txt2f;
         String txt3f;
         String txt4f ;
         String namap;
//         String respon = look_up.helloTo(nama);
	public GameMoves() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        current_player=0;
        la = new Layout(250,150,txt1f,txt2f,txt3f,txt4f);
        bp=new Build_Player(la.height,la.width);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }
public void namapemain(String txt1,String txt2, String txt3,String txt4){
         txt1f = txt1;
          txt2f = txt2;
         txt3f = txt3;
         txt4f = txt4;
         
     }
    @Override
    public void paint(Graphics g) {
        la = new Layout(250,150,txt1f,txt2f,txt3f,txt4f);
    	la.draw((Graphics2D)g);
    	bp.draw((Graphics2D)g);
    	if(bp.player[current_player].coin==4) {
    		g.setColor(Color.WHITE);//tempat pergantian player
    		g.fillRect(250,5,450,130);
    		if(current_player==0) {
				g.setColor(Color.RED);
                                namap =txt1f;
			}
			else if(current_player==1) {
				g.setColor(Color.GREEN);
                                namap =txt2f;
			}
			else if(current_player==2) {
				g.setColor(Color.YELLOW);
                                namap =txt4f;
			}
			else if(current_player==3) {
				g.setColor(Color.BLUE);
                                namap =txt3f;
			}
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString(namap+"Menang!", 455, 110);
            current_player=0;
            bp=new Build_Player(la.height,la.width);
            dice=0;
            flag=0;
            roll=0;
            kill=0;
    	}
    	else if(dice!=0) {
    		g.setColor(Color.WHITE);//tempat pergantian player
    		g.fillRect(250,5,450,130);
    		if(current_player==0) {
				g.setColor(Color.RED);
                                namap =txt1f;
			}
			else if(current_player==1) {
				g.setColor(Color.GREEN);
                                namap =txt2f;
			}
			else if(current_player==2) {
				g.setColor(Color.YELLOW);
                                namap =txt4f;
			}
			else if(current_player==3) {
				g.setColor(Color.BLUE);
                                namap =txt3f;
			}
                if (namap == null){
                     g.drawString("...", 450, 95);
                } else{
                     g.drawString(""+namap, 450, 95);
                }
           
            g.setColor(Color.WHITE);
            g.fillRect(455,20,50,50);
            g.setColor(Color.BLACK);//memberi garis pinggir
        g.drawRect(455,20,50,50);
             if(dice == 1){
            g.drawString(".", 477, 45); /// yang diubah bagian sini
            }
            else if ( dice == 2){
            g.drawString(".  .", 465, 45); /// yang diubah bagian sini      
            }
            else if ( dice == 3){
            g.drawString(".", 490, 30); /// X,Y 
            g.drawString(".", 477, 45); /// yang diubah bagian sini     
            g.drawString(".", 465, 60); /// yang diubah bagian sini   

            }
            else if ( dice == 4){
             g.drawString(".  .", 465, 30); /// X,Y      
             g.drawString(".  .", 465, 60); /// yang diubah bagian sini
            }
            else if ( dice == 5){
             g.drawString(".  .", 465, 30); /// X,Y 
             g.drawString(".", 477, 45); /// yang diubah bagian sini  
             g.drawString(".  .", 465, 60); /// yang diubah bagian sini   
            }
            else {
             g.drawString(".  .", 465, 30); /// X,Y /
             g.drawString(".  .", 465, 45); /// yang diubah bagian sini     
             g.drawString(".  .", 465, 60); /// yang diubah bagian sini
            }
            
    	}
        
    	if(flag==0&&dice!=0&&dice!=6&&kill==0) { //next player
            if(current_player==3) {
                                namap =txt1f;
			}
			else if(current_player==0) {
                                namap =txt2f;
			}
			else if(current_player==1) {
                                namap =txt4f;
			}
			else if(current_player==2) {
                                namap =txt3f;
			}
            g.setColor(Color.GRAY);
            g.setFont(new Font("serif", Font.BOLD, 20));
            if(namap == null){
            g.drawString("berikutnya: ...", 415, 120);    
            }else {
            g.drawString("berikutnya: "+namap, 415, 120);    
            }
            
            current_player=(current_player+1)%4;
                        
		}
        if(dice==6){
            if(current_player==0) {
				g.setColor(Color.RED);
                                namap =txt1f;
			}
			else if(current_player==1) {
				g.setColor(Color.GREEN);
                                namap =txt2f;
			}
			else if(current_player==2) {
				g.setColor(Color.YELLOW);
                                namap =txt4f;
			}
			else if(current_player==3) {
				g.setColor(Color.BLUE);
                                namap =txt3f;
			}
            g.setColor(Color.GRAY);
            g.setFont(new Font("serif", Font.BOLD, 20));
            if(namap == null){
            g.drawString("... main lagi", 415, 120);   
            }else {
            g.drawString(namap+" main lagi", 415, 120);   
            }
            
        }
    	kill=0;
    }
    
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) {//untuk yang sudah diluar rumah
			roll=0;
			dice=1 + (int)(Math.random() * 6);//angka dari 0-5 
			repaint();
			for(int i=0;i<4;i++) {// i adalah pemainnya
    			if(bp.player[current_player].pawn[i].current!=-1&&bp.player[current_player].pawn[i].current!=56&&(bp.player[current_player].pawn[i].current+dice)<=56) {
    				flag=1;
    				break;
                            }
                        }
                    if(flag==0&&dice==6) { //untuk yang didalam rumah
                        for(int i=0;i<4;i++) {
                            if(bp.player[current_player].pawn[i].current==-1) {
    				flag=1;//untuk menjalankan fungsi keylistener
    				break;
                                }
                        }repaint();
                    }
		} 
                 
	}
	
	public void mouseClicked(MouseEvent e) {
		if(flag==1) {
			int x=e.getX();
			int y=e.getY();
			x=x-250;
			y=y-150;
			x=x/30;
			y=y/30;
			int value=-1;
			if(dice==6) {
				for(int i=0;i<4;i++) {// jika sudah diluar rumah
					if(bp.player[current_player].pawn[i].x==x&&bp.player[current_player].pawn[i].y==y&&(bp.player[current_player].pawn[i].current+dice)<=56) {
                                            value=i;
						flag=0; 
						break;
					}
                                        else  {  
                                                value=-1;
                                                flag=0; 
						break;}
						
				}
				if(value!=-1) {
					bp.player[current_player].pawn[value].current+=dice;
					if(bp.player[current_player].pawn[value].current==56) {
						bp.player[current_player].coin++;
					}
					int k=0;
					int hou=bp.player[current_player].pawn[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51) //bunuh
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][bp.player[current_player].pawn[value].current],tem2=Path.ay[current_player][bp.player[current_player].pawn[value].current];
								if(bp.player[i].pawn[j].x==tem1&&bp.player[i].pawn[j].y==tem2) {
									bp.player[i].pawn[j].current=-1;
									kill=1;
									k=1;
									break;
								}
							}
						}
						if(k==1)
							break;
					}
					}
				}
				else { //didalam rumah, kalo dice 6 akan pindah ke current=0;
					for(int i=0;i<4;i++) {
						if(bp.player[current_player].pawn[i].current==-1) {
							bp.player[current_player].pawn[i].current=0;
							flag=0;
							break;
						}	
					}
				}
			}
			else {
				for(int i=0;i<4;i++) {
					if(bp.player[current_player].pawn[i].x==x&&bp.player[current_player].pawn[i].y==y&&(bp.player[current_player].pawn[i].current+dice)<=56) {
						value=i;
						flag=0;
						break;
					}	
				}
				if(value!=-1) {
					bp.player[current_player].pawn[value].current+=dice;
					if(bp.player[current_player].pawn[value].current==56) {
						bp.player[current_player].coin++;
					}
					int k=0;
					int hou=bp.player[current_player].pawn[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51)
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][bp.player[current_player].pawn[value].current],tem2=Path.ay[current_player][bp.player[current_player].pawn[value].current];
								if(bp.player[i].pawn[j].x==tem1&&bp.player[i].pawn[j].y==tem2) {
									bp.player[i].pawn[j].current=-1;
									kill=1;
									k=1;
									break;
								}
							}
						}
						if(k==1)
							break;
					}
					}
				}
			}
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
