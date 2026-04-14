package org.evstats;


public class Controller {
    private PageFormatter pageFormatter;
    private CSVController csvController;
    Countries countries;

    public Controller() throws Exception{
        this.pageFormatter = new PageFormatter("https://operationworld.org/locations/europe/"); // Class care prelucrează pagina
        this.countries = new Countries(pageFormatter.getCountriesList(pageFormatter.getCountries()));
        this.csvController = new CSVController("src/main/resources/data/data.csv");
    }

    public String showCountry(String countryName){ // Returnează parametre țării specifice in String
        return countries.showCountry(countryName);
    }
    public void saveToCSV() { // salvează câteva date în CSV
        csvController.save(countries);
    }
    public String showCountries(){
        return countries.toString();
    }
}
