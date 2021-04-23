package ex06.캡슐화.lotto.객체지향.생성자.정적;

import java.util.Random;

public class Program {
	
	public static void main(String[] args) { // main 함수에는 앞으로 계속 재사용할 함수들만 두기

		// lotto 객체 생성
		Lotto lotto = new Lotto(); // 4(nums) + 4(size) = 8바이트 필요
//		Lotto lotto1 = new Lotto(); // 4 + 4 = 8바이트 필요
		
		lotto.gen();
		
		LottoConsole.print(lotto); // 출력 함수도 재사용하기 위해 main 함수와 분리

		System.out.println();
	}
		
}


