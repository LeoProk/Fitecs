package tk.leopro.fitecs.Utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Created by Leo on 9/19/2015.
 */
final class JSONConverter implements FactoryInterface {

    private String mUrl;

    public JSONConverter(String url){

        mUrl = url;
    }


    @Override
    public Object doTask() {
        String stream = "";
        try {
            URL url = new URL(mUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Check the connection status
            if (urlConnection.getResponseCode() == 200) {
                // if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                // End reading

                // Disconnect the HttpURLConnection
                urlConnection.disconnect();
            } else {
                // Do something
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        // Return the data from specified url
        return stream;
    }
}
