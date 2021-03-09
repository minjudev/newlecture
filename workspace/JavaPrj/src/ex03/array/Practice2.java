package ex03.array;

import java.util.Random;

public class Practice2 {

	public static void main(String[] args) {
		
		// 0부터 10까지 모두 더한 값을 출력해보자.
		int[] nums = new int[11];
		int sum = 0;
		
		for(int i=0; i<11; i++) {
			nums[i] = i;
			sum = sum + nums[i];
			
		}
		
		System.out.print(sum);
		
	}

}
