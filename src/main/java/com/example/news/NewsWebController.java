package com.example.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsWebController {
  final NewsDAO newsDAO;

  @Autowired
  public NewsWebController(NewsDAO newsDAO) {
    this.newsDAO = newsDAO;
  }

  @Value("${news.imgdir}") // application.properties 에 입력해놓은 저장경로 참조
  String fdir;

  @GetMapping("/list")
  public String news(Model model) {
    model.addAttribute("title", "News");
    return "news/newsList";
  }
}
