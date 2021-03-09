package ex03.array;

import java.util.Random;

public class Practice3 {

	public static void main(String[] args) {
		
		// 0부터 20까지 짝수만 출력해보자.
		int[] nums = new int[21];
		
		for(int i=0; i<=20; i++) {
			nums[i] = i;
			
			if(i % 2 ==0) {
				System.out.print(nums[i]);				
			}
		}
		
	}

}
