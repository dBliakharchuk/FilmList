package com.example.dima.filmlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private ListView mListView;
    ArrayList<Actor> filmList;

    public SecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_second, container, false);
// 1
        //final ArrayList<Film> filmList = createFilmList();
// 2
//        String[] listItems = new String[recipeList.size()];
// 3
//        for(int i = 0; i < recipeList.size(); i++){
//            Recipe recipe = recipeList.get(i);
//            listItems[i] = recipe.title;
//        }
// 4
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        mListView = (ListView) view.findViewById(R.id.actor_list_view);
        ArrayAdapter adapter = new ArrayAdapter(this, filmList);
        mListView.setAdapter(adapter);
    }

    public void setActors(ArrayList<Actor> actorList){
        this.filmList = actorList;
    }
}
