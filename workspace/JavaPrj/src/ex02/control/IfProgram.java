package ex02.control;

import java.util.Scanner;

public class IfProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x: ");
		int x = scan.nextInt();
				
		if(x % 2 == 0) {
			System.out.print("¦��");
			System.out.println(" ��");
		} else {
			System.out.print("Ȧ��");
			System.out.println(" ��");
		}
		
		if(x < 3) {
			System.out.print("3���� �۴�");
		} else if(x > 5) {
			System.out.print("5���� ũ��");
		}		
				
	}

}
