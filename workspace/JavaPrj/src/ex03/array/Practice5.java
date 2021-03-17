package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		String[][] rows;
		
		// 레코드 개수를 알아내는 코드
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
			
			while(fscan.hasNextLine()) {
				line = fscan.nextLine();
				
				count++;
			}
			
			fscan.close();
			fis.close();
			
			System.out.printf("총 행의 개수: %d\n", count);
			System.out.println();
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
				
				if(j < 9) 
					System.out.printf(", ");
			}
			
			System.out.println();	
		}
		
		System.out.println();		
		
		
		// 검사진행자 누적 수를 얻는 코드
		{		
			int total = 0;
			
			for(int i=0; i<count; i++) 
				total += Integer.parseInt(rows[i][3]);
			
			System.out.printf("검사진행자 누적 수: %d\n", total);
		}
		
		System.out.println();		

		
		// 일별 가장 많은 검사진행자 수와 해당하는 날의 날짜는?
		{
			int max = 0;
			int current = 0;
			String date = "";
			
			for(int i=0; i<count; i++) {
				current = Integer.parseInt(rows[i][3]);
				
				if(current > max)
					max = current;
			}
			
			for(int i=0; i<count; i++) {
				if(max == Integer.parseInt(rows[i][3]))
					date = rows[i][0];
			}

			System.out.printf("일별 가장 많은 검사진행자 수: %d, 해당 날짜: %s\n", max, date);
		}
		
		System.out.println();		

		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 출력하시오.
		{
			int index = 0;
			int old = Integer.parseInt(rows[0][1]);
			int current;
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) {
				current = Integer.parseInt(rows[i][1]);
				
				if(current > old) {
					diff = current - old;
					date = rows[i][0];
					old = current;
					
					System.out.printf("%d - 날짜: %s, 증가된 확진자 수: %d\n", ++index, date, diff);
				}
			}	
		}
		
		System.out.println();		
		
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 다음 배열에 담으시오.
		String[][] results;
		int resultCount = 0;
		
		{
			int old = Integer.parseInt(rows[0][1]);
			
			for(int i=0; i<count; i++) {
				int current = Integer.parseInt(rows[i][1]);
				
				if(current > old) {
					old = current;
					resultCount++;
				}
			}
			
			System.out.printf("증가된 확진자 수가 발생한 날짜의 수: %d", resultCount);
		
			// -----------------------------------------------------------------------------
			
			results = new String[resultCount][];
			old = Integer.parseInt(rows[0][1]);
			int index = 0;
			int diff = 0;
			String date = "";
		
			for(int i=0; i<count; i++) {
				int current = Integer.parseInt(rows[i][1]);
				
				if(current > old) {
					diff = current - old;
					date = rows[i][0];
					old = current;
					
					String[] row = new String[2];
					row[0] = date;
					row[1] = String.valueOf(diff);
					results[index] = row;
					
					System.out.print(Arrays.toString(results[index]));
					index++;
				}
			}
		}	
		
	}
	
}
