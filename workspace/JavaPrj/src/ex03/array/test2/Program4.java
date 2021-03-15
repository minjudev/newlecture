package ex03.array.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) throws IOException {

//		["제주 검사진행자수" 컬럼의 총합을 구해보자.]						
		FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
		Scanner fscan = new Scanner(fis); 
		
		String line = fscan.nextLine();
		String[] words = line.split(",");
		System.out.println(Arrays.toString(words));
		
		int index = 0;
		for(int i=0; i<words.length; i++)
			if(words[i].equals("제주 검사진행자수")) {
				index = i;
			}
		
		int total = 0;
		while(fscan.hasNextLine()) {
			line = fscan.nextLine();
			String[] cases = line.split(",");
			
			int col = Integer.parseInt(cases[index]);
			total += col;
		}
		
		System.out.print(total);
	
		fscan.close();
		fis.close();
	
		}
		

}	

