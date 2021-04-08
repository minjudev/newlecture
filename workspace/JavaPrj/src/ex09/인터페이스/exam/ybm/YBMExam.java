package ex09.�������̽�.exam.ybm;

import ex09.�������̽�.exam.Banner;
import ex09.�������̽�.exam.Exam;

// ����и�(kor, eng, math)�� Exam���� ���ٰ� ����
// �߻� Ŭ������ Exam�� ��üȭ�Ǿ�� �ȵȴٴ� ����
// �ڹٿ����� Ư�� Ŭ�������� �ϳ��� Ŭ������ ��� �����ϰ�, ���� �������̽� ���� ����
public class YBMExam extends Exam {
	
	private int toeic;
	private int aa;
	
	public YBMExam() {
		
	}
	
	public YBMExam(int kor, int eng, int math, int toeic, int aa) {
		super(kor, eng, math);
		this.toeic = toeic;
		this.aa = aa;
	}
	
	@Override
	public int total() {
		return baseTotal() + toeic + aa;
	}
	
	@Override
	public float avg() {
		return total() / 5.0f;
	}
	
	public int getToeic() {
		return toeic;
	}

	public void setToeic(int toeic) {
		this.toeic = toeic;
	}

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

}
