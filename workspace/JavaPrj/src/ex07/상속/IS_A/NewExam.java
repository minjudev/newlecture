package ex07.���.IS_A;

public class NewExam extends Exam/* ���� Exam�� Ʋ�� ������ ���� */ {

	// ��ǻ�� ���� �߰�
	private int com;
	
	public NewExam() {
		// super(); // �ڽ� ��ü(NewExam) ���� �� �θ� ��ü(Exam)�� �����ڰ� �ڵ����� ȣ��Ǿ� �θ� ��ü�� �Բ� �����ȴ�.
					// �ڵ������� ������ ����Ǵ� �� �³�? O
		com = 10;
	}
	
	// Override�ؼ� �����ؼ� ����ϱ�
	// �θ� Ŭ������ �ҽ��ڵ带 ���� ���Ѵٸ�? Ctrl + space�� �ڵ� ���� ����
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
