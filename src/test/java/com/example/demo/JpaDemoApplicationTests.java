package com.example.demo;

import com.example.demo.controller.PostController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpaDemoApplicationTests {

	@Autowired
	PostController postController;

	@Test
	void contextLoads() {
		Assert.assertNotNull(postController);
	}

}
