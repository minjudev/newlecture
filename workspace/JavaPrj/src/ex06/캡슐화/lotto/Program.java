package ex06.ĸ��ȭ.lotto;

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
		// lotto.gen(); => �ζǸ� �����Ѵ�.(�츮�� ǥ���ϴ� ������� �ڵ带 �ۼ��ϸ� ������ �ռ���� ��)
		// lotto�� �ռ����� ���ڴ� �ǹ�
		// �̿��� ������ �տ� �δ� ��
		// �־�� ����� �켱�ǰ� ���簡 �ڷ� ���� �ڵ带 �ۼ�����.
		
		// �ζ� ����ϱ�
		print(lotto);
		// lotto.print(); => �ζǸ� ����Ѵ�.

		System.out.println();
		
//		// �ζǸ� �����ϰ�
		Lotto.sort(lotto);
		// lotto.sort(); => �ζǸ� �����Ѵ�.
//		
//		// �ζ� ����ϱ�
		print(lotto);
		// lotto.print(); => �ζǸ� ����Ѵ�.

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
		
}


