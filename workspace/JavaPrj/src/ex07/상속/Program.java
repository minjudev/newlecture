package ex07.���;

/*
 * 
 * ���: �����޴� < *�ɷ�/����� �����޴�*
 * ��ӿ��� �� ������ ����
 * 1. Has A ���: � Ŭ������ �ٸ� ��ü�� ��� �Լ��� ������ �ִ� ��, �׷��� this�� �̿��� �ش� ��ü�� ����� �� �ִ�
 * 	- Composition Has A ���: ��ü��
 *	- Association Has A ���: �и���
 * 
 *     A ��ü B ��ü�� Composition���� Has �ϰ� ����.
 *     class A {
 *         private B b;
 *   
 *         public A() { // A ��ü�� ������ �� B ��ü�� �Բ� �����ǰ� �ϱ�
 *           b = new B();
 *         }
 *     }
 * 
 * 2. Is A ���
 *  
 */


public class Program {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();
		lotto.gen();
		
		// �Լ�����
		// LottoConsole�� lotto�� ����ϴ� ��ü�� �ƴ� print �Լ��� �����ϴ� ��Ÿ�� ����
		// LottoConsole.print(lotto); // LottoConsole�� ��ü�� �ƴ�, new ������ ����ؼ� ��üȭ�� �Ǿ���� ��ü��� �� �� ����
		
		// ��ü����
		// lotto�� �̿��ؼ� ����� ����ϴ� ��ü
		// lotto�� ����ϴ� �����ڿ� �߽��� �ּ� ��� ��� ��ü�� ����
		// ���� �߽������� �ٶ󺸴� ���� ��ü�����̴�.
		LottoConsole console = new LottoConsole(lotto); // new LottoConsole: ������(=��ü)
														// �� lotto��� ���ڸ� �Ѱ� �޾�����?
														// lotto��� ���� ����ؾ��ϴϱ� lotto�� ���ڷ� �Ѱ� �޾���
//		LottoConsole console = new LottoConsole(); // ��ü������ ��� �� �ش� �ڵ� ���
		console.print();
				   
	}

}
