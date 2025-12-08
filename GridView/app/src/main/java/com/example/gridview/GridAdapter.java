package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    //11

    Context context;

    //12..Copiem Aray listurile aici

    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();

    // 13.cream constructor

    public GridAdapter(Context context, ArrayList<String> text, ArrayList<Integer> image) {
        this.context = context;
        this.text = text;
        this.image = image;
    }
    //14.returnam numarul de elemente
    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //15. Transformă fișierul XML gridview_layout într-un obiect View, pregătit să fie afișat în listă/grilă.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gridview_layout,parent, false);

        //16 Definim textview si Image view aici
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(text.get(position));
        imageView.setImageResource(image.get(position));
        return view;
    }
}
