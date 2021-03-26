package ex06.캡슐화.lotto.객체지향;

import java.util.Random;

public class Lotto {
						
	private int[] nums; 
	private int size;
	
	public void setSize(int size) {
		this.size = size; // 이 때는 this 생략 불가능
						  // size라는 이름의 지역변수가 이미 있기 때문에 this 안에서 size라는 변수를 찾지 않음
						  // 그래서 왼쪽의 size가 this 안의 멤버변수라는 것을 알리기 위해 this를 명시해주어야 함  
	}
	
	// 클래스 안에 있는 일반 함수와 인스턴스 함수에 차별점을 두기 위해 클래스 안의 일반 함수에 static을 붙임
	// static 메소드 <-> 인스턴스 메소드(객체 메소드, 실체 메소드)
	public void init() {
		size = 6;
		nums = new int[size];
	}
	
	public int getSize() {
		return size;
	}
	
	// private 변수 nums를 밖으로 꺼내줄 수 있는 대안을 함수로 만들기
	public int getNum(int i) {
		int number = nums[i];
		return number;
	}
	
	// 로또 생성
	public void gen() { // generate 함수에서는 객체가 아닌 값만 생성하게 하자
		Random rand = new Random();
		
		for(int i=0; i<size; i++) { // size는 this에 있는 멤버이지 맨 위의 private int size를 가리키는 게 아님 
									// private int size는 실제 존재하는 게 아님, lotto 객체를 생성한 후에 그 객체의 공간에 있는 size를 쓰는 것임
									// private int size는 설계도일 뿐이지 이 변수에 값을 채울 수 없음
			int number = rand.nextInt(45) + 1;
			nums[i] = number; 
		}
	}
	
	// 로또 정렬
	// 클래스에서 객체지향적으로 함수를 만들고 싶을 때는 static과 매개변수를 지우기
	// 원래 매개변수를 전달받아 사용했던 매개변수 코드 자리를 this로 바꾸기
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
