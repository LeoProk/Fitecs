package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.telephony.SmsManager;

import java.util.Random;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.R;

/**
 * Send sms message to the phone number with activation code.
 */
final class SendSMS  implements FactoryInterface {

    String mPhoneNo;
    Context mContext;


    public SendSMS(String phoneNo,Context context){
        mPhoneNo = phoneNo;
        mContext = context;
    }

    @Override
    public Object doTask() {
        Random rand = new Random();
        String code = Integer.toString(rand.nextInt((98799 - 12345) + 1) + 12345);
        String text = String.format(mContext.getResources().getString(R.string.sms_message),
                code);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mPhoneNo, mContext.getResources().getString(R.string.app_name), text
                , null, null);
        return null;
    }
}
