package ex04.struct;

public class Program_practice {

	public static void main(String[] args) {

		Covid19[] list = new Covid19[10];
		Covid19 row = new Covid19();
				
		list[0] = row;
		row.date = "2020";
		row.dead = 23;
		row.positive = 1;
		
		System.out.println(row.date);
		System.out.println(row.dead);
		System.out.println(row.positive);
	}

}
