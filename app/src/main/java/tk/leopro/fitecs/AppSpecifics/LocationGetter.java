package tk.leopro.fitecs.AppSpecifics;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import tk.leopro.fitecs.Interfaces.FactoryInterface;
import tk.leopro.fitecs.Interfaces.OnTaskCompleted;
import tk.leopro.fitecs.Utilities.UtilitiesFactory;

/**
 * Gets user info from url using ip in json format.
 */
public class  LocationGetter extends AsyncTask<String,String,String> implements FactoryInterface {

    JSONObject mReader;
    private OnTaskCompleted listener;

    public LocationGetter(OnTaskCompleted listener){
        this.listener=listener;
    }
    @Override
    public Object doTask() {

        return null;
    }


    @Override
    protected String doInBackground(String... params) {
        try {
            mReader= new JSONObject((String)UtilitiesFactory.getFromUrl(params[0]).doTask());
            return  mReader.getString("country");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        try {
            Log.e("YAY", mReader.getString("country") + " " + mReader.getString("countryCode"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            listener.onTaskCompleted();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
