package ex03.array;

import java.util.Random;

public class Practice1 {

	public static void main(String[] args) {
		
		// 0부터 90까지 10단위로 출력해보자.
		int[] nums = new int[10];
		
		for(int i=0; i<10; i++) {
			nums[i] = i * 10;
			
			System.out.printf("%d ", nums[i]);
		}
		
	}

}
