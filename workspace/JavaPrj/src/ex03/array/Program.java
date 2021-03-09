package ex03.array;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		// Random 객체를 rand라는 이름으로 새엉
		Random rand = new Random();
		
		int[] kors = new int[6]; 
		
		for(int i = 0; i < 6; i++) {
			kors[i] = rand.nextInt(45) + 1;
			System.out.printf("%d ", kors[i]);
		}
		
	}

}
