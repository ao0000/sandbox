package dev.ao0000.springtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/{temp}")
    public String index(@PathVariable String temp) {
        return switch (temp) {
            case "index" -> "index";
            default -> "other";
        };
    }
}
