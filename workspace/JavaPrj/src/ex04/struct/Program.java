package ex04.struct;

public class Program {

	public static void main(String[] args) {

		String[] row1 = new String[3];
		
		// �⺻���� �ƴ� ��� �ڷ����� ���� �������� ������ ���õ��� �ʰ�, new��� �����ڸ� ���� heap�� ������ ���õ�
		Covid19 row2 = new Covid19();
		
		row2.dead = 30;
		row2.positive = 30;
		row2.tests = 23;
		
		Covid19[] list = new Covid19[10]; // Covid19 Ŭ������ ���ǵ� �迭 ��Ұ� 10�� �����ǰ� �ش� �迭�� �̸��� list
										  // ������ �� ��, list �迭�� heap �������� null�� ����Ű�� ����		
		
		// ------------------------------
		list[0] = new Covid19(); // �̷��� list[0]�� Covid19 Ŭ������ �Ҵ����ֱ� ������ list�� ��� ��ҵ��� ���� null�� 
								 // �ش� ��Ұ� null�� ����Ű�� �ִٰ� �Ҵ��� ���ְ� �Ǹ� null�� �ƴ� Covid19 Ŭ������ �ٽ� ����Ű�� ��
		list[0].date = "";
		list[0].dead = 12;	
		
		// ------------------------------
		list[1] = new Covid19();
		list[1].date = "";
		list[1].dead = 12;
		
		
		// �� ��ĺ��� �Ʒ� ����� �� ����
		Covid19 row;
		row = new Covid19();
		row.date = "2020";
		row.dead = 20;
		
		// ------------------------------
		list[0] = row;
		row = new Covid19();
		row.date = "2020";
		row.dead = 20;
		
		// ------------------------------
		list[1] = row;
		row = new Covid19();
		row.date = "2020";
		row.dead = 20;
	}

}
