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
	
	private static final long serialVersionUID = 1L;
	Layout la;
	Build_Player bp;
	Timer time;
	int delay=10;
	int current_player,dice;
        String namap;
	int flag=0,roll,kill=0;
        String txt1f ;
         String txt2f;
         String txt3f;
         String txt4f ;
        public void namapemain(String txt1,String txt2, String txt3,String txt4){
         txt1f = txt1;
          txt2f = txt2;
         txt3f = txt3;
         txt4f = txt4;
         
     }
	public GameMoves() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        current_player=0;
        bp=new Build_Player();
        la = new Layout(250,150, txt1f,txt2f,txt3f,txt4f);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }

    @Override
    public void paint(Graphics g) {
        la = new Layout(250,150, txt1f,txt2f,txt3f,txt4f);
    	la.draw((Graphics2D)g);
    	bp.draw((Graphics2D)g);
    	if(bp.pl[current_player].coin==4) {
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
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Player "+(current_player+1)+" wins.", 465, 110);
            g.drawString("Congratulations.", 465, 160);
            current_player=0;
            la = new Layout(250,150,txt1f,txt2f,txt3f,txt4f);
            bp=new Build_Player();
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
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString(""+namap, 465, 110);
            g.setColor(Color.WHITE);
            g.fillRect(452,10,50,60);
    	g.setColor(Color.BLACK);//memberi garis pinggir
        g.drawRect(452,10,50,60);
            g.setColor(Color.BLACK);
            g.drawString(""+dice, 465, 50);
    	}
    	if(flag==0&&dice!=0&&dice!=6&&kill==0) { //next player
			current_player=(current_player+1)%4;
		}
    	kill=0;
    }
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) {
			roll=0;
			dice=1 + (int)(Math.random() * 6);//angka dari 0-5 
			repaint();
			for(int i=0;i<4;i++) {
    			if(bp.pl[current_player].pa[i].current!=-1&&bp.pl[current_player].pa[i].current!=56&&(bp.pl[current_player].pa[i].current+dice)<=56) {
    				flag=1;
    				break;
    			}
    		}
    		if(flag==0&&dice==6) {
    			for(int i=0;i<4;i++) {
    				if(bp.pl[current_player].pa[i].current==-1) {
    					flag=1;
    					break;
    				}
    			}
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
			//System.out.println(x+" "+y);
			if(dice==6) {
				for(int i=0;i<4;i++) {
					if(bp.pl[current_player].pa[i].x==x&&bp.pl[current_player].pa[i].y==y&&(bp.pl[current_player].pa[i].current+dice)<=56) {
						value=i;
						flag=0;
						break;
					}	
				}
				if(value!=-1) {
					bp.pl[current_player].pa[value].current+=dice;
					if(bp.pl[current_player].pa[value].current==56) {
						bp.pl[current_player].coin++;
					}
					int k=0;
					int hou=bp.pl[current_player].pa[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51)
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][bp.pl[current_player].pa[value].current],tem2=Path.ay[current_player][bp.pl[current_player].pa[value].current];
								if(bp.pl[i].pa[j].x==tem1&&bp.pl[i].pa[j].y==tem2) {
									bp.pl[i].pa[j].current=-1;
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
				else {
					for(int i=0;i<4;i++) {
						if(bp.pl[current_player].pa[i].current==-1) {
							bp.pl[current_player].pa[i].current=0;
							flag=0;
							break;
						}	
					}
				}
			}
			else {
				for(int i=0;i<4;i++) {
					if(bp.pl[current_player].pa[i].x==x&&bp.pl[current_player].pa[i].y==y&&(bp.pl[current_player].pa[i].current+dice)<=56) {
						value=i;
						flag=0;
						break;
					}	
				}
				if(value!=-1) {
					bp.pl[current_player].pa[value].current+=dice;
					if(bp.pl[current_player].pa[value].current==56) {
						bp.pl[current_player].coin++;
					}
					int k=0;
					int hou=bp.pl[current_player].pa[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51)
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][bp.pl[current_player].pa[value].current],tem2=Path.ay[current_player][bp.pl[current_player].pa[value].current];
								if(bp.pl[i].pa[j].x==tem1&&bp.pl[i].pa[j].y==tem2) {
									bp.pl[i].pa[j].current=-1;
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
