package ex02.control;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		// 기본 형식
        int kor, eng, math;
        int total;
        float avg;
        
        boolean more = true;
        
        while(more) {
        	
	        Scanner scan = new Scanner(System.in);
	        
	        // 성적 입력
	        System.out.println("┌───────────────────────────┐");
	        System.out.println("│          성적 입력          │");
	        System.out.println("└───────────────────────────┘");
	        
	        System.out.printf("국어: ");
	        kor = scan.nextInt();
	
	        System.out.printf("영어: ");
	        eng = scan.nextInt();
	        
	        System.out.printf("수학: ");
	        math = scan.nextInt();
	
	        total = kor + eng + math;
	        avg = total / 3.0f;
	        
	
	        // 성적 출력
	        System.out.println("┌───────────────────────────┐");
	        System.out.println("│          성적 출력          │");
	        System.out.println("└───────────────────────────┘");
	
	        System.out.printf("국어 : %d\n", kor);
	        System.out.printf("영어 : %d\n", eng);
	        System.out.printf("수학 : %d\n", math);
	        
	        System.out.printf("총점 : %d\n", total);
	        System.out.printf("평균 : %5.2f\n", avg);
	
	        System.out.println("─────────────────────────────");
	        
	        System.out.println("계속 진행할까요? (true / false)");
	        more = scan.nextBoolean();
        }
        
        System.out.println("Bye!");
     
	}

}
