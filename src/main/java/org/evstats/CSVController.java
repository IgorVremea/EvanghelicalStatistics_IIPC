package org.evstats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVController {
    private Statistics statistics;
    private String path;

    public CSVController(Statistics statistics, String path) {
        this.statistics = statistics;
        this.path = path;
    }

    public CSVController(String path){
        this(new Statistics(new ArrayList<String>(), new ArrayList<String>()), path);
    }
    public void saveStatistics(Statistics statistics) { // Salvează statistica trimisa în fișier
        this.statistics = statistics;
        try {
            FileWriter out = new FileWriter(path);
            CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("ID", "Country", "Statistics"));
            for(int i = 0; i < statistics.length(); i++){
                printer.printRecord(i, statistics.getCountryById(i), statistics.getStatisticsById(i) == null ? "0 %" : statistics.getStatisticsById(i) );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
