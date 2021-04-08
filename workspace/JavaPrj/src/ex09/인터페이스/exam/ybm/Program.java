package ex09.인터페이스.exam.ybm;

public class Program {

	public static void main(String[] args) {

		YBMExam exam = new YBMExam(1,1,1,1,1);
		YBMExamConsole console = new YBMExamConsole();
		console.setExam(exam);
		console.setBanner(console);
		
		console.input();
		console.print();
	}

}
