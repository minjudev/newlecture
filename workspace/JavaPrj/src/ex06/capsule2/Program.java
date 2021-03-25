package ex06.capsule2;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main �Լ����� ������ ��� ������ �Լ��鸸 �α�

//		int[] lotto;
		Lotto lotto;		
	
		// �ζǸ� �����
//		lotto = LottoProgram.gen(); 
		lotto = gen();
		
		// �ζ� ����ϱ�
		print(lotto);

		System.out.println();
		
//		// �ζǸ� �����ϰ�
//		LottoProgram.sort(lotto);
//		
//		// �ζ� ����ϱ�
//		print(lotto);
	}

	// �ζ� ���
	private static void print(Lotto lotto) {
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto.nums[i]);
			
			if(i < 5)
				System.out.print(", ");
		}	
	}
	
	// �ζ� ����
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
