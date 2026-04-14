package org.evstats;

import java.util.ArrayList;

public class Statistics {
    private ArrayList<String> countries;
    private ArrayList<String> statistics;

    public Statistics(ArrayList<String> countries, ArrayList<String> statistics) {
        this.countries = countries;
        this.statistics = statistics;
    }

    public String getStatistics(String country){
        return statistics.get(countries.indexOf(country));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("-------------------------------");
        for(String country: this.countries){
            stringBuilder.append(country);
            stringBuilder.append(": ");
            stringBuilder.append(getStatistics(country));
            stringBuilder.append('\n');
        }
        stringBuilder.append("-------------------------------");
        return stringBuilder.toString();
    }
}
