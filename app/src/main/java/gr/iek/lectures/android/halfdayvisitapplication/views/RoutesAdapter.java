package gr.iek.lectures.android.halfdayvisitapplication.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gr.iek.lectures.android.halfdayvisitapplication.R;
import gr.iek.lectures.android.halfdayvisitapplication.classes.Route;

public class RoutesAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<Route> routes;
    private static LayoutInflater inflater;

    public RoutesAdapter(Activity context, ArrayList<Route> routes) {
        this.context = context;
        this.routes = routes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return routes.size();
    }

    @Override
    public Object getItem(int position) {
        return routes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.adapter_view_layout, null) : itemView;
        TextView routeName = (TextView) itemView.findViewById(R.id.textViewName);
        Route selectedRoute = routes.get(position);
        routeName.setText(selectedRoute.getRouteName());
        return itemView;
    }
}
