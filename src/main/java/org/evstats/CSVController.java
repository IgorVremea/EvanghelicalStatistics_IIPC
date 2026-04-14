package org.evstats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVController {
    private String path;

    public CSVController(String path) {
        this.path = path;
    }

    public void save(Countries countries) { // Salvează date necesare în CSV
        try {
            FileWriter out = new FileWriter(path);
            CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("Country", "Population", "% Evangelical"));
            for(Country country: countries.getCountries()){
                printer.printRecord(country.getName(), country.getValueOf("Population"), country.getValueOf("% Evangelical"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
