package org.evstats;

import java.util.ArrayList;

public class Controller {
    private Statistics statistics;
    private PageFormatter pageFormatter;
    private CSVController csvController;

    public Controller() throws Exception{
        this.pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/"); // Class care prelucrează pagina
        this.statisticsInit();
    }
    public void initCSVController(String path){ // Initierea lucrării cu file
        this.csvController = new CSVController(this.statistics, path);
    }
    public void statisticsInit(){ // Adunarea statisticii
        ArrayList<String> countries = pageFormatter.getCountries();
        ArrayList<String> statistics = pageFormatter.getStatisticsList(countries);
        this.statistics = new Statistics(countries, statistics);
    }
    public String getCountryStatistics(String country){ // Statistica țării specifice
        return statistics.getStatistics(country);
    }
    public String getStatisticsToString(){ // Pentru afișarea
        return statistics.toString();
    }
    public void saveStatisticsToFile(String path){ // pastrarea in file
        this.initCSVController(path);
        csvController.saveStatistics(this.statistics);
    }
}
