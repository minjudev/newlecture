package ex08.�߻�ȭ;

// ����и�(kor, eng, math)�� Exam���� ���ٰ� ����
// �߻� Ŭ������ Exam�� ��üȭ�Ǿ�� �ȵȴٴ� ����
public class YBMExam extends Exam {
	
	private int toeic;
	
	public YBMExam(int kor, int eng, int math, int toeic) {
		super(kor, eng, math);
		this.toeic = toeic;
	}
	
	@Override
	public int total() {
		return super.total() + toeic;
	}
	
	@Override
	public float avg() {
		return total() / 4.0f;
	}
	
}
