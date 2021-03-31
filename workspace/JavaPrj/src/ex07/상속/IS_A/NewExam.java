package ex07.상속.IS_A;

public class NewExam extends Exam/* 기존 Exam을 틀로 가져다 쓰기 */ {

	// 컴퓨터 과목 추가
	private int com;
	
	public NewExam() {
		// super(); // 자식 객체(NewExam) 생성 시 부모 객체(Exam)의 생성자가 자동으로 호출되어 부모 객체도 함께 생성된다.
					// 자동적으로 윗줄이 실행되는 거 맞나? O
		com = 10;
	}
	
	// Override해서 수정해서 사용하기
	// 부모 클래스의 소스코드를 알지 못한다면? Ctrl + space로 자동 생성 가능
	@Override
	public int total() {
		return super.total() + com; // super를 생략하게 되면 super 대신 this가 붙게 됨
									// 현재 객체(NewExam)가 가지고 있는 total()을 계속 호출(재귀 호출)해서 무한 루프에 빠지게 됨
									// 경우에 따라 부모가 가지고 있는 것을 호출할 때는 super를 꼭 명시해야함
	}
	                               
	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
