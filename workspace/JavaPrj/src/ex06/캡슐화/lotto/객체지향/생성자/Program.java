package ex06.캡슐화.lotto.객체지향.생성자;

import java.util.Random;

public class Program {
	

	public static void main(String[] args) { // main 함수에는 앞으로 계속 재사용할 함수들만 두기

//		Lotto lotto;	
		// lotto 객체 생성
		Lotto lotto = new Lotto(); // Lotto의 인스턴스(=객체, 실체) 만들기
		
		// lotto 생성 후에 반드시 lotto에 nums 공간을 만들어주는 초기화 작업이 필요
//		lotto.nums = new int[6]; // 캡슐화가 깨지지 않게 nums를 여기서 사용하지 않도록 캡슐 내에서 nums 초기화해주는 함수 만들기
//		Lotto.init(lotto); 
//		lotto.init(); 
	
		// 로또를 만들고
//		lotto = Lotto.gen(lotto); 
		lotto.gen();
		// lotto.gen(); => 로또를 생성한다.(우리가 표현하는 방식으로 코드를 작성하면 도구를 앞세우게 됨)
		// 이제 gen()을 단순히 함수로 볼 것이냐 lotto라는 객체가 제공하는 서비스로 볼 것이냐는 생각을 하게 됨
		// lotto의 기능으로서 gen()을 바라보게 됨 -> 서비스, [메소드(객체의 속성에 접근할 수 있는 역할을 하니까)], 멤버 함수, ...
		// this를 사용하는 함수를 메소드라고 할 것임
		
		// lotto.init(); 이게 여기에 또 호출될 수 있지만 초기화해주는 함수가 처음 초기화 기능 이외에 다른 곳에 또 호출될 수 있게 만들면 안됨
		
		// 로또 출력하기
		LottoConsole.print(lotto); // 출력 함수도 재사용하기 위해 main 함수와 분리
		// lotto.print(); => 로또를 출력한다.

		System.out.println();
		
		// 로또를 정렬하고
		// Lotto.sort(lotto);
		// lotto.sort(); => 로또를 정렬한다.
		lotto.sort(); // sort 앞의 lotto가 인자가 되는 것 
					  // 저 lotto라는 객체(이거, this)를 전달해서 정렬해달라고 하는 것
		
		// 로또 출력하기
		LottoConsole.print(lotto);
		// lotto.print(); => 로또를 출력한다.

	}
		
}


