package com.linda.movie_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class YtsAdapter extends RecyclerView.Adapter<YtsAdapter.MyViewHolder>{
    private static final String TAG = "YtsAdapter";
    private List<YtsData.MyData.Movie> movies = new ArrayList<>();

    public void addItem(YtsData.MyData.Movie movie){
        movies.add(movie);
    }

    public void addItems(List<YtsData.MyData.Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cardItemView = inflater.inflate(R.layout.card_item, parent,false);
        Log.d(TAG, "onCreateViewHolder: "+"cardItem생성됨");
        return new MyViewHolder(cardItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.setItem(movies.get(position));
        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //책꽂이(View들을 채워두면 된다.)
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //card_item 에 있는 view들을 여기에 다 찾아요!
        private ImageView ivPoster;
        private TextView tvTitle;
        private TextView tvRating;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
            ratingBar = itemView.findViewById(R.id.rating_bar);

          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "클릭됨"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        //데이터 바인딩하기
        public void setItem(YtsData.MyData.Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvRating.setText(movie.getRating() + "");
            Picasso.get().load(movie.getMedium_cover_image()).into(ivPoster); //http주소
            ratingBar.setRating(movie.getRating() / 2);
        }
    }
}
