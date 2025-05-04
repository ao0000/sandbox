package dev.ao0000.springtutorial;

import dev.ao0000.springtutorial.model.Person;
import dev.ao0000.springtutorial.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("msg", "データを表示します。");
//        String[] data = new String[]{"One", "Two", "Three"};
//        mav.addObject("data", data);
//        return mav;
//    }

//    @GetMapping("/{month}")
//    public ModelAndView index(@PathVariable int month, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("msg", month + "月は？");
//        mav.addObject("month", month);
//        return mav;
//    }

//    @GetMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("msg", "メッセージだよ。");
//        return mav;
//    }

//    @GetMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.setViewName("index");
//        String msg = """
//                <div class="border border-primary">
//                    <h2>Message</h2>
//                    <p>This is sample message!</p>
//                </div>
//                """;
//        mav.addObject("msg", msg);
//        return mav;
//    }

//    private boolean flag = false;
//
//    @RequestMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.setViewName("index");
//        flag = !flag;
//        mav.addObject("flag", flag);
//        mav.addObject("msg", "メッセージを表示します。");
//        return mav;
//    }

//    @Autowired
//    PersonRepository personRepository;
//
//    @GetMapping("/")
//    public ModelAndView index(ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("title", "Hello page");
//        mav.addObject("msg", "this is JPA sample data.");
//        Iterable<Person> list = personRepository.findAll();
//        mav.addObject("data", list);
//        return mav;
//    }

    @Autowired
    PersonRepository repository;

    @GetMapping("/")
    public ModelAndView index(
            @ModelAttribute("formModel") Person person,
            ModelAndView mav
    ) {
        mav.setViewName("index");
        mav.addObject("title", "Hello page");
        mav.addObject("msg", "this is JPA sample data.");
        List<Person> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }

    @PostMapping("/")
    @Transactional
    public ModelAndView form(@ModelAttribute("formModel") Person person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/");
    }

    @PostConstruct
    public void init() {
        Person p1 = new Person();
        p1.setName("taro");
        p1.setAge(39);
        p1.setMail("taro@yamada");
        repository.saveAndFlush(p1);

        Person p2 = new Person();
        p2.setName("hanako");
        p2.setAge(28);
        p2.setMail("hanako@flower");
        repository.saveAndFlush(p2);

        Person p3 = new Person();
        p3.setName("sachiko");
        p3.setAge(17);
        p3.setMail("sachiko@happy");
        repository.saveAndFlush(p3);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@ModelAttribute Person person, @PathVariable("id") int id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "edit Person.");
        Optional<Person> data = repository.findById((long) id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @PostMapping("/edit")
    @Transactional
    public ModelAndView update(@ModelAttribute Person person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id, ModelAndView mav) {
        mav.setViewName("delete");
        mav.addObject("title", "delete Person.");
        mav.addObject("msg", "Can I delete this record?");
        Optional<Person> data = repository.findById((long) id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @PostMapping("/delete")
    @Transactional
    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
        repository.deleteById((long) id);
        return new ModelAndView("redirect:/");
    }
}
