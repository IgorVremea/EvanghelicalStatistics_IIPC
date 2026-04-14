package org.evstats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PageFormatter {
    private String url;
    private Document doc;

    public PageFormatter(String url) throws Exception{
        this.url = url;
        this.doc = Jsoup.connect(url).get();
    }
    public ArrayList<String> getElementsTextBySelector(String selector){
        ArrayList<String> res = new ArrayList<>();
        Elements elementsList = doc.select(selector);
        for(Element element : elementsList){
            res.add(element.text().substring(0, element.text().length() - 2));
        };
        return res;
    }
    public String getElementsTextBySelectorInString(String selector) {
        StringBuilder stringBuilder = new StringBuilder();
        Elements elementsList = doc.select(selector);
        for(Element element : elementsList){
            stringBuilder.append(element.text().substring(0, element.text().length() - 2));
            stringBuilder.append('\n');
        };
        return stringBuilder.toString();
    }
    public ArrayList<Element> getStatisticsList(){
        ArrayList<Element> res = new ArrayList<>();
        return res;
    }

    public String getStatistics(String country) throws Exception{
        String url = this.url.substring(0, this.url.length()-7) + country + '/';
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("table tbody tr");
        for(Element element: elements){
            if(element.child(0).text().equals("% Evangelical:") ){
                return element.child(1).text();
            }
        }
        return null;
    }
}
