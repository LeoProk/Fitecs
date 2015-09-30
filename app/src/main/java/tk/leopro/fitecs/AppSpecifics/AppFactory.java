package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Created by Leo on 9/18/2015.
 */
public class AppFactory  {

    //Gets list of countries
    public static FactoryInterface getRegisterInfo(Context context){
        return new CountriesPhoneMaker(context);
    }
}
