package com.reddit_scrape.services;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScrapeService {

	public void navigateSite(String url, int count) {

	}

	public List<String> Scrape(String url, String keyword, int count, List<String> results) {
		if (count >= 5) {
			return results;
		}
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select(".thing");
			Integer keyCount = 0;
			for (Element link : links) {
				Element s = link.select("a[href]").first();
				if (s.attr("href").contains(keyword)) {
					results.add(s.attr("href"));
					keyCount++;
				}
			}
			String nextPage = doc.select(".next-button").select("a").attr("href");
			Scrape(nextPage, keyword, ++count, results);
		} catch (Exception e) {
			System.out.println("ERROR\n" + e);
		}
		return results;
	}

}
