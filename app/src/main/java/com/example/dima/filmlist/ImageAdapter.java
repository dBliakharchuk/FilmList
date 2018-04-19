package com.example.dima.filmlist;

/**
 * Created by Dima on 4/16/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Integer> images;


    public ImageAdapter(FirstFragment context, ArrayList<Integer> images) {
        this.mContext = context.getContext();
        this.images = images;
    }


    @Override
    public int getCount() {
        if(images == null)
            return 0;
        return images.size();
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Integer image = images.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.activity_pager_adapter, null);
        }
        // 3
        final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);
        imageViewFavorite.setImageResource(image);
        return convertView;
    }

}
