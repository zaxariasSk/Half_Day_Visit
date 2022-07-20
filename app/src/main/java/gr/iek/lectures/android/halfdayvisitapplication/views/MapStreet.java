package gr.iek.lectures.android.halfdayvisitapplication.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Street;

public class MapStreet extends AppCompatActivity implements OnMapReadyCallback {
    private Street street;
    private GoogleMap mMap;

    public MapStreet() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        this.street = (Street) intent.getSerializableExtra("street");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Πληροφορίες Σημείου");

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        double[] position = street.getPosition();

        LatLng centerMap = new LatLng(position[0],position[1]);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centerMap));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
        mMap.addMarker(new MarkerOptions().position(centerMap).title(street.getName()));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

    }
}
