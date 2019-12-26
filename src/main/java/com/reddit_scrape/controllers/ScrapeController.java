package com.reddit_scrape.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reddit_scrape.services.ScrapeService;

@RestController
public class ScrapeController {

	private final ScrapeService scrapeService;

	public ScrapeController(ScrapeService scrapeService) {
		this.scrapeService = scrapeService;
	}

	@GetMapping("scrape/{sub}/{keyword}")
	public List<String> TestM(@PathVariable("sub") String sub, @PathVariable("keyword") String keyword) {
		return scrapeService.Scrape("https://old.reddit.com" + "/r/"+ sub, keyword, 0, new ArrayList<String>());
	}
}
