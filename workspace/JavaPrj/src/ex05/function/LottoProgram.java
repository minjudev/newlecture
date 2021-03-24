package ex05.function;

import java.util.Arrays;
import java.util.Random;

public class LottoProgram {

	public static void main(String[] args) {
		// ����� ������ ���� �ڿ����� �ƴ��� Ȯ�� �ʿ�, ���� �ڿ��̸� �ش� ������ ���������� ������ �־�� ��
		int[] lotto;
		
		// �ζǸ� �����
		lotto = gen();
		
		// �ζ� ����ϱ�
		print(lotto);
		
		// �ζǸ� �����ϰ�
		sort(lotto);
		
		// �ζ� ����ϱ�
		print(lotto);
	}
	
	// �ζ� ����
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

	// �ζ� ���
	private static void print(int[] lotto) {
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i]);
			
			if(i < 5)
				System.out.print(", ");
		}
		
		System.out.println();
	}

	// �ζ� ����
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
