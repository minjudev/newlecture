package ex07.상속;

// console의 UI 담당
// UI가 달라져도 콘솔용 UI를 분리했으므로 다른 입출력장치에서도 Lotto 클래스 사용 가능
public class LottoConsole {

	// 객체를 이용하는 또 다른 객체를 만들 수 있음
	// 객체가 다른 객체를 자신의 멤버로 Has 하고 그것을 이용하면 그것을 Has A 상속이라고 한다.(멤버로 가지고 있을 때만 Has라고 함)
	// LottoConsole이 Lotto의 기능을 가지게 됨으로써 Has A 상속 관계가 됨
	// 다른 객체를 자신의 부품으로 갖는 것
	private Lotto lotto; // LottoConsole은 Lotto를 상속(제공) 받아서 멤버 함수(print)를 구현한다.
						 // 다른 객체의 기능 이용
						 // Lotto라는 사용자 정의 자료형을 사용하겠다, 이름은 lotto로 선언
	
	// Composition Has A 상속: 일체형
	// LottoConsole이 lotto를 넘겨받지 않고 직접 lotto를 생성
//	public LottoConsole() {
//		this.lotto = new Lotto(); // this는 전역변수에 접근하고 싶을 때 사용
//		this.lotto.gen();
//	}
	
	// Association Has A 상속: 분리형
	public LottoConsole(Lotto lotto) { // 생성자로 초기화하면서 여기서 lotto 객체를 넘겨 받아줌
		this.lotto = lotto; // 여기서 lotto를 넘겨받을 때 Program.java 40번째 줄의 인자 lotto의 값을 넘겨 받음
	}
	
	// 로또 출력
	public void print() { // 이 함수의 구현을 위해 다른 객체를 자신의 부품으로 가져오는 것: Has A 상속
		System.out.print("로또 번호: ");
		
		for(int i=0; i<this.lotto.getSize(); i++) {
			System.out.print(/*Lotto.getNum(lotto, i)*/this.lotto.getNum(i)); // 반환값으로 lotto라는 것이 가지고 있는 nums의 i번째 값을 반환하기
			
			if(i < this.lotto.getSize()-1)
				System.out.print(", ");
		}	
	}
}
