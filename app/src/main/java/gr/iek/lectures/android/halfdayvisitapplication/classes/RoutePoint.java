package gr.iek.lectures.android.halfdayvisitapplication.classes;

import java.io.Serializable;

public class RoutePoint implements Serializable {

    private int pointID;
    private String pointName;
    private String pointDescription;
    private double[] pointCoordinates;
    private String photoPath;

    public RoutePoint(int pointID, String pointName, String pointDescription, double[] pointCoordinates, String photoPath) {
        this.pointID = pointID;
        this.pointName = pointName;
        this.pointDescription = pointDescription;
        this.pointCoordinates = pointCoordinates;
        this.photoPath = photoPath;
    }

    public int getPointID() {
        return pointID;
    }

    public void setPointID(int pointID) {
        this.pointID = pointID;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription;
    }

    public double[] getPointCoordinates() {
        return pointCoordinates;
    }

    public void setPointCoordinates(double[] pointCoordinates) {
        this.pointCoordinates = pointCoordinates;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
