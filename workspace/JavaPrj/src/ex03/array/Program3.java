package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) throws IOException {
		
		String[] row1;
		String[] row2;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Downloads\\제주특별자치도_코로나현황_20201214.csv");
		Scanner fscan = new Scanner(fis);
		
		String line = fscan.nextLine();
		
		line = fscan.nextLine();
		row1 = line.split(",");
	
		line = fscan.nextLine();
		row2 = line.split(",");
		
		for(int i=0; i<10; i++) {
			System.out.printf("%s", row1[i]);
			
			if(i<9) 
				System.out.printf(", ", row1[i]);
		}
		
		System.out.println();
		
		for(int i=0; i<10; i++) {
			System.out.printf("%s", row2[i]);
			
			if(i<9) 
				System.out.printf(", ", row2[i]);	
		}
		
		fis.close();
		fscan.close();
		
	}

}
