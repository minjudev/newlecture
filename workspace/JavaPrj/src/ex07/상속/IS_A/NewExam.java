package ex07.���.IS_A;

public class NewExam extends Exam/* ���� Exam�� Ʋ�� ������ ���� */ {

	// ��ǻ�� ���� �߰�
	private int com;
	
	public NewExam() { 
//		super(); // �ڽ� ��ü(NewExam) ���� �� �θ� ��ü(Exam)�� �����ڰ� �ڵ����� ȣ��Ǿ� �θ� ��ü�� �Բ� �����ȴ�.
//		super(1, 1, 1); // �θ��� �����ε� ������ ȣ��
		
		// �ʱⰪ ����
		this(1, 1, 1, 1); // �ڵ尡 �ߺ��� �����ڸ� �̷��� �ذ�, �����ε�� �����ڸ� ��ȣ��
						  // this(1,1,1,1)�̶� this()���� ����Ű�� this�� ��� Program.java�� 48��°�� NewExam�ε� 
						  // this(1,1,1,1)�� ���� ���� �����ε� �����ڰ� ȣ��ǰ� this()�� ���� ���� �⺻ �����ڰ� ȣ��Ǵ� ����
//		com = 10;
	}
	
	// �ڽ� ��ü������ �����ε� ������ ��� ����
	public NewExam(int kor, int eng, int math, int com) {
//		super(); 
		super(kor, eng, math); // �θ� ��ü�� �����ε� �����ڷ� ���� �Ѱ��ֱ�
		this.com = com;
	}

	
	// Override�ؼ� �����ؼ� ����ϱ�
	@Override
	public int total() {
		return super.total() + com; // super�� �����ϰ� �Ǹ� super ��� this�� �ٰ� ��
									// ���� ��ü(NewExam)�� ������ �ִ� total()�� ��� ȣ��(��� ȣ��)�ؼ� ���� ������ ������ ��
									// ��쿡 ���� �θ� ������ �ִ� ���� ȣ���� ���� super�� �� ����ؾ���
	}
	                               
	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
