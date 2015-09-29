package tk.leopro.fitecs.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import tk.leopro.fitecs.AppSpecifics.AppFactory;
import tk.leopro.fitecs.AppSpecifics.LocationGetter;
import tk.leopro.fitecs.R;

/**
 * This class get the phone from text view and send confirmation sms to the number
 */
public class RegistrationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.register_fragment, container, false);
    Spinner spinner = (Spinner) rootView.findViewById(R.id.country_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
    android.R.layout.simple_spinner_item,(ArrayList<String>) AppFactory.getCountries().doTask() );
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    new LocationGetter().execute("http://ip-api.com/json");
    return rootView;
    }
}