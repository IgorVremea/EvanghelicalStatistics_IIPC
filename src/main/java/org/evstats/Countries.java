package org.evstats;

import java.util.ArrayList;

public class Countries {
    ArrayList<Country> countries;

    public Countries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public String showCountry(String countryName){ // Returnează țara specifică în String
        for(Country country: countries){
            if(country.getName().equals(countryName)) return country.toString();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Country country: countries){
            stringBuilder.append(country.toString());
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}
