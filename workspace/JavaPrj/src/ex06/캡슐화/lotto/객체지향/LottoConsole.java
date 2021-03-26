package ex06.캡슐화.lotto.객체지향;

public class LottoConsole {

	// 로또 출력
	public static void print(Lotto lotto) {
		System.out.print("로또 번호: ");
		
		for(int i=0; i<lotto.getSize(); i++) {
			System.out.print(/*Lotto.getNum(lotto, i)*/lotto.getNum(i)); // 반환값으로 lotto라는 것이 가지고 있는 nums의 i번째 값을 반환하기
			
			if(i < lotto.getSize()-1)
				System.out.print(", ");
		}	
	}
}
