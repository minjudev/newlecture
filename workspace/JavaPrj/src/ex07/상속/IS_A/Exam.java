package ex07.���.IS_A;

public class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// �����ڴ� �Լ��� Ư¡�� �����Ƿ� ���ڸ� ���� �� �־, �⺻���� �ƴ� ���� ���ϴ� ������ ���� ����
	public Exam() {
		// �⺻ ��
		kor = 10;
		eng = 10;
		math = 10;
	}
	
	public int total() {
		return this.kor + eng + math;
	}
	
	public float avg() {
		return total() / 3.0f;
	}
	
}
