package ex09.인터페이스.exam.ybm;

import java.util.Scanner;

import ex09.인터페이스.exam.Banner;
import ex09.인터페이스.exam.ExamConsole;

public class YBMExamConsole extends ExamConsole implements Banner {
	
	@Override
	protected void onPrint() {
		// YBMExam을 Exam으로 참조하면 아래의 YBMExam 내의 getToeic, getAa 함수 사용 불가능
		// 그래서 참조변수의 형식을 바꿔서 받은 것임
		// 부모(Exam)가 자식(YBMExam)형이 될때는 직접 형변환해줘야함
		// ExamConsole의 자식 객체인 YBMExamConsole이 ExamConsole이 has a 하고 있는 Exam exam을 사용하지 못하므로 getter 이용해 사용
		YBMExam exam = (YBMExam)getExam(); 
		
		System.out.printf("toeic: %d\n", exam.getToeic());
		System.out.printf("aa: %d\n", exam.getAa());
	}
	
	@Override
	public void input() {
		super.input();
		Scanner scan = new Scanner(System.in);
		
		int toeic;
		int aa;
		
		System.out.print("toeic: ");
		toeic = Integer.parseInt(scan.nextLine());
		System.out.print("aa: ");
		aa = Integer.parseInt(scan.nextLine());
		
		YBMExam exam = (YBMExam)getExam();
		exam.setToeic(toeic);
		exam.setAa(aa);
	}

	@Override
	public void printStart() {
		System.out.println("----------------------------------");
		System.out.println("            YBM 성적 출력           ");
		System.out.println("----------------------------------");
	}

	@Override
	public void printEnd() {
		System.out.println("----------------------------------");		
	}
	
}
