package ex03.array.test;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {

		// [nums �迭�� �����.]
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Random rand = new Random();
		
		// �� �ε��� ��ġ �� �ٲٱ�
		for(int i=0; i<100; i++) {
			int idx1 = rand.nextInt(10); // ������(0 ~ 9) ���
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
		
		// ����(��������/��������/������...)
		// [nums �迭�� ���������غ���.]
		
		// nums �迭 ���������ϱ�
		for(int j=0; j<9; j++)
			// nums �迭 �� ���� ū ���ڸ� ���� �ڷ� �ű��
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

