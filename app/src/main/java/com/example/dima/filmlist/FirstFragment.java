package com.example.dima.filmlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
//    public static final String _text = "text";
//    public static final String _image = "image";
//    public static final FirstFragment newInstance(String ttext, int timage)
//    {
//        FirstFragment fr = new FirstFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(_text, ttext);
//        bundle.putInt(_image, timage);
//        fr.setArguments(bundle);
//        return fr;
//    }
//    public static final String _arrayList =  "list";

    public FirstFragment(){
    }

    public ArrayList<Integer> integerArraylist;

    public void setIntegerArrayList(ArrayList<Integer> listInt){
        this.integerArraylist = listInt;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        String text = getArguments().getString(_text);
//        int image = getArguments().getInt(_image);
//        TextView tv_text = view.findViewById(R.id.textID);
//        ImageView iv_image = view.findViewById(R.id.imageID);
//        tv_text.setText(text);
//        iv_image.setImageResource(image);
//        pobieranie text, image z

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        GridView gridView = getView().findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(this, integerArraylist);
        gridView.setAdapter(imageAdapter);
    }
}
