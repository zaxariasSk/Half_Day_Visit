package gr.iek.lectures.android.halfdayvisitapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import gr.iek.lectures.android.halfdayvisitapplication.MainActivity;
import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Route;
import gr.iek.lectures.android.halfdayvisitapplication.classes.RoutePoint;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Street;

public class StreetInformationActivity extends AppCompatActivity {

    private TextView pointName, pointDescription;
    private Street street;
    private Button mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_information);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Πληροφορίες Σημείου");

        Intent intent = getIntent();
        Street streetPoint = (Street) intent.getSerializableExtra("street");
        street = (Street) intent.getSerializableExtra("street");

        this.pointName = findViewById(R.id.point_name);
        this.pointName.setText(streetPoint.getName());
        this.pointDescription = findViewById(R.id.point_description);
        this.pointDescription.setText(streetPoint.getDescription());

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        mapBtn = findViewById(R.id.show_map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(StreetInformationActivity.this, MapStreet.class));
                        Intent send = new Intent(StreetInformationActivity.this, MapStreet.class);
                        Bundle b = new Bundle();
                        b.putSerializable("street", street);
                        System.out.println(street);
                        send.putExtras(b);
                        startActivity(send);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent send = new Intent(StreetInformationActivity.this, StreetList.class);
                Bundle b = new Bundle();
                b.putSerializable("street", street);
                System.out.println(street);
                send.putExtras(b);
                startActivity(send);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //
//    @Override
//    public void onBackPressed() {
//
//        System.out.println("back pressed");
//        Intent send = new Intent(PointInformationActivity.this, RoutePoint.class);
//        Bundle b = new Bundle();
//        b.putSerializable("route", route);
//        send.putExtras(b);
//        startActivity(send);
//        finish();
//
//    }
}
