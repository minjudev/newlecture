package ex03.array.test2;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("�Է¹��� ����: ");
		int num = scan.nextInt();
		
		int sum = 0;
		for(int i=0; i<num; i++) {
			sum += (i+1);
		}
		
		System.out.printf("1���� %d������ ��: %d", num, sum);
	}
		
}

