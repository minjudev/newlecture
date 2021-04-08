package ex09.인터페이스;

import ex09.인터페이스.exam.Exam;

public class NewExam extends Exam/* 기존 Exam을 틀로 가져다 쓰기 */ {

	// 컴퓨터 과목 추가
	private int com;
	
	public NewExam() { 
		// 초기값 세팅
		this(1, 1, 1, 1);
	}
	
	// 자식 객체에서도 오버로드 생성자 사용 가능
	public NewExam(int kor, int eng, int math, int com) {
		super(kor, eng, math); // 부모 객체의 오버로드 생성자로 인자 넘겨주기
		this.com = com;
	}

	
	// Override해서 수정해서 사용하기
	@Override
	public int total() {
		return baseTotal() + com; // 부모 class에서 protected된 함수, 자식 클래스에서 사용 가능
	}
	                               
	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
