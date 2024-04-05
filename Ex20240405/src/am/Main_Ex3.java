package am;

public class Main_Ex3 {

	public static void main(String[] args) { // 메인스레드
		// 프로그램 시작
		
		
		// 스레드 생성
		Thread_Ex3 t1 = new Thread_Ex3();
		t1.start();	// 스레드 시작(start) > run()함수 호출
		
		// t1.run() // < run함수를 호출한 것이지 스레드를 시작한게 아니다.
					//   그러므로 독립적인 수행을 하지 않는다.

		
		Thread_Ex4 t2 = new Thread_Ex4();
		t2.start();
//		try {
//			Thread.sleep(300);
//		} catch (InterruptedException e) {}
		
		// 결과예측이 굉장히 모호하다.
		// 허나, 메인스레드가 우선순위가 어느정도있기에
		// 확률적으로는 메인스레드가 먼저 실행되나
		// 스레드는 모두 독립적이고 수행효율이 어떻게 될 지 모르기에
		// 결과예측이 굉장히 모호한게 맞다.
		System.out.println("Thread 연습");
		
	}

}
