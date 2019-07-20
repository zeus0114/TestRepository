package com.spring.myapp.commons;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentTest {

	private static final Logger logger = LoggerFactory.getLogger(UriComponentTest.class);
	
	/*@Test
	public void testUriComp() throws Exception {
		
		UriComponents ucp = UriComponentsBuilder.newInstance()
							.path("/board/content")
							.queryParam("boardNo", 33)
							.queryParam("page", 25)
							.queryParam("countPerPage", 20)
							.build();
		//String str = "HELLO WORLD";
		//str.toLowerCase().split(""
		
		logger.info(ucp.toString());
	}
	@Test
	public void testUriComp2() throws Exception {
		
		UriComponents ucp = UriComponentsBuilder.newInstance()
				.path("/{link1}/{link2}")
				.queryParam("boardNo", 33)
				.queryParam("page", 25)
				.queryParam("countPerPage", 20)
				.build().expand("board", "write")
				.encode();
				
		logger.info(ucp.toString());
		
		int result = add(new int[] {1,2,3,4,5});
		System.out.println(result);
		
	}*/
	
	private int add(int... nums) {
		int total = 0;
		for(int n : nums) {
			total += n;
		}
		return total;
	}
	
	
	
}
