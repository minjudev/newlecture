package ex02.control;

import java.util.Scanner;

public class ProgramWithMenuUsingSwitch2 {

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
	        
	        menu = Integer.parseInt(scan.nextLine());
	        
        	switch(menu) {
	        case 1: 
	        	// ���� �Է�
		        System.out.println("����������������������������������������������������������");
		        System.out.println("��          ���� �Է�          ��");
		        System.out.println("����������������������������������������������������������");
		
		        do {
		        	System.out.printf("����: ");
			        kor = scan.nextInt(); 
			        
			        if(kor < 0 || 100 < kor) {
			        	System.out.println("0 ~ 100 ������ ���� �Է��� �� �ֽ��ϴ�.");  
			        }
		        } while (kor < 0 || 100 < kor);
		     
		        System.out.printf("����: ");
		        eng = scan.nextInt(); 
		        
		        System.out.printf("����: ");
		        math = scan.nextInt(); 
		        break;
		    	
	        case 2:
	        	// ���� ���
	        	total = kor + eng + math;
	        	avg = total / 3.0f;

	        	System.out.println("����������������������������������������������������������");
		        System.out.println("��          ���� ���          ��");
		        System.out.println("����������������������������������������������������������");
		
		        for(int i = 0; i < 3; i++) {
		        	System.out.printf("���� : %d\n", kor);
		        	System.out.printf("���� : %d\n", eng);
		        	System.out.printf("���� : %d\n", math);
		        	
		        	System.out.printf("���� : %d\n", total);
		        	System.out.printf("��� : %5.2f\n", avg);
		        	
		        	System.out.println("����������������������������������������������������������");
		        	
		        }
		        
		        break;
		        
	        case 3: 	
	        	// ����
		        break EXIT;
        	}
	       
        }
        
        System.out.println("Bye!");        
	}

}
