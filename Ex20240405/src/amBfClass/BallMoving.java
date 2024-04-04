package amBfClass;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BallMoving extends JFrame {
	
	Canvas can;
	
	KeyAdapter keyAdp;
	
	int x=100, y=100;
	
	
	public BallMoving() {
		
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				
				g.fillOval(x, y, 50, 50);
			}
		};
		
		this.add(can);
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		
		
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
				
				if(code == e.VK_RIGHT) {
					x += 5;
				} else if(code == e.VK_LEFT) {
					x -= 5;
				} else if(code == e.VK_UP) {
					y -= 5;
				} else if(code == e.VK_DOWN){
					y += 5;
				}
				
				can.repaint();
			}
		};
		
		this.addKeyListener(keyAdp);
		can.addKeyListener(keyAdp);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new BallMoving();

	}

}
