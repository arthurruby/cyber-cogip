package fr.cybercogip;

import fr.cybercogip.controllers.MainController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CogipApplicationTests {

	@Autowired
	private MainController controller;

	@Test
	void contextLoads(){
		Assertions.assertThat(this.controller).isNotNull();
	}

}
