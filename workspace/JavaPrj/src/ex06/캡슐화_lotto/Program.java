package ex06.캡슐화_lotto;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main 함수에는 앞으로 계속 재사용할 함수들만 두기

//		Lotto lotto;	
		// lotto 객체 생성
		Lotto lotto = new Lotto(); // Lotto의 인스턴스(=객체, 실체) 만들기
		
		// lotto 생성 후에 반드시 lotto에 nums 공간을 만들어주는 초기화 작업이 필요
//		lotto.nums = new int[6]; // 캡슐화가 깨지지 않게 nums를 여기서 사용하지 않도록 캡슐 내에서 nums 초기화해주는 함수 만들기
		Lotto.init(lotto); // lotto
	
		// 로또를 만들고
//		lotto = LottoProgram.gen(); 
		lotto = Lotto.gen(lotto); 
		
		// 로또 출력하기
		print(lotto);

		System.out.println();
		
//		// 로또를 정렬하고
		Lotto.sort(lotto);
//		
//		// 로또 출력하기
		print(lotto);
	}

	// 로또 출력
	private static void print(Lotto lotto) {
		System.out.print("로또 번호: ");
		
		for(int i=0; i<Lotto.getSize(lotto); i++) {
			System.out.print(Lotto.getNum(lotto, i)); // nums를 이용하는 것 대신 lotto에서 i번째를 꺼내주는 함수를 만들자
//			System.out.print(lotto.nums[i]);          // 반환값으로 lotto라는 것이 가지고 있는 nums의 i번째 값을 반환하기
			
			if(i < Lotto.getSize(lotto)-1)
				System.out.print(", ");
		}	
	}
	
	// 로또 생성
//	private static Lotto gen() {
//		
////		int[] lotto = new int[6];
//		Lotto lotto = new Lotto();
//		lotto.nums = new int[6];
//		
//		Random rand = new Random();
//		
//		for(int i=0; i<6; i++) {
//			int number = rand.nextInt(45) + 1;
//			lotto.nums[i] = number;	
//		}
//		
//		return lotto;
//	}
		
}


