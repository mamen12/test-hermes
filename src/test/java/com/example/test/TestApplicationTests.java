package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

	@Test
	void createdLoopAlgo() {
		int loop = 5;
		for (int i = 1; i <= loop; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+"");
			}
			System.out.println();
		}
		
	}

}
