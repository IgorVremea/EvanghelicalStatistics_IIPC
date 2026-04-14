package org.evstats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            controller.saveToCSV();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}