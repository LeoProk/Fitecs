package tk.leopro.fitecs;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import tk.leopro.fitecs.Fragments.RegistrationFragment;
import tk.leopro.fitecs.Utilities.UtilitiesFactory;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilitiesFactory.addFragment(this,new RegistrationFragment(),"register",true).doTask();
    }
}
