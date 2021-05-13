package org.meicode.appfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {
    ImageView movie_img;
    Button play_btn;
    TextView movie_name;
    String mName,mImage,mId,mFileUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movie_img  = findViewById(R.id.movie_img);
        movie_name = findViewById(R.id.movie_name);
        play_btn= findViewById(R.id.play_btn);
        //
        mId = getIntent().getStringExtra("movieId");
        mName = getIntent().getStringExtra("movieName");
        mImage = getIntent().getStringExtra("movieImageUrl");
        mFileUrl = getIntent().getStringExtra("movieFile");

        Glide.with(this).load(mImage).into(movie_img);
        movie_name.setText(mName);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MovieDetails.this,VideoPlayerActivity.class);
                i.putExtra("url",mFileUrl);
                startActivity(i);
            }
        });
    }
}