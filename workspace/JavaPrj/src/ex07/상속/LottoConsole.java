package ex07.���;

// console�� UI ���
// UI�� �޶����� �ֿܼ� UI�� �и������Ƿ� �ٸ� �������ġ������ Lotto Ŭ���� ��� ����
public class LottoConsole {

	// ��ü�� �̿��ϴ� �� �ٸ� ��ü�� ���� �� ����
	// ��ü�� �ٸ� ��ü�� �ڽ��� ����� Has �ϰ� �װ��� �̿��ϸ� �װ��� Has A ����̶�� �Ѵ�.(����� ������ ���� ���� Has��� ��)
	// LottoConsole�� Lotto�� ����� ������ �����ν� Has A ��� ���谡 ��
	// �ٸ� ��ü�� �ڽ��� ��ǰ���� ���� ��
	private Lotto lotto; // LottoConsole�� Lotto�� ���(����) �޾Ƽ� ��� �Լ�(print)�� �����Ѵ�.
						 // �ٸ� ��ü�� ��� �̿�
						 // Lotto��� ����� ���� �ڷ����� ����ϰڴ�, �̸��� lotto�� ����
	
	// Composition Has A ���: ��ü��
	// LottoConsole�� lotto�� �Ѱܹ��� �ʰ� ���� lotto�� ����
//	public LottoConsole() {
//		this.lotto = new Lotto(); // this�� ���������� �����ϰ� ���� �� ���
//		this.lotto.gen();
//	}
	
	// Association Has A ���: �и���
	public LottoConsole(Lotto lotto) { // �����ڷ� �ʱ�ȭ�ϸ鼭 ���⼭ lotto ��ü�� �Ѱ� �޾���
		this.lotto = lotto; // ���⼭ lotto�� �Ѱܹ��� �� Program.java 40��° ���� ���� lotto�� ���� �Ѱ� ����
	}
	
	// �ζ� ���
	public void print() { // �� �Լ��� ������ ���� �ٸ� ��ü�� �ڽ��� ��ǰ���� �������� ��: Has A ���
		System.out.print("�ζ� ��ȣ: ");
		
		for(int i=0; i<this.lotto.getSize(); i++) {
			System.out.print(/*Lotto.getNum(lotto, i)*/this.lotto.getNum(i)); // ��ȯ������ lotto��� ���� ������ �ִ� nums�� i��° ���� ��ȯ�ϱ�
			
			if(i < this.lotto.getSize()-1)
				System.out.print(", ");
		}	
	}
}
