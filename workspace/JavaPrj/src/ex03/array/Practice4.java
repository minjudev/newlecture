package ex03.array;

import java.util.Random;
import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		
		// 숫자를 5번 입력받고, 입력받을 때마다 더해지는 식을 작성해보자.
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[5];
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			System.out.print("숫자를 입력하세요: ");
			nums[i] = scan.nextInt();			
			sum += nums[i];
			System.out.printf("출력: %d", sum);
			System.out.println();
		}
		
	}

}
