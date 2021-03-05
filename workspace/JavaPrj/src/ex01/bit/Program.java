package ex01.bit;

import java.io.FileInputStream;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {

		// 이미지 파일을 읽기 위한 파일 입력 스트림
		FileInputStream fis = new FileInputStream("res/image.bmp");
		
		// read()는 1바이트씩 읽음
		// 파일 구조 상에서 signature를 읽어야 이미지의 파일 크기를 읽을 수 있음
		int b; // 2바이트
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
