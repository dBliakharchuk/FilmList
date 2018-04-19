package com.example.dima.filmlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static ArrayList<Film> MainFilmList = new ArrayList<Film>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(savedInstanceState == null)
            MainFilmList = createFilmList();

        mAdapter = new RecycleViewAdapter(MainFilmList, recyclerView);
        recyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                MainFilmList.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };
        new ItemTouchHelper(simpleItemTouchCallback).attachToRecyclerView(recyclerView);
    }


    private ArrayList<Film> createFilmList()
    {
        ArrayList<Integer> batmanArray = new ArrayList<Integer>();
        batmanArray.add(R.drawable.batman1);
        batmanArray.add(R.drawable.batman2);
        //batmanArray.add(R.drawable.batman3);
        //batmanArray.add(R.drawable.batman4);
        batmanArray.add(R.drawable.batman5);

        ArrayList<Integer> spiderManArray = new ArrayList<>();
        spiderManArray.add(R.drawable.spiderman1);
        //spiderManArray.add(R.drawable.spiderman2);
        //spiderManArray.add(R.drawable.spiderman3);
        spiderManArray.add(R.drawable.spiderman4);
        spiderManArray.add(R.drawable.spiderman5);

        ArrayList<Integer> superWomanArray = new ArrayList<>();
        superWomanArray.add(R.drawable.superwoman1);
        superWomanArray.add(R.drawable.superwoman2);
        //superWomanArray.add(R.drawable.superwoman3);
        //superWomanArray.add(R.drawable.superwoman4);
        superWomanArray.add(R.drawable.superwoman5);

        ArrayList<Integer> hitmanArray = new ArrayList<>();
        hitmanArray.add(R.drawable.hitman1);
        hitmanArray.add(R.drawable.hitman2);
       // hitmanArray.add(R.drawable.hitman3);
        hitmanArray.add(R.drawable.hitman4);

        ArrayList<Integer> arrayFlash = new ArrayList<>();
        arrayFlash.add(R.drawable.flash1);
        arrayFlash.add(R.drawable.flash2);
        //arrayFlash.add(R.drawable.flash3);
        arrayFlash.add(R.drawable.flash4);
        //arrayFlash.add(R.drawable.flash5);
        //arrayFlash.add(R.drawable.flash6);

        ArrayList<Actor> actorsArray = new ArrayList<>();
        actorsArray.add(new Actor("Szylar Piotr",(R.drawable.actor1)));
        actorsArray.add(new Actor("Pietrzak Przemysław",(R.drawable.actor2)));
        actorsArray.add(new Actor("Kopacki Wojciech",(R.drawable.actor3)));
        actorsArray.add(new Actor("Bielas Aleksander",(R.drawable.actor4)));
        actorsArray.add(new Actor("Sitkowski Karol",(R.drawable.actor5)));


        MainFilmList.add(new Film("Batman","Fantasy",(R.drawable.batman1),batmanArray, actorsArray));
        MainFilmList.add(new Film("SpiderMan","Fantasy",(R.drawable.spiderman),spiderManArray, actorsArray));
        MainFilmList.add(new Film("SuperWoman","Fantasy",(R.drawable.superwoman1),superWomanArray, actorsArray));
        MainFilmList.add(new Film("HitMan","Fantasy",(R.drawable.hitman1),hitmanArray, actorsArray));
        MainFilmList.add(new Film("Flash","Fantasy",(R.drawable.flash4),arrayFlash, actorsArray));

        return MainFilmList;
    }
}