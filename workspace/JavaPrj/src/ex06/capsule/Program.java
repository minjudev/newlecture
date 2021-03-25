package ex06.capsule;

public class Program {
	
	// 로또 출력
	private static void print(int[] lotto) {
		System.out.print("로또 번호: ");
		
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i]);
			
			if(i < 5)
				System.out.print(", ");
		}	
	}

	public static void main(String[] args) { // main 함수에는 앞으로 계속 재사용할 함수들만 두기

		int[] lotto;
		
		// 로또를 만들고
		lotto = LottoProgram.gen(); // 다른 클래스에 있는 함수를 사용할 때는 앞에 클래스 이름을 명시해야 함
		
		// 로또 출력하기
		print(lotto);
		
		System.out.println();
		
		// 로또를 정렬하고
		LottoProgram.sort(lotto);
		
		// 로또 출력하기
		print(lotto);
	}

}
