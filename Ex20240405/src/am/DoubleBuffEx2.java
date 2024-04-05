package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoubleBuffEx2 extends JFrame {
	
	int x = 210;
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			
			Image buf = createImage(this.getWidth(), this.getHeight());
			
			Graphics buf_g = buf.getGraphics();
			
			buf_g.setColor(Color.GREEN);
			buf_g.fillRect(x, 235, 80, 30);
			
			g.drawImage(buf, 0, 0, this);
		}
		
	};
	
	
	public DoubleBuffEx2() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 600);
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
				case KeyEvent.VK_RIGHT:
					x += 5;
					if(x>p.getWidth()-80) {
						x = p.getWidth()-80;
					}
					break;
					
				case KeyEvent.VK_LEFT:
					x -= 5;
					if(x<0) {
						x = 0;
					}
					break;
				}
				
				p.repaint();
			}
		});
		
	}
	
	

	public static void main(String[] args) {
		new DoubleBuffEx2();

	}

}
