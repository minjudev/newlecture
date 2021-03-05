package ex02.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyProgram {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/image.bmp");
		FileOutputStream fos = new FileOutputStream("res/copy_image.bmp");
		
		int b = 0; 
		while((b = fis.read()) != -1) 
			fos.write(b);
		
		fis.close();
		fos.close();
		
		System.out.print("이미지 복사 완료!");
	}
}
