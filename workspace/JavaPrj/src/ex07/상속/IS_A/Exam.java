package ex07.상속.IS_A;

public class Exam {

	private int kor;
	private int eng;
	private int math;
	
	
	// 기본 생성자
	public Exam() {
//		kor = 10; // 초기값 없애기
//		eng = 10;
//		math = 10;
		
		// 기본 생성자와 오버로드 생성자 코드의 중복 발생
		// 기본 생성자가 오버로드 생성자를 호출하게 하기
		this(10, 10, 10); // 이 때 인자의 개수가 3개를 만족하는 this인, Exam 오버로드 생성자 호출
		// this(); // 이렇게 하면 기본 생성자의 Exam 객체가 계속 호출됨
	}
	
	// 생성자는 함수의 특징을 가지므로 인자를 가질 수 있어서, 기본값이 아닌 내가 원하는 값으로 세팅 가능
	// 기본 생성자는 내부적으로 정의된 값으로 초기화, 아래 생성자는 사용자가 정의한 값으로 초기화
	// 생성자는 꼭 필요한 함수는 아님(생성자를 지워도 오류X)
	// 오류가 발생하지 않은 이유는 컴파일러가 개입해서 기본 생성자를 만들어주기 때문
	// But, 오버로드 생성자를 만든 경우 -> 오버로드 생성자를 가지고 있기 때문에 컴파일러가 기본 생성자를 만들어주지 않음
	// 기본 생성자가 필요할 경우: 오버로드 생성자와 함께 기본 생성자도 같이 만들어줘야 함
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
	
	// 인자를 추가로 가지고 있는 함수가 오버로드 함수(인자가 확장됨)
	public int total(int ext) {
		return this.kor + eng + math;
	}
	
	public float avg() {
		return total() / 3.0f;
	}
	
}
