package tk.leopro.fitecs.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.leopro.fitecs.R;

/**
 * Created by Leo on 10/4/2015.
 */
public class GymLocationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.gym_fragment, container, false);

        return rootView;
    }
}
