package ex08.�߻�ȭ.����;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new YBMExam(1,1,1,1,1);
				
		// �����ڿ� ���� �ȴ� ��(��ǰ�� �����ִ� ��), ��ü�� ó�� ���� ���� ��ǰ �����ֱ� ����
		// ������ ���Ӽ� ����: Constructor DI
		// DI: Dependency(���Ӽ�), Injection(����) 
//		ExamConsole console = new ExamConsole(exam);
		
		// �ٸ� ��ü�� �ٲٰ� ���� ��쿡 setter�� �̿��� ��ü�� �ٲ� �� ����
		// Setter DI
//		console.setExam(exam);
//		console.print();
		
		YBMExamConsole ybmConsole = new YBMExamConsole();
		ybmConsole.setExam(exam);
				
		ybmConsole.input();
		ybmConsole.print();
			
		
		// ����и�: ����
		// �׸�, ����, ��, ���� �׷�����
		// �׸�, ����, ��, ������ ����и��� ������ �̾Ƴ� -> �߻� Ŭ���� ��üȭ�ϸ� X
		
		// ����и�: ���� ���α׷�
		// ���� ����б�, YBM ����б� ���� ���α׷�
		// ó�� ���� ���� ���α׷��� ����ȭ�ؼ� �ٸ� � ����б� ���� ���α׷��� �͵� �׿� �´� ���α׷��� ����� �ϱ� -> �߻� Ŭ���� ��üȭ�ص� O
		// ���� ���� ���α׷��� ������� �� �� ����� �������� ������ �߻�
		
		// �߻�ȭ�� ������� Ŭ������ Ư¡
		// 1. �߻� Ŭ������ �����̹Ƿ� ����� ��üȭ�Ǿ�� �ȵ� -> ����и� ������ ��üȭ�� ������ �����ϱ�
		// 2. �߻� Ŭ������ �����̹Ƿ� �ݵ�� �������ؾ� �ϴ� �޼ҵ尡 ����
		// -> �� ���� ��������� abstract Ű���带 ����� �ذ� ����
		
//		Exam exam = new YBMExam(1,1,1,1);
//		System.out.println(exam.avg());
		
		// ���������� �θ� �ڷ������� �θ� avg() �Լ��� �ϰ� ó�� ����
//		Exam[] exams = new Exam[2];
//		
//		exams[0] = new YBMExam(1,1,1,1);
//		exams[1] = new NewExam(2,2,2,2);
//		
//		for(int i=0; i<2; i++)
//			// avg() �Լ� �ϰ� ó�� ����
//			System.out.println(exams[i].avg());
		
				
	}

}
