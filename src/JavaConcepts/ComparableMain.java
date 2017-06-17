package JavaConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain{

    public static void main(String[] args) {
        Country indiaCountry=new Country(1, "India");
        Country chinaCountry=new Country(4, "China");
        Country nepalCountry=new Country(3, "Nepal");
        Country bhutanCountry=new Country(2, "Bhutan");

        List<Country> listOfCountries = new ArrayList<Country> ();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);

        System.out.println("Before Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"||"+"Country name: "+country.getCountryName());
        }
        Collections.sort(listOfCountries);

        System.out.println("After Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
        }
    }

}
