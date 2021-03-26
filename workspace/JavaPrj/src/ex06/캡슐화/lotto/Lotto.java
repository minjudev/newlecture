package ex06.ĸ��ȭ.lotto;

import java.util.Random;

public class Lotto {
						
	private int[] nums; // nums �迭�� ĸ�� �ۿ��� �� �� ������ �ؼ�, �׷��� �ۿ��� �� �� ������ �ϱ� ���� private ���� ���� �����ڸ� ��������
	private int size;
	
	public static void init(Lotto lotto) {
		lotto.size = 6;
		lotto.nums = new int[lotto.size];
	}
	
	// ������ ���콺 -> Source -> Generate Getters and Setters
	public static int getSize(Lotto lotto) {
		return lotto.size;
	}
	
	// print �Լ��� �ű��� ���� ����(�ű��� �ʾƾ� �� �ʿ伺�� �ִ� �Լ����� ����)
	// ����� �Լ��̱� ������ ����� �ϰ� �Ǵ� ����
	// ����ڿ��� ������ �� �ִ� �ɼǵ�: �ܼ� ��� / ������ ��� / �� ��� / Ȧ�α׷� ���
	// print �Լ��� �ְ� �Ǹ� Lotto��� ĸ���� �ֿܼ뿡�� �����Ǵ� ���α׷��� �Ǵ� ����
	// ������ print �Լ��� �� ĸ���� ���� ������ �� ������ �߻�
	
	// �ذ� �����?
	// ĸ���� ������ �ʵ��� nums �迭�� ��� private�� ����
	// �ٲ��� ���� �� �ִ� ����� ������ �ִ� �Լ��� ������� ����
	// private ���� nums�� ������ ������ �� �ִ� ����� �Լ��� �����
	public static int getNum(Lotto lotto, int i) {
		int number = lotto.nums[i];
		return number;
	}
	
	// �ζ� ����
	public static Lotto gen(Lotto lotto) { // generate �Լ������� ��ü�� �ƴ� ���� �����ϰ� ����
		// Lotto lotto = new Lotto(); // Lotto�� ��ü, ��ü, �ν��Ͻ��� ����
								   // Lotto�� ��ü�� ����� ���� �޸𸮿����� int[] nums�� 4byte�� ������� 
								   // 4byte   [  ]
								   //			��
		// lotto.nums = new int[6];   // 24btyte [        ]
		
		Random rand = new Random();
		
		for(int i=0; i<lotto.size; i++) {
			int number = rand.nextInt(45) + 1;
			lotto.nums[i] = number;	
		}
		
		return lotto;
	}
	
	// �ζ� ����
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
