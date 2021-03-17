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
		
		// ���ڵ� ������ �˾Ƴ��� �ڵ�
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
			
			while(fscan.hasNextLine()) {
				line = fscan.nextLine();
				
				count++;
			}
			
			fscan.close();
			fis.close();
			
			System.out.printf("�� ���� ����: %d\n", count);
			System.out.println();
		}
		
		
		// ���ڵ带 �ε��ϴ� �ڵ�
		{
			rows = new String[count][];
			
			FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
			
			for(int i=0; i<count; i++) {
				line = fscan.nextLine();
				rows[i] = line.split(",");
			}
			
			fscan.close();
			fis.close();			
		}
		
		
		// ���ڵ带 ����ϴ� �ڵ�
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
		
		
		// �˻������� ���� ���� ��� �ڵ�
		{		
			int total = 0;
			
			for(int i=0; i<count; i++) 
				total += Integer.parseInt(rows[i][3]);
			
			System.out.printf("�˻������� ���� ��: %d\n", total);
		}
		
		System.out.println();		

		
		// �Ϻ� ���� ���� �˻������� ���� �ش��ϴ� ���� ��¥��?
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

			System.out.printf("�Ϻ� ���� ���� �˻������� ��: %d, �ش� ��¥: %s\n", max, date);
		}
		
		System.out.println();		

		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ����Ͻÿ�.
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
					
					System.out.printf("%d - ��¥: %s, ������ Ȯ���� ��: %d\n", ++index, date, diff);
				}
			}	
		}
		
		System.out.println();		
		
		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ���� �迭�� �����ÿ�.
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
			
			System.out.printf("������ Ȯ���� ���� �߻��� ��¥�� ��: %d", resultCount);
		
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
