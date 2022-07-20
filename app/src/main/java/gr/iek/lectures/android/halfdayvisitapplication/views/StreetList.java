package gr.iek.lectures.android.halfdayvisitapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Street;

public class StreetList extends AppCompatActivity {
    private ListView streetListView;
    private ArrayAdapter<Street> streetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street);

        streetListView = findViewById(R.id.listViewStreet);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Δρομοι");

        ArrayList<Street> street = this.getJsonFile();

        streetAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, street);
        streetListView.setAdapter(streetAdapter);

        streetListView.setOnItemClickListener(((parent, view, position, id) -> {

            Street streets = (Street) parent.getItemAtPosition(position);

            Intent send = new Intent(StreetList.this, StreetInformationActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("street", streets);
            send.putExtras(b);
            startActivity(send);
        }));
    }

    public ArrayList<Street> getJsonFile() {
        ArrayList<Street> streetList = new ArrayList<>();
        String json;
        try {
            InputStream inputStream = getAssets().open("routes.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject);
                int streetId = jsonObject.getInt("street_id");
                String streetName = jsonObject.getString("street_name");
                String streetDescription = jsonObject.getString("street_description");
                double pointCoordsX = jsonObject.getDouble("street_long");
                double pointCoordsY = jsonObject.getDouble("street_lat");
                Street street = new Street(streetId, streetName, streetDescription, new double[] {pointCoordsX, pointCoordsY});
//                ArrayList<RoutePoint> points = this.getRoutePoints(jsonObject.getJSONArray("points"));
//                route.setRoutePoints(points);
                streetList.add(street);
            }

        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return streetList;
    }

//    private ArrayList<RoutePoint> getRoutePoints(JSONArray routePoints) throws JSONException {
//        ArrayList<RoutePoint> routePointsList = new ArrayList<>();
//        for (int i = 0; i < routePoints.length(); i++) {
//            JSONObject routePoint = routePoints.getJSONObject(i);
//            int pointId = routePoint.getInt("point_id");
//            String pointName = routePoint.getString("point_name");
//            String pointDescription = routePoint.getString("point_description");
//            double pointCoordsX = routePoint.getDouble("point_coordinates_x");
//            double pointCoordsY = routePoint.getDouble("point_coordinates_y");
//            String pointPhotoPath = routePoint.getString("point_photo");
//            RoutePoint point = new RoutePoint(pointId, pointName, pointDescription, new double[]{pointCoordsX, pointCoordsY}, pointPhotoPath);
//            routePointsList.add(point);
//        }
//
//        return routePointsList;
//    }
}
