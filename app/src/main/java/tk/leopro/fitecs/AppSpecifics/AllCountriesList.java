package tk.leopro.fitecs.AppSpecifics;

import java.util.ArrayList;
import java.util.Locale;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Gets list of all countries
 */
final class AllCountriesList implements FactoryInterface {
    @Override
    public Object doTask() {
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        return countries;
    }
}
