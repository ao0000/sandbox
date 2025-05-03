package dev.ao0000.springtutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class SpringtutorialApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringtutorialApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setHeadless(false);
        springApplication.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JFrame frame = new JFrame("Spring Boot Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new JLabel("Spring Boot Application."));
        frame.setVisible(true);
    }
}
