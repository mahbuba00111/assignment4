package com.example.assignment4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SocialMediaAdapter extends BaseAdapter {

    String[] SName;
    Integer[] img;
    Context context;

    SocialMediaAdapter(Context context, String[] SName, Integer[] img) {
        this.context = context;
        this.SName = SName;
        this.img = img;
    }

    @Override
    public int getCount() {
        return SName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.snameid);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        textView.setText(SName[position]);
        imageView.setImageResource(img[position]);

        return convertView;
    }
}