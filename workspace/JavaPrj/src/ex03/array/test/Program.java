package ex03.array.test;

public class Program {

	public static void main(String[] args) {

		int[] nums = new int[10];
		
		// 2부터 20까지 짝수만 출력해보자.
		for(int i=0; i<10; i++) {
//			nums[i] = i * 2 + 2; // an = a1 + (n-1) * d
//			System.out.printf("%d", nums[i]);		
//			
//			if(i < 9) {
//				System.out.printf(", ");
//			}
			
			// 1, 2, 3, 1, 2, 3, 1, 2, 3, 1을 출력해보자.
			nums[i] = i % 3 + 1;
			System.out.printf("%d", nums[i]);
			
			if(i < 9) {
				System.out.printf(", ");
			}
			
		}
	
	}
		
}

