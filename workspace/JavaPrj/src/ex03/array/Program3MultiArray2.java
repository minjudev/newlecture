package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray2 {

	public static void main(String[] args) throws IOException {
		
		String[][] rows = new String[2][]; // 뒤 배열의 크기([2][v])를 정하지 않으면 배열을 담는 공간이 일단 2개만 만들어짐
										   // 1차원 배열을 묶어서 단일한 이름(rows)을 가지게 해서 일괄 처리 가능하게 함
			
		FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		for(int i=0; i<2; i++) {
			line = fscan.nextLine();
			rows[i] = line.split(","); // line.split(",") 된 것을 rows라는 참조 변수의 이름으로 지어주겠다
		}
		
		for(int j=0; j<2; j++) {
			for(int i=0; i<10; i++) {
				System.out.printf("%s", rows[j][i]);
				
				if(i<9) 
					System.out.printf(", ", rows[j][i]);
			}
		
			System.out.println();	
		}
		
		fis.close();
		fscan.close();
		
	}

}
