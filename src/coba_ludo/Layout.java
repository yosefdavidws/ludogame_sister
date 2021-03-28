package coba_ludo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.rmi.Remote;
import javax.swing.JPanel;

public class Layout extends JPanel{
	
	int x,y,width,height;
	String a1,b1,c1,d1;
	public Layout(int xi,int yi,String a, String b, String c, String d) {
             a1 = a;
            b1 = b;
            c1 = c;
            d1 = d;
		x=xi;//80
		y=yi;//50
		width=30;//lebar kotak satuan (1)
		height=30;//tinggi kotak satuan (1)
                
	}
       
	public void draw(Graphics2D g){
            //1
		g.setColor(Color.WHITE);
                g.fillRect(x,y,15*width,15*height);//lapisan bawah warna putih (80,50,450,450)
        for(int i=0;i<6;i++) {//warna kotak dalam rumah
        	g.setColor(Color.RED);
        	g.fillRect(x+(i*width),y, width, height);//merah atas(80,50,30,30)
        	g.fillRect(x, y+(i*height), width, height);//merah kiri
        	g.fillRect(x+(i*width),y+(5*height), width, height);//bawah
        	g.fillRect(x+(5*width), y+(i*height), width, height);//kanan
        	g.setColor(Color.GREEN);
        	g.fillRect(x+((i+9)*width),y, width, height);//atas
        	g.fillRect(x+(9*width), y+(i*height), width, height);//kiri
        	g.fillRect(x+((i+9)*width),y+(5*height), width, height);//bawah
        	g.fillRect(x+(14*width), y+(i*height), width, height);//kanan
        	g.setColor(Color.YELLOW);
        	g.fillRect(x+((i+9)*width),y+(9*height), width, height);//atas
        	g.fillRect(x+(9*width), y+((i+9)*height), width, height);//kiri
        	g.fillRect(x+((i+9)*width),y+(14*height), width, height);//bawah
        	g.fillRect(x+(14*width), y+((i+9)*height), width, height);//kanan
        	g.setColor(Color.BLUE);
        	g.fillRect(x+(i*width),y+(9*height), width, height);//atas
        	g.fillRect(x, y+((i+9)*height), width, height);//kiri
        	g.fillRect(x+(i*width),y+(14*height), width, height);//bawah
        	g.fillRect(x+(5*width), y+((i+9)*height), width, height);//kanan
        }
        //2
        for(int i=1;i<6;i++) {//jalan masuk ke tengah
        	g.setColor(Color.RED);
        	g.fillRect(x+(i*width),y+(7*height), width, height);
        	g.setColor(Color.YELLOW);
        	g.fillRect(x+((8+i)*width),y+(7*height), width, height);
        	g.setColor(Color.GREEN);
        	g.fillRect(x+(7*width),y+(i*height), width, height);
        	g.setColor(Color.BLUE);
        	g.fillRect(x+((7)*width),y+((8+i)*height), width, height);
        }
        //jalan depan rumah 1 kotak
        g.setColor(Color.RED);
    	g.fillRect(x+(1*width),y+(6*height), width, height);
    	g.setColor(Color.YELLOW);//jalan ke-1
    	g.fillRect(x+((13)*width),y+(8*height), width, height);
    	g.setColor(Color.GREEN);
    	g.fillRect(x+(8*width),y+(1*height), width, height);
    	g.setColor(Color.BLUE);
    	g.fillRect(x+((6)*width),y+((13)*height), width, height);
        //3
    	int x2=x+45,y2=y+45;
    	for(int i=0;i<2;i++) {//tempat player
    		for(int j=0;j<2;j++) {
    		g.setColor(Color.RED);
    	    	g.fillRect(x2+(2*i*width),y2+(2*j*height), width, height);//ataskiri (125,95,30,30), bawahkiri(125,155,30,30), ataskanan(185,95,30,30), bawahkanan(185,155,30,30)
    	    	g.setColor(Color.YELLOW);
    	    	g.fillRect(x2+(2*i*width)+9*width,y2+(2*j*height)+9*height, width, height);//ataskiri (395,365,30,30), bawahkiri(395,405,30,30), ataskanan(455,365,30,30), bawahkanan(455,405,30,30)
    	    	g.setColor(Color.GREEN);
    	    	g.fillRect(x2+(2*i*width)+9*width,y2+(2*j*height)+0*height, width, height);//ataskiri (395,95,30,30), bawahkiri(395,155,30,30), ataskanan(455,95,30,30), bawahkanan(455,155,30,30)
    	    	g.setColor(Color.BLUE);
    	    	g.fillRect(x2+(2*i*width)+0*width,y2+(2*j*height)+9*height, width, height);//ataskiri (125,365,30,30), bawahkiri(125,365,30,30), ataskanan(185,365,30,30), bawahkanan(185,405,30,30)
    		}
    	}
        //segitiga tengah final
    	g.setColor(Color.RED);
    	int xpoints0[] = {x+(6*width),x+(6*width), x+15+(7*width)};
        int ypoints0[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints = 3;
        g.fillPolygon(xpoints0, ypoints0, npoints);
    	g.setColor(Color.YELLOW);
    	int xpoints1[] = {x+(9*width),x+(9*width), x+15+(7*width)};
        int ypoints1[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints1= 3;
        g.fillPolygon(xpoints1, ypoints1, npoints1);
    	g.setColor(Color.GREEN);
    	int xpoints2[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints2[] = {y+(6*height),y+(6*height),y+15+(7*width)};
        int npoints2= 3;
        g.fillPolygon(xpoints2, ypoints2, npoints2);
    	g.setColor(Color.BLUE);
    	int xpoints3[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints3[] = {y+(9*height),y+(9*height),y+15+(7*width)};
        int npoints3= 3;
        g.fillPolygon(xpoints3, ypoints3, npoints3);
        //4
    	g.setStroke(new BasicStroke(2));//tebal garis 
    	g.setColor(Color.BLACK);//memberi garis kotak-kotak
    	for(int i=0;i<3;i++) {
    		for(int j=0;j<6;j++) {
    	        g.drawRect(x+((i+6)*width),y+(j*height), width, height);// atas
    	        g.drawRect(x+((j)*width),y+((i+6)*height), width, height);//kiri
    	        g.drawRect(x+((i+6)*width),y+((j+9)*height), width, height);//bawah
    	        g.drawRect(x+((j+9)*width),y+((i+6)*height), width, height);//kanan
    		}
    	}
    	g.drawRect(x+((1)*width),y+(1*height),4*width,4*height);//garis rumah merah
    	g.drawRect(x+((10)*width),y+(1*height),4*width,4*height);//garis rumah hijau
    	g.drawRect(x+((1)*width),y+(10*height),4*width,4*height);//garis rumah biru
    	g.drawRect(x+((10)*width),y+(10*height),4*width,4*height);//garis rumah  kuning
        g.drawRect(x,y,15*width,15*height);//garis pinggir papan ludo
        for(int i=0;i<2;i++) {//garis tempat koin
    		for(int j=0;j<2;j++) {
    	    	g.drawRect(x2+(2*i*width),y2+(2*j*height), width, height);
    	    	g.drawRect(x2+(2*i*width)+9*width,y2+(2*j*height)+9*height, width, height);
    	    	g.drawRect(x2+(2*i*width)+9*width,y2+(2*j*height)+0*height, width, height);
    	    	g.drawRect(x2+(2*i*width)+0*width,y2+(2*j*height)+9*height, width, height);
    		}
    	}
        g.drawPolygon(xpoints0, ypoints0, npoints);//garis segitiga
        g.drawPolygon(xpoints1, ypoints1, npoints1);
        g.drawPolygon(xpoints2, ypoints2, npoints2);
        g.drawPolygon(xpoints3, ypoints3, npoints3);
        //checkpoin lingkaran
        g.drawOval(x+5+(6*width),y+5+(2*height),width-10,height-10);
        g.drawOval(x+5+(12*width),y+5+(6*height),width-10,height-10);
        g.drawOval(x+5+(8*width),y+5+(12*height),width-10,height-10);
        g.drawOval(x+5+(2*width),y+5+(8*height),width-10,height-10);
        g.setFont(new Font("serif", Font.BOLD, 30));//font
        g.setColor(Color.RED);
        g.fillOval(220,623,25,25);
        if (a1 == null){
        g.drawString("", 250, 646);
        } else {
        g.drawString(""+a1, 250, 646);
        }
        
        g.setColor(Color.GREEN);
        g.fillOval(380,623,25,25);
        if (b1 == null){
        g.drawString("", 410, 646);
        } else {
        g.drawString(""+b1, 410, 646);
        }
        
        g.setColor(Color.BLUE);
        g.fillOval(540,623,25,25);
        if (c1 == null){
        g.drawString("", 570, 646);
        }else {
        g.drawString(""+c1, 570, 646);
        }
        
        g.setColor(Color.YELLOW);
        g.fillOval(700,623,25,25);
        if (d1 == null){
        g.drawString("", 730, 646);
        } else  {
        g.drawString(""+d1, 730, 646);
        }
        
        
        g.setColor(Color.WHITE);//tempat pergantian player
    		g.fillRect(250,5,450,130);
                  g.setColor(Color.WHITE);
            g.fillRect(455,20,50,50);
            g.setColor(Color.BLACK);//memberi garis pinggir
        g.drawRect(455,20,50,50);
        g.setFont(new Font("serif", Font.BOLD, 15));
        g.drawString("dadu",465,50);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString("Enter untuk mulai", 370, 110);
//         g.drawString("m", 300, 200);
//        g.drawString("m", 300, 255);
//        g.drawString("m", 360, 200);
//        g.drawString("m", 360, 255);
//           g.drawString("k", 570, 470);
//        g.drawString("k", 570, 530);
//        g.drawString("k", 630, 470);
//        g.drawString("k", 630, 530);
//         g.drawString("b", 300, 470);
//        g.drawString("b", 300, 530);
//        g.drawString("b", 360, 470);
//        g.drawString("b", 360, 530);
//         g.drawString("h", 570, 200);
//        g.drawString("h", 570, 255);
//        g.drawString("h", 630, 200);
//        g.drawString("h", 630, 255);
    }
}
