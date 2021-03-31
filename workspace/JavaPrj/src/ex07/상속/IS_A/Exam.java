package ex07.상속.IS_A;

public class Exam {

	private int kor;
	private int eng;
	private int math;
	
	// 생성자는 함수의 특징을 가지므로 인자를 가질 수 있어서, 기본값이 아닌 내가 원하는 값으로 세팅 가능
	public Exam() {
		// 기본 값
		kor = 10;
		eng = 10;
		math = 10;
	}
	
	public int total() {
		return this.kor + eng + math;
	}
	
	public float avg() {
		return total() / 3.0f;
	}
	
}
