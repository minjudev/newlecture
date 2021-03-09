package ex02.control;

import java.util.Scanner;

public class IfProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x: ");
		int x = scan.nextInt();
				
		if(x % 2 == 0) {
			System.out.print("짝수");
			System.out.println(" 값");
		} else {
			System.out.print("홀수");
			System.out.println(" 값");
		}
		
		if(x < 3) {
			System.out.print("3보다 작다");
		} else if(x > 5) {
			System.out.print("5보다 크다");
		}		
				
	}

}
