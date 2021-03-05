import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
        
        
        // 파일 입력
        // data.txt 파일에서 국어, 영어, 수학 성적 입력 받기
        FileInputStream fis = new FileInputStream("C:\\Users\\이민주\\Desktop\\coding\\2021-02\\workspace\\data.txt");
        Scanner scan1 = new Scanner(fis);
        kor = scan1.nextInt(); 
        eng = scan1.nextInt(); 
        math = scan1.nextInt();
        scan1.close(); // scanner에게 먼저 닫아준다고 알려줘야 함
        fis.close(); // 그 후에 파일을 닫아줌
        
        
        // 파일 출력
        FileOutputStream fos = new FileOutputStream("C:\\Users\\이민주\\Desktop\\coding\\2021-02\\workspace\\data.txt");
        PrintStream fout = new PrintStream(fos); // system.out은 콘솔에 출력을 하는 역할
        kor++; 
        eng--; 
        
        fout.printf("%d %d %d", kor, eng, math); // Printstream 안에 system.out이 있음
        fout.close();
        fos.close();
                
    }
}