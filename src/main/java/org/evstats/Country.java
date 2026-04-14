package org.evstats;

import java.util.HashMap;
import java.util.Map;

public class Country {
    private String name;
    private HashMap<String, String> stats;

    public Country(String name, HashMap<String, String> stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, String> stats) {
        this.stats = stats;
    }

    public String getValueOf(String stat){ // returnează valoarea statisticii anumite
        return stats.get(stat);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name + ":\n");
        for(Map.Entry<String, String> entry: stats.entrySet()){
            stringBuilder.append("\t");
            stringBuilder.append(entry.getKey());
            stringBuilder.append(": ");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
