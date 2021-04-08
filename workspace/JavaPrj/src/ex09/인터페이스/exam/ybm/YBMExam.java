package ex09.인터페이스.exam.ybm;

import ex09.인터페이스.exam.Banner;
import ex09.인터페이스.exam.Exam;

// 공통분모(kor, eng, math)를 Exam으로 뺐다고 가정
// 추상 클래스인 Exam은 객체화되어서는 안된다는 전제
// 자바에서는 특정 클래스에서 하나의 클래스만 상속 가능하고, 여러 인터페이스 구현 가능
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
