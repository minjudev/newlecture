package ex02.control;

import java.util.Scanner;

public class ProgramWithMenu {

	public static void main(String[] args) {

		// �⺻ ����
        int kor = 0;
        int eng = 0;
        int math = 0;
        int total;
        float avg;
        
        boolean more = true;
        Scanner scan = new Scanner(System.in);
        
        while(more) {        	
        	int menu;
	        
	        // ���� �޴�
	        System.out.println("����������������������������������������������������������");
	        System.out.println("��          ���� �޴�          ��");
	        System.out.println("����������������������������������������������������������");
	        
	        System.out.println("1. ���� �Է�");
	        System.out.println("2. ���� ���");
	        System.out.println("3. ����");
	        System.out.print("���� > ");
	        
	        menu = scan.nextInt();
	        // menu = Integer.parseInt(scan.nextLine());
	        if(menu == 1) {
	        	
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
		    	
	        } else if(menu == 2) {
	        	
	        	// ���� ���
	        	total = kor + eng + math;
	        	avg = total / 3.0f;

	        	System.out.println("����������������������������������������������������������");
		        System.out.println("��          ���� ���          ��");
		        System.out.println("����������������������������������������������������������");
		
		        System.out.printf("���� : %d\n", kor);
		        System.out.printf("���� : %d\n", eng);
		        System.out.printf("���� : %d\n", math);
		        
		        System.out.printf("���� : %d\n", total);
		        System.out.printf("��� : %5.2f\n", avg);
		
		        System.out.println("����������������������������������������������������������");
	        
	        } else {
	        	
	        	// ����
		        more = false;

	        } 
	        // System.out.println("��� �����ұ��? (true / false)");
	        // more = scan.nextBoolean();
        }
        
        System.out.println("Bye!");
        
	}

}
