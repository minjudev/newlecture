package ex06.캡슐화.corona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		int count = 0;

		// 레코드 개수 알아내기
		count = Covid19.getCount(count);
		
		// count 개수만큼의 요소를 가진 Covid19 형식의 list 배열 생성 
		Covid19[] list = new Covid19[count];
		
		// 레코드 로드하기
		list = Covid19.loadCovid19List(list, count);
		
		// 레코드 출력하기
		printCovid19List(list, count);
		
		// 검사진행자 누적 수 얻기
		int total = Covid19.getTotal(list, count); 
		
		System.out.printf("검사진행자 누적 수: %d\n", total);
		System.out.println();	
		
		// 일별 가장 많은 검사진행자 수는?
		printMax(list, count);
		
		// 검사진행자 수가 가장 많았던 날은?
		printDate(list, count);
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수 출력하기
		printIncreasedDateAndNumber(list, count);
		
		// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 다음 배열에 담기
		Covid19.loadIncreasedDateAndNumber(list, count);
		
	}
	
	// 레코드를 출력하는 코드
	static void printCovid19List(Covid19[] list, int count) { 
		for(int i=0; i<count; i++) {                           
			Covid19 covid = list[i];			
			System.out.printf("%d - %s, %d, %d, %d, %d, %d, %d, %d, %d, %s",
					i+1,
					Covid19.getDate(list, i), 
					Covid19.getCases(list, i),
					Covid19.getDead(list, i),
					Covid19.getTests(list, i),
					Covid19.getSelfIsolation(list, i),
					Covid19.getRelease(list, i),
					Covid19.getRecover(list, i),
					Covid19.getSelfIsolationDomestic(list, i),
					Covid19.getSelfIsolationOverseas(list, i),
					Covid19.getPubDate(list, i));
			
			System.out.println();			
		}	
		
		System.out.println();	
	}
	
	// 일별 가장 많은 검사진행자 수를 출력하는 코드 
	static void printMax(Covid19[] list, int count) {
		int max = Covid19.getMax(list, count);
		
		System.out.printf("일별 최대 검사진행자 수: %d\n", max); 
		System.out.println();
	}
	
	// 검사진행자 수가 가장 많았던 날을 출력하는 코드
	static void printDate(Covid19[] list, int count) {
		
		String date = Covid19.getMaxDate(list, count);
		
		System.out.printf("검사진행자 수가 가장 많았던 날: %s\n", date); 
		System.out.println();	
	}
	
	// 확진자 수가 늘어난 날짜와 증가된 확진자 수를 출력하는 코드	
	static void printIncreasedDateAndNumber(Covid19[] list, int count) {
		int index = 0; 
		int old = Covid19.getPrevCases(list); // 이전 확진자 수
		int current = 0; // 현재 확진자 수
		int diff = 0;
		String date = "";
		
		for(int i=0; i<count; i++) { 
			current = Covid19.getCases(list, i);

			if(old < current) {
				diff = current - old;
				date = Covid19.getDate(list, i);
				old = current; // 현재 값을 다시 이전 확진자 수 변수에 담기
				
				index++; 
				System.out.printf("%d - 날짜: %s / 증가된 확진자 수: %d\n", index, date, diff);
			}
		}	
		
		System.out.println();	
	}

}
