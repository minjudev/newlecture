package ex02.control;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		// �⺻ ����
        int kor, eng, math;
        int total;
        float avg;
        
        boolean more = true;
        
        while(more) {
        	
	        Scanner scan = new Scanner(System.in);
	        
	        // ���� �Է�
	        System.out.println("����������������������������������������������������������");
	        System.out.println("��          ���� �Է�          ��");
	        System.out.println("����������������������������������������������������������");
	        
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
	        
	        System.out.println("��� �����ұ��? (true / false)");
	        more = scan.nextBoolean();
        }
        
        System.out.println("Bye!");
     
	}

}
