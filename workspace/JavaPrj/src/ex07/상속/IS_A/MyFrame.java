package ex07.���.IS_A;

import java.awt.Frame;
import java.awt.Graphics;

public class MyFrame extends Frame {

	// ���ľ��� ���ؼ��� ���뿡�� �� �ٲ�� ���ľ� �� �ִ��� �˾ƾ� ��
	// �׷��� �����ӿ�ũ ���ΰ� �ʿ���
	@Override
	public void paint(Graphics g) {
		// �׸��� �׸� �� ���Ǵ� ����
		g.drawLine(100, 100, 300, 300);
	}
	
}
