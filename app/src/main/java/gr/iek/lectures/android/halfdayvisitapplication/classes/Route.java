package gr.iek.lectures.android.halfdayvisitapplication.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Route implements Serializable {

    private int routeID;
    private String routeName;
    private ArrayList<RoutePoint> routePoints = new ArrayList<RoutePoint>();

    public Route(int routeID, String routeName) {
        this.routeID = routeID;
        this.routeName = routeName;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public ArrayList<RoutePoint> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(ArrayList<RoutePoint> routePoints) {
        this.routePoints = routePoints;
    }
}
