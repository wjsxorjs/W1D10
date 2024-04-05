package pmBfClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SquareMovingEx1 extends JFrame {
	
	int x=100, y=100, xInc=5, yInc=5;
		
	int keyPress;
	
	boolean onGame, gameOver;
	
	Thread t1;
	
	JPanel p1;
	

	public void startGame() {
		t1 = new Thread() {
			@Override
			public void run() {
				gameOver = false;
				while(true) {
					x += xInc;
					y += yInc;
					
					if(x>p1.getWidth()-50) {
						x=p1.getWidth()-50;
						xInc = -5;
					} else if(x<0) {
						x=0;
						xInc = 5; 
					}
					if(y>p1.getHeight()-50) {
						y = p1.getHeight()-50;
						yInc = -5; 
					} else if(y<0) {
						y = 0;
						yInc = 5; 
					} 
					
					
					p1.repaint();
					try {
						Thread.sleep(100);
					} catch (Exception e) {}
				}
			}
		};
		
		t1.start();
	
	}
	
	public SquareMovingEx1() {
		
//			t1 = new Thread() {
//				@Override
//				public void run() {
//					while(true) {
//						x += xInc;
//						y += yInc;
//						
//						if(x>p1.getWidth()-50) {
//							x=p1.getWidth()-50;
//							xInc = -5;
//							break;
//						} else if(x<0) {
//							x=0;
//							xInc = 5; 
//							break;
//						}
//						if(y>p1.getHeight()-50) {
//							y = p1.getHeight()-50;
//							yInc = -5; 
//							break;
//						} else if(y<0) {
//							y = 0;
//							yInc = 5; 
//							break;
//						}
//						
//						
//						p1.repaint();
//						
//						try {
//							Thread.sleep(10);
//						} catch (Exception e) {}
//					}
//					JOptionPane.showMessageDialog(p1, "키를 누른 횟수: "+keyPress, "게임 종료", JOptionPane.ERROR_MESSAGE);
//				}
//			};
		
		
		
		p1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				Graphics buf_g = buf.getGraphics();
				
				buf_g.setColor(Color.GREEN);
				buf_g.fillRect(x, y, 50, 50);
				
				g.drawImage(buf, 0, 0, this);
				
			}
		};
		
		
		this.add(p1);
		
		
		this.setBounds(150, 150, 500, 600);
		this.setVisible(true);
		
		
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_SPACE:
					try {
//						t1.start();
						startGame();
					} catch (Exception e2) {}
					break;
				}	
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	
	
	

	public static void main(String[] args) {

		new SquareMovingEx1();

	}

}
