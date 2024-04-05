package homework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Test2 extends JFrame {

	int x = 100, y = 100;
	
	Canvas can = new Canvas() {
		
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.ORANGE);
			g.fillOval(x, y, 50, 50);
		}
		
	};
	
	public Test2() {
		
		
		this.add(can);
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_LEFT:
					x -= 5;
					if(x < 0) {
						x = 0;
					}
					break;
				case KeyEvent.VK_RIGHT:
					x += 5;
					int w = can.getWidth();
					if(x > w-50) {
						x = w-50;
					}
					break;
				case KeyEvent.VK_UP:
					y -= 5;
					if(y < 0) {
						y = 0;
					}
					break;
				case KeyEvent.VK_DOWN:
					y += 5;
					int h = can.getHeight();
					if(y > h-50) {
						y = h-50;
					}
					break;
				}
				
				can.repaint();
				
			}
		});
		
		
	}
	

	public static void main(String[] args) {
		new Test2();

	}

}
