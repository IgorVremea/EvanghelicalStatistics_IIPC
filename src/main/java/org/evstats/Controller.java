package org.evstats;

import java.util.ArrayList;

public class Controller {
    private Statistics statistics;
    private PageFormatter pageFormatter;

    public Controller() throws Exception{
        this.pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/");
        this.statisticsInit();
    }

    public void statisticsInit(){
        ArrayList<String> countries = pageFormatter.getCountries();
        ArrayList<String> statistics = pageFormatter.getStatisticsList(countries);
        this.statistics = new Statistics(countries, statistics);
    }
    public String getCountryStatistics(String country){
        return statistics.getStatistics(country);
    }
    public String getStatisticsToString(){
        return statistics.toString();
    }
}
