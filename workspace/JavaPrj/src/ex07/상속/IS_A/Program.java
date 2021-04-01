package ex07.상속.IS_A;


/*
 * 
 * 상속: 물려받다 < *능력/기능을 제공받다*
 * 상속에는 두 가지가 있음
 * 1. Has A 상속: 어떤 클래스가 다른 객체를 멤버 함수로 가지고 있는 것, 그래서 this를 이용해 해당 객체를 사용할 수 있다
 * 	- Composition Has A 상속: 일체형
 *	- Association Has A 상속: 분리형
 * 
 *     A 객체 B 객체를 Composition으로 Has 하게 하자.
 *     class A {
 *         private B b;
 *   
 *         public A() { // A 객체를 생성할 때 B 객체도 함께 생성되게 하기
 *           b = new B();
 *         }
 *     }
 *	
 *	Has A 상속으로 Lotto와 LottoConsole을 결합
 *
 *  2. Is A 상속
 *	다음 버전을 만들 때 Lotto를 그대로 쓰기에 문제가 있는 경우 -> 새로 만들기 
 *		아예 Lotto를 새로 만드는 것 가능(새로 만들기)
 *		Lotto를 수정 없이 그대로 가져와 쓰면서 고쳐 쓰는 것 가능(새로 만드는데 기존 것을 가져옴)
 *	결합: 1. 기능을 담당하는 일부 구성으로서 결합
 *		 2. 부품 관계가 아닌 기존 로또를 틀로 해서, 기반으로 해서 고쳐씀
 *			(새로운 엔진을 만드는데 기존 엔진을 가져와서 고쳐씀)
 *			(틀로써 상속: 동일한 객체를 이용, 동일한 객체를 상속받음)
 *          (동일한 부품을 만드는데, 기존의 부품이 쓸모가 있다면 기존 부품을 가져다 쓰는 것)
 * 
 *  
 */


public class Program {

	public static void main(String[] args) {

//		Lotto2 lotto = new Lotto2();
//		lotto.gen();
		
		// Exam 객체를 직접 사용하지 않고 NewExam에서 부모의 오버로드 생성자를 호출해 Exam 객체에 인자를 넘겨줄 수 있음
//		Exam e1 = new Exam(10, 20, 30);
		
		// 성적 데이터
		NewExam exam = new NewExam(); 
//		NewExam exam = new NewExam(1, 1, 1, 1); // 이렇게 하면 인자가 총 5개 넘겨짐: 1, 1, 1, 1과 NewExam 객체
		int total = exam.total(); 
		float avg = exam.avg();
		
		System.out.printf("total: %d, avg: %f\n", total, avg);
		
		// Frame을 Is A 상속하기
		MyFrame win = new MyFrame();
		win.setVisible(true);
		
	}

}
