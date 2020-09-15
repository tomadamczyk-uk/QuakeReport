package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Context context;
    private List<Earthquake> earthquakes = new ArrayList<>();


    public ListAdapter(@NonNull Context context, ArrayList<Earthquake> list) {
        super(context, 0, list);
        this.context = context;
        this.earthquakes = list;
    }

    private String decFormat(double d){
        DecimalFormat dF = new DecimalFormat("0.0");
        String output = dF.format(d);

        return output;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        Earthquake earthquakeData = earthquakes.get(position);

        TextView quakeLocation = (TextView) listItem.findViewById(R.id.locationTextView);
        quakeLocation.setText(earthquakeData.getLocation());

        TextView locationOffset = (TextView) listItem.findViewById(R.id.locationOffsetTextView);
        locationOffset.setText(earthquakeData.getLocationOffset());

        TextView quakeMagnitude = (TextView) listItem.findViewById(R.id.magTextView);
        quakeMagnitude.setText(decFormat(earthquakeData.getMagnitude()));

        TextView quakeDate = (TextView) listItem.findViewById(R.id.dateTextView);
        quakeDate.setText(earthquakeData.getDate());

        TextView quakeTime = (TextView) listItem.findViewById(R.id.timeTextView);
        quakeTime.setText(earthquakeData.getTime());

        return listItem;
    }
}

