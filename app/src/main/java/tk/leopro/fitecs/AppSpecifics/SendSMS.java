package tk.leopro.fitecs.AppSpecifics;

import android.telephony.SmsManager;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Send sms message to the phone number with activation code.
 */
final class SendSMS  implements FactoryInterface {

    String mPhoneNo;

    public SendSMS(String phoneNo){
        mPhoneNo = phoneNo;
    }

    @Override
    public Object doTask() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mPhoneNo, null, "sms message", null, null);
        return null;
    }
}
