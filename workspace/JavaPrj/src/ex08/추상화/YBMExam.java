package ex08.추상화;

// 공통분모(kor, eng, math)를 Exam으로 뺐다고 가정
// 추상 클래스인 Exam은 객체화되어서는 안된다는 전제
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
