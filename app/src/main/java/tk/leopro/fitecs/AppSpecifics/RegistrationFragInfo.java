package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Created by Leo on 10/2/2015.
 */
final class RegistrationFragInfo implements FactoryInterface {

    private Spinner mCountries;

    private Button mNext;

    private EditText mUserPhone;

    private String mAreaCode;

    private CodesAndCountriesInfo mInfo;

    private Context mContext;

    public RegistrationFragInfo(Spinner countries, Button next, EditText userPhone, CodesAndCountriesInfo info, Context context){
        mCountries = countries;
        mNext = next;
        mUserPhone = userPhone;
        mInfo = info;
        mContext = context;
    }

    @Override
    public Object doTask() {
        mCountries .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mAreaCode ="+"+mInfo.getAreaCode(mCountries.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUserPhone.getText().toString()!= null) {
                    Log.e("yay", mAreaCode + phoneNumber(mUserPhone.getText().toString()));
                    AppFactory.sendSMS(mAreaCode + phoneNumber(mUserPhone.getText().toString()), mContext).doTask();
                }
            }
        });
        return null;
    }
    final String phoneNumber(String userNum){
        if(userNum.charAt(0)=='0'){
           userNum = userNum.substring(1);
        }
        String phoneNum = userNum;
        return phoneNum;
    }
}
