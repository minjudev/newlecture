package ex06.ĸ��ȭ.corona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		int count = 0;

		// ���ڵ� ���� �˾Ƴ���
		count = Covid19.getCount(count);
		
		// count ������ŭ�� ��Ҹ� ���� Covid19 ������ list �迭 ���� 
		Covid19[] list = new Covid19[count];
		
		// ���ڵ� �ε��ϱ�
		list = Covid19.loadCovid19List(list, count);
		
		// ���ڵ� ����ϱ�
		printCovid19List(list, count);
		
		// �˻������� ���� �� ���
		int total = Covid19.getTotal(list, count); 
		
		System.out.printf("�˻������� ���� ��: %d\n", total);
		System.out.println();	
		
		// �Ϻ� ���� ���� �˻������� ����?
		printMax(list, count);
		
		// �˻������� ���� ���� ���Ҵ� ����?
		printDate(list, count);
		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� �� ����ϱ�
		printIncreasedDateAndNumber(list, count);
		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ���� �迭�� ���
		Covid19.loadIncreasedDateAndNumber(list, count);
		
	}
	
	// ���ڵ带 ����ϴ� �ڵ�
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
	
	// �Ϻ� ���� ���� �˻������� ���� ����ϴ� �ڵ� 
	static void printMax(Covid19[] list, int count) {
		int max = Covid19.getMax(list, count);
		
		System.out.printf("�Ϻ� �ִ� �˻������� ��: %d\n", max); 
		System.out.println();
	}
	
	// �˻������� ���� ���� ���Ҵ� ���� ����ϴ� �ڵ�
	static void printDate(Covid19[] list, int count) {
		
		String date = Covid19.getMaxDate(list, count);
		
		System.out.printf("�˻������� ���� ���� ���Ҵ� ��: %s\n", date); 
		System.out.println();	
	}
	
	// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ����ϴ� �ڵ�	
	static void printIncreasedDateAndNumber(Covid19[] list, int count) {
		int index = 0; 
		int old = Covid19.getPrevCases(list); // ���� Ȯ���� ��
		int current = 0; // ���� Ȯ���� ��
		int diff = 0;
		String date = "";
		
		for(int i=0; i<count; i++) { 
			current = Covid19.getCases(list, i);

			if(old < current) {
				diff = current - old;
				date = Covid19.getDate(list, i);
				old = current; // ���� ���� �ٽ� ���� Ȯ���� �� ������ ���
				
				index++; 
				System.out.printf("%d - ��¥: %s / ������ Ȯ���� ��: %d\n", index, date, diff);
			}
		}	
		
		System.out.println();	
	}

}
