package ex04.struct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		
		// 레코드 개수를 알아내는 코드
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
			Scanner fscan = new Scanner(fis);
			
			String line = fscan.nextLine();
	                                       
			while(fscan.hasNextLine()) {   
				fscan.nextLine();          
				count++;                   
			}                              
			                               
			fscan.close();                 
			fis.close();                   
		}
		
		
		// Covid19를 로드하는 코드		
		Covid19[] list = new Covid19[count];
		
		{			
			FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
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
		
		
		// 레코드를 출력하는 코드
		for(int i=0; i<count; i++) {
			// Covid 한 줄을 출력하자.
			Covid19 covid = list[i]; // list[i]에 담긴 값을 새로 정의한 변수 covid에 대입
			System.out.printf("%s, %d, %d, %d, %d, %d, %d, %d, %d, %s", 
					covid.date, // list로 변경해서 이전과 같은 결과가 출력되도록 하시오.
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
//		// 기본형이 아닌 모든 자료형은 변수 선언만으로 공간이 마련되지 않고, new라는 연산자를 통해 heap에 공간이 마련됨
//		Covid19 row2 = new Covid19();
//		row2.dead = 30;
//		row2.cases = 30;
//		row2.tests = 23;
//										 
//		Covid19[] list = new Covid19[10]; // Covid19 클래스 형식으로 정의된 배열 요소가 10개 생성되고 해당 배열의 이름은 list
//										  // 하지만 이 때, list 배열은 heap 영역에서 null을 가리키고 있음		
//		
//		// ------------------------------
//		list[0] = new Covid19(); // 이렇게 list[0]에 Covid19 클래스를 할당해주기 전까진 list의 모든 요소들의 값이 null임 
//								 // 해당 요소가 null을 가리키고 있다가 할당을 해주게 되면 null이 아닌 Covid19 클래스를 다시 가리키게 됨
//		list[0].date = "";
//		list[0].dead = 12;	
//		
//		// ------------------------------
//		list[1] = new Covid19();
//		list[1].date = "";
//		list[1].dead = 12;
//		
//		
//		// 위 방식보다 아래 방식이 더 나음
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
