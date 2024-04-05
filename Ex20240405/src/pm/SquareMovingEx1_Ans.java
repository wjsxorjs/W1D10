package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareMovingEx1_Ans extends JFrame {

	
	int x=210, y=210;
	
	int cmd; // 방향키 중 하나가 들어감
	
	boolean flag;
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			
			// 임시 이미지 객체
			Image buf = createImage(this.getWidth(), this.getHeight());
			Graphics bufG = buf.getGraphics();
			// 임시 이미지 객체에 도형 그리기
			bufG.setColor(Color.CYAN);
			bufG.fillRect(x, y, 50, 50);
			
			// 도형이 그려진 이미지 객체를 현재 JPanel에 그리기
			g.drawImage(buf, 0, 0, this);
		}
		
	};
	
	Thread thread = new Thread() {

		@Override
		public void run() {
			
			// 스레드가 해야할 일은 바깥쪽 클래스의 x값 또는 y값을 변경해야한다.
			while(flag) {
				switch(cmd) {
				case KeyEvent.VK_LEFT:
					x -= 2;
					break;
				case KeyEvent.VK_RIGHT:
					x += 2;
					break;
				case KeyEvent.VK_UP:
					y -= 2;
					break;
				case KeyEvent.VK_DOWN:
					y += 2;
					break;
					
					
				} // switch문의 끝
				
				p.repaint();
				try {
					Thread.sleep(5);
				} catch (Exception e) {}
				
				
			} // while문의 끝
		}
		
	};
	
	
	public SquareMovingEx1_Ans() {

		
		
		
		this.add(p);
		
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
				
				if(code == KeyEvent.VK_SPACE) {
					// 스레드가 처음 시작되는 시점 cmd가 0일 때
					if(cmd==0) {
						cmd = (int)(Math.random()*4+37);
						thread.start(); // 스레드 구동 시작
						flag = true;
					} else {
						flag = false;
						cmd = 0; 	// 스레드가 소멸되어서 오류가 나므로 다시 시작하지는 못한다.
							  		// 
					}
				} else if(code>=37 && code <=40) {
					// 방향키만 선별하기 위해
					cmd = code;
				}
			}
		});
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new SquareMovingEx1_Ans();

	}

}
