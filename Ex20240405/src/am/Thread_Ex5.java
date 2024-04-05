package am;

public class Thread_Ex5 extends Thread {
	
	Frame_Ex5 fe5;
	
	// 현재 스레드가 해야할 일은 Frame_Ex5의 멤버 변수들 중
	// x값을 5씩 증가해야한다. 그래서 Frame_Ex5의 주소를
	// 현재 객체가 생성될 때 받아야한다.
	
	public Thread_Ex5(Frame_Ex5 f) {
		fe5 = f;
	}
	
	
	@Override
	public void run() {
		
//		while(fe5.x<fe5.p.getWidth()-50) {
//			fe5.x += 5;
//			fe5.p.repaint();
//			try {
//				Thread.sleep(50);
//			} catch (Exception e) {}
//		} // while문의 끝
//		
//		fe5.x=fe5.p.getWidth()-50;
		
		for(int i=0; i<1000;i++) {
			if(fe5.x > fe5.p.getWidth()-50) {
				fe5.x = fe5.getWidth()-50;
				fe5.xInc *= -1;
			} else if(fe5.x < 0) {
				fe5.x = 0;
				fe5.xInc *= -1;
			}
				fe5.x += fe5.xInc;
				fe5.p.repaint();
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {}
		}
	}

	
	
	
}
