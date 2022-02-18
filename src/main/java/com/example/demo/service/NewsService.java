package com.example.demo.service;

import java.io.IOException;

import com.example.demo.model.NewsEntity;
import com.example.demo.persistence.NewsRepository;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsService {
    @Autowired
    NewsRepository newsRepo;

    private static String News_URL = "https://finance.naver.com/news/news_list.naver?mode=LSS3D&section_id=101&section_id2=258&section_id3=401";
    
    public int UrlPage(String url){
        try{
            Document doc = Jsoup.connect(url).get();
            Elements el = doc.select(".pgRR");

            Elements pgElement = el.select("a");
            String PgUrl = pgElement.attr("href");
            
            if(PgUrl.isEmpty()){
                return 1;
            }
            else{
                return PgUrl.charAt(PgUrl.length() - 1);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 1;
    }

    public String Crawling(){
        int maxPage = UrlPage(News_URL);

        for (int page = 1; page <= maxPage; page++){
			final String url = News_URL+"&page="+page;
			Connection conn = Jsoup.connect(url);
			try {
				Document document = conn.get();
				Elements artElements = document.getElementsByAttributeValue("class", "articleSubject");

				for(int i = 0; i <= artElements.size(); i++){
					try{
						Element articleElement = artElements.get(i);
						Elements aElements = articleElement.select("a");
						Element aElement = aElements.get(0);

						String articleTitle = aElement.attr("title");
						String articleUrl = aElement.attr("href");
						
						NewsEntity newsE = new NewsEntity();

						newsE.setTitle(articleTitle);
						newsE.setUrl(articleUrl);
						newsRepo.save(newsE);
						
						System.out.println(articleTitle);
						System.out.println("https://finance.naver.com" + articleUrl);
					}
					catch (Exception e){
						e.getStackTrace();
					}
				}
			}
			catch(IOException e){
				e.getStackTrace(); // 에러의 Exception 내용과 원인을 출력
				return e.toString();
			}
		}
		return "a";
    }
}
