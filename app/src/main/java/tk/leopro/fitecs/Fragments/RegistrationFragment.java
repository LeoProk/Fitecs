package tk.leopro.fitecs.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.concurrent.ExecutionException;

import tk.leopro.fitecs.AppSpecifics.AppFactory;
import tk.leopro.fitecs.AppSpecifics.LocationGetter;
import tk.leopro.fitecs.AppSpecifics.CodesAndCountriesInfo;
import tk.leopro.fitecs.Interfaces.OnTaskCompleted;
import tk.leopro.fitecs.R;

/**
 * Thtasis fragment get the phone from text view and send confirmation sms to the number
 */
public class RegistrationFragment extends Fragment implements OnTaskCompleted {
    private CodesAndCountriesInfo mInfo;
    private ArrayAdapter<String> mAdapter;
    private String mUserCountry;
    private Spinner mSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.register_fragment, container, false);
    mInfo = (CodesAndCountriesInfo)AppFactory.getRegisterInfo(getActivity()).doTask();
    final EditText phone = (EditText)rootView.findViewById(R.id.phoneNum);
    final Button next = (Button)rootView.findViewById(R.id.next);
    mSpinner = (Spinner) rootView.findViewById(R.id.country_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    mAdapter = new ArrayAdapter<>(getActivity(),
    android.R.layout.simple_spinner_item, mInfo.getCountries());
    // Specify the layout to use when the list of choices appears
    mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    mSpinner.setAdapter(mAdapter);
    AppFactory.getRegistrationFragInfo(mSpinner,next,phone,mInfo,getActivity()).doTask();
        try {
            mUserCountry = new LocationGetter(this).execute("http://ip-api.com/json").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return rootView;
    }

    @Override
    public void onTaskCompleted() throws ExecutionException, InterruptedException {
        mSpinner.setSelection(mAdapter.getPosition(mUserCountry));
    }
}