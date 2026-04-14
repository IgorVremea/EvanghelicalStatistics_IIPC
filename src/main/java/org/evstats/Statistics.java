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
    public int length(){
        return countries.size();
    }
    public ArrayList<String> getRecordById(int id){
        ArrayList<String> res = new ArrayList<>();
        res.add(countries.get(id));
        res.add(statistics.get(id));
        return res;
    }
    public String getCountryById(int id){
        return countries.get(id);
    }
    public String getStatisticsById(int id){
        return statistics.get(id);
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
