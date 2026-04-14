package org.evstats;

import java.util.ArrayList;

public class Controller {
    private Statistics statistics;
    private PageFormatter pageFormatter;
    private CSVController csvController;

    public Controller() throws Exception{
        this.pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/");
        this.statisticsInit();
    }
    public void initCSVController(String path){
        this.csvController = new CSVController(this.statistics, path);
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
    public void saveStatisticsToFile(String path){
        this.initCSVController(path);
        csvController.saveStatistics(this.statistics);
    }
}
