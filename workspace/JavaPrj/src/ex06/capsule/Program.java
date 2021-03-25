package ex06.capsule;

public class Program {
	
	// �ζ� ���
	private static void print(int[] lotto) {
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i]);
			
			if(i < 5)
				System.out.print(", ");
		}	
	}

	public static void main(String[] args) { // main �Լ����� ������ ��� ������ �Լ��鸸 �α�

		int[] lotto;
		
		// �ζǸ� �����
		lotto = LottoProgram.gen(); // �ٸ� Ŭ������ �ִ� �Լ��� ����� ���� �տ� Ŭ���� �̸��� ����ؾ� ��
		
		// �ζ� ����ϱ�
		print(lotto);
		
		System.out.println();
		
		// �ζǸ� �����ϰ�
		LottoProgram.sort(lotto);
		
		// �ζ� ����ϱ�
		print(lotto);
	}

}
