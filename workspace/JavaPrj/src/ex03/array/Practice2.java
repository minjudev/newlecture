package ex03.array;

import java.util.Random;

public class Practice2 {

	public static void main(String[] args) {
		
		// 0���� 10���� ��� ���� ���� ����غ���.
		int[] nums = new int[11];
		int sum = 0;
		
		for(int i=0; i<11; i++) {
			nums[i] = i;
			sum = sum + nums[i];
			
		}
		
		System.out.print(sum);
		
	}

}
