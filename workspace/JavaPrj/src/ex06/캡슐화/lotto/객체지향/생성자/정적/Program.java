package ex06.ĸ��ȭ.lotto.��ü����.������.����;

import java.util.Random;

public class Program {
	
	public static void main(String[] args) { // main �Լ����� ������ ��� ������ �Լ��鸸 �α�

		// lotto ��ü ����
		Lotto lotto = new Lotto(); // 4(nums) + 4(size) = 8����Ʈ �ʿ�
//		Lotto lotto1 = new Lotto(); // 4 + 4 = 8����Ʈ �ʿ�
		
		lotto.gen();
		
		LottoConsole.print(lotto); // ��� �Լ��� �����ϱ� ���� main �Լ��� �и�

		System.out.println();
	}
		
}


