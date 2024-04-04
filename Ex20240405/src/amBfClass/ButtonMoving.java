package amBfClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonMoving extends JFrame {
	
	JButton btnL, btnC, btnR;
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	JPanel panel = new JPanel(layout);
	

	public ButtonMoving() {
		
		btnL = new JButton("L");
		btnC = new JButton("C");
		btnR = new JButton("R");
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(btnL);
		panel.add(btnC);
		panel.add(btnR);
		this.add(panel,BorderLayout.NORTH);
		
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btnL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.setAlignment(FlowLayout.LEFT);
				panel.revalidate();
			}
		});
		
		btnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.setAlignment(FlowLayout.CENTER);
				panel.revalidate();
				
			}
		});
		
		btnR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.setAlignment(FlowLayout.RIGHT);
				panel.revalidate();
				
			}
		});
			
		
		
	}
	
	
	public static void main(String[] args) {
		/*
		  BorderLayout.NORTH에 버튼 3개
		  L : flowlayout.left
		  C : flowlayout.center
		  R : flowlayout.right
		 */
		
		new ButtonMoving();
		
	}



}
