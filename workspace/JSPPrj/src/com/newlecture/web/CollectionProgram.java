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

		// Collection: Set / List / Map(데이터 저장 시 이 세가지를 가장 많이 사용)
		// 셋의 차이점: 데이터 식별 시 어떤 것을 사용하는지(인덱스, 데이터, 키)
		// 인덱스 기반으로 데이터 식별 가능
		// 가변길이 배열로서 쓰기 적합
		List<Integer>/*자료형을 int로 한정*/ list = new ArrayList<>();
		list.add(10); // 정수만 담을 수 있음
		list.add(100);
//		list.add("hello");
//		list.add(2.3);
		
//		List<Member> list = new ArrayList<>(); /*parameter로 사용하고자 하는 자료형 넘겨주기*/
//		list.add(new Member());
//		list.add(new Member());
//		
//		list.get(0).getNickName(); // 자료를 뽑을 시 형변환해줄 필요가 없음
//		
//		System.out.println(list.get(1));
		
		// 컬렉션에서 값을 뽑아낼 수 있는 단일한 방법이 필요
		for(Integer n : list) // list의 값을 순차적으로 n에 담아서 그것을 출력
			System.out.println(n);
		
		// 데이터가 곧 식별자
		// 값이 키이므로, 중복 허용X
		Set set = new HashSet(); // set에 담겨진 데이터의 정렬방식은 알 수 없음
		set.add(10);
		set.add(100);
		set.add(100);
		set.add(100);
		set.add("hello");
		set.add(2.3);
		
		// Set에서는 특정한 값을 꺼내는 게 불가능
		System.out.println(100);
		
		for(Object n : list) 
			System.out.println(n);
		
		// 값과 키를 같이 넣을 수 있음
		// 임시 클래스, 임시 데이터 구조로 사용 가능
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
