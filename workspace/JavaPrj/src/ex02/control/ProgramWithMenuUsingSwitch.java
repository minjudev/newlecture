package ex02.control;

import java.util.Scanner;

public class ProgramWithMenuUsingSwitch {

	public static void main(String[] args) {

		// 기본 형식
        int kor = 0;
        int eng = 0;
        int math = 0;
        int total;
        float avg;
        
        boolean more = true;
        Scanner scan = new Scanner(System.in);
        
        EXIT:
        while(true) {   
        	int menu;

        	// 메인 메뉴
	        System.out.println("┌───────────────────────────┐");
	        System.out.println("│          메인 메뉴          │");
	        System.out.println("└───────────────────────────┘");
	        
	        System.out.println("1. 성적 입력");
	        System.out.println("2. 성적 출력");
	        System.out.println("3. 종료");
	        System.out.print("선택 > ");
	        
	        // menu = scan.nextInt();
	        menu = Integer.parseInt(scan.nextLine());
	        
        	switch(menu) {
	        case 1: 
	        	// 성적 입력
		        System.out.println("┌───────────────────────────┐");
		        System.out.println("│          성적 입력          │");
		        System.out.println("└───────────────────────────┘");
		        
		        System.out.printf("국어: ");
		        kor = Integer.parseInt(scan.nextLine());
		
		        System.out.printf("영어: ");
		        eng = Integer.parseInt(scan.nextLine());
		        
		        System.out.printf("수학: ");
		        math = Integer.parseInt(scan.nextLine());
		        break;
		    	
	        case 2:
	        	// 성적 출력
	        	total = kor + eng + math;
	        	avg = total / 3.0f;

	        	System.out.println("┌───────────────────────────┐");
		        System.out.println("│          성적 출력          │");
		        System.out.println("└───────────────────────────┘");
		
		        System.out.printf("국어 : %d\n", kor);
		        System.out.printf("영어 : %d\n", eng);
		        System.out.printf("수학 : %d\n", math);
		        
		        System.out.printf("총점 : %d\n", total);
		        System.out.printf("평균 : %5.2f\n", avg);
		
		        System.out.println("─────────────────────────────");
		        break;
		        
	        case 3: 	
	        	// 종료
		        break EXIT;
        	}
	       
        }
        
        System.out.println("Bye!");        
	}

}
