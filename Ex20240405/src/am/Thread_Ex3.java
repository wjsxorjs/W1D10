package am;

public class Thread_Ex3 extends Thread {
	
	// 스레드를 상속받은 현재 클래스는 스레드다.
	
	
	@Override
	public void run() {
		// 현재 스레드가 해야할 일들...
		
		for(int i=1;i<11;i++) {
			System.out.printf("%-3d",i);
			
			// 잠깐 휴식 < 예외 발생 가능 < 예외처리 필요
			try {
				sleep(100);
			} catch (Exception e) {}
			
			
		}// for의 끝
		
	}
	

}
