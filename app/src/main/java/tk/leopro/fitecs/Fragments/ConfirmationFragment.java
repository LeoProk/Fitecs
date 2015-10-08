package tk.leopro.fitecs.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tk.leopro.fitecs.AppController;
import tk.leopro.fitecs.R;

/**
 * Confirm Fragment checks if user writes the right 5 digit number.
 */
public class ConfirmationFragment extends Fragment {

    private EditText mConfirmText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.confirm_fragmnet, container, false);
        mConfirmText = (EditText) rootView.findViewById(R.id.confirm_phone);
        final Button buttonConfirm = (Button) rootView.findViewById(R.id.confirm_button);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mConfirmText.getText().toString().replaceAll("\\s+", "").equals(AppController.mRegisterCode.replaceAll("\\s+", ""))){
                    Log.e("confirm","The Code Match");
                }else {
                    Log.e("confirm","wrong code "+" "+AppController.mRegisterCode);
                }
            }
        });
        return rootView;
    }
}
