package ex06.ĸ��ȭ.lotto.��ü����.������;

import java.util.Random;

public class Lotto {
						
	private int[] nums; 
	private int size;
	
	// 1. �ʱ�ȭ�� �� �� ���� ����Ǳ� ���Ѵ�.
	// 2. �ʱ�ȭ�� �Ӽ��� ���Ǳ� ������ ����Ǳ� ���Ѵ�. 
	// 	(= �ٸ� � �������� ���� ���� ����Ǳ� ���Ѵ�.)
	// ���� �� ������ �����ϰ� ���ִ� ���� => Constructor(������): �ʱ�ȭ �Լ�
	// ������: �Լ� ���¸� ��������, �Լ�ó�� ��������� �̸��� ������ ���� �ʱ� ������ �Լ�ó�� ȣ���� �� ����
	// �̸��� ����, ��ȯ Ÿ�Ե� ����, ��� ������(Lotto)�� ��
	public Lotto() { // Lotto��� ������ ���� �� �¾ ��ü���� ���� ȣ���� �� �ִٴ� �ǹ�
		size = 6;    
		nums = new int[size];
	}
	
//	public void init() {
//		nums = new int[size];
//	}
	
	public int getSize() {
		return size;
	}
	
	// private ���� nums�� ������ ������ �� �ִ� ������� �Լ� �����
	public int getNum(int i) {
		int number = nums[i];
		return number;
	}
	
	// �ζ� ����
	public void gen() { // generate �Լ������� ��ü�� �ƴ� ���� �����ϰ� ����
		Random rand = new Random();
		
		for(int i=0; i<size; i++) { // size�� this�� �ִ� ������� �� ���� private int size�� ����Ű�� �� �ƴ� 
									// private int size�� ���� �����ϴ� �� �ƴ�, lotto ��ü�� ������ �Ŀ� �� ��ü�� ������ �ִ� size�� ���� ����
									// private int size�� ���赵�� ������ �ű⿡ ���� ä�� �� ����
			int number = rand.nextInt(45) + 1;
			nums[i] = number; 
		}
	}
	
	// �ζ� ����
	// ��ü�������� ǥ�������� �ٲ� �Լ�
	// ��ü�� ����ϴ� �Լ�: Objected function / Instance function / Method
	public void sort() { 
		for(int i=0; i<size-1; i++) 	
			for(int j=0; j<size-1-i; j++) 			
				if(nums[j] > nums[j+1]) {
					int temp;
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}	
	}
	
	
	
	
	
	
	
	
	
	
	
}
