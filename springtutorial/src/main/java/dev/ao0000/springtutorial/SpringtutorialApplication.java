package dev.ao0000.springtutorial;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringtutorialApplication {

    DataObject[] data = {
            new DataObject("noname", "no email address", 0),
            new DataObject("taro", "taro@yamada", 39),
            new DataObject("hanako", "hanako@flower", 28),
            new DataObject("sachiko", "sachiko@happy", 17),
            new DataObject("jiro", "jiro@change", 6),
    };

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringtutorialApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setHeadless(false);
        springApplication.run(args);
    }

//    @RequestMapping("/")
//    public String index() {
//        return "Hello, World!";
//    }

//    @RequestMapping("/")
//    public String index(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType(MediaType.TEXT_HTML_VALUE);
//        String content = """
//                <html>
//                <head>
//                    <title>Sample App</title>
//                </head>
//                <body>
//                <h1>Sample App</h1>
//                <p>This is sample app page!</p>
//                </body>
//                </html>
//                """;
//        return content;
//    }

//    @RequestMapping("/{num}")
//    public DataObject index(@PathVariable int num) {
//        int n = num < 0 ? 0 : num >= data.length ? 0 : num;¡
//        return data[n];
//    }
}

class DataObject {
    private String name;
    private String email;
    private int age;

    public DataObject(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}