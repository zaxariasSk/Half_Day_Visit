package gr.iek.lectures.android.halfdayvisitapplication.classes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Formatter;

public class Street implements Serializable {
    private int id;
    private String name;
    private String description;
    double[] position;

    public Street(int id, String name, String description, double[] position)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name;
    }
}
