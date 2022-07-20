package gr.iek.lectures.android.halfdayvisitapplication.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Route;
import gr.iek.lectures.android.halfdayvisitapplication.classes.RoutePoint;

public class PointInformationActivity extends AppCompatActivity {

    private TextView pointName, pointDescription;
    private ImageView pointImage;
    Route route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_point_information);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Πληροφορίες Σημείου");
        Intent intent = getIntent();
        RoutePoint routePoint = (RoutePoint) intent.getSerializableExtra("routePoint");
        route = (Route) intent.getSerializableExtra("route");
        this.pointName = findViewById(R.id.point_name);
        this.pointName.setText(routePoint.getPointName());
        this.pointDescription = findViewById(R.id.point_description);
        this.pointDescription.setText(routePoint.getPointDescription());
        this.pointImage = findViewById(R.id.point_image);
        this.displayImage(routePoint);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent send = new Intent(PointInformationActivity.this, RoutePoints.class);
                Bundle b = new Bundle();
                b.putSerializable("route", route);
                System.out.println(route);
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

    private void displayImage(RoutePoint routePoint) {
        int j = getResources().getIdentifier(routePoint.getPhotoPath(), "drawable", getPackageName());
        this.pointImage.setImageResource(j);
    }
}