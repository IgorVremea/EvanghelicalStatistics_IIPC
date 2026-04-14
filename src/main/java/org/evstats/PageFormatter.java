package org.evstats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageFormatter {
    private String url;
    private Document doc;

    public PageFormatter(String url) throws Exception{
        this.url = url;
        this.doc = Jsoup.connect(url).get();
    }
    public String getStringListBySelector(String selector){
        StringBuilder stringBuilder = new StringBuilder();
        Elements elementsList = doc.select(selector);
        for(Element element : elementsList){
            stringBuilder.append(element.text().substring(0, element.text().length() - 2));
            stringBuilder.append('\n');
        };
        return stringBuilder.toString();
    }
}
