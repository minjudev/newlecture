package ex02.control;

import java.util.Scanner;

public class ProgramWithMenuUsingSwitch {

	public static void main(String[] args) {

		// �⺻ ����
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

        	// ���� �޴�
	        System.out.println("����������������������������������������������������������");
	        System.out.println("��          ���� �޴�          ��");
	        System.out.println("����������������������������������������������������������");
	        
	        System.out.println("1. ���� �Է�");
	        System.out.println("2. ���� ���");
	        System.out.println("3. ����");
	        System.out.print("���� > ");
	        
	        // menu = scan.nextInt();
	        menu = Integer.parseInt(scan.nextLine());
	        
        	switch(menu) {
	        case 1: 
	        	// ���� �Է�
		        System.out.println("����������������������������������������������������������");
		        System.out.println("��          ���� �Է�          ��");
		        System.out.println("����������������������������������������������������������");
		        
		        System.out.printf("����: ");
		        kor = Integer.parseInt(scan.nextLine());
		
		        System.out.printf("����: ");
		        eng = Integer.parseInt(scan.nextLine());
		        
		        System.out.printf("����: ");
		        math = Integer.parseInt(scan.nextLine());
		        break;
		    	
	        case 2:
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
		        break;
		        
	        case 3: 	
	        	// ����
		        break EXIT;
        	}
	       
        }
        
        System.out.println("Bye!");        
	}

}
