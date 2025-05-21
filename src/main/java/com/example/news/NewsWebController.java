package com.example.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

  @GetMapping("/del/{aid}")
  public String del(@PathVariable("aid") int aid, Model model) {
    try {
      newsDAO.delNews(aid);
    } catch (Exception e) {
      model.addAttribute("error", "뉴스 삭제 오류");
    }
    return "redirect:/news/list";
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

  @PostMapping("/add")
  public String add(@ModelAttribute("news") NewsDTO newsDTO,
                    @RequestParam("img") MultipartFile img,
                    Model model) {


    File file = new File(fdir + "/" + img.getOriginalFilename());
    System.out.println(newsDTO);
    System.out.println(img.getOriginalFilename());
    System.out.println(file);

    News news = new News();
    news.setTitle(newsDTO.getTitle());
    news.setContent(newsDTO.getContent());
    news.setImg(img.getOriginalFilename());

    try {
      img.transferTo(file);
      newsDAO.addNews(news);
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", "뉴스 등록 오류");
    }
    return "redirect:/news/list";
  }
}
