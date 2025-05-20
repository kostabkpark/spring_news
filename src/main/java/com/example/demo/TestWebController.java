package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestWebController {
  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @GetMapping("/hello2")
  @ResponseBody
  public String hello2(@RequestParam(value="name", required = false, defaultValue = "홍길동") String name) {
    return "hello , " + name ;
  }

  @GetMapping("/hello3/{msg}")
  public String hello3(@PathVariable("msg") String msg, Model m) {
    m.addAttribute("msg", msg);
    return "hello";
  }
}
