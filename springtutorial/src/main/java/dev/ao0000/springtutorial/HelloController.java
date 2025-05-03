package dev.ao0000.springtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView index(ModelAndView model) {
//        model.addObject("msg", "名前をかいてください。");
//        model.setViewName("index");
//        return model;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ModelAndView form(@RequestParam("text1") String str, ModelAndView model) {
//        model.addObject("msg", "こんにちは、" + str + "さん");
//        model.addObject("value", str);
//        model.setViewName("index");
//        return model;
//    }

    //    @GetMapping("/")
//    public ModelAndView index(ModelAndView modelAndView) {
//        modelAndView.setViewName("index");
//        modelAndView.addObject("msg", "フォームを送信ください。");
//        return modelAndView;
//    }
//
//    @PostMapping("/")
//    public ModelAndView form(
//            @RequestParam(value = "check1", required = false) boolean check1,
//            @RequestParam(value = "radio1", required = false) String radio1,
//            @RequestParam(value = "select1", required = false) String select1,
//            @RequestParam(value = "select2", required = false) String[] select2,
//            ModelAndView model
//    ) {
//        String res = "";
//        try {
//            res = "check1: " + check1 +
//                    " radio1: " + radio1 +
//                    " select1: " + select1 +
//                    "\nselect2: ";
//        } catch (Exception e) {
//        }
//        try {
//            res += select2[0];
//            for (int i = 1; i < select2.length; i++) {
//                res += ", " + select2[i];
//            }
//        } catch (Exception e) {
//            res += "null";
//        }
//        model.addObject("msg", res);
//        model.setViewName("index");
//        return model;
//    }
//    @GetMapping("/")
//    public ModelAndView index(ModelAndView modelAndView) {
//        modelAndView.setViewName("index");
//        modelAndView.addObject("msg", "HelloController/indexのページです。");
//        return modelAndView;
//    }
//
//    @GetMapping("/other")
//    public String other() {
//        return "redirect:/";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "forward:/";
//    }

//    private boolean flag = false;
//
//    @GetMapping("/")
//    public ModelAndView index(ModelAndView modelAndView) {
//        flag = !flag;
//        modelAndView.setViewName("index");
//        modelAndView.addObject("flag", flag);
//        modelAndView.addObject("msg", "サンプルのメッセージです。");
//        return modelAndView;
//    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "データを表示します。");
        String[] data = new String[]{"One", "Two", "Three"};
        mav.addObject("data", data);
        return mav;
    }
}
