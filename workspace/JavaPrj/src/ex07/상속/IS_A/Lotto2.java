package ex07.상속.IS_A;

import ex07.상속.Lotto;

public class Lotto2 extends Lotto/* extends를 이용해 기존 Lotto를 틀로 가져옴 */{

	// 기존 Lotto를 틀로 가져와서 고쳐서 쓰고자 함
	// 고치는 작업: 추가 / 수정
	
//	public Lotto2() {
//		super(); // 부모 객체(Lotto)를 가리킴, 부모 객체를 이용											
//	}
	
	// 로또 번호 역정렬하기
	// 새로운 기능 추가
	public void sortDsc() {
		
	}
	
	// 로또 번호 생성하기
	// 기존 기능 수정
	// 물려받은 것을 쓰는 게 아닌 새로 정의한 내용을 쓰게 됨, 새로 정의한 내용이 더 높은 우선순위를 가짐
	// Override 메소드: 기존 것을 덮어쓴다
	public void gen() {
		System.out.println("good!");
	}
	
}
