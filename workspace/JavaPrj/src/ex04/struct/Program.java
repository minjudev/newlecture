package ex04.struct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		
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
		
		
		// Covid19�� �ε��ϴ� �ڵ�		
		Covid19[] list = new Covid19[count];
		
		{			
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
				
//				System.out.println(covid);
			}
			
			fscan.close();
			fis.close();
		}
		
		
		// ���ڵ带 ����ϴ� �ڵ�
		for(int i=0; i<count; i++) {
			// Covid �� ���� �������.
			Covid19 covid = list[i]; // list[i]�� ��� ���� ���� ������ ���� covid�� ����
			System.out.printf("%s, %d, %d, %d, %d, %d, %d, %d, %d, %s", 
					covid.date, // list�� �����ؼ� ������ ���� ����� ��µǵ��� �Ͻÿ�.
					covid.cases,
					covid.dead,
					covid.tests,
					covid.selfIsolation,
					covid.release,
					covid.recover,
					covid.selfIsolationDomestic,
					covid.selfIsolationOverseas,
					covid.pubDate); 
			
			System.out.println();			
		}		
		                      
		System.out.println();				
                              
		

//		String[] row1 = new String[3];
//		
//		// �⺻���� �ƴ� ��� �ڷ����� ���� �������� ������ ���õ��� �ʰ�, new��� �����ڸ� ���� heap�� ������ ���õ�
//		Covid19 row2 = new Covid19();
//		row2.dead = 30;
//		row2.cases = 30;
//		row2.tests = 23;
//										 
//		Covid19[] list = new Covid19[10]; // Covid19 Ŭ���� �������� ���ǵ� �迭 ��Ұ� 10�� �����ǰ� �ش� �迭�� �̸��� list
//										  // ������ �� ��, list �迭�� heap �������� null�� ����Ű�� ����		
//		
//		// ------------------------------
//		list[0] = new Covid19(); // �̷��� list[0]�� Covid19 Ŭ������ �Ҵ����ֱ� ������ list�� ��� ��ҵ��� ���� null�� 
//								 // �ش� ��Ұ� null�� ����Ű�� �ִٰ� �Ҵ��� ���ְ� �Ǹ� null�� �ƴ� Covid19 Ŭ������ �ٽ� ����Ű�� ��
//		list[0].date = "";
//		list[0].dead = 12;	
//		
//		// ------------------------------
//		list[1] = new Covid19();
//		list[1].date = "";
//		list[1].dead = 12;
//		
//		
//		// �� ��ĺ��� �Ʒ� ����� �� ����
//		Covid19 row;
//		row = new Covid19();
//		row.date = "2020";
//		row.dead = 20;
//		
//		// ------------------------------
//		list[0] = row;
//		row = new Covid19();
//		row.date = "2020";
//		row.dead = 20;
//		
//		// ------------------------------
//		list[1] = row;
//		row = new Covid19();
//		row.date = "2020";
//		row.dead = 20;
	}

}
