package ex08.추상화.재사용;

// 공통분모(kor, eng, math)를 Exam으로 뺐다고 가정
// 추상 클래스인 Exam은 객체화되어서는 안된다는 전제
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
