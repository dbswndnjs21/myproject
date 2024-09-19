package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/test01")
    public String test01(Model model) {
        List<String> list = new ArrayList<String>();
        list.add("개나리");
        list.add("진달래");
        list.add("무궁화");
        model.addAttribute("list1", list);

        List<User> list2 = new ArrayList<>();
        list2.add(new User("hello", "1234"));
        list2.add(new User("java", "4567"));
        list2.add(new User("spring", "3456"));
        model.addAttribute("list2", list2);

        Map<String ,String> map = new HashMap<>();
        map.put("name", "김자바");
        map.put("email", "kim@gmail.com");
        model.addAttribute("mem", map);

        Map<String, User> map2 = new HashMap<>();
        map2.put("user1", new User("주원", "1234"));
        map2.put("user2", new User("유현", "54353"));
        model.addAttribute("map2", map2);

        return "sample/test01";
    }

    @GetMapping("/test02")
    public String test02(Model model) {
        model.addAttribute("date1",new Date());
        model.addAttribute("date2", LocalDateTime.now());
        return "sample/test02Date";
    }
//<li><a th:href="@{/sample/link1(id='hello',pwd='1234')}">sample/link1</a> </li>
    @GetMapping("/link1")
    public String link1(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
    //  spring boot 3.0 이상 부터는 값 받아올때 @RequestParam 으로 해서 받아와야함
        System.out.println(id);
        System.out.println(pwd);
        return "home";
    }

    // sample/link2/aaa/1234
    @GetMapping("/link2/{id}/{pwd}")
    public String link2(@PathVariable("id") String id,@PathVariable("pwd") String pwd) {
        System.out.println("id:"+id +" pwd:"+pwd );
        return "sample/result";
    }

    @GetMapping("/form")
    public String form(Model model) { // void로 하면 그냥 그대로 감 sample/form으로
        Member m = new Member("test", "1234", "123@", false);
        model.addAttribute("mem", m);
        return "sample/form";
    }

    @GetMapping("/formOk")
    public void formOk(@ModelAttribute Member m) { //이렇게 담으면 클래스 이름으로 담김 (첫글자 소문자)
        System.out.println("formOk ->" + m);
    }
}
