package com.example.dima.filmlist;

/**
 * Created by Dima on 4/15/2018.
 */
import java.util.List;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    public final static String CATEGORY = "Category: ";
    private List<Film> listOfFilms;
    private RecyclerView rv;
    public static final String FILM_LIST = "Film of List";


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView txtImage;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtImage = v.findViewById(R.id.icon);
        }
    }

    public RecycleViewAdapter(List<Film> myDataset) {
        listOfFilms = myDataset;
    }
    public RecycleViewAdapter(List<Film> myDataset, RecyclerView tempRV) {
        listOfFilms = myDataset;
        rv = tempRV;
    }



    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Film film = listOfFilms.get(position);
        holder.txtHeader.setText(film.getName());
        holder.txtImage.setImageResource(film.getImage());
        holder.txtFooter.setText(CATEGORY + film.getCategory());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("FILM_DATA", film);
                v.getContext().startActivity(intent);
            }

        });

//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
//        itemTouchHelper.attachToRecyclerView(rv);


    }

    @Override
    public int getItemCount() {
        return listOfFilms.size();
    }



//    public void remove(int position) {
//        listOfFilms.remove(position);
//        notifyItemRemoved(position);
//    }
}
