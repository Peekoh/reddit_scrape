package com.reddit_scrape.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit_scrape.services.ScrapeService;

@RestController
public class MainController {

	public final ScrapeService scrapeService;

	public MainController(ScrapeService scrapeService) {
		this.scrapeService = scrapeService;
	}

	@GetMapping("scrape")
	public String ReturnScrape() {
		try {
			return scrapeService.ScrapeTitle("http://reddit.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("scrapes")
	public List<String> TestM() {
	
			return scrapeService.Scrape("https://www.reddit.com/");


	}
}
