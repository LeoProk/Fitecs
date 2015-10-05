package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * App factory that create new classes based on call.
 */
public class AppFactory  {

    //Gets list of countries
    public static FactoryInterface getRegisterInfo(Context context){
        return new CountriesPhoneMaker(context);
    }
    //Conects to google api and gets current location
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
