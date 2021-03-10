package ex03.array.test;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {

		// [nums 배열을 섞어보자.]
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Random rand = new Random();
		
		// 두 인덱스 위치 값 바꾸기
		for(int i=0; i<100; i++) {
			int idx1 = rand.nextInt(10); // 랜덤값(0 ~ 9) 얻기
			int idx2 = rand.nextInt(10); 
			
			System.out.printf("idx1: %d ", idx1);
			System.out.printf("idx2: %d", idx2);
			System.out.println();
			
			int temp;
			temp = nums[idx1];
			nums[idx1] = nums[idx2];
			nums[idx2] = temp;
		}
		
		for(int i=0; i<10; i++) {
			System.out.printf("%d", nums[i]);
			
			if(i < 9) 
				System.out.printf(", ");
		}
		
		System.out.println();
		
//		System.out.print(nums);
		
//		-------------------------------------------------------
		
		// 정렬(버블정렬/선택정렬/퀵정렬...)
		// [nums 배열을 버블정렬해보자.]
		
		// nums 배열 버블정렬하기
		for(int j=0; j<9; j++)
			// nums 배열 중 가장 큰 숫자를 제일 뒤로 옮기기
			for(int i=0; i<9; i++) 
				if(nums[i] > nums[i+1]) {
					int temp;
					temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				}
		
		for(int i=0; i<10; i++) {
			System.out.printf("%d", nums[i]);
			
			if(i < 9) 
				System.out.printf(", ");
		}
		
	}
		
}

