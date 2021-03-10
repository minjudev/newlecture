package ex03.array.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		String[] names = new String[10];
	
		FileInputStream fis = new FileInputStream("res/names.txt");
		Scanner scan = new Scanner(fis);
		
		int i = 0;
		
		while(scan.hasNextLine()) { // ������ �о��ٴ� ���� �˷��ִ� �Լ� ���
			String name = scan.nextLine(); 
			names[i++] = name; 
			System.out.printf("%s", names[i-1]); // ���� ���� �����ڷ� ���� i�� 1�� �ǹǷ�, i-1�� ���־�� 0���� ���ʴ�� �ε��� ������ �°� names[i]�� ��µ�
			
			if(scan.hasNextLine() == true)
				System.out.printf(", ");	
		}
		
		
//		for(int i=0; i<7; i++) { // text ������ ������ �����Ѵٸ� while�� ��� ����
//			names[i] = scan.nextLine();
//			System.out.printf("%s", names[i]);
//			
//			if(i < 6) 
//				System.out.printf(", ");
//		}
		
		scan.close();
		fis.close();
		
	}
		
}

