package com.example.demo.controller;

import com.example.demo.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Controller
@Component
@RequiredArgsConstructor
@RestController
public class NewsController {
	@Autowired
	private final NewsService newsService;

    @GetMapping("crawling")
    public String crawl(){
		return newsService.Crawling();
    }
}
