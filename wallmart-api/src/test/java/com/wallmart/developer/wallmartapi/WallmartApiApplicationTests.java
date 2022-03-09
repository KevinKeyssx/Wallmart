package com.wallmart.developer.wallmartapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WallmartApiApplicationTests {

	@Test
	void contextLoads() {
		WallmartApiApplication.main(new String[] {});
		assertTrue(Boolean.TRUE);
	}

}
