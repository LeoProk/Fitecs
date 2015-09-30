package tk.leopro.fitecs.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import tk.leopro.fitecs.AppSpecifics.AppFactory;
import tk.leopro.fitecs.AppSpecifics.LocationGetter;
import tk.leopro.fitecs.AppSpecifics.RegisterInfo;
import tk.leopro.fitecs.R;

/**
 * This fragment get the phone from text view and send confirmation sms to the number
 */
public class RegistrationFragment extends Fragment {
    RegisterInfo mInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.register_fragment, container, false);
    mInfo = (RegisterInfo)AppFactory.getRegisterInfo(getActivity()).doTask();
    final Spinner spinner = (Spinner) rootView.findViewById(R.id.country_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
    android.R.layout.simple_spinner_item, mInfo.getCountries());
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.e("your code is : ", mInfo.getAreaCode(spinner.getSelectedItem().toString()));
            }
    });
    new LocationGetter().execute("http://ip-api.com/json");
    return rootView;
    }
}