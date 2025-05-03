package dev.ao0000.springtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//   @RequestMapping("/")
//   public String index(Model model) {
//       model.addAttribute("msg", "これはコントローラに用意したメッセージです。");
//       return "index";
//   }

//    @RequestMapping("/{num}")
//    public String index(@PathVariable int num, Model model) {
//        int res = 0;
//        for (int i = 1; i <= num; i++) {
//            res += i;
//        }
//        model.addAttribute("msg", "total: " + res);
//        return "index";
//    }

    @RequestMapping("/{num}")
    public ModelAndView index(@PathVariable int num, ModelAndView mav) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            total += i;
        }
        mav.addObject("msg", num + "までの合計を計算します。");
        mav.addObject("content", "total: " + total);
        mav.setViewName("index");
        return mav;
    }
}
