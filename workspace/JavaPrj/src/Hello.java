import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Hello {
    public static void main(String[] args) throws IOException {
        
    	// 기본 형식
        int kor, eng, math;
        int total;
        float avg;
        
        // 성적 입력
        System.out.println("┌───────────────────────────┐");
        System.out.println("│          성적 입력          │");
        System.out.println("└───────────────────────────┘");
        
        Scanner scan = new Scanner(System.in);
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
        
        // 파일 입출력
        FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Desktop\\coding\\2021-02\\workspace\\JavaPrj\\data.txt");
        Scanner scan1 = new Scanner(fis);
        kor = scan1.nextInt(); 
        eng = scan1.nextInt(); 
        math = scan1.nextInt();
        System.out.printf("국어 : %d\n", kor);
        System.out.printf("영어 : %d\n", eng);
        System.out.printf("수학 : %d\n", math);
        
    }
}