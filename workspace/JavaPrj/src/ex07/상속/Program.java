package ex07.상속;

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
 * 2. Is A 상속
 *  
 */


public class Program {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();
		lotto.gen();
		
		// 함수지향
		// LottoConsole이 lotto를 출력하는 객체가 아닌 print 함수가 존재하는 울타리 역할
		// LottoConsole.print(lotto); // LottoConsole은 개체가 아님, new 연산을 사용해서 객체화가 되어야지 개체라고 할 수 있음
		
		// 객체지향
		// lotto를 이용해서 출력을 담당하는 객체
		// lotto를 출력하는 역할자에 중심을 둬서 출력 담당 객체를 만듦
		// 역할 중심적으로 바라보는 것이 객체지향이다.
		LottoConsole console = new LottoConsole(lotto); // new LottoConsole: 역할자(=객체)
														// 왜 lotto라는 인자를 넘겨 받아주지?
														// lotto라는 것을 출력해야하니까 lotto를 인자로 넘겨 받아줌
//		LottoConsole console = new LottoConsole(); // 일체형으로 상속 시 해당 코드 사용
		console.print();
				   
	}

}
