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
		
		while(scan.hasNextLine()) { // 끝까지 읽었다는 것을 알려주는 함수 사용
			String name = scan.nextLine(); 
			names[i++] = name; 
			System.out.printf("%s", names[i-1]); // 위의 후위 연산자로 인해 i가 1이 되므로, i-1을 해주어야 0부터 차례대로 인덱스 순서에 맞게 names[i]가 출력됨
			
			if(scan.hasNextLine() == true)
				System.out.printf(", ");	
		}
		
		
//		for(int i=0; i<7; i++) { // text 파일의 변경을 생각한다면 while문 사용 가능
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

