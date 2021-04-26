package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Member;

public class CollectionProgram {

	public static void main(String[] args) {
		
		Object[] members = new Object[10];
		members[0] = new Member();
		members[1] = new Member();

		((Member)members[0]).getNickName();
		
//		Object obj = 3;
//		int x = (int)obj;

		// Collection: Set / List / Map(������ ���� �� �� �������� ���� ���� ���)
		// ���� ������: ������ �ĺ� �� � ���� ����ϴ���(�ε���, ������, Ű)
		// �ε��� ������� ������ �ĺ� ����
		// �������� �迭�μ� ���� ����
		List<Integer>/*�ڷ����� int�� ����*/ list = new ArrayList<>();
		list.add(10); // ������ ���� �� ����
		list.add(100);
//		list.add("hello");
//		list.add(2.3);
		
//		List<Member> list = new ArrayList<>(); /*parameter�� ����ϰ��� �ϴ� �ڷ��� �Ѱ��ֱ�*/
//		list.add(new Member());
//		list.add(new Member());
//		
//		list.get(0).getNickName(); // �ڷḦ ���� �� ����ȯ���� �ʿ䰡 ����
//		
//		System.out.println(list.get(1));
		
		// �÷��ǿ��� ���� �̾Ƴ� �� �ִ� ������ ����� �ʿ�
		for(Integer n : list) // list�� ���� ���������� n�� ��Ƽ� �װ��� ���
			System.out.println(n);
		
		// �����Ͱ� �� �ĺ���
		// ���� Ű�̹Ƿ�, �ߺ� ���X
		Set set = new HashSet(); // set�� ����� �������� ���Ĺ���� �� �� ����
		set.add(10);
		set.add(100);
		set.add(100);
		set.add(100);
		set.add("hello");
		set.add(2.3);
		
		// Set������ Ư���� ���� ������ �� �Ұ���
		System.out.println(100);
		
		for(Object n : list) 
			System.out.println(n);
		
		// ���� Ű�� ���� ���� �� ����
		// �ӽ� Ŭ����, �ӽ� ������ ������ ��� ����
		Map map = new HashMap();
		map.put("id", 1);
		map.put("title", "Hello");
		map.put("hit", 1);
		
		System.out.println(map.get("title"));
		
		for(Object k :  map.keySet()) 
			System.out.println(k);

		for(Object v :  map.values()) 
			System.out.println(v);
		
//		for(Object e :  map.entrySet()) 
//			System.out.println(e);
	}

}
