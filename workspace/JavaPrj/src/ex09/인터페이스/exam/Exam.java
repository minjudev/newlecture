package ex09.인터페이스.exam;

// NewExam에서 binary로 된 Exam 클래스 코드를 추상화 클래스로 사용하기
public abstract class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// 기본 생성자
	public Exam() {
		this(10, 10, 10); 
	}
	
	// 오버로드 생성자
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

//	public int total(int ext) {
//		return this.kor + eng + math;
//	}
	
	// 기본 baseTotal 함수를 준비한 상태에서 아래에 또 추상화한 total 함수를 만들어서 자식들이 사용할 수 있게 하기
	// 이 함수는 자식에게 제공할 목적이지 다른 객체에게 제공할 목적이 X -> but, public 이면 다른 객체도 사용 가능해짐
	// 해결 방법: protected(다른 패키지에서만 보호됨)
	protected int baseTotal() {
		return this.kor + eng + math;
	}
	
	// 이 코드를 너희 상황에 맞게 바꿔서 사용해라(abstract)
	// 고쳐 사용하는 또 다른 방법: Interface
	public abstract int total();
	
	// Exam으로 exam을 참조해서 avg()를 사용할 수 있게 하려면 Exam 클래스에도 avg()가 정의되어있어야 함
	// 부모 클래스에서 함수 구현이 필요하지 않지만, 일괄처리할 수 있게 부모 클래스에 존재해야 하는 함수는 abstract 키워드 사용해 정의하기
	// 내가 함수 코드를 구현하지 않았지만, 내가 상속하고 있는 자식 클래스들이 반드시 avg를 구현할 것이다라는 의미
	// abstract가 들어간 함수가 있으면 class에도 abstract 키워드가 있어야 함
	public abstract float avg();

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
}
