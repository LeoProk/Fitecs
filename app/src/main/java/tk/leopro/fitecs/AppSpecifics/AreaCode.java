package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.telephony.TelephonyManager;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.R;

/**
 * Created by Leo on 9/18/2015.
 */
final class AreaCode implements FactoryInterface {

    private Context mContext;

    public AreaCode(Context context){
        mContext = context;
    }

    @Override
    public Object doTask() {
        String countryZipCode="";
        String countryID = "";
        String[] codes=mContext.getResources().getStringArray(R.array.country_codes);
        for(int i=0;i<codes.length;i++){
            String[] locationCodes=codes[i].split(",");
            if(locationCodes[1].trim().equals(countryID.trim())){
                countryZipCode=locationCodes[0];
                break;
            }
        }
        return countryZipCode;

    }
}
