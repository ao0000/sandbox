package dev.ao0000.springtutorial;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringtutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringtutorialApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------");
		System.out.println("| This is CommnadLine Runner program. |");
		System.out.println("---------------------------------------");
		System.out.println("["+String.join(", ", args)+"]");
		System.out.println();
	}
}
