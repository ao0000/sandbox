package dev.ao0000.springtutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringtutorialApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringtutorialApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("---------------------------------------");
        System.out.println("| This is Application Runner program. |");
        System.out.println("---------------------------------------");
        System.out.println(args.getOptionNames());
        System.out.println(args.getNonOptionArgs());
        System.out.println(Arrays.asList(args.getSourceArgs()));
    }
}
