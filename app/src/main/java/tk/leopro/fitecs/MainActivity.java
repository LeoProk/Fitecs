package tk.leopro.fitecs;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import tk.leopro.fitecs.AppSpecifics.AppFactory;
import tk.leopro.fitecs.Fragments.RegistrationFragment;
import tk.leopro.fitecs.Utilities.UtilitiesFactory;


public class MainActivity extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppFactory.getCurrentLocation(this).doTask();
        UtilitiesFactory.addFragment(this,new RegistrationFragment(),"register",true).doTask();
    }


}
