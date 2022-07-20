package gr.iek.lectures.android.halfdayvisitapplication.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.loader.AssetsProvider;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Route;
import gr.iek.lectures.android.halfdayvisitapplication.classes.RoutePoint;

public class RoutesList extends AppCompatActivity {

    private ListView routesListView;
    private RoutesAdapter routesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);

        routesListView = findViewById(R.id.routes_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Διαδρομές");

        ArrayList<Route> routes = this.getJsonFile();
        routesAdapter = new RoutesAdapter(this, routes);
        routesListView.setAdapter(routesAdapter);
        routesListView.setOnItemClickListener(((parent, view, position, id) -> {

            Route route = (Route) parent.getItemAtPosition(position);
            Intent send = new Intent(RoutesList.this, RoutePoints.class);
            Bundle b = new Bundle();
            b.putSerializable("route", route);
            send.putExtras(b);
            startActivity(send);
        }));
    }

    public ArrayList<Route> getJsonFile() {
        ArrayList<Route> routesList = new ArrayList<>();
        String json;
        try {
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject);
                int routeId = jsonObject.getInt("id");
                String routeName = jsonObject.getString("name");
                Route route = new Route(routeId, routeName);
                ArrayList<RoutePoint> points = this.getRoutePoints(jsonObject.getJSONArray("points"));
                route.setRoutePoints(points);
                routesList.add(route);
            }

        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return routesList;
    }

    private ArrayList<RoutePoint> getRoutePoints(JSONArray routePoints) throws JSONException {
        ArrayList<RoutePoint> routePointsList = new ArrayList<>();
        for (int i = 0; i < routePoints.length(); i++) {
            JSONObject routePoint = routePoints.getJSONObject(i);
            int pointId = routePoint.getInt("point_id");
            String pointName = routePoint.getString("point_name");
            String pointDescription = routePoint.getString("point_description");
            double pointCoordsX = routePoint.getDouble("point_coordinates_x");
            double pointCoordsY = routePoint.getDouble("point_coordinates_y");
            String pointPhotoPath = routePoint.getString("point_photo");
            RoutePoint point = new RoutePoint(pointId, pointName, pointDescription, new double[]{pointCoordsX, pointCoordsY}, pointPhotoPath);
            routePointsList.add(point);
        }

        return routePointsList;
    }
}