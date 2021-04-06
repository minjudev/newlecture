package ex08.추상화;

public class Program {

	public static void main(String[] args) {
		
		// 공통분모: 도형
		// 네모, 세모, 원, 선을 그려보자
		// 네모, 세모, 원, 선에서 공통분모인 도형을 뽑아냄 -> 추상 클래스 실체화하면 X
		
		// 공통분모: 성적 프로그램
		// 뉴렉 고등학교, YBM 고등학교 성적 프로그램
		// 처음 만든 성적 프로그램을 공통화해서 다른 어떤 고등학교 성적 프로그램이 와도 그에 맞는 프로그램을 만들게 하기 -> 추상 클래스 실체화해도 O
		// 다음 성적 프로그램을 만들려고 할 때 상속이 많아지는 문제점 발생
		
		// 추상화로 만들어진 클래스의 특징
		// 1. 추상 클래스는 뼈대이므로 절대로 실체화되어서는 안됨 -> 공통분모만 가지는 완성형 상태가 아닌 캡슐은 객체화할 생각이 없으므로
		// 2. 추상 클래스는 뼈대이므로 반드시 재정의해야 하는 메소드가 있음
		// -> 두 가지 제약사항을 abstract 키워드를 사용해 해결 가능
		
//		Exam exam = new YBMExam(1,1,1,1);
//		System.out.println(exam.avg());
		
		// 참조형식을 부모 자료형으로 두면 avg() 함수를 일괄 처리 가능
		Exam[] exams = new Exam[2];
		
		exams[0] = new YBMExam(1,1,1,1);
		exams[1] = new NewExam(2,2,2,2);
		
		for(int i=0; i<2; i++)
			// avg() 함수 일괄 처리 가능
			System.out.println(exams[i].avg());
				
	}

}
