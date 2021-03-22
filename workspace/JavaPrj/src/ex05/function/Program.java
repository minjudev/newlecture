package ex05.function;

public class Program {

	// power(x) = (x+3)*(x+3);
	static int power(int x) {
		return (x+3)*(x+3); 
	}
	
	// add(x, y) = x + y;
	static int add(int x, int y) {
		return x + y; // return �Ǵ� �� ��ġ�� x+y�� ������ ���ڴٴ� �ǹ�
	}
	
	// print(x) = x�� output�Ѵ�.
	// ��ȯ���� ���� ���� ������ �ǹ��ϴ� void Ű���� ���
	static void print(int x) {
		System.out.println(x);
	}
	
	// printSum(x, length); // x: 2, length: 3 -> 2+3+4
	static void printSum(int x, int length) {
		if(length <= 0) { // �߸��� ������ ��� �ڵ� ����X
			System.out.println("length�� �߸��� ���� �Է��Ͽ����ϴ�.");
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
