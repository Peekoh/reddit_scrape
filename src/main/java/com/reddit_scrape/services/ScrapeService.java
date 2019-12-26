package com.reddit_scrape.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Service
public class ScrapeService {

	public void navigateSite(String url, int count) {

	}

	public List<String> Scrape(String url, String keyword, int count, List<String> results) {
		if (count > 5) {
			return results;
		}
		System.out.println("COUNT: " + count);
		try {
			// write recursive function with counter, navigating to next page 5 times
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select(".thing");
			for (Element link : links) {
				Element s = link.select("a[href]").first();
				if (s.attr("href").contains(keyword)) {
					results.add(s.attr("href"));
					System.out.println("Added");
				}
			}
			String nextPage = doc.select(".next-button").select("a").attr("href");
			System.out.println("RESULTS\n" + results);
			Scrape(nextPage, keyword, ++count, results);
		} catch (Exception e) {
			System.out.println("ERROR\n"+e);
		}
		return results;
	}
}
