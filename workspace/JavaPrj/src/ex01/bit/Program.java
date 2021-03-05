package ex01.bit;

import java.io.FileInputStream;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {

		// �̹��� ������ �б� ���� ���� �Է� ��Ʈ��
		FileInputStream fis = new FileInputStream("res/image.bmp");
		
		// read()�� 1����Ʈ�� ����
		// ���� ���� �󿡼� signature�� �о�� �̹����� ���� ũ�⸦ ���� �� ����
		int b; // 2����Ʈ
		b = fis.read();
		b = fis.read();
		
		// fileSize
		int b1 = fis.read(); 
		int b2 = fis.read(); 
		int b3 = fis.read();
		int b4 = fis.read();
		
		int fileSize = 0; 
//		fileSize = b1; // [][][][b1];
//		fileSize = b2; // [][][][b2];
//		fileSize = b3; // [][][][b3];
//		fileSize = b4; // [][][][b4];
		
		fileSize = (b4 & 0x000000ff) << 8*3 | // [b4][][][];
				   (b3 & 0x000000ff) << 8*2 | // [b4][b3][][];
		           (b2 & 0x000000ff) << 8*1 | // [b4][b3][b2][];
		           (b1 & 0x000000ff);		  // [b4][b3][b2][b1];
				
		System.out.println(Integer.toBinaryString(b4));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b1));
		
		System.out.printf("file size: %d\n", fileSize);	
		
		fis.close();
	}

}
