package tk.leopro.fitecs.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.leopro.fitecs.R;

/**
 * Created by Leo on 9/19/2015.
 */
public class ConfirmationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.confirm_fragmnet, container, false);
        return rootView;
    }
}
