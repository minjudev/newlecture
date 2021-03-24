package ex05.function;

import java.util.Arrays;
import java.util.Random;

public class LottoProgram {

	public static void main(String[] args) {
		// 사용할 변수가 공유 자원인지 아닌지 확인 필요, 공유 자원이면 해당 변수를 전역적으로 가지고 있어야 함
		int[] lotto;
		
		// 로또를 만들고
		lotto = gen();
		
		// 로또 출력하기
		print(lotto);
		
		// 로또를 정렬하고
		sort(lotto);
		
		// 로또 출력하기
		print(lotto);
	}
	
	// 로또 정렬
	private static void sort(int[] lotto) {
		for(int i=0; i<5; i++) 	
			for(int j=0; j<5-i; j++) 			
				if(lotto[j] > lotto[j+1]) {
					int temp;
					temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}	
	}

	// 로또 출력
	private static void print(int[] lotto) {
		System.out.print("로또 번호: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i]);
			
			if(i < 5)
				System.out.print(", ");
		}
		
		System.out.println();
	}

	// 로또 생성
	private static int[] gen() {
		int[] lotto = new int[6];
		Random rand = new Random();
		
		for(int i=0; i<6; i++) {
			int number = rand.nextInt(45) + 1;
			lotto[i] = number;	
		}
		
		return lotto;
	}

}
