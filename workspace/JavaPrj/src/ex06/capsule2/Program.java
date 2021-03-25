package ex06.capsule2;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main 함수에는 앞으로 계속 재사용할 함수들만 두기

//		int[] lotto;
		Lotto lotto;		
	
		// 로또를 만들고
//		lotto = LottoProgram.gen(); 
		lotto = gen();
		
		// 로또 출력하기
		print(lotto);

		System.out.println();
		
//		// 로또를 정렬하고
//		LottoProgram.sort(lotto);
//		
//		// 로또 출력하기
//		print(lotto);
	}

	// 로또 출력
	private static void print(Lotto lotto) {
		System.out.print("로또 번호: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto.nums[i]);
			
			if(i < 5)
				System.out.print(", ");
		}	
	}
	
	// 로또 생성
	private static Lotto gen() {
		
//		int[] lotto = new int[6];
		Lotto lotto = new Lotto();
		lotto.nums = new int[6];
		
		Random rand = new Random();
		
		for(int i=0; i<6; i++) {
			int number = rand.nextInt(45) + 1;
			lotto.nums[i] = number;	
		}
		
		return lotto;
	}
	
}
