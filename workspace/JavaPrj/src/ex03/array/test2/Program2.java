package ex03.array.test2;

import java.util.Arrays;
import java.util.Random;

public class Program2 {

	public static void main(String[] args) {

		String[] names = new String[] {"강호동", "유재석", "하하", "김지호", "김현준", "김태희", "박민정"};
				
		String n = new String("hello"); // new 연산자로 "hello"라는 String 객체를 만들고 n(참조변수)이라는 이름을 붙여줌
		String nn = "hello"; // 단순한 문자열이 아니라 문자열을 품고 있는 커다란 도구
		// 저 도구("hello")를 사용해서 문자열에 대한 연산을 할 수 있음, 문자열("hello")은 String 객체
		
		String n1 = "홍길동"; // 이렇게 써도 실제로는 n3, n4처럼 객체에 담아짐
		String n2 = "홍길동";
		String n3 = new String("홍길동");
		String n4 = new String("홍길동");

		System.out.println(n1 == n2); // true : 객체를 비교하는 것은 맞지만 같은 상수값은 같은 객체를 참조하기 때문에 true 반환
		System.out.println(n1.equals(n2));
		System.out.println(n3 == n4); // false : 문자열이 아닌 객체를 비교(두 객체는 각각 다른 객체)
		System.out.println(n3.equals(n4)); // true: 객체가 아닌 문자열의 값을 비교
		
		String fileName = "photo.jpg";
		System.out.println(fileName.length());
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.substring(0, 5));
		System.out.println(fileName.substring(6));
		
		int dot = fileName.indexOf(".");
		System.out.print(fileName.substring(0, dot));
		System.out.println();

		
		System.out.println(fileName.compareTo("photo.jpg"));
		
		
//		-------------------------------------------------------------------
		
		
		Random rand = new Random();
		
		// 두 인덱스 위치 값 바꾸기
		for(int i=0; i<100; i++) { 
			int idx1 = rand.nextInt(7); // 랜덤값(0 ~ 6) 얻기
			int idx2 = rand.nextInt(7); // 랜덤값(0 ~ 6) 얻기
			
			String temp;
			temp = names[idx1];
			names[idx1] = names[idx2];
			names[idx2] = temp;
		}
			
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"", names[i]);
			
			if(i < 6) 
				System.out.print(", ");
		}	
		
		System.out.println();
			
				
		// 버블정렬해서 순서대로 이름 출력하기
		for(int j=0; j<6; j++) 
			for(int i=0; i<7-1-j; i++) 
				if(names[i].compareTo(names[i+1]) > 0) {
					String temp;
					temp = names[i];
					names[i] = names[i+1];
					names[i+1] = temp;
				}
			
		
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"", names[i]);
			
			if(i < 6) 
				System.out.printf(", ");
		}
		
	}
		
}

