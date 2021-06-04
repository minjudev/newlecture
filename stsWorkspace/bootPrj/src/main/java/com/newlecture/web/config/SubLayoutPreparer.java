package com.newlecture.web.config;

import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class SubLayoutPreparer implements ViewPreparer { // 뷰가 만들어지기 전에 먼저 실행됨
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {

		// request: 스프링이 반환한 것, 타일즈에서 사용하는 것
		// tilesContext: tiles를 사용할 때 사용할 수 있는 공용 도구
		// 타일즈가 [request에 담겨져온 것(값을 담을 때 담는 형식이 맵이기 때문에 키값을 같이 담은 것)]을 맵 형식으로 꺼내준 것
		Map<String, Object> model = tilesContext.getContext("request"); // 사용자의 요청 얻어오기, 모델이라는 이름은 그냥 임의로 붙여준 것
		model.put("data", "data"); // 타일즈 방식의 데이터 세팅 방식
		
		Object title = model.get("title");
		if(title == null)
			// request 덮어쓰기 가능
			model.put("title", "뉴렉처 온라인2"); // -> tiles.xml로 이동(값을 넘겨주는 순서)
	}
}
