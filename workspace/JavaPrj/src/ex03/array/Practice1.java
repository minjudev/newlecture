package ex03.array;

import java.util.Random;

public class Practice1 {

	public static void main(String[] args) {
		
		// 0���� 90���� 10������ ����غ���.
		int[] nums = new int[10];
		
		for(int i=0; i<10; i++) {
			nums[i] = i * 10;
			
			System.out.printf("%d ", nums[i]);
		}
		
	}

}
