package tk.leopro.fitecs.AppSpecifics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Store the countries and there codes in hashmap and arraylist with getters , have method do get code by country
 */
public class RegisterInfo {
    private HashMap<String,String> mCodesAndCountries;
    private ArrayList<String> mCountries;
    public RegisterInfo(HashMap<String,String> codesAndCountries, ArrayList<String> countries){
        mCodesAndCountries = codesAndCountries;
        mCountries = countries;
    }
   public ArrayList<String> getCountries(){
       return mCountries;
   }
   public HashMap<String,String> getCodesAndCountries(){
       return mCodesAndCountries;
   }
   public String getAreaCode(String country){
        return mCodesAndCountries.get(country);
   }
}
