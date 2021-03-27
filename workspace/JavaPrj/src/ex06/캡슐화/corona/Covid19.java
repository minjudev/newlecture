package ex06.ĸ��ȭ.corona;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Covid19 {
	
	private String date;
	private int cases;
	private int dead;
	private int tests;
	private int selfIsolation; 
	private int release;
	private int recover;
	private int selfIsolationDomestic;
	private int selfIsolationOverseas;
	private String pubDate;
	
	// ���ڵ� ������ �˾Ƴ��� �ڵ�
	static int getCount(int count) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
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
	
	// ���ڵ带 �ε��ϴ� �ڵ�
	static Covid19[] loadCovid19List(Covid19[] list, int count) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		for(int i=0; i<count; i++) {
			line = fscan.nextLine();
			String[] tokens = line.split(",");
			
			Covid19 covid = new Covid19();
			covid.date = tokens[0];
			covid.cases = Integer.parseInt(tokens[1]);
			covid.dead = Integer.parseInt(tokens[2]);
			covid.tests = Integer.parseInt(tokens[3]);
			covid.selfIsolation = Integer.parseInt(tokens[4]);
			covid.release = Integer.parseInt(tokens[5]);
			covid.recover = Integer.parseInt(tokens[6]);
			covid.selfIsolationDomestic = Integer.parseInt(tokens[7]);
			covid.selfIsolationOverseas = Integer.parseInt(tokens[8]);
			covid.pubDate = tokens[9];

			list[i] = covid;
		}
		
		fscan.close();
		fis.close();
		
		return list;
	}
		
//	// ���ڵ带 ����ϴ� �ڵ�
//	static void printCovid19List(Covid19[] list, int count) { 
//		for(int i=0; i<count; i++) {                           
//			Covid19 covid = list[i]; 
//			System.out.printf("%d - %s, %d, %d, %d, %d, %d, %d, %d, %d, %s",
//					i+1,
//					covid.date, 
//					covid.cases,
//					covid.dead,
//					covid.tests,
//					covid.selfIsolation,
//					covid.release,
//					covid.recover,
//					covid.selfIsolationDomestic,
//					covid.selfIsolationOverseas,
//					covid.pubDate); 
//			
//			System.out.println();			
//		}	
//		
//		System.out.println();	
//	}
	
	public static String getDate(Covid19[] list, int i) {
		return list[i].date;
	}

	public static int getCases(Covid19[] list, int i) {
		return list[i].cases;
	}

	public static int getDead(Covid19[] list, int i) {
		return list[i].dead;
	}

	public static int getTests(Covid19[] list, int i) {
		return list[i].tests;
	}

	public static int getSelfIsolation(Covid19[] list, int i) {
		return list[i].selfIsolation;
	}

	public static int getRelease(Covid19[] list, int i) {
		return list[i].release;
	}

	public static int getRecover(Covid19[] list, int i) {
		return list[i].recover;
	}

	public static int getSelfIsolationDomestic(Covid19[] list, int i) {
		return list[i].selfIsolationDomestic;
	}

	public static int getSelfIsolationOverseas(Covid19[] list, int i) {
		return list[i].selfIsolationOverseas;
	}

	public static String getPubDate(Covid19[] list, int i) {
		return list[i].pubDate;
	}

	// �˻������� ���� ���� ��� �ڵ�
	static int getTotal(Covid19[] list, int count) {
		int total = 0;

		for(int i=0; i<count; i++)
			total += list[i].tests; 

		return total;
	}

	// 1. �Ϻ� ���� ���� �˻������� ���� ��� �ڵ�
	static int getMax(Covid19[] list, int count) {
		int max = 0;
		int current;
		
		for(int i=0; i<count; i++) {
			current = list[i].tests;
			if(current > max) 
				max = current;
		}
		
		return max;
	}
	
//	// 2. �Ϻ� ���� ���� �˻������� ���� ����ϴ� �ڵ� 
//	static void printMax(Covid19[] list, int count) {
//		int max = getMax(list, count);
//		
//		System.out.printf("�Ϻ� �ִ� �˻������� ��: %d\n", max); 
//		System.out.println();
//	}
	
	// 1. �˻������� ���� ���� ���Ҵ� ���� ��� �ڵ�
	static String getMaxDate(Covid19[] list, int count) {
		int index = 0;
		String date = ""; 
		int max = getMax(list, count);
		
		for(int i=0; i<count; i++) {
			if(list[i].tests == max) {
				index = i;
				break; // max�� ã������ �� ��ġ���� ������ �ϱ�
			}
		}
		
		date = list[index].date;
		return date;
	}
	
//	// 2. �˻������� ���� ���� ���Ҵ� ���� ����ϴ� �ڵ�
//	static void printDate(Covid19[] list, int count) {
//		
//		String date = getDate(list, count);
//		
//		System.out.printf("�˻������� ���� ���� ���Ҵ� ��: %s\n", date); 
//		System.out.println();	
//	}
	
//	// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ����ϴ� �ڵ�	
//	static void printIncreasedDateAndNumber(Covid19[] list, int count) {
//		int index = 0; 
//		int old = list[0].cases; // ���� Ȯ���� ��
//		int current = 0; // ���� Ȯ���� ��
//		int diff = 0;
//		String date = "";
//		
//		for(int i=0; i<count; i++) { 
//			current = list[i].cases;
//
//			if(old < current) {
//				diff = current - old;
//				date = list[i].date;
//				old = current; // ���� ���� �ٽ� ���� Ȯ���� �� ������ ���
//				
//				index++; 
//				System.out.printf("%d - ��¥: %s / ������ Ȯ���� ��: %d\n", index, date, diff);
//			}
//		}	
//		
//		System.out.println();	
//	}
	
	static int getPrevCases(Covid19[] list) {
		return list[0].cases;
	}
	
	// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ���� �迭�� ���
	static void loadIncreasedDateAndNumber(Covid19[] list, int count) {
		String[][] results;
		int resultCount = 0;
	
		{
			int old = list[0].cases; // ���� Ȯ���� ��
			
			for(int i=0; i<count; i++) { 
				int current = list[i].cases; // i��° ���� Ȯ���� ��
	
				if(old < current) {
					old = current;
					resultCount++;
				}				
			}
			
			System.out.printf("������ Ȯ���� ���� �߻��� ��¥ ��: %d\n", resultCount);
			System.out.println();
			
			// -----------------------------------------------------------------
			
			results = new String[resultCount][];
			old = list[0].cases;
			int index = 0;
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) { 
				int current = list[i].cases; // i��° ���� Ȯ���� ��
	
				if(current > old) {
					diff = current - old;
					date = list[i].date;
					old = current; // ���� ���� �ٽ� ���� Ȯ���� �� ������ ���
					
					// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ��� ���� �迭
					String[] row = new String[2]; 
					row[0] = date; 
					row[1] = String.valueOf(diff); 
					results[index] = row; 
					
					System.out.println(Arrays.toString(results[index++]));
				}
			}		
		}
	}
}
