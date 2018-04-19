package com.example.dima.filmlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dima on 4/16/2018.
 */

public class ArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Actor> mDataSource;

    public ArrayAdapter(SecondFragment context, ArrayList<Actor> items) {
        mContext = context.getContext();
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        if(mDataSource == null)
            return 0;
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_view_row_loyout, parent, false);
        // Get title element
        TextView titleTextView = rowView.findViewById(R.id.mainText);
        ImageView mainImageView = rowView.findViewById(R.id.mainImage);

        Actor actor =(Actor) getItem(position);

        titleTextView.setText(actor.getName());
        mainImageView.setImageResource(actor.getImage());

        return rowView;
    }
}
