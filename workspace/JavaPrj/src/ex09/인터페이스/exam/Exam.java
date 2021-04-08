package ex09.�������̽�.exam;

// NewExam���� binary�� �� Exam Ŭ���� �ڵ带 �߻�ȭ Ŭ������ ����ϱ�
public abstract class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// �⺻ ������
	public Exam() {
		this(10, 10, 10); 
	}
	
	// �����ε� ������
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

//	public int total(int ext) {
//		return this.kor + eng + math;
//	}
	
	// �⺻ baseTotal �Լ��� �غ��� ���¿��� �Ʒ��� �� �߻�ȭ�� total �Լ��� ���� �ڽĵ��� ����� �� �ְ� �ϱ�
	// �� �Լ��� �ڽĿ��� ������ �������� �ٸ� ��ü���� ������ ������ X -> but, public �̸� �ٸ� ��ü�� ��� ��������
	// �ذ� ���: protected(�ٸ� ��Ű�������� ��ȣ��)
	protected int baseTotal() {
		return this.kor + eng + math;
	}
	
	// �� �ڵ带 ���� ��Ȳ�� �°� �ٲ㼭 ����ض�(abstract)
	// ���� ����ϴ� �� �ٸ� ���: Interface
	public abstract int total();
	
	// Exam���� exam�� �����ؼ� avg()�� ����� �� �ְ� �Ϸ��� Exam Ŭ�������� avg()�� ���ǵǾ��־�� ��
	// �θ� Ŭ�������� �Լ� ������ �ʿ����� ������, �ϰ�ó���� �� �ְ� �θ� Ŭ������ �����ؾ� �ϴ� �Լ��� abstract Ű���� ����� �����ϱ�
	// ���� �Լ� �ڵ带 �������� �ʾ�����, ���� ����ϰ� �ִ� �ڽ� Ŭ�������� �ݵ�� avg�� ������ ���̴ٶ�� �ǹ�
	// abstract�� �� �Լ��� ������ class���� abstract Ű���尡 �־�� ��
	public abstract float avg();

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
}
