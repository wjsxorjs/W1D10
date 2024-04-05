package amBfClass;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BallMoving4 extends JFrame {
	
	Canvas can;
	
	KeyAdapter keyAdp;
	
	int x=200, y=150;
	
	int xInc = 10, yInc = 10;
	
	Rectangle windowRect;
	
	boolean move;
	
	class MyOval {
		
		Color c;
		int xx, yy;
		
		public MyOval() {
			c = new Color(red, green, blue);
			this.xx = x;
			this.yy = y;
		}

	}
	
	MyOval[] moArr = new MyOval[5];
	int arrInd = 0;
	
	int red = (int)(Math.random()*256);
	int green = (int)(Math.random()*256);
	int blue = (int)(Math.random()*256);
	
	public void changeColor() {
		red = (int)(Math.random()*256);
		green = (int)(Math.random()*256);
		blue = (int)(Math.random()*256);
	}
	
	public void moveBall() {

		x += xInc;
		y += yInc;
		
		if(x > can.getWidth()-50) {
			x = can.getWidth()-50;
			xInc *= -1;
		} else if(x<0){
			x = 0;
			xInc *= -1;
		}
		
		if(y > can.getHeight()-50){
			y = can.getHeight()-50;
			yInc *= -1;
		} else if(y < 0){
			y = 0;
			yInc *= -1;
		} 
		
		
		
		can.repaint();
	}
	
	
	public BallMoving4() {
		for(int i=0;i<5;i++) {
			moArr[arrInd%5] = new MyOval();
			arrInd++;
		}
		
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				for(int i=arrInd;i<arrInd+5;i++) {
					g.setColor(moArr[i%5].c);
					g.fillOval(moArr[i%5].xx, moArr[i%5].yy, 50, 50);
				}
			}
		};
		
		
		this.add(can);
		this.setBounds(100, 100, 300, 250);
		this.setVisible(true);
		
				
		
		windowRect = this.getBounds();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});

		
		keyAdp = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				arrInd++;
				changeColor();
				moveBall();
				moArr[arrInd%5] = new MyOval();
				
			}
		};
		
		this.addKeyListener(keyAdp);
		can.addKeyListener(keyAdp);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new BallMoving4();

	}

}
