package ex04.struct;

public class Program {

	public static void main(String[] args) {

		String[] row1 = new String[3];
		
		// 기본형이 아닌 모든 자료형은 변수 선언만으로 공간이 마련되지 않고, new라는 연산자를 통해 heap에 공간이 마련됨
		Covid19 row2 = new Covid19();
		
		row2.dead = 30;
		row2.positive = 30;
		row2.tests = 23;
		
		Covid19[] list = new Covid19[10]; // Covid19 클래스로 정의된 배열 요소가 10개 생성되고 해당 배열의 이름은 list
										  // 하지만 이 때, list 배열은 heap 영역에서 null을 가리키고 있음		
		
		// ------------------------------
		list[0] = new Covid19(); // 이렇게 list[0]에 Covid19 클래스를 할당해주기 전까진 list의 모든 요소들의 값이 null임 
								 // 해당 요소가 null을 가리키고 있다가 할당을 해주게 되면 null이 아닌 Covid19 클래스를 다시 가리키게 됨
		list[0].date = "";
		list[0].dead = 12;	
		
		// ------------------------------
		list[1] = new Covid19();
		list[1].date = "";
		list[1].dead = 12;
		
		
		// 위 방식보다 아래 방식이 더 나음
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
