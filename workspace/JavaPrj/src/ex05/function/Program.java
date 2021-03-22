package ex05.function;

public class Program {

	// power(x) = (x+3)*(x+3);
	static int power(int x) {
		return (x+3)*(x+3); 
	}
	
	// add(x, y) = x + y;
	static int add(int x, int y) {
		return x + y; // return 되는 그 위치에 x+y를 가지고 가겠다는 의미
	}
	
	// print(x) = x를 output한다.
	// 반환값이 없을 때는 없음을 의미하는 void 키워드 사용
	static void print(int x) {
		System.out.println(x);
	}
	
	// printSum(x, length); // x: 2, length: 3 -> 2+3+4
	static void printSum(int x, int length) {
		if(length <= 0) { // 잘못된 인자의 경우 코드 실행X
			System.out.println("length에 잘못된 값을 입력하였습니다.");
			return; 
		}
		
		for(int i=0; i<length; i++) {
			System.out.printf("%d", x+i);
			
			if(i < length - 1)
				System.out.print("+");
		}
		
		int total = 0;
		for(int i=0; i<length; i++)
			total += (x + i);
			// 2 + 3 + 4 + 5
			// 2 + 0
			// 2 + 1
			// 2 + 2
			// 2 + 3
	
		System.out.print(" = ");
		System.out.printf("%d\n", total);
	}
	
	public static void main(String[] args) {

		int z = add(2, 6);
//		System.out.println(z);
//		System.out.println(add(2, 6));
		
		printSum(2, 3);
	
	}

}
