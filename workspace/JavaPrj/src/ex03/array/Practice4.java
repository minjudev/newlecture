package ex03.array;

import java.util.Random;
import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		
		// ���ڸ� 5�� �Է¹ް�, �Է¹��� ������ �������� ���� �ۼ��غ���.
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[5];
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			nums[i] = scan.nextInt();			
			sum += nums[i];
			System.out.printf("���: %d", sum);
			System.out.println();
		}
		
	}

}
