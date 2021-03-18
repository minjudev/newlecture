package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray3 {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		String[][] rows;
		
		// ���ڵ� ������ �˾Ƴ��� �ڵ�
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
	
			while(fscan.hasNextLine()) {
				fscan.nextLine();
				count++;
			}
			
			fscan.close();
			fis.close();
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
				
//				rows[i][0];
//				rows[i][1];
//				rows[i][2];

				// ��ó�� �迭�� ǥ���ϴ� �ͺ��� �Ʒ�ó�� �ǹ̸� ���������� ����� ǥ���ϴ� ���� �������� �ǹ̸� Ȯ���� �� �� ����
				// �̸� ���� �ʿ��� ���� class(struct�� �ϴ� ���� �ڹٿ����� class�� �� �� ����)
				// class: ������ ���� ǥ��, ĸ��ȭ�� ���� ���
//				rows.date;
//				rows.positive;
//				rows.death;
				
			}
			
			fscan.close();
			fis.close();
		}
		
		
		// ���ڵ带 ����ϴ� �ڵ�
		for(int i=0; i<count; i++) {
			System.out.printf("%d - ", i+1);
			
			for(int j=0; j<10; j++) {
				System.out.printf("%s", rows[i][j]);
				
				if(j<9) 
					System.out.printf(", ");
			}
			
			System.out.println();			
		}
		
		System.out.println();	
		
		
		// �˻������� ���� ���� ��� �ڵ�
		{				
			int total = 0;

			for(int i=0; i<count; i++)
				total += Integer.parseInt(rows[i][3]); // ���������� rows�� �ٷ� �������� rows�� ��������� ������ �ٽ� �ٸ� �������� rows ���� ������ ������

			System.out.printf("�˻������� ���� ��: %d\n", total);
			System.out.println();	
		}
		
		
		// �Ϻ� ���� ���� �˻������� ���� �ش��ϴ� ���� ��¥��?
		{
			int max = 0;
			int current;
			int index = 0;
			String date = ""; // �ʱ�ȭ���ִ� ����: �ʱ�ȭ������ ������ date�� ���ǿ� ���� �ʾ� for, if�� ���� ���� �ʰ� �״�� ��µ��� ��� �ƹ� ���� ���� ��µǹǷ�
			
			for(int i=0; i<count; i++) {
				current = Integer.parseInt(rows[i][3]);
				if(current > max) { 
					max = current;  
//					index = i; // current�� max���� Ŭ ������ index�� ��µǹǷ� �̷��� �����ϸ� �ȵ�
//					System.out.println(index); 				
				}
			}
			
			for(int i=0; i<count; i++) {
				if(Integer.parseInt(rows[i][3]) == max) {
					index = i;
					break; // max�� ã������ �� ��ġ���� ������ �ϱ�
				}
			}
			
			System.out.printf("�Ϻ� �ִ� �˻������� ��: %d, �ش� ��¥: %s\n", max, rows[index][0]); 
			System.out.println();	
		}
		
		
		// Ȯ���� ���� �þ ��¥�� ������ Ȯ���� ���� ����Ͻÿ�.		
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
