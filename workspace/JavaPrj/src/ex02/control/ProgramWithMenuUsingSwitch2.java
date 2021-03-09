package ex02.control;

import java.util.Scanner;

public class ProgramWithMenuUsingSwitch2 {

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
	        
	        menu = Integer.parseInt(scan.nextLine());
	        
        	switch(menu) {
	        case 1: 
	        	// 성적 입력
		        System.out.println("┌───────────────────────────┐");
		        System.out.println("│          성적 입력          │");
		        System.out.println("└───────────────────────────┘");
		
		        do {
		        	System.out.printf("국어: ");
			        kor = scan.nextInt(); 
			        
			        if(kor < 0 || 100 < kor) {
			        	System.out.println("0 ~ 100 범위의 값만 입력할 수 있습니다.");  
			        }
		        } while (kor < 0 || 100 < kor);
		     
		        System.out.printf("영어: ");
		        eng = scan.nextInt(); 
		        
		        System.out.printf("수학: ");
		        math = scan.nextInt(); 
		        break;
		    	
	        case 2:
	        	// 성적 출력
	        	total = kor + eng + math;
	        	avg = total / 3.0f;

	        	System.out.println("┌───────────────────────────┐");
		        System.out.println("│          성적 출력          │");
		        System.out.println("└───────────────────────────┘");
		
		        for(int i = 0; i < 3; i++) {
		        	System.out.printf("국어 : %d\n", kor);
		        	System.out.printf("영어 : %d\n", eng);
		        	System.out.printf("수학 : %d\n", math);
		        	
		        	System.out.printf("총점 : %d\n", total);
		        	System.out.printf("평균 : %5.2f\n", avg);
		        	
		        	System.out.println("─────────────────────────────");
		        	
		        }
		        
		        break;
		        
	        case 3: 	
	        	// 종료
		        break EXIT;
        	}
	       
        }
        
        System.out.println("Bye!");        
	}

}
