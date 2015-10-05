package tk.leopro.fitecs.AppSpecifics;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import tk.leopro.fitecs.AppController;
import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Connects to google apis and gets current location
 */
final class CurrentLocation implements FactoryInterface , GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Context mContext;

    public CurrentLocation(Context context){
        mContext = context;
    }
    @Override
    public Object doTask() {
        buildGoogleApiClient();
        return null;
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            Log.e("yay",mLastLocation.toString());
            /*AppController.currentLocation = new Location("Current Location");
            AppController.currentLocation.setLatitude(mLastLocation.getLatitude());
            AppController.currentLocation.setLongitude(mLastLocation.getLongitude());*/
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
    final synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
}
