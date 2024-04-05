package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex5 extends JFrame {
	
	int x = 210, xInc = 5;
	
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// JPanel의 크기와 같은 이미지 객체 생성
			Image buf = createImage(this.getWidth(), this.getHeight());
			
			// 준비된 이미지 객체에만 그림을 그릴 수 있는 붓과 같은 객체
			Graphics buf_g = buf.getGraphics();
			buf_g.setColor(Color.GREEN);
			buf_g.fillOval(x, 245, 50, 50);
			
			g.drawImage(buf, 0, 0, this);
		}
		
	};
	
	Thread_Ex5 t1;
	
	public Frame_Ex5() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		
		
		t1 = new Thread_Ex5(this);		// 스레드 생성
		t1.start();						// 스레드 구동		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
	}
	
	

	public static void main(String[] args) {
		// 
		new Frame_Ex5();

	}

}
