package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program3MultiArray2 {

	public static void main(String[] args) throws IOException {
		
		String[][] rows = new String[2][]; // �� �迭�� ũ��([2][v])�� ������ ������ �迭�� ��� ������ �ϴ� 2���� �������
										   // 1���� �迭�� ��� ������ �̸�(rows)�� ������ �ؼ� �ϰ� ó�� �����ϰ� ��
			
		FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Downloads\\����Ư����ġ��_�ڷγ���Ȳ_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		for(int i=0; i<2; i++) {
			line = fscan.nextLine();
			rows[i] = line.split(","); // line.split(",") �� ���� rows��� ���� ������ �̸����� �����ְڴ�
		}
		
		for(int j=0; j<2; j++) {
			for(int i=0; i<10; i++) {
				System.out.printf("%s", rows[j][i]);
				
				if(i<9) 
					System.out.printf(", ", rows[j][i]);
			}
		
			System.out.println();	
		}
		
		fis.close();
		fscan.close();
		
	}

}
