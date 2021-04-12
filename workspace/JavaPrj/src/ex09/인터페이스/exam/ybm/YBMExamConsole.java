package ex09.�������̽�.exam.ybm;

import java.util.Scanner;

import ex09.�������̽�.exam.Banner;
import ex09.�������̽�.exam.ExamConsole;

// ���� ����� ������(is a ��� + �������̽� ����): �θ� Ŭ������ �޼ҵ带 �������̵��ϰ� ��
public class YBMExamConsole extends ExamConsole /*implements Banner*/ {
	
	private int a;
	
	public YBMExamConsole() {
//		class XXX implements Banner {
//			private int a;
//			
//			public XXX() {
//				a = 4;
//			}
//			
//			@Override
//			public void print() {
//				// YBMExamConsole�� ��������� ��� ����
//				// a = 3;
//			
//				System.out.println("----------------------------------");
//				System.out.println("            YBM ���� ���           ");
//				System.out.println("----------------------------------");
//				System.out.println(this.a); // 4�� ���
//				
//				// �ƿ��� Ŭ������ a ���� ����ϰ� ���� ����?
//				System.out.println(YBMExamConsole.this.a); // 3�� ���
//			}
//			
//			@Override
//			public void printEnd() {
//				System.out.println("----------------------------------");		
//			}
//		}
//		
		
		// ��ø�� Ŭ������ ������ �� new �տ� this�� �����Ǿ��ִٴ� ���� �����ϰ� �ֱ�
		// �������� Ŭ������ �����ϴ� �Ͱ� ����� ���������, ��ø Ŭ������ �����ϰ� �ִٴ� �� �����ϱ�
//		/*YBMExamConsole.*/XXX x = /*this.*/new XXX();	
		
		// �������̽��� �����ϴ� ���� �����̸� Ŭ�������� ������ ���ڴ� �ǵ����� anonymous class�� ����
		// ������ x��� Ŭ������ ����� �Ͱ� �޸� Ŭ�������� �ŷ����� ����
//		/*this.*/setBanner(x);

		// �������̽��� �����ϴ� ���� �����̸� Ŭ������ ���� �������� ���� �޼ҵ� �ȿ��� Ŭ������ ��������
		// �޼ҵ� �ȿ��� ���ǵ� Ŭ���� - �ٸ� �������� ���� �� �� ����
		// �� �޼ҵ�(YBMExamConsole ������)�� ȣ���� �� Ŭ������ �� ���� ���Ǿ��ٰ� ������ �ϱ�
		
		// �̷��� �� �Ÿ� Ŭ������ ��ü�� ���ִ� �� ��� -> �͸� Ŭ���� ����
		// �������̽��� �ڵ带 �����ϴ� �۾��� �ϸ鼭 new �ϰ� �ϱ�
		// �������̽��� ������ ������ ������ Ŭ������ new �ϰ� �ؼ�, �װ� �Ʒ� setBanner()���� ������ �� �ְ� ��
		Banner banner = new Banner() {
				
			@Override
			public void print() {
				a = 3;
				System.out.println("----------------------------------");
				System.out.println("            YBM ���� ���           ");
				System.out.println("----------------------------------");
				
				// �ƿ��� Ŭ������ a ���� ����ϰ� ���� ����?
				System.out.println(YBMExamConsole.this.a); // 3�� ���
			}
			
			@Override
			public void printEnd() {
				System.out.println("----------------------------------");		
			}
			
		};
		
		setBanner(banner);
	}
	
	@Override
	protected void onPrint() {
		// YBMExam�� Exam���� �����ϸ� �Ʒ��� YBMExam ���� getToeic, getAa �Լ� ��� �Ұ���
		// �׷��� ���������� ������ �ٲ㼭 ���� ����
		// �θ�(Exam)�� �ڽ�(YBMExam)���� �ɶ��� ���� ����ȯ�������
		// ExamConsole�� �ڽ� ��ü�� YBMExamConsole�� ExamConsole�� has a �ϰ� �ִ� Exam exam�� ������� ���ϹǷ� getter �̿��� ���
		YBMExam exam = (YBMExam)getExam(); 
		
		System.out.printf("toeic: %d\n", exam.getToeic());
		System.out.printf("aa: %d\n", exam.getAa());
	}
	
	@Override
	public void input() {
		super.input();
		Scanner scan = new Scanner(System.in);
		
		int toeic;
		int aa;
		
		System.out.print("toeic: ");
		toeic = Integer.parseInt(scan.nextLine());
		System.out.print("aa: ");
		aa = Integer.parseInt(scan.nextLine());
		
		YBMExam exam = (YBMExam)getExam();
		exam.setToeic(toeic);
		exam.setAa(aa);
	}

	// Banner�� ����� �����Ϸ� ������ ExamConsole�� print�� �������ϰ� ��
	// �ذ� ���: nested class
//	public class XXX implements Banner {
//		private int a;
//		
//		public XXX() {
//			a = 4;
//		}
//		
//		@Override
//		public void print() {
//			// YBMExamConsole�� ��������� ��� ����
//			// a = 3;
//		
//			System.out.println("----------------------------------");
//			System.out.println("            YBM ���� ���           ");
//			System.out.println("----------------------------------");
//			System.out.println(this.a); // 4�� ���
//			
//			// �ƿ��� Ŭ������ a ���� ����ϰ� ���� ����?
//			System.out.println(YBMExamConsole.this.a); // 3�� ���
//		}
//		
//		@Override
//		public void printEnd() {
//			System.out.println("----------------------------------");		
//		}
//	}
	
}
