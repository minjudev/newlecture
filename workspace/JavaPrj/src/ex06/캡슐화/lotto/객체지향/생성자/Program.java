package ex06.ĸ��ȭ.lotto.��ü����.������;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main �Լ����� ������ ��� ������ �Լ��鸸 �α�

//		Lotto lotto;	
		// lotto ��ü ����
		Lotto lotto = new Lotto(); // Lotto�� �ν��Ͻ�(=��ü, ��ü) �����
		
		// lotto ���� �Ŀ� �ݵ�� lotto�� nums ������ ������ִ� �ʱ�ȭ �۾��� �ʿ�
//		lotto.nums = new int[6]; // ĸ��ȭ�� ������ �ʰ� nums�� ���⼭ ������� �ʵ��� ĸ�� ������ nums �ʱ�ȭ���ִ� �Լ� �����
//		Lotto.init(lotto); 
//		lotto.init(); 
	
		// �ζǸ� �����
//		lotto = Lotto.gen(lotto); 
		lotto.gen();
		// lotto.gen(); => �ζǸ� �����Ѵ�.(�츮�� ǥ���ϴ� ������� �ڵ带 �ۼ��ϸ� ������ �ռ���� ��)
		// ���� gen()�� �ܼ��� �Լ��� �� ���̳� lotto��� ��ü�� �����ϴ� ���񽺷� �� ���̳Ĵ� ������ �ϰ� ��
		// lotto�� ������μ� gen()�� �ٶ󺸰� �� -> ����, [�޼ҵ�(��ü�� �Ӽ��� ������ �� �ִ� ������ �ϴϱ�)], ��� �Լ�, ...
		// this�� ����ϴ� �Լ��� �޼ҵ��� �� ����
		
		// lotto.init(); �̰� ���⿡ �� ȣ��� �� ������ �ʱ�ȭ���ִ� �Լ��� ó�� �ʱ�ȭ ��� �̿ܿ� �ٸ� ���� �� ȣ��� �� �ְ� ����� �ȵ�
		
		// �ζ� ����ϱ�
		LottoConsole.print(lotto); // ��� �Լ��� �����ϱ� ���� main �Լ��� �и�
		// lotto.print(); => �ζǸ� ����Ѵ�.

		System.out.println();
		
		// �ζǸ� �����ϰ�
		// Lotto.sort(lotto);
		// lotto.sort(); => �ζǸ� �����Ѵ�.
		lotto.sort(); // sort ���� lotto�� ���ڰ� �Ǵ� �� 
					  // �� lotto��� ��ü(�̰�, this)�� �����ؼ� �����ش޶�� �ϴ� ��
		
		// �ζ� ����ϱ�
		LottoConsole.print(lotto);
		// lotto.print(); => �ζǸ� ����Ѵ�.

	}
		
}


