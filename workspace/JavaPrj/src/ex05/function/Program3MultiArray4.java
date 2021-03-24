package ex05.function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray4 {
	
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
	static String[][] loadCovid19List(String[][] rows, int count) throws IOException {

		rows = new String[count][]; 
		// �̷��� ���� rows�� �����ع����� ���� �ٿ��� �Ű������� ���� rows�� �ƴ� ���ο� rows�� for�� ������ �Ǿ� return�� �ϰ� ��
		
		FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
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
	
	
	// ���ڵ带 ����ϴ� �ڵ�
	static void printCovid19List(String[][] rows, int count) { // �Լ��� ���� �㹰 �� �ִ� ��: �Ű�����, main �Լ� �ȿ� ��ġ���ִ� �� ������ �� �Լ��� �Ű������� �������ֱ�
		for(int i=0; i<count; i++) {                           // �Ű������� �̸��� �ٸ��� �ص� �Ǳ� ������ ���� ������ �̸���� ���� ���� ����
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
	
	
	// �˻������� ���� ���� ��� �ڵ�
	static int getTotal(String[][] rows, int count) { 
		int total = 0;

		for(int i=0; i<count; i++)
			total += Integer.parseInt(rows[i][3]); // ���������� rows�� �ٷ� �������� rows�� ��������� ������ �ٽ� �ٸ� �������� rows ���� ������ ������

		return total;
	}

	
	// ũ�ν� �������� �ܼ��� �����⸸ �� �ڵ�, �� �� �����غ� �� �ִ� ������ ������?
	// �Լ��� Ư¡ �� ������ �����غ��� ���� ���� ������?
	// �� �Լ��� �ܼ� ��¿����θ� ����� �� �ִ� �Լ��� �Ǿ����
	// �����͸� ���ϴ� �ڵ�� ������ϴ� �ڵ带 ���� ���� �ʰ� ���շ��� ������(1, 2 �ڵ�� �и�)
	// 1. �Ϻ� ���� ���� �˻������� ���� ��� �ڵ�
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
	
	
	// 2. �Ϻ� ���� ���� �˻������� ���� ����ϴ� �ڵ� 
	static void printMax(String[][] rows, int count) {
		
		int max = getMax(rows, count);
		
		System.out.printf("�Ϻ� �ִ� �˻������� ��: %d\n", max); 
		System.out.println();
	}
	
	
	// 1. �˻������� ���� ���� ���Ҵ� ���� ��� �ڵ�
	static String getDate(String[][] rows, int count) {
		int index = 0;
		String date = ""; 
		int max = getMax(rows, count);
		
		for(int i=0; i<count; i++) {
			if(Integer.parseInt(rows[i][3]) == max) {
				index = i;
				break; // max�� ã������ �� ��ġ���� ������ �ϱ�
			}
		}
		
		date = rows[index][0];
		return date;
	}
	
	
	// 2. �˻������� ���� ���� ���Ҵ� ���� ����ϴ� �ڵ�
	static void printDate(String[][] rows, int count) {
		
		String date = getDate(rows, count);
		
		System.out.printf("�˻������� ���� ���� ���Ҵ� ��: %s\n", date); 
		System.out.println();	
	}
	
	
	// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ����ϴ� �ڵ�	
	static void printIncreasedDateAndNumber(String[][] rows, int count) {
		{
			int index = 0; 
			int old = Integer.parseInt(rows[0][1]); // ���� Ȯ���� ��
			int current = 0; // ���� Ȯ���� ��
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) { 
				current = Integer.parseInt(rows[i][1]);

				if(old < current) {
					diff = current - old;
					date = rows[i][0];
					old = current; // ���� ���� �ٽ� ���� Ȯ���� �� ������ ���
					
					index++; 
					System.out.printf("%d - ��¥: %s / ������ Ȯ���� ��: %d\n", index, date, diff);
				}
			}	
			
			System.out.println();	
		}		
	}
	
	
	// main �Լ�
	public static void main(String[] args) throws IOException {
		
		int count = 0;
		String[][] rows = null; 
		// String[][] rows = new String[count][]; // count ������ �˾Ƴ� �Ŀ� rows �迭 �����ؾ��ؼ� �� ���� count = checkCovid19List(count); ���� �Ʒ��� �־�� ��
		
		
		// ���ڵ� ���� �˾Ƴ���
		count = getCount(count); 
		
		
		// ���ڵ� �ε��ϱ�
		rows = loadCovid19List(rows/* ���� ���� */, count /* �� ���� */); // ���⿡ �Ű������� ���� rows�� ���ٿ��� ������ ���ڿ� rows �迭, �ٵ� ���� �� �Լ� �ڵ忡���� ���� �ٸ� ���ο� ��ü rows�� ���� ������ �� for���� ���� �迭�� return ����
																	   // heap, stack���� �����غ���
		
		// ���ڵ� ����ϱ�
		printCovid19List(rows, count);
		
		
		// �˻������� ���� �� ���
		int total = getTotal(rows, count); // �迭�� �������� ���� ���� �����ϴ� �� �ƴ϶� ������ �����ϴ� ��(���� ������ �ǹ�: ��Ī�� ���� ����)
		
		System.out.printf("�˻������� ���� ��: %d\n", total);
		System.out.println();	
		
		
		// �Ϻ� ���� ���� �˻������� ����?
		printMax(rows, count);
		
			
		// �˻������� ���� ���� ���Ҵ� ����?
		printDate(rows, count);
		
		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� �� ����ϱ�
		printIncreasedDateAndNumber(rows, count);

		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ���� �迭�� ����ֽÿ�.
		String[][] results;
		int resultCount = 0;
		
		{
			int old = Integer.parseInt(rows[0][1]); // ���� Ȯ���� ��
			
			for(int i=0; i<count; i++) { 
				int current = Integer.parseInt(rows[i][1]); // i��° ���� Ȯ���� ��

				if(old < current) {
					old = current;
					resultCount++;
				}				
			}
			
			System.out.printf("������ Ȯ���� ���� �߻��� ��¥ ��: %d\n", resultCount);
			System.out.println();
			
			// -----------------------------------------------------------------
			
			results = new String[resultCount][];
			old = Integer.parseInt(rows[0][1]);
			int index = 0;
			int diff = 0;
			String date = "";
			
			for(int i=0; i<count; i++) { 
				int current = Integer.parseInt(rows[i][1]); // i��° ���� Ȯ���� ��

				if(current > old) {
					diff = current - old;
					date = rows[i][0];
					old = current; // ���� ���� �ٽ� ���� Ȯ���� �� ������ ���
					
					// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ��� ���� �迭
					String[] row = new String[2];
					row[0] = date;
					row[1] = String.valueOf(diff);
					results[index] = row; // ���� �����ڸ� ���� �ش� �ڵ� ���� �� index�� �ٷ� 1�� ������
					
					System.out.println(Arrays.toString(results[index++]));

//					index++;
				}
			}		
		}

	}







	

}
