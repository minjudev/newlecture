package ex09.인터페이스.exam.ybm;

public class Program {

	public static void main(String[] args) {

		YBMExam exam = new YBMExam();
		YBMExamConsole console = new YBMExamConsole();
		console.setExam(exam);
		
		// import를 하지 않으면 XXX 앞에 아우터 클래스(YBMExamConsole)의 이름을 명시해주어야 함
		// 이너 클래스는 아우터 클래스를 통해서 만들어져야 함
		// 객체가 가지고 있는 new라는 연산자를 사용해서 이너 클래스를 만들자
		// YBMExamConsole.XXX x = console.new XXX();
		
		// setBanner에 꽂아넣게 될 클래스가 아우터 클래스 안에 있는 이너 클래스임
		// console.setBanner(x);
		
		console.input();
		console.print();
	}

}

/*
 * 인터페이스: 사물 또는 공간을 이어주는 접점
 * 자바 인터페이스: 객체와 객체를 이어주는 접점 
 * 
 * 인터페이스를 통해서 정의하고 구현하고 사용하는 절차가 접합이 되면?
 * 다형성이 발생
 * 
 * 일부 절차가 인터페이스로 정의된다?
 * A 클래스가 인터페이스를 정의하였다.
 * 
 * 인터페이스를 구현하는 방법을 4가지로 나누어볼 수 있다.
 * 1. 외부 클래스로 구현
 * 2. 내부 클래스로 구현
 * 3. 메소드 내의 중첩 클래스로 구현
 * 4. 익명 클래스로 구현
 * 5. 람다식을 이용한 구현 
 * 
*/
