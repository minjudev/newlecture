package ex08.추상화;

// 추상 클래스를 사용하지 않게, 실체화하지 않게 하기: abstract 키워드
public abstract class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// 기본 생성자
	public Exam() {
//		kor = 10; // 초기값 없애기
//		eng = 10;
//		math = 10;
		
		this(10, 10, 10);
	}
	
	// 오버로드 생성자
	public Exam(int kor, int eng, int math) {
		// 넘겨받은 값으로 초기화
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int total() {
		return this.kor + eng + math;
	}
	
	// total은 다시 사용할 수 있는 함수이므로 abstract 키워드 사용X
	// total 함수를 추상화해서 자식 클래스에서 함수를 재정의하라고 하고 싶은데 부모 클래스에서 함수를 구현한 상태에서 abstract를 쓸 수 있을까? X
	// abstract를 쓰지 않은 이유는 아래의 total() 함수는 자식 클래스에서도 사용할 수 있는 함수이므로
	public int total(int ext) {
		return this.kor + eng + math;
	}
	
	// Exam으로 exam을 참조해서 avg()를 사용할 수 있게 하려면 Exam 클래스에도 avg()가 정의되어있어야 함
	// 부모 클래스에서 함수 구현이 필요하지 않지만, 일괄처리할 수 있게 부모 클래스에 존재해야 하는 함수는 abstract 키워드 사용해 정의하기
	// 내가 함수 코드를 구현하지 않았지만, 내가 상속하고 있는 자식 클래스들이 반드시 avg를 구현할 것이다라는 의미
	public abstract float avg();
	
}
