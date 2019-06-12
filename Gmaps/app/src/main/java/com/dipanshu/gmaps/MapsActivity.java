package com.dipanshu.gmaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import javax.security.auth.login.LoginException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    LocationManager lm;
    LatLng newp;
    LatLng curr;
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lm= (LocationManager) getSystemService(LOCATION_SERVICE);

        ActivityCompat.requestPermissions(MapsActivity.this,
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION
                },
                12345);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"Using your Location",Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 12345:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //attach the location listener
                    startLocationUpdates(lm);
                }
                        break;

        }
    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates(LocationManager lm) {
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1,this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        LatLng delhi = new LatLng(28.7,77.1);
//        delhi=curr;
//        mMap.addMarker(new MarkerOptions()
//                .position(curr)
//                .title("delhi")
//                .draggable(false)
//                .alpha(0.7f)
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(curr,13));

        startLocationUpdates((LocationManager) getSystemService(LOCATION_SERVICE));



//  to get location updates we have used this method.

    }


    @Override
    public void onLocationChanged(Location location) {

        if(flag==1){
            curr=new LatLng(location.getLatitude(),location.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(curr)
                    .title("delhi")
                    .draggable(false)
                    .alpha(0.7f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(curr,13));

            flag=0;
        }
        Log.e("POSITION",":"+location.getLatitude() + " "+location.getLongitude());
        newp =new LatLng(location.getLatitude(),location.getLongitude());
        Marker mm= mMap.addMarker(new MarkerOptions()
                    .position(newp)
                    .title("new position")
                    .alpha(0.7f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        );

        mMap.addPolyline(new PolylineOptions()
                    .add(curr,newp)
                    .color(Color.argb(100,255,0,0))
                    .width(8f));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(newp,13));
        curr=newp;
        mm.remove();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        lm.removeUpdates(this);
//    }
}
