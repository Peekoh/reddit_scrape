package com.reddit_scrape.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reddit_scrape.services.ScrapeService;

@Controller
public class MainController {

	private final ScrapeService scrapeService;

	public MainController(ScrapeService scrapeService) {
		this.scrapeService = scrapeService;
	}

	@GetMapping("/")
	public String Index() {
		return "index.jsp";
	}


}
