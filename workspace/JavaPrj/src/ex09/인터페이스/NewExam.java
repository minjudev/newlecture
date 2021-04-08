package ex09.�������̽�;

import ex09.�������̽�.exam.Exam;

public class NewExam extends Exam/* ���� Exam�� Ʋ�� ������ ���� */ {

	// ��ǻ�� ���� �߰�
	private int com;
	
	public NewExam() { 
		// �ʱⰪ ����
		this(1, 1, 1, 1);
	}
	
	// �ڽ� ��ü������ �����ε� ������ ��� ����
	public NewExam(int kor, int eng, int math, int com) {
		super(kor, eng, math); // �θ� ��ü�� �����ε� �����ڷ� ���� �Ѱ��ֱ�
		this.com = com;
	}

	
	// Override�ؼ� �����ؼ� ����ϱ�
	@Override
	public int total() {
		return baseTotal() + com; // �θ� class���� protected�� �Լ�, �ڽ� Ŭ�������� ��� ����
	}
	                               
	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
