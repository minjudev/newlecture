package ex07.상속.IS_A;

public class NewExam extends Exam/* 기존 Exam을 틀로 가져다 쓰기 */ {

	// 컴퓨터 과목 추가
	private int com;
	
	public NewExam() { 
//		super(); // 자식 객체(NewExam) 생성 시 부모 객체(Exam)의 생성자가 자동으로 호출되어 부모 객체도 함께 생성된다.
//		super(1, 1, 1); // 부모의 오버로드 생성자 호출
		
		// 초기값 세팅
		this(1, 1, 1, 1); // 코드가 중복된 생성자를 이렇게 해결, 오버로드된 생성자를 재호출
						  // this(1,1,1,1)이랑 this()에서 가리키는 this는 모두 Program.java의 48번째줄 NewExam인데 
						  // this(1,1,1,1)을 했을 때는 오버로드 생성자가 호출되고 this()를 했을 때는 기본 생성자가 호출되는 것임
//		com = 10;
	}
	
	// 자식 객체에서도 오버로드 생성자 사용 가능
	public NewExam(int kor, int eng, int math, int com) {
//		super(); 
		super(kor, eng, math); // 부모 객체의 오버로드 생성자로 인자 넘겨주기
		this.com = com;
	}

	
	// Override해서 수정해서 사용하기
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
