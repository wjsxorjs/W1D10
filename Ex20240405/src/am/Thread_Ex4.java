package am;

public class Thread_Ex4 extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<7; i++) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {}
			System.out.printf("%-2s","*");
			
		}
	}

}
