package com.example.dima.filmlist;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends FragmentActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        film = (Film) getIntent().getParcelableExtra("FILM_DATA");
        TextView tv =  findViewById(R.id.textDescriptionActivity);
        ImageView iv = findViewById(R.id.imageDescriptionActivity);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        tv.setText(film.getName());
        iv.setImageResource(film.getImage());
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


   /* private List<Fragment> getFragment()
    {
        if(f1 == null) {
            f1 = new FirstFragment();
            f1.setIntegerArrayList(film.getPhotosFromFilm());
        }
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(f1);

        if(f2 == null) {
            f2 = new SecondFragment();
            f2.setActors(film.getOtherDataFromFilm());
        }
        list.add(f2);

        return list;

//        Bundle bundle = new Bundle();
//        bundle.putIntegerArrayList("ARRAYLIST", film.getPhotosFromFilm());
//        FirstFragment firstFragment = new FirstFragment();
//        firstFragment.setArguments(bundle);

        //list.add(firstFragment);
        //list.add(new SecondFragment());

//        FirstFragment f1 = FirstFragment.newInstance("xxx", R.mipmap.ic_spiderman23_round);
//        f1.receive(5);
//        list.add(f1);
//        list.add(FirstFragment.newInstance("lfdasfd",R.mipmap.ic_spiderman23_round));
//        list.add(FirstFragment.newInstance("fdasdfas",R.mipmap.ic_spiderman23_round));
    }*/


    private class PagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 2;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            switch(position){
                case 0:
                    fragment = new FirstFragment();
                    ((FirstFragment) fragment).setIntegerArrayList(film.getPhotosFromFilm());
                    break;
                case 1:
                    fragment = new SecondFragment();
                    ((SecondFragment) fragment).setActors(film.getOtherDataFromFilm());
                    break;
                default: fragment = null;
            }
            if(fragment != null)
                fragment.setRetainInstance(true);

            return fragment;
        }


        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
