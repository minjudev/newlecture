package ex03.array.test2;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("입력받은 숫자: ");
		int num = scan.nextInt();
		
		int sum = 0;
		for(int i=0; i<num; i++) {
			sum += (i+1);
		}
		
		System.out.printf("1부터 %d까지의 합: %d", num, sum);
	}
		
}

