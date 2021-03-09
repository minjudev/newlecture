package ex03.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyProgram {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/image.bmp");
		FileOutputStream fos = new FileOutputStream("res/copy_image.bmp");
		
		int size = 0; 
				
		byte[] buf = new byte[1000];
		
		while((size = fis.read(buf)) != -1) // fis.read(buf)�� �о���� ����Ʈ �� ��ȯ
			fos.write(buf);
		
		fis.close();
		fos.close();
		
		System.out.print("�̹��� ���� �Ϸ�!");
	}
}
