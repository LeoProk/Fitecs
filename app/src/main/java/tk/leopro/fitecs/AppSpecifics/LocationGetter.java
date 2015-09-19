package tk.leopro.fitecs.AppSpecifics;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Gets user info from url using ip in json format.
 */
public class LocationGetter extends AsyncTask<String,Void,Void> implements FactoryInterface {




    JSONArray dataJsonArr = null;

    @Override
    public Object doTask() {

        return null;
    }


    @Override
    protected Void doInBackground(String... params) {
        String countGetterUrl = "http://ip-api.com/json";
        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);

            // get the array of users
            dataJsonArr = json.getJSONArray("Users");

            // loop through all users
            for (int i = 0; i < dataJsonArr.length(); i++) {
                JSONObject c = dataJsonArr.getJSONObject(i);
                // Storing each json item in variable
                String country = c.getString("firstname");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
