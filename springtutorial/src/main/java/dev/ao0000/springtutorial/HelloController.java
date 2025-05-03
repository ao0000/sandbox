package dev.ao0000.springtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @RequestMapping("/{num}")
//    public ModelAndView index(@PathVariable int num, ModelAndView mav) {
//        int total = 0;
//        for (int i = 1; i <= num; i++) {
//            total += i;
//        }
//        mav.addObject("msg", num + "までの合計を計算します。");
//        mav.addObject("content", "total: " + total);
//        mav.setViewName("index");
//        return mav;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model) {
        model.addObject("msg", "名前をかいてください。");
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView form(@RequestParam("text1") String str, ModelAndView model) {
        model.addObject("msg", "こんにちは、" + str + "さん");
        model.addObject("value", str);
        model.setViewName("index");
        return model;
    }
}
