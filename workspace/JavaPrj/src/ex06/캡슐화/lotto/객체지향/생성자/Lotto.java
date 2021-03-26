package ex06.캡슐화.lotto.객체지향.생성자;

import java.util.Random;

public class Lotto {
						
	private int[] nums; 
	private int size;
	
	// 1. 초기화는 단 한 번만 실행되길 원한다.
	// 2. 초기화는 속성이 사용되기 전에만 실행되길 원한다. 
	// 	(= 다른 어떤 로직보다 가장 먼지 실행되길 원한다.)
	// 위의 두 조건을 가능하게 해주는 도구 => Constructor(생성자): 초기화 함수
	// 생성자: 함수 형태를 지니지만, 함수처럼 명시적으로 이름을 가지고 있지 않기 때문에 함수처럼 호출할 수 없음
	// 이름도 없고, 반환 타입도 없음, 대신 한정사(Lotto)를 둠
	public Lotto() { // Lotto라는 형식을 가진 갓 태어난 객체만이 나를 호출할 수 있다는 의미
		size = 6;    
		nums = new int[size];
	}
	
//	public void init() {
//		nums = new int[size];
//	}
	
	public int getSize() {
		return size;
	}
	
	// private 변수 nums를 밖으로 꺼내줄 수 있는 대안으로 함수 만들기
	public int getNum(int i) {
		int number = nums[i];
		return number;
	}
	
	// 로또 생성
	public void gen() { // generate 함수에서는 객체가 아닌 값만 생성하게 하자
		Random rand = new Random();
		
		for(int i=0; i<size; i++) { // size는 this에 있는 멤버이지 맨 위의 private int size를 가리키는 게 아님 
									// private int size는 실제 존재하는 게 아님, lotto 객체를 생성한 후에 그 객체의 공간에 있는 size를 쓰는 것임
									// private int size는 설계도일 뿐이지 거기에 값을 채울 수 없음
			int number = rand.nextInt(45) + 1;
			nums[i] = number; 
		}
	}
	
	// 로또 정렬
	// 객체지향적인 표현식으로 바뀐 함수
	// 객체를 사용하는 함수: Objected function / Instance function / Method
	public void sort() { 
		for(int i=0; i<size-1; i++) 	
			for(int j=0; j<size-1-i; j++) 			
				if(nums[j] > nums[j+1]) {
					int temp;
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}	
	}
	
	
	
	
	
	
	
	
	
	
	
}
