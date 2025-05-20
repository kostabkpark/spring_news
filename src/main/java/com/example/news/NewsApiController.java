package com.example.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsApiController {
  final NewsDAO newsDAO;

  @Autowired
  public NewsApiController(NewsDAO newsDAO) {
    this.newsDAO = newsDAO;
  }

  @GetMapping
  public List<News> getAllNews() {
    List<News> newsList = null;
    try {
       newsList = newsDAO.getAll();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return newsList;
  }

  @GetMapping("/{aid}")
  public News getNewsById(@PathVariable int aid) {
    News news = null;
    try {
      news = newsDAO.getNews(aid);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return news;
  }

  @PostMapping
  public String addNews(@RequestBody News news) {
    try {
      newsDAO.addNews(news);
    } catch (Exception e) {
      e.printStackTrace();
      return "news api : 뉴스 등록 에러";
    }
    return "news api : 뉴스 등록 완료";
  }

  @DeleteMapping("/{aid}")
  public String deleteNewsById(@PathVariable int aid) {
    try {
      newsDAO.delNews(aid);
    } catch (Exception e) {
      e.printStackTrace();
      return "news api : 삭제 실패";
    }
    return "news api : 삭제 성공";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello-get";
  }

  @PostMapping("/hello")
  public String postHello() {
    return "hello-post";
  }
}
