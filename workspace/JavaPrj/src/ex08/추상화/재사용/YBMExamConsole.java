package ex08.�߻�ȭ.����;

import java.util.Scanner;

public class YBMExamConsole extends ExamConsole {
	
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

}
