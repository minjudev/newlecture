package ex03.array;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		// Random ��ü�� rand��� �̸����� ����
		Random rand = new Random();
		
		int[] kors = new int[6]; 
		
		for(int i = 0; i < 6; i++) {
			kors[i] = rand.nextInt(45) + 1;
			System.out.printf("%d ", kors[i]);
		}
		
	}

}
