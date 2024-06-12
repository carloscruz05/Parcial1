package com.example.planetasapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nombres;
    private final Integer[] idimage;

    public AdapterList(Activity context, String[] nombres, Integer[] idimage) {
        super(context, R.layout.item, nombres);
        this.context = context;
        this.nombres = nombres;
        this.idimage = idimage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item, null);

        TextView _nombre = rowView.findViewById(R.id.nombre);
        ImageView _imagen = rowView.findViewById(R.id.logo);

        _nombre.setText(nombres[position]);
        _imagen.setImageResource(idimage[position]);

        return rowView;
    }
}