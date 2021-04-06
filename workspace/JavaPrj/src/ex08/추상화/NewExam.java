package ex08.추상화;

public class NewExam extends Exam/* 기존 Exam을 틀로 가져다 쓰기 */ {

	// 컴퓨터 과목 추가
	private int com;
	
	public NewExam() { 
		// 초기값 세팅
		this(1, 1, 1, 1); 
	}
	
	// 오버로드 생성자
	public NewExam(int kor, int eng, int math, int com) {
		super(kor, eng, math); // 부모 객체의 오버로드 생성자로 인자 넘겨주기
		this.com = com;
	}

	
	// Override해서 수정해서 사용하기
	@Override
	public int total() {
		return super.total() + com; 
	}
	                               
	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
