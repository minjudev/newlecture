package ex08.�߻�ȭ;

// �߻� Ŭ������ ������� �ʰ�, ��üȭ���� �ʰ� �ϱ�: abstract Ű����
public abstract class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// �⺻ ������
	public Exam() {
//		kor = 10; // �ʱⰪ ���ֱ�
//		eng = 10;
//		math = 10;
		
		this(10, 10, 10);
	}
	
	// �����ε� ������
	public Exam(int kor, int eng, int math) {
		// �Ѱܹ��� ������ �ʱ�ȭ
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int total() {
		return this.kor + eng + math;
	}
	
	// total�� �ٽ� ����� �� �ִ� �Լ��̹Ƿ� abstract Ű���� ���X
	// total �Լ��� �߻�ȭ�ؼ� �ڽ� Ŭ�������� �Լ��� �������϶�� �ϰ� ������ �θ� Ŭ�������� �Լ��� ������ ���¿��� abstract�� �� �� ������? X
	// abstract�� ���� ���� ������ �Ʒ��� total() �Լ��� �ڽ� Ŭ���������� ����� �� �ִ� �Լ��̹Ƿ�
	public int total(int ext) {
		return this.kor + eng + math;
	}
	
	// Exam���� exam�� �����ؼ� avg()�� ����� �� �ְ� �Ϸ��� Exam Ŭ�������� avg()�� ���ǵǾ��־�� ��
	// �θ� Ŭ�������� �Լ� ������ �ʿ����� ������, �ϰ�ó���� �� �ְ� �θ� Ŭ������ �����ؾ� �ϴ� �Լ��� abstract Ű���� ����� �����ϱ�
	// ���� �Լ� �ڵ带 �������� �ʾ�����, ���� ����ϰ� �ִ� �ڽ� Ŭ�������� �ݵ�� avg�� ������ ���̴ٶ�� �ǹ�
	public abstract float avg();
	
}
