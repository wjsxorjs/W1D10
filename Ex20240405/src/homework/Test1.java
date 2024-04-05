package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 extends JFrame {
	
	JButton left_bt, center_bt, right_bt;
	JPanel p1;
	
	public Test1() {
		
		left_bt = new JButton("Left");
		center_bt = new JButton("Center");
		right_bt = new JButton("Right");
		
		p1 = new JPanel();
		p1.add(left_bt);
		p1.add(center_bt);
		p1.add(right_bt);
		
		// 버튼들을 가지는 Panel을 현재 창의 NORTH영역에 추가
		this.add(p1,BorderLayout.NORTH);
		
		
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
		
		// Left_Button을 클릭했을 때 p1의 정렬을 왼쪽 정렬로 변경
		left_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 오로지 left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.LEFT));
				p1.revalidate();
//				p1.updateUI(); // 이것도 작동한다.
			}
			
		});
		
		// Left_Button을 클릭했을 때 p1의 정렬을 왼쪽 정렬로 변경
		center_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 오로지 left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.CENTER));
				p1.revalidate();
//				p1.updateUI(); // 이것도 작동한다.
			}
			
		});
		
		// Left_Button을 클릭했을 때 p1의 정렬을 왼쪽 정렬로 변경
		right_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 오로지 left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
//				p1.revalidate();
				p1.updateUI(); // 이것도 작동한다.
			}
			
		});
		
		
	}
	
	

	public static void main(String[] args) {

		new Test1();

	}

}
