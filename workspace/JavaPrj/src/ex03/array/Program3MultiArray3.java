package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray3 {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		String[][] rows;
		
		// 레코드 개수를 알아내는 코드
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
	
			while(fscan.hasNextLine()) {
				fscan.nextLine();
				count++;
			}
			
			fscan.close();
			fis.close();
		}
		
		
		// 레코드를 로드하는 코드
		{
			rows = new String[count][]; 
			
			FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
			
			for(int i=0; i<count; i++) {
				line = fscan.nextLine();
				rows[i] = line.split(",");
			}
			
			fscan.close();
			fis.close();
		}
		
		
		// 레코드를 출력하는 코드
		for(int i=0; i<count; i++) {
			System.out.printf("%d - ", i+1);
			
			for(int j=0; j<10; j++) {
				System.out.printf("%s", rows[i][j]);
				
				if(j<9) 
					System.out.printf(", ", rows[i][j]);
			}
			
			System.out.println();			
		}
		
		System.out.println();	
		
		
		// 검사진행자 누적 수를 얻는 코드
		{				
			int total = 0;

			for(int i=0; i<count; i++)
				total += Integer.parseInt(rows[i][3]); // 지역적으로 rows를 다뤘어도 전역에서 rows를 선언해줬기 때문에 다시 다른 지역에서 rows 관련 연산이 가능함

			System.out.printf("검사진행자 누적 수: %d\n", total);
			System.out.println();	
		}
		
		
		// 일별 가장 많은 검사진행자 수와 해당하는 날의 날짜는?
		{
			int max = 0;
			int current;
			int index = 0;
			String date = ""; // 초기화해주는 이유: 초기화해주지 않으면 date가 조건에 맞지 않아 for, if문 등을 돌지 않고 그대로 출력됐을 경우 아무 값이 없게 출력되므로
			
			for(int i=0; i<count; i++) {
				current = Integer.parseInt(rows[i][3]);
				if(current > max) { 
					max = current;  
//					index = i; // current가 max보다 클 때마다 index가 출력되므로 이렇게 구현하면 안됨
//					System.out.println(index); 				
				}
			}
			
			for(int i=0; i<count; i++) {
				if(Integer.parseInt(rows[i][3]) == max) {
					index = i;
					break; // max를 찾았으면 그 위치에서 끝나게 하기
				}
			}
			
			System.out.printf("일별 최대 검사진행자 수: %d, 해당 날짜: %s\n", max, rows[index][0]); // 맞게 한 건가?
			System.out.println();	
		}
		
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 출력하시오.
	
		{
			int index = 0; 
			int old = Integer.parseInt(rows[0][1]); // 이전 확진자 수
			int current = 0; // 현재 확진자 수
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) { 
				current = Integer.parseInt(rows[i][1]);

				if(old < current) {
					diff = current - old;
					date = rows[i][0];
					old = current; // 현재 값을 다시 이전 확진자 수 변수에 담기
					
					index++; 
					System.out.printf("%d - 날짜: %s / 증가된 확진자 수: %d\n", index, date, diff);
				}
			}		
		}
		
	}

}
