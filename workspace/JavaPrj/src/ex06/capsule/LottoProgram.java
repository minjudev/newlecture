package ex06.capsule;

import java.util.Random;

// ������ �ڵ�
public class LottoProgram {
	
	// �ζ� ����
	public static void sort(int[] lotto) {
		for(int i=0; i<5; i++) 	
			for(int j=0; j<5-i; j++) 			
				if(lotto[j] > lotto[j+1]) {
					int temp;
					temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}	
	}
	
	// �ζ� ����
	public static int[] gen() {
		int[] lotto = new int[6];
		Random rand = new Random();
		
		for(int i=0; i<6; i++) {
			int number = rand.nextInt(45) + 1;
			lotto[i] = number;	
		}
		
		return lotto;
	}
}
