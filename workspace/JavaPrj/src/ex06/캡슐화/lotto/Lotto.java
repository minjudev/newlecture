package ex06.캡슐화.lotto;

import java.util.Random;

public class Lotto {
						
	private int[] nums; // nums 배열을 캡슐 밖에서 볼 수 없도록 해서, 그래서 밖에서 쓸 수 없도록 하기 위해 private 접근 제어 지시자를 설정해줌
	private int size;
	
	public static void init(Lotto lotto) {
		lotto.size = 6;
		lotto.nums = new int[lotto.size];
	}
	
	// 오른쪽 마우스 -> Source -> Generate Getters and Setters
	public static int getSize(Lotto lotto) {
		return lotto.size;
	}
	
	// print 함수를 옮기지 않은 이유(옮기지 않아야 할 필요성이 있는 함수들이 있음)
	// 입출력 함수이기 때문에 고민을 하게 되는 것임
	// 사용자에게 보여줄 수 있는 옵션들: 콘솔 출력 / 윈도우 출력 / 웹 출력 / 홀로그램 출력
	// print 함수를 넣게 되면 Lotto라는 캡슐은 콘솔용에만 한정되는 프로그램이 되는 것임
	// 하지만 print 함수를 이 캡슐에 넣지 않으면 또 오류가 발생
	
	// 해결 방법은?
	// 캡슐이 깨지지 않도록 nums 배열은 계속 private로 설정
	// 바뀌지 않을 수 있는 약속을 가지고 있는 함수를 대안으로 제시
	// private 변수 nums를 밖으로 꺼내줄 수 있는 대안을 함수로 만들기
	public static int getNum(Lotto lotto, int i) {
		int number = lotto.nums[i];
		return number;
	}
	
	// 로또 생성
	public static Lotto gen(Lotto lotto) { // generate 함수에서는 객체가 아닌 값만 생성하게 하자
		// Lotto lotto = new Lotto(); // Lotto의 객체, 실체, 인스턴스를 만듦
								   // Lotto의 객체를 만들면 실제 메모리에서는 int[] nums인 4byte가 만들어짐 
								   // 4byte   [  ]
								   //			↓
		// lotto.nums = new int[6];   // 24btyte [        ]
		
		Random rand = new Random();
		
		for(int i=0; i<lotto.size; i++) {
			int number = rand.nextInt(45) + 1;
			lotto.nums[i] = number;	
		}
		
		return lotto;
	}
	
	// 로또 정렬
	public static void sort(Lotto lotto) {
		for(int i=0; i<lotto.size-1; i++) 	
			for(int j=0; j<lotto.size-1-i; j++) 			
				if(lotto.nums[j] > lotto.nums[j+1]) {
					int temp;
					temp = lotto.nums[j];
					lotto.nums[j] = lotto.nums[j+1];
					lotto.nums[j+1] = temp;
				}	
	}
	
}
