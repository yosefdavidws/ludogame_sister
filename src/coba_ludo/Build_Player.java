package coba_ludo;


import java.awt.Graphics2D;

public class Build_Player {

	Player[] pl=new Player[4]; 
	int[][] initialx= {
			{1,1,3,3},//red
			{10,10,12,12},//yellow
			{10,10,12,12},//green
			{1,1,3,3}//blue
	};
	int[][] initialy= {
			{1,3,1,3},//red
			{1,3,1,3},//yelow
			{10,12,10,12},//green
			{10,12,10,12}//blue
	};
	public Build_Player() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<4;i++) {
			pl[i]=new Player();
		}
	}
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				pl[i].pa[j].draw(g,initialx[i][j],initialy[i][j],i);
			}
		}
	}
	
}
