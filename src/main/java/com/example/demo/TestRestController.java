package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestRestController {
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "msg", required = false, defaultValue = "message") String msg) {
    return msg;
  }

  @GetMapping("/hello2")
  public String hello2(@RequestParam(value = "name", required = false, defaultValue = "홍길동") String name,
                       @RequestParam(value = "age", required = false, defaultValue = "20") int age,
                       @RequestParam(value = "nationality", required = false, defaultValue = "대한민국") String nationality)  {
    return name + ":" + age + ":" + nationality;
  }

  @GetMapping("/hello3")
  public Person hello3(Person person) {
    return person;
  }
}


