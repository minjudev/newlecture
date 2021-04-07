package ex08.�߻�ȭ.����;

import java.util.Scanner;

public class ExamConsole {
	
	// ExamConsole�� �ڽĵ��� Exam�� ����� �� �ְ� �������
	// �پ��� ������ Exam�� �����ϰ� �ϱ� ���ؼ��� �ڷ����� �θ� ��ü�� Exam���� ���ֱ�
	private Exam exam;
//	private PrintListener printListener;
	
	// ���⼭ �⺻ �����ڸ� �־���� �Ǹ� null�� ������ exam���� ���α׷����� �� �� �ְ� ��
	// �⺻ �����ڸ� ���־� ����ڰ� ��ü ���� �� ������ exam�� �ֵ��� ������ �� �ְ� ��	
	public ExamConsole() {

	}
	
	// console�� exam ���� �ǹ̰� ���� ������ �������� ���� exam�� �ȾƳ��� �� �ְ� �ϱ�
	public ExamConsole(Exam exam) {
		this.exam = exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	// �ڽ� Ŭ���������� Exam Ŭ������ ������ ���⸦ ����(protected)
	protected Exam getExam() {
		return exam;
	}
		
//	public void setPrintListener(PrintListener printListener) {
//		this.printListener = printListener;
//	}
	
	// �ڽ� Ŭ�������� �����Ͱ� Ȯ��� ���� �������� �ذ��ϱ� ���� �Լ�
	protected void onPrint() {
		
	}

	// print�� ����� �θ� ��ü�� exam�� �������� �ʰ� �ڽ� ��ü�� ������ ���� �޶��� �ʿ䰡 ������ ����
	public void print() {
		System.out.println("----------------------------------");
		System.out.println("              ���� ���             ");
		System.out.println("----------------------------------");
		System.out.printf("kor: %d\n", exam.getKor());
		System.out.printf("eng: %d\n", exam.getEng());
		System.out.printf("math: %d\n", exam.getMath());
//		if(printListener != null)
//			printListener.onPrint();
		// Ȯ��� �ٸ� ������ ��µ� �� ������ ���ڴ� -> ������ ���̿� ���� �� �ְ� ����� ����� ����
		// �Ʒ� �Լ��� �ٸ� ��ü�� �����ϰ� �ϱ�, �������� �������� �� �ִٸ� ExamConsole�� ��� ������ �� ����
		// onPrint�� �������̵��� �� �ְ� �ؼ� print��� �Լ��� ����� �� �ְ� ��
		onPrint();
		System.out.printf("total: %d\n", exam.total());
		System.out.printf("avg: %f\n", exam.avg());
	}
	
	// input �Լ��� �ڽ� Ŭ�������� �״�� ��� ����
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		int kor;
		int eng;
		int math;
		
		System.out.print("kor: ");
		kor = Integer.parseInt(scan.nextLine());
		System.out.print("eng: ");
		eng = Integer.parseInt(scan.nextLine());
		System.out.print("math: ");
		math = Integer.parseInt(scan.nextLine());
		
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
	}

}
