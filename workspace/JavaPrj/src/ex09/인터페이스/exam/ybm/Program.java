package ex09.�������̽�.exam.ybm;

public class Program {

	public static void main(String[] args) {

		YBMExam exam = new YBMExam();
		YBMExamConsole console = new YBMExamConsole();
		console.setExam(exam);
		
		// import�� ���� ������ XXX �տ� �ƿ��� Ŭ����(YBMExamConsole)�� �̸��� ������־�� ��
		// �̳� Ŭ������ �ƿ��� Ŭ������ ���ؼ� ��������� ��
		// ��ü�� ������ �ִ� new��� �����ڸ� ����ؼ� �̳� Ŭ������ ������
		// YBMExamConsole.XXX x = console.new XXX();
		
		// setBanner�� �ȾƳְ� �� Ŭ������ �ƿ��� Ŭ���� �ȿ� �ִ� �̳� Ŭ������
		// console.setBanner(x);
		
		console.input();
		console.print();
	}

}

/*
 * �������̽�: �繰 �Ǵ� ������ �̾��ִ� ����
 * �ڹ� �������̽�: ��ü�� ��ü�� �̾��ִ� ���� 
 * 
 * �������̽��� ���ؼ� �����ϰ� �����ϰ� ����ϴ� ������ ������ �Ǹ�?
 * �������� �߻�
 * 
 * �Ϻ� ������ �������̽��� ���ǵȴ�?
 * A Ŭ������ �������̽��� �����Ͽ���.
 * 
 * �������̽��� �����ϴ� ����� 4������ ����� �� �ִ�.
 * 1. �ܺ� Ŭ������ ����
 * 2. ���� Ŭ������ ����
 * 3. �޼ҵ� ���� ��ø Ŭ������ ����
 * 4. �͸� Ŭ������ ����
 * 5. ���ٽ��� �̿��� ���� 
 * 
*/
