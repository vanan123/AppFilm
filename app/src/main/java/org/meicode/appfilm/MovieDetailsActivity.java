package org.meicode.appfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MovieDetailsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ImageView movie_img;
    Button play_btn;
    TextView movie_name;
    String mName,mImage,mId,mFileUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        initViews();
        setInfo();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            bottomNavigationView.getMenu().setGroupCheckable(0, true, true);
            switch (item.getItemId()) {
                case R.id.menu_item_acc:
                    SharedPreferences loginSharedPreferences = getApplicationContext().getSharedPreferences("isLoggedIn", MODE_PRIVATE);
                    Boolean isLoggin = loginSharedPreferences.getBoolean("isLoggedIn", false);
                    if(isLoggin) {
                        Intent userProfileIntent = new Intent(this, UserProfileActivity.class);
                        startActivity(userProfileIntent);
                    } else {
                        startActivity(new Intent(MovieDetailsActivity.this, LoginActivity.class));
                    }
                    return true;
                case R.id.menu_item_home:
                    startActivity(new Intent(this, MainActivity.class));
                    return true;
                case R.id.menu_item_fav:
                    Toast.makeText(this,"Favorite clicked", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MovieDetailsActivity.this,VideoPlayerActivity.class);
                i.putExtra("url",mFileUrl);
                startActivity(i);
            }
        });
    }

    private void setInfo() {
        mId = getIntent().getStringExtra("movieId");
        mName = getIntent().getStringExtra("movieName");
        mImage = getIntent().getStringExtra("movieImageUrl");
        mFileUrl = getIntent().getStringExtra("movieFile");
        Glide.with(this).load(mImage).into(movie_img);
        movie_name.setText(mName);
    }

    private void initViews() {
        movie_img  = findViewById(R.id.movie_img);
        movie_name = findViewById(R.id.movie_name);
        play_btn= findViewById(R.id.play_btn);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);
    }
}