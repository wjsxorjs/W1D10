package homework;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 extends JFrame {
	
	JButton left_bt, center_bt, right_bt;
	JPanel p1;
	
	public Test1() {
		
		
		
		
		
		
		this.setBounds(300,100,500,400);
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowAdapter() {
			// 현재 영역: WindowAdapter를 상속받는 이름없는 내부 클래스
			// class ? extends WindowAdapter {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
	}
	
	

	public static void main(String[] args) {

		new Test1();

	}

}
