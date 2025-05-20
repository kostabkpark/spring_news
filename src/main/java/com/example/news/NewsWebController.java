package com.example.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    List<News> newsList = null;
    try {
      newsList = newsDAO.getAll();
      if(newsList.size() == 0) {
        model.addAttribute("error", "뉴스 목록 검색 오류");
      } else {
        model.addAttribute("newsList", newsList);
      }
    } catch (Exception e) {
      model.addAttribute("error", "뉴스 목록 검색 오류");
    }
    model.addAttribute("title", "News 목록 보기");
    return "news/newsList";
  }

  @GetMapping("/{aid}")
  public String news(@PathVariable int aid, Model model) {
    News news = null;
    try {
      news = newsDAO.getNews(aid);
      System.out.println(news);
      if (news.getAid() != 0) {
        model.addAttribute("news", news);
      } else {
        model.addAttribute("error", "뉴스 검색 오류");
      }
    } catch (Exception e) {
      model.addAttribute("error", "뉴스 검색 오류");
    }
    return "news/newsView";
  }
}
