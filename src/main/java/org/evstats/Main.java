package org.evstats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            PageFormatter pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/");
//            System.out.println("-------------------------\nCountries:\n\n" + pageFormatter.getElementsTextBySelector(".list-group-item"));
            System.out.println(pageFormatter.getStatistics("Albania"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}