package ex03.array.test2;

import java.util.Arrays;
import java.util.Random;

public class Program2 {

	public static void main(String[] args) {

		String[] names = new String[] {"��ȣ��", "���缮", "����", "����ȣ", "������", "������", "�ڹ���"};
				
		String n = new String("hello"); // new �����ڷ� "hello"��� String ��ü�� ����� n(��������)�̶�� �̸��� �ٿ���
		String nn = "hello"; // �ܼ��� ���ڿ��� �ƴ϶� ���ڿ��� ǰ�� �ִ� Ŀ�ٶ� ����
		// �� ����("hello")�� ����ؼ� ���ڿ��� ���� ������ �� �� ����, ���ڿ�("hello")�� String ��ü
		
		String n1 = "ȫ�浿"; // �̷��� �ᵵ �����δ� n3, n4ó�� ��ü�� �����
		String n2 = "ȫ�浿";
		String n3 = new String("ȫ�浿");
		String n4 = new String("ȫ�浿");

		System.out.println(n1 == n2); // true : ��ü�� ���ϴ� ���� ������ ���� ������� ���� ��ü�� �����ϱ� ������ true ��ȯ
		System.out.println(n1.equals(n2));
		System.out.println(n3 == n4); // false : ���ڿ��� �ƴ� ��ü�� ��(�� ��ü�� ���� �ٸ� ��ü)
		System.out.println(n3.equals(n4)); // true: ��ü�� �ƴ� ���ڿ��� ���� ��
		
		String fileName = "photo.jpg";
		System.out.println(fileName.length());
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.substring(0, 5));
		System.out.println(fileName.substring(6));
		
		int dot = fileName.indexOf(".");
		System.out.print(fileName.substring(0, dot));
		System.out.println();

		
		System.out.println(fileName.compareTo("photo.jpg"));
		
		
//		-------------------------------------------------------------------
		
		
		Random rand = new Random();
		
		// �� �ε��� ��ġ �� �ٲٱ�
		for(int i=0; i<100; i++) { 
			int idx1 = rand.nextInt(7); // ������(0 ~ 6) ���
			int idx2 = rand.nextInt(7); // ������(0 ~ 6) ���
			
			String temp;
			temp = names[idx1];
			names[idx1] = names[idx2];
			names[idx2] = temp;
		}
			
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"", names[i]);
			
			if(i < 6) 
				System.out.print(", ");
		}	
		
		System.out.println();
			
				
		// ���������ؼ� ������� �̸� ����ϱ�
		for(int j=0; j<6; j++) 
			for(int i=0; i<7-1-j; i++) 
				if(names[i].compareTo(names[i+1]) > 0) {
					String temp;
					temp = names[i];
					names[i] = names[i+1];
					names[i+1] = temp;
				}
			
		
		for(int i=0; i<7; i++) {
			System.out.printf("\"%s\"", names[i]);
			
			if(i < 6) 
				System.out.printf(", ");
		}
		
	}
		
}

