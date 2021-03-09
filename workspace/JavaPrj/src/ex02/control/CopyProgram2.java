package ex02.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyProgram2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/image.bmp");
		FileOutputStream fos = new FileOutputStream("res/copy_image.bmp");
		
//		while((b = fis.read()) != -1) 
//			fos.write(b);
		
		int b;
		do {
			b = fis.read();
			if(b != -1) {
				fos.write(b);
			}
		} while(b != -1);
		
		fis.close();
		fos.close();
		
		System.out.print("이미지 복사 완료!");
	}
}
