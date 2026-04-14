package org.evstats;

import java.util.ArrayList;

public class Statistics {
    private ArrayList<String> countries;
    private ArrayList<String> statistics;

    public Statistics(ArrayList<String> countries, ArrayList<String> statistics) {
        this.countries = countries;
        this.statistics = statistics;
    }

    public String getStatistics(String country){ // returnează statistica pentru tara specifică
        return statistics.get(countries.indexOf(country));
    }
    public int length(){ // returnează cantitatea țărilor
        return countries.size();
    }

    public String getCountryById(int id){ // Returnează țara by id
        return countries.get(id);
    }
    public String getStatisticsById(int id){ // Returnează statistica țării by id
        return statistics.get(id);
    }

    @Override
    public String toString() { // pentru afișarea mai „frumoasă”
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
