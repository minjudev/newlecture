package ex08.추상화.재사용;

import java.util.Scanner;

public class ExamConsole {
	
	// ExamConsole의 자식들이 Exam을 사용할 수 있게 해줘야함
	// 다양한 종류의 Exam을 참조하게 하기 위해서는 자료형을 부모 객체인 Exam으로 해주기
	private Exam exam;
//	private PrintListener printListener;
	
	// 여기서 기본 생성자를 넣어놓게 되면 null인 상태의 exam으로 프로그래밍을 할 수 있게 됨
	// 기본 생성자를 없애야 사용자가 객체 생성 시 무조건 exam을 넣도록 강요할 수 있게 됨	
	public ExamConsole() {

	}
	
	// console은 exam 없이 의미가 없기 때문에 생성하자 마자 exam을 꽂아넣을 수 있게 하기
	public ExamConsole(Exam exam) {
		this.exam = exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	// 자식 클래스에서만 Exam 클래스를 가져다 쓰기를 원함(protected)
	protected Exam getExam() {
		return exam;
	}
		
//	public void setPrintListener(PrintListener printListener) {
//		this.printListener = printListener;
//	}
	
	// 자식 클래스에서 데이터가 확장될 때의 문제점을 해결하기 위한 함수
	protected void onPrint() {
		
	}

	// print의 기능이 부모 객체인 exam에 한정되지 않고 자식 객체의 종류에 따라 달라질 필요가 있음을 느낌
	public void print() {
		System.out.println("----------------------------------");
		System.out.println("              성적 출력             ");
		System.out.println("----------------------------------");
		System.out.printf("kor: %d\n", exam.getKor());
		System.out.printf("eng: %d\n", exam.getEng());
		System.out.printf("math: %d\n", exam.getMath());
//		if(printListener != null)
//			printListener.onPrint();
		// 확장된 다른 과목이 출력될 수 있으면 좋겠다 -> 절차를 사이에 꽂을 수 있게 만드는 방법이 있음
		// 아래 함수를 다른 객체가 구현하게 하기, 누군가가 구현해줄 수 있다면 ExamConsole을 계속 재사용할 수 있음
		// onPrint만 오버라이드할 수 있게 해서 print라는 함수를 사용할 수 있게 함
		onPrint();
		System.out.printf("total: %d\n", exam.total());
		System.out.printf("avg: %f\n", exam.avg());
	}
	
	// input 함수는 자식 클래스에서 그대로 사용 가능
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		int kor;
		int eng;
		int math;
		
		System.out.print("kor: ");
		kor = Integer.parseInt(scan.nextLine());
		System.out.print("eng: ");
		eng = Integer.parseInt(scan.nextLine());
		System.out.print("math: ");
		math = Integer.parseInt(scan.nextLine());
		
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
	}

}
