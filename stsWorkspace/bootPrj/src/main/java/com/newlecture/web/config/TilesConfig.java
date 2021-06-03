package com.newlecture.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

// 타일 리졸버를 생성하는 작업이 아래 코드

//@Controller/@RestController
//@Service
//@Repository(DAO)
//@Configuration
//(Component == 위 4개)식별할 때 더 잘 식별하기 위해 역할에 따른 객체를 선택적으로 사용 가능

@Configuration // Component = 구성요소: 스프링 어플리케이션을 구성하는 객체들
// 객체를 담고 있는 것은 빈을 담고 있다고 해서 Bean Container(콩자루, 콩보따리)라고 함: IoC Container
// 다섯 개 중 아무 거나 붙이면 톰캣이 실행되면서 TilesConfig를 객체화하게 됨
public class TilesConfig /* tilesConfig라는 이름으로 참조변수가 됨 */ { // 2. 이게 먼저 인스턴스화되어야 함
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer conf = new TilesConfigurer();
		conf.setDefinitions(new String[] {
				"WEB-INF/tiles.xml"
		});
		
		return conf;
	}
	
	@Bean // 얘도 콩이라고, 객체라고 알려주는 것
	// 누군가가 호출해서 사용하는 함수가 아니라 config로서 메모리에 올리기 위한 변수, tilesViewResolver가 콩자루에 들어가는 식별명
	public TilesViewResolver tilesViewResolver() { // 1. 이게 인스턴스화되려면
	
		// 톰캣 서버가 시작되는 순간 타일즈 뷰 리졸버가 메모리에 있어야 함 -> 따로 설정 필요
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		
		return resolver; // bean은 실행해서 반환하는 이 객체를 콩자루에 담게 해줌
						 // resolver가 tilesViewResolver라는 이름으로 콩자루에 들어감
	}
}
