package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.HashMap;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.R;

/**
 * Created by Leo on 9/18/2015.
 */
final class CountriesPhoneMaker implements FactoryInterface {

    private Context mContext;

    public CountriesPhoneMaker(Context context){
        mContext = context;
    }

    @Override
    public Object doTask() {
        String countryZipCode="";
        HashMap<String,String> countriesPhones = new HashMap<>();
        String[] codes=mContext.getResources().getStringArray(R.array.counties);
        for(int i=0;i<codes.length;i++){
            String[] locationCodes=codes[i].split(",");
            countriesPhones.put(locationCodes[0],locationCodes[1].replaceAll("\\s+",""));
        }
        return countryZipCode;

    }
}