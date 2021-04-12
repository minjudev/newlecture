package ex09.인터페이스.exam.ybm;

import java.util.Scanner;

import ex09.인터페이스.exam.Banner;
import ex09.인터페이스.exam.ExamConsole;

// 다중 상속의 문제점(is a 상속 + 인터페이스 구현): 부모 클래스의 메소드를 오버라이드하게 됨
public class YBMExamConsole extends ExamConsole /*implements Banner*/ {
	
	private int a;
	
	public YBMExamConsole() {
//		class XXX implements Banner {
//			private int a;
//			
//			public XXX() {
//				a = 4;
//			}
//			
//			@Override
//			public void print() {
//				// YBMExamConsole의 멤버변수를 사용 가능
//				// a = 3;
//			
//				System.out.println("----------------------------------");
//				System.out.println("            YBM 성적 출력           ");
//				System.out.println("----------------------------------");
//				System.out.println(this.a); // 4가 출력
//				
//				// 아우터 클래스의 a 값을 사용하고 싶을 때는?
//				System.out.println(YBMExamConsole.this.a); // 3이 출력
//			}
//			
//			@Override
//			public void printEnd() {
//				System.out.println("----------------------------------");		
//			}
//		}
//		
		
		// 중첩된 클래스를 정의할 때 new 앞에 this가 생략되어있다는 것을 인지하고 있기
		// 독립적인 클래스를 생성하는 것과 모양은 비슷하지만, 중첩 클래스를 생성하고 있다는 것 인지하기
//		/*YBMExamConsole.*/XXX x = /*this.*/new XXX();	
		
		// 인터페이스를 구현하는 것이 목적이면 클래스명을 정하지 말자는 의도에서 anonymous class가 나옴
		// 위에서 x라는 클래스를 만드는 것과 달리 클래스명을 거론하지 말자
//		/*this.*/setBanner(x);

		// 인터페이스를 구현하는 것이 목적이면 클래스를 따로 정의하지 말고 메소드 안에서 클래스를 정의하자
		// 메소드 안에서 정의된 클래스 - 다른 곳에서는 절대 볼 수 없음
		// 위 메소드(YBMExamConsole 생성자)를 호출할 때 클래스가 한 번만 사용되었다가 끝나게 하기
		
		// 이렇게 할 거면 클래스명 자체를 없애는 게 어떨까 -> 익명 클래스 등장
		// 인터페이스가 코드를 구현하는 작업을 하면서 new 하게 하기
		// 인터페이스를 실제로 구현한 무명의 클래스를 new 하게 해서, 그걸 아래 setBanner()에서 세팅할 수 있게 됨
		Banner banner = new Banner() {
				
			@Override
			public void print() {
				a = 3;
				System.out.println("----------------------------------");
				System.out.println("            YBM 성적 출력           ");
				System.out.println("----------------------------------");
				
				// 아우터 클래스의 a 값을 사용하고 싶을 때는?
				System.out.println(YBMExamConsole.this.a); // 3이 출력
			}
			
			@Override
			public void printEnd() {
				System.out.println("----------------------------------");		
			}
			
		};
		
		setBanner(banner);
	}
	
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

	// Banner의 기능을 구현하려 했으나 ExamConsole의 print를 재정의하게 됨
	// 해결 방법: nested class
//	public class XXX implements Banner {
//		private int a;
//		
//		public XXX() {
//			a = 4;
//		}
//		
//		@Override
//		public void print() {
//			// YBMExamConsole의 멤버변수를 사용 가능
//			// a = 3;
//		
//			System.out.println("----------------------------------");
//			System.out.println("            YBM 성적 출력           ");
//			System.out.println("----------------------------------");
//			System.out.println(this.a); // 4가 출력
//			
//			// 아우터 클래스의 a 값을 사용하고 싶을 때는?
//			System.out.println(YBMExamConsole.this.a); // 3이 출력
//		}
//		
//		@Override
//		public void printEnd() {
//			System.out.println("----------------------------------");		
//		}
//	}
	
}
