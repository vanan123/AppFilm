package org.meicode.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import org.meicode.appfilm.MovieDetails;
import org.meicode.appfilm.R;
import org.meicode.appfilm.model.BannerMovie;

import java.util.ArrayList;

public class BannerMoviesAdapter extends PagerAdapter {
    Context cont;
    ArrayList<BannerMovie> BannerList;

    public BannerMoviesAdapter(Context cont, ArrayList<BannerMovie> bannerList) {
        this.cont = cont;
        BannerList = bannerList;
    }

    @Override
    public int getCount() {
        return BannerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(cont).inflate(R.layout.banner_movies,null);
        ImageView imgBanner = view.findViewById(R.id.banner_img);
        Glide.with(cont).load(BannerList.get(position).getImgUrl()).into(imgBanner);
        container.addView(view);
        imgBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cont, MovieDetails.class);
                i.putExtra("movieId",BannerList.get(position).getId());
                i.putExtra("movieName",BannerList.get(position).getMovieName());
                i.putExtra("movieImageUrl",BannerList.get(position).getImgUrl());
                i.putExtra("movieFile",BannerList.get(position).getFileUrl());
                cont.startActivity(i);
            }
        });
        return view;
    }
}
