package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Created by Leo on 9/18/2015.
 */
public class AppFactory  {

    //Gets list of countries
    public static FactoryInterface getRegisterInfo(Context context){
        return new CountriesPhoneMaker(context);
    }
    public static FactoryInterface getCurrentLocation(Context context){
        return new CurrentLocation(context);
    }
    public static FactoryInterface sendSMS(String phoneNum,Context context){
        return new SendSMS(phoneNum,context);
    }
    public static FactoryInterface getRegistrationFragInfo(Spinner countries, Button next, EditText userPhone, CodesAndCountriesInfo info,Context context){
        return new RegistrationFragInfo(countries,next,userPhone,info,context);
    }
}
