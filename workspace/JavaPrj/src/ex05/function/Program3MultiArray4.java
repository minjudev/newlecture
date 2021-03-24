package ex05.function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray4 {
	
	// 레코드 개수를 알아내는 코드
	static int getCount(int count) throws IOException {
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

		rows = new String[count][]; 
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

	
	// 크로스 방향으로 단순히 나누기만 한 코드, 좀 더 개선해볼 수 있는 여지가 있을까?
	// 함수의 특징 중 재사용을 생각해보면 답이 있지 않을까?
	// 이 함수는 콘솔 출력용으로만 사용할 수 있는 함수가 되어버림
	// 데이터를 구하는 코드와 입출력하는 코드를 같이 쓰지 않고 결합력을 낮추자(1, 2 코드로 분리)
	// 1. 일별 가장 많은 검사진행자 수를 얻는 코드
	static int getMax(String[][] rows, int count) {
		int max = 0;
		int current;
		
		for(int i=0; i<count; i++) {
			current = Integer.parseInt(rows[i][3]);
			if(current > max) 
				max = current;
		}
		
		return max;
	}
	
	
	// 2. 일별 가장 많은 검사진행자 수를 출력하는 코드 
	static void printMax(String[][] rows, int count) {
		
		int max = getMax(rows, count);
		
		System.out.printf("일별 최대 검사진행자 수: %d\n", max); 
		System.out.println();
	}
	
	
	// 1. 검사진행자 수가 가장 많았던 날을 얻는 코드
	static String getDate(String[][] rows, int count) {
		int index = 0;
		String date = ""; 
		int max = getMax(rows, count);
		
		for(int i=0; i<count; i++) {
			if(Integer.parseInt(rows[i][3]) == max) {
				index = i;
				break; // max를 찾았으면 그 위치에서 끝나게 하기
			}
		}
		
		date = rows[index][0];
		return date;
	}
	
	
	// 2. 검사진행자 수가 가장 많았던 날을 출력하는 코드
	static void printDate(String[][] rows, int count) {
		
		String date = getDate(rows, count);
		
		System.out.printf("검사진행자 수가 가장 많았던 날: %s\n", date); 
		System.out.println();	
	}
	
	
	// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 출력하는 코드	
	static void printIncreasedDateAndNumber(String[][] rows, int count) {
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
	}
	
	
	// main 함수
	public static void main(String[] args) throws IOException {
		
		int count = 0;
		String[][] rows = null; 
		// String[][] rows = new String[count][]; // count 개수를 알아낸 후에 rows 배열 생성해야해서 이 줄이 count = checkCovid19List(count); 보다 아래에 있어야 함
		
		
		// 레코드 개수 알아내기
		count = getCount(count); 
		
		
		// 레코드 로드하기
		rows = loadCovid19List(rows/* 참조 변수 */, count /* 값 변수 */); // 여기에 매개변수로 들어가는 rows는 윗줄에서 정의한 문자열 rows 배열, 근데 위의 이 함수 코드에서는 전혀 다른 새로운 객체 rows를 새로 생성한 후 for문을 돌린 배열을 return 했음
																	   // heap, stack으로 생각해보기
		
		// 레코드 출력하기
		printCovid19List(rows, count);
		
		
		// 검사진행자 누적 수 얻기
		int total = getTotal(rows, count); // 배열을 전달해줄 때는 값을 전달하는 게 아니라 참조를 전달하는 것(참조 전달의 의미: 별칭을 만들어서 전달)
		
		System.out.printf("검사진행자 누적 수: %d\n", total);
		System.out.println();	
		
		
		// 일별 가장 많은 검사진행자 수는?
		printMax(rows, count);
		
			
		// 검사진행자 수가 가장 많았던 날은?
		printDate(rows, count);
		
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수 출력하기
		printIncreasedDateAndNumber(rows, count);

		
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
