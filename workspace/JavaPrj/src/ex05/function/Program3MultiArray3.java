package ex05.function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray3 {
	
	// 레코드 개수를 알아내는 코드
	static int getCovid19List(int count) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();

		while(fscan.hasNextLine()) {
			fscan.nextLine();
			count++;
		}
		
		fscan.close();
		fis.close();
		
		return count;
	}
	
	
	// 레코드를 로드하는 코드
	static String[][] loadCovid19List(String[][] rows, int count) throws IOException {

		// rows = new String[count][]; 
		// 이렇게 새로 rows를 정의해버리면 위에 줄에서 매개변수로 받은 rows가 아닌 새로운 rows에 for문 연산이 되어 return을 하게 됨
		
		FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		for(int i=0; i<count; i++) {
			line = fscan.nextLine();
			rows[i] = line.split(",");
		}
		
		fscan.close();
		fis.close();
		
		return rows;
	}
	
	
	// 레코드를 출력하는 코드
	static void printCovid19List(String[][] rows, int count) { // 함수의 벽을 허물 수 있는 것: 매개변수, main 함수 안에 위치해있는 두 변수를 이 함수의 매개변수로 전달해주기
		for(int i=0; i<count; i++) {                           // 매개변수의 이름을 다르게 해도 되긴 하지만 원래 변수의 이름대로 쓰는 것이 좋음
			System.out.printf("%d - ", i+1);
			
			for(int j=0; j<10; j++) {
				System.out.printf("%s", rows[i][j]);
				
				if(j<9) 
					System.out.printf(", ");
			}
			
			System.out.println();			
		}	
		
		System.out.println();	
	}
	
	
	// 검사진행자 누적 수를 얻는 코드
	static int getTotal(String[][] rows, int count) { 
		int total = 0;

		for(int i=0; i<count; i++)
			total += Integer.parseInt(rows[i][3]); // 지역적으로 rows를 다뤘어도 전역에서 rows를 선언해줬기 때문에 다시 다른 지역에서 rows 관련 연산이 가능함

		return total;
	}

	
	public static void main(String[] args) throws IOException {
		
		int count = 0;
		
		// 레코드 개수 알아내기
		count = getCovid19List(count); 
		String[][] rows = new String[count][]; // count 개수를 알아낸 후에 rows 배열 생성해야해서 이 줄이 count = checkCovid19List(count); 보다 아래에 있어야 함
		
		
		// 레코드 로드하기
		loadCovid19List(rows, count); // 여기에 매개변수로 들어가는 rows는 윗줄에서 정의한 문자열 rows 배열, 근데 위의 이 함수 코드에서는 전혀 다른 새로운 객체 rows를 새로 생성한 후 for문을 돌린 배열을 return 했음
			
		
		// 레코드 출력하기
		printCovid19List(rows, count);
		
		
		// 검사진행자 누적 수 얻기
		int total = getTotal(rows, count); // 배열을 전달해줄 때는 값을 전달하는 게 아니라 참조를 전달하는 것(참조 전달의 의미: 별칭을 만들어서 전달)
		
		System.out.printf("검사진행자 누적 수: %d\n", total);
		System.out.println();	
		
		
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
			
			System.out.printf("일별 최대 검사진행자 수: %d, 해당 날짜: %s\n", max, rows[index][0]); 
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
			
			System.out.println();	
		}
		
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 다음 배열에 담아주시오.
		String[][] results;
		int resultCount = 0;
		
		{
			int old = Integer.parseInt(rows[0][1]); // 이전 확진자 수
			
			for(int i=0; i<count; i++) { 
				int current = Integer.parseInt(rows[i][1]); // i번째 행의 확진자 수

				if(old < current) {
					old = current;
					resultCount++;
				}				
			}
			
			System.out.printf("증가된 확진자 수가 발생한 날짜 수: %d\n", resultCount);
			System.out.println();
			
			// -----------------------------------------------------------------
			
			results = new String[resultCount][];
			old = Integer.parseInt(rows[0][1]);
			int index = 0;
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) { 
				int current = Integer.parseInt(rows[i][1]); // i번째 행의 확진자 수

				if(current > old) {
					diff = current - old;
					date = rows[i][0];
					old = current; // 현재 값을 다시 이전 확진자 수 변수에 담기
					
					// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 담기 위한 배열
					String[] row = new String[2];
					row[0] = date;
					row[1] = String.valueOf(diff);
					results[index] = row; // 후위 연산자를 통해 해당 코드 실행 후 index에 바로 1이 더해짐
					
					System.out.println(Arrays.toString(results[index++]));

//					index++;
				}
			}		
		}

	}


	

}
