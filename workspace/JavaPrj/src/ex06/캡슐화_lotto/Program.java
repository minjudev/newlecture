package ex06.ĸ��ȭ_lotto;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main �Լ����� ������ ��� ������ �Լ��鸸 �α�

//		Lotto lotto;	
		// lotto ��ü ����
		Lotto lotto = new Lotto(); // Lotto�� �ν��Ͻ�(=��ü, ��ü) �����
		
		// lotto ���� �Ŀ� �ݵ�� lotto�� nums ������ ������ִ� �ʱ�ȭ �۾��� �ʿ�
//		lotto.nums = new int[6]; // ĸ��ȭ�� ������ �ʰ� nums�� ���⼭ ������� �ʵ��� ĸ�� ������ nums �ʱ�ȭ���ִ� �Լ� �����
		Lotto.init(lotto); // lotto
	
		// �ζǸ� �����
//		lotto = LottoProgram.gen(); 
		lotto = Lotto.gen(lotto); 
		
		// �ζ� ����ϱ�
		print(lotto);

		System.out.println();
		
//		// �ζǸ� �����ϰ�
		Lotto.sort(lotto);
//		
//		// �ζ� ����ϱ�
		print(lotto);
	}

	// �ζ� ���
	private static void print(Lotto lotto) {
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<Lotto.getSize(lotto); i++) {
			System.out.print(Lotto.getNum(lotto, i)); // nums�� �̿��ϴ� �� ��� lotto���� i��°�� �����ִ� �Լ��� ������
//			System.out.print(lotto.nums[i]);          // ��ȯ������ lotto��� ���� ������ �ִ� nums�� i��° ���� ��ȯ�ϱ�
			
			if(i < Lotto.getSize(lotto)-1)
				System.out.print(", ");
		}	
	}
	
	// �ζ� ����
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


