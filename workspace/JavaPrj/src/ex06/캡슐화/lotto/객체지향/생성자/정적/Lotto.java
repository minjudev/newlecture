package ex06.ĸ��ȭ.lotto.��ü����.������.����;

import java.util.Random;

public class Lotto {
	
	// �ν��Ͻ� ����(�ν��Ͻ��� ���� ������ �����Ǵ�, �޸𸮿� �ö󰡴� ����), �ν��Ͻ� �ʵ�					
	private int[] nums; // ���� ������ ��ȣ�� �޶���
//	private int size; // ���� ������ ��ȣ�� �޶����� ����
	private static int size; // ���������� �����, �ν��Ͻ��� ���X
							 // ��ü�� ������ �ʾƵ� �̹� Lotto �ȿ� ���� -> Program���� �ζ� �������� �ʰ� Lotto.size = 30; �̷��� ��� ����
							 // new�� �ζǸ� �����ϴ��� size�� ���� �������� ����
							 // 100���� �ζǰ� ��������� size�� �ѹ��� ���������(�޸� ����), ���������̱� ������ 100���� �ζǿ��� ���� ����
							 // main �Լ����� �� ���� ���α׷��� �������ڸ��� �ٷ� ������
	
	static { // ��ü�� ������ �ʾƵ� Ŭ������ �����ϱ⸸ �ϸ� ȣ���
		size = 6; // ���� ������, �Ʒ��� �ٸ��� �ѹ��� 6�� �����ϰ� ������ ��
	}
	
	public Lotto() { 
//		size = 6;    // ������ �ϳ��ε� ��� 6�� �����ϴ� ���� �߻�
		nums = new int[size];
	}
	
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
