package amBfClass;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BallMoving3 extends JFrame {
	
	Canvas can;
	
	KeyAdapter keyAdp;
	
	int x=200, y=150;
	
	int xInc = 15, yInc = 15;
	
	Rectangle windowRect;
	
	
	
	
	public BallMoving3() {
		
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				
				g.fillOval(x, y, 50, 50);
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
				int code = e.getKeyCode();
				
				
				if(x + xInc > windowRect.width) {
					xInc *= -1;
				} else if(x + xInc<0){
					xInc *= -1;
				} else if(y + yInc > windowRect.height){
					yInc *= -1;
				} else if(y + yInc < 0){
					yInc *= -1;
				} 
				
				x += xInc;
				y += yInc;
				
				
				can.repaint();
			}
		};
		
		this.addKeyListener(keyAdp);
		can.addKeyListener(keyAdp);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new BallMoving3();

	}

}
