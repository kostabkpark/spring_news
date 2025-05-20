package com.example.news;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {
	private int    aid;
	private String title;
	private String img;
	private String date;
	private String content;


	@Override
	public String toString() {
		return "News [aid=" + aid + ", title=" + title + ", date=" + date + "]";
	}
}
