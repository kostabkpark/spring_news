package com.example.news;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsDTO {
  private String title;
  private String content;

  @Override
  public String toString() {
    return "NewsDTO{" +
        "title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
