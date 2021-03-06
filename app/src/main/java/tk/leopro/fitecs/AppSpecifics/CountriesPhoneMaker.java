package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.R;

/**
 * Gets phone code and contries from array xml and make hashmap and arraylist from them.
 */
final class CountriesPhoneMaker implements FactoryInterface {

    private Context mContext;

    public CountriesPhoneMaker(Context context){
        mContext = context;
    }

    @Override
    public Object doTask() {
        ArrayList<String> locations = new ArrayList<>();
        HashMap<String,String> countriesPhones = new HashMap<>();
        String[] codes=mContext.getResources().getStringArray(R.array.counties);
        for(int i=0;i<codes.length;i++){
            String[] locationCodes=codes[i].split(",");
            locations.add(locationCodes[0]);
            countriesPhones.put(locationCodes[0],locationCodes[1].replaceAll("\\s+",""));
        }
        return new CodesAndCountriesInfo(countriesPhones,locations);

    }
}
