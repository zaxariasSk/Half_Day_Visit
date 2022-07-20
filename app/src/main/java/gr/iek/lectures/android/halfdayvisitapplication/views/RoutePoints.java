package gr.iek.lectures.android.halfdayvisitapplication.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Route;
import gr.iek.lectures.android.halfdayvisitapplication.classes.RoutePoint;

public class RoutePoints extends AppCompatActivity {

    private ListView routePointsListView;
    private RoutePointAdapter routePointsAdapter;
    private Button openMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_points);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Σημεία Διαδρομής");

        routePointsListView = findViewById(R.id.street_list);
        Intent intent = getIntent();
        Route route = (Route) intent.getSerializableExtra("route");
        ArrayList<RoutePoint> routePoints = route.getRoutePoints();
        routePointsAdapter = new RoutePointAdapter(this, routePoints);
        routePointsListView.setAdapter(routePointsAdapter);
        routePointsListView.setOnItemClickListener(((parent, view, position, id) -> {
            RoutePoint routePoint = (RoutePoint) parent.getItemAtPosition(position);
            Intent send = new Intent(RoutePoints.this, PointInformationActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("routePoint", routePoint);
            b.putSerializable("route", route);
            send.putExtras(b);
            startActivity(send);
        }));

        this.openMap = findViewById(R.id.open_map);
        //κουμπι το οποιο σε πηγαινει στον χαρτη
        this.openMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //μεσω της κλασης Intent, γινεται αλλαγή των activities
                Intent sendToMap = new Intent(RoutePoints.this, MapActivity.class);
                //μεσω της κλασης Bunble, δημιουργουνται τα δεδομενα για να πανε στην κλαση του χαρτη
                Bundle b = new Bundle();
                b.putSerializable("route", route);
                //μεσω του Intent περναμε τα δεδομενα στο χαρτη
                sendToMap.putExtras(b);
                //ξεκιναει - ανοιγει το activity του χαρτη
                startActivity(sendToMap);
            }
        });
    }


}