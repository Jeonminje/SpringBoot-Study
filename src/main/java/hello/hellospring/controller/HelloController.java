package hello.hellospring.controller;


import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
   @GetMapping("hello")
   public String hello(Model model){
       model.addAttribute("data","mie12!!");
       return "hello";
   }

   @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
       model.addAttribute("name",name);
       return "hello-template";
   }
   @GetMapping("hello-string")
   @ResponseBody //바디부분을 직접 주겠다는 의미
   public String helloString(@RequestParam("name") String name){
       return "hello " + name; // hello spring
   }

   @GetMapping("hello-api")
   @ResponseBody
   public Hello helloApi(@RequestParam("name") String name) {
       Hello hello = new Hello();
       hello.setName(name);
       return hello; // 객체면 제이슨 방식으로 반환하겠다는 약속
   }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
