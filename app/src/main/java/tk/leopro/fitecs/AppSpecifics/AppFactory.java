package tk.leopro.fitecs.AppSpecifics;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Created by Leo on 9/18/2015.
 */
public class AppFactory  {

    //Gets list of countries
    public static FactoryInterface getCountries(){
        return new AllCountriesList();
    }
}
