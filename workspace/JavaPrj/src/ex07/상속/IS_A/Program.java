package ex07.���.IS_A;


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
 *	Has A ������� Lotto�� LottoConsole�� ����
 *
 *  2. Is A ���
 *	���� ������ ���� �� Lotto�� �״�� ���⿡ ������ �ִ� ��� -> ���� ����� 
 *		�ƿ� Lotto�� ���� ����� �� ����(���� �����)
 *		Lotto�� ���� ���� �״�� ������ ���鼭 ���� ���� �� ����(���� ����µ� ���� ���� ������)
 *	����: 1. ����� ����ϴ� �Ϻ� �������μ� ����
 *		 2. ��ǰ ���谡 �ƴ� ���� �ζǸ� Ʋ�� �ؼ�, ������� �ؼ� ���ľ�
 *			(���ο� ������ ����µ� ���� ������ �����ͼ� ���ľ�)
 *			(Ʋ�ν� ���: ������ ��ü�� �̿�, ������ ��ü�� ��ӹ���)
 *          (������ ��ǰ�� ����µ�, ������ ��ǰ�� ���� �ִٸ� ���� ��ǰ�� ������ ���� ��)
 * 
 *  
 */


public class Program {

	public static void main(String[] args) {

//		Lotto2 lotto = new Lotto2();
//		lotto.gen();
		
		// Exam ��ü�� ���� ������� �ʰ� NewExam���� �θ��� �����ε� �����ڸ� ȣ���� Exam ��ü�� ���ڸ� �Ѱ��� �� ����
//		Exam e1 = new Exam(10, 20, 30);
		
		// ���� ������
		NewExam exam = new NewExam(); 
//		NewExam exam = new NewExam(1, 1, 1, 1); // �̷��� �ϸ� ���ڰ� �� 5�� �Ѱ���: 1, 1, 1, 1�� NewExam ��ü
		int total = exam.total(); 
		float avg = exam.avg();
		
		System.out.printf("total: %d, avg: %f\n", total, avg);
		
		// Frame�� Is A ����ϱ�
		MyFrame win = new MyFrame();
		win.setVisible(true);
		
	}

}
