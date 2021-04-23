package ex06.캡슐화.lotto.객체지향.생성자.정적;

import java.util.Random;

public class Lotto {
	
	// 인스턴스 변수(인스턴스를 만들 때마다 생성되는, 메모리에 올라가는 변수), 인스턴스 필드					
	private int[] nums; // 만들 때마다 번호가 달라짐
//	private int size; // 만들 때마다 번호가 달라지지 않음
	private static int size; // 전역변수로 만들기, 인스턴스와 상관X
							 // 객체를 만들지 않아도 이미 Lotto 안에 존재 -> Program에서 로또 생성하지 않고도 Lotto.size = 30; 이렇게 사용 가능
							 // new로 로또를 생성하더라도 size는 새로 생성되지 않음
							 // 100개의 로또가 만들어져도 size는 한번만 만들어지고(메모리 절약), 전역변수이기 때문에 100개의 로또에서 공유 가능
							 // main 함수보다 더 먼저 프로그램을 실행하자마자 바로 생성됨
	
	static { // 객체를 만들지 않아도 클래스에 접근하기만 하면 호출됨
		size = 6; // 정적 생성자, 아래와 다르게 한번만 6을 대입하고 끝나게 됨
	}
	
	public Lotto() { 
//		size = 6;    // 변수는 하나인데 계속 6을 대입하는 현상 발생
		nums = new int[size];
	}
	
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
