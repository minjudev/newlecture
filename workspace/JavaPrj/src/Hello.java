import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

class Hello {
    public static void main(String[] args) throws IOException {
        
    	// �⺻ ����
        int kor, eng, math;
        int total;
        float avg;
        
        
        // ���� �Է�
        System.out.println("����������������������������������������������������������");
        System.out.println("��          ���� �Է�          ��");
        System.out.println("����������������������������������������������������������");
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("����: ");
        kor = scan.nextInt();

        System.out.printf("����: ");
        eng = scan.nextInt();
        
        System.out.printf("����: ");
        math = scan.nextInt();

        total = kor + eng + math;
        avg = total / 3.0f;
        

        // ���� ���
        System.out.println("����������������������������������������������������������");
        System.out.println("��          ���� ���          ��");
        System.out.println("����������������������������������������������������������");

        System.out.printf("���� : %d\n", kor);
        System.out.printf("���� : %d\n", eng);
        System.out.printf("���� : %d\n", math);
        
        System.out.printf("���� : %d\n", total);
        System.out.printf("��� : %5.2f\n", avg);

        System.out.println("����������������������������������������������������������");
        
        
        // ���� �Է�
        // data.txt ���Ͽ��� ����, ����, ���� ���� �Է� �ޱ�
        FileInputStream fis = new FileInputStream("C:\\Users\\�̹���\\Desktop\\coding\\2021-02\\workspace\\data.txt");
        Scanner scan1 = new Scanner(fis);
        kor = scan1.nextInt(); 
        eng = scan1.nextInt(); 
        math = scan1.nextInt();
        scan1.close(); // scanner���� ���� �ݾ��شٰ� �˷���� ��
        fis.close(); // �� �Ŀ� ������ �ݾ���
        
        
        // ���� ���
        FileOutputStream fos = new FileOutputStream("C:\\Users\\�̹���\\Desktop\\coding\\2021-02\\workspace\\data.txt");
        PrintStream fout = new PrintStream(fos); // system.out�� �ֿܼ� ����� �ϴ� ����
        kor++; 
        eng--; 
        
        fout.printf("%d %d %d", kor, eng, math); // Printstream �ȿ� system.out�� ����
        fout.close();
        fos.close();
                
    }
}