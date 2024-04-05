package amBfClass;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BallMoving2 extends JFrame {
	
	Canvas can;
	
	KeyAdapter keyAdp;
	
	int x=200, y=200;
	
	
	public BallMoving2() {
		
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
				
				if(code == e.VK_NUMPAD0) {
					x = 200;
					y = 200;
				} else if(code == e.VK_NUMPAD1) {
					x -= 10;
					y += 10;
				} else if(code == e.VK_NUMPAD2) {
					y += 10;
				} else if(code == e.VK_NUMPAD3){
					x += 10;
					y += 10;
				} else if(code == e.VK_NUMPAD4){
					x -= 10;
				} else if(code == e.VK_NUMPAD6){
					x += 10;
				} else if(code == e.VK_NUMPAD7){
					x -= 10;
					y -= 10;
				} else if(code == e.VK_NUMPAD8){
					y -= 10;
				} else if(code == e.VK_NUMPAD9){
					x += 10;
					y -= 10;
				}
				
				can.repaint();
			}
		};
		
		this.addKeyListener(keyAdp);
		can.addKeyListener(keyAdp);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new BallMoving2();

	}

}
