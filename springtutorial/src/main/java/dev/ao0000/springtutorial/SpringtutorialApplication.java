package dev.ao0000.springtutorial;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringtutorialApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringtutorialApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	@RequestMapping("/")
	public String index() {
		return "Hello, Spring Boot3!!!";
	}
}
