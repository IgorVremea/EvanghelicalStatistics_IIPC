package org.evstats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;

public class PageFormatter {
    private String url;
    private Document doc;

    public PageFormatter(String url) throws Exception{
        this.url = url;
        this.doc = Jsoup.connect(url).get();
    }
    public ArrayList<String> getCountries(){ // Scoate lista țărilor din site
        return getElementsTextBySelector(".list-group-item");
    }
    public ArrayList<String> getElementsTextBySelector(String selector){ // Extrage text din elemente cu un selector CSS specific
        ArrayList<String> res = new ArrayList<>();
        Elements elementsList = doc.select(selector);
        for(Element element : elementsList){
            res.add(element.text().substring(0, element.text().length() - 2));
        };
        return res;
    }
    public ArrayList<Country> getCountriesList(ArrayList<String> countries){ // Scoate toată informația țărilor
        System.out.println("Collecting data for:"); // am pus ca să văd tot proces
        ArrayList<Country> res = new ArrayList<>();
        for(String countryName: countries){
            try{
                System.out.println(countryName);
                res.add(new Country(countryName, this.getStats(countryName)));
            } catch (Exception e){
                System.out.println(e.getCause() + " " + e.getMessage());
                res.add(new Country(countryName, new HashMap<>()));
            }
        }
        return res;
    }
    public HashMap<String, String> getStats(String countryName) throws Exception { // Scoate intreagă statistica pentru o tara anumită
        String url = this.url.substring(0, this.url.length()-7) + countryName + '/';
        url = url.replace(" ", "-"); // Formatez url ca să poată găsi și țările care conțin space
        Document doc = Jsoup.connect(url).get();
        Elements stats = doc.select("table tbody tr");
        HashMap<String, String> res = new HashMap<>();
        for(Element stat: stats){
            res.put(stat.child(0).text().substring(0, stat.child(0).text().length() - 1), stat.child(1).text());
        }
        return res;
    }
}
