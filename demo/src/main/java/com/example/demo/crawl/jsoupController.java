package com.example.demo.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jsoupController {
	
	@GetMapping("/jsoup/test")
	public void test() throws IOException {
		Document doc = Jsoup.connect("https://www.netflix.com/kr-en/browse/genre/34399").get();
		System.out.println(doc);
		Elements list = doc.select(".nm-collections-title-img");
		
		for (Element ele : list) {
			String imgSrc = ele.attr("src");
			System.out.println(imgSrc);
		}
		
       // return ResponseEntity.ok(doc);

		/*
		 * Elements newsHeadlines = doc.select("#mp-itn b a"); for (Element headline :
		 * newsHeadlines) { System.out.println(headline.attr("title")+"|"
		 * +headline.absUrl("href")); } return newsHeadlines;
		 */

	}

}
