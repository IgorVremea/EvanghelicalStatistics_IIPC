package org.evstats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            PageFormatter pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/");
            System.out.println("-------------------------\nCountries:\n\n" + pageFormatter.getStringListBySelector(".list-group-item"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}