package ex07.상속.IS_A;

import java.awt.Frame;
import java.awt.Graphics;

public class MyFrame extends Frame {

	// 고쳐쓰기 위해서는 뼈대에서 뭘 바꿔야 고쳐쓸 수 있는지 알아야 함
	// 그래서 프레임워크 공부가 필요함
	@Override
	public void paint(Graphics g) {
		// 그림을 그릴 때 사용되는 도구
		g.drawLine(100, 100, 300, 300);
	}
	
}
