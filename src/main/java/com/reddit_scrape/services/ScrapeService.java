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

	public String ScrapeTitle(String url) throws IOException {
		Document d = Jsoup.connect(url).get();
		return d.title();
	}

	public List<String> Scrape(String url) {

		try {
			Document doc = Jsoup.connect(url).get();
			// System.out.println(doc.getElementsByTag("div"));
			Elements links = doc.select(".scrollerItem");
			List<String> divs = new ArrayList<>();
			for (Element link : links) {
				//System.out.println("\nlink : " + link.attr("href"));
				//System.out.println("text : " + link);
				Element s = link.select("a[href]").first();
				System.out.println(s);
				divs.add(s.attr("href"));
			}

			return divs;
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;

		// System.out.println(e);
		// Element e = d.select("div").first();
		// Element link = d.select("a").first();
		// return d;

	}
}
