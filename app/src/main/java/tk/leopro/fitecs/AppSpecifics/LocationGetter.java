package tk.leopro.fitecs.AppSpecifics;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.Utilities.UtilitiesFactory;

/**
 * Gets user info from url using ip in json format.
 */
public class LocationGetter extends AsyncTask<String,Void,Void> implements FactoryInterface {

    JSONObject mReader;


    JSONArray dataJsonArr = null;

    @Override
    public Object doTask() {

        return null;
    }


    @Override
    protected Void doInBackground(String... params) {
        try {
            mReader= new JSONObject((String)UtilitiesFactory.getFromUrl(params[0]).doTask());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            Log.e("YAY",mReader.getString("country")+" "+ mReader.getString("countryCode") );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
