package ex06.ĸ��ȭ.lotto.��ü����;

public class LottoConsole {

	// �ζ� ���
	public static void print(Lotto lotto) {
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<lotto.getSize(); i++) {
			System.out.print(/*Lotto.getNum(lotto, i)*/lotto.getNum(i)); // ��ȯ������ lotto��� ���� ������ �ִ� nums�� i��° ���� ��ȯ�ϱ�
			
			if(i < lotto.getSize()-1)
				System.out.print(", ");
		}	
	}
}
