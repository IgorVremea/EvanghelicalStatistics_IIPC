package org.evstats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            System.out.println(controller.getStatisticsToString()); // Arăt statistica in consola
            controller.saveStatisticsToFile("src/main/resources/data/data.csv"); // Salvez file in data.csv
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}