package org.meicode.appfilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.meicode.appfilm.adapter.BannerMoviesAdapter;
import org.meicode.appfilm.adapter.MainRcViewAdapter;
import org.meicode.appfilm.model.AllCategory;
import org.meicode.appfilm.model.BannerMovie;
import org.meicode.appfilm.model.CategoryItem;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    BannerMoviesAdapter AdapterBanner;
    TabLayout IncaditorTab , categoryTab ;
    ViewPager banner;
    ArrayList<BannerMovie> HomeBannerList;
    ArrayList<BannerMovie> TvShowsBannerList;
    ArrayList<BannerMovie> MovieBannerList;
    ArrayList<BannerMovie> KidsBannerList;

    MainRcViewAdapter AdapterRcView;
    RecyclerView MainRcView;
    ArrayList<AllCategory> CateList;
    NestedScrollView nestedScroll;
    AppBarLayout appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_item_acc:
                    SharedPreferences loginSharedPreferences = getApplicationContext().getSharedPreferences("isLoggedIn", MODE_PRIVATE);
                    Boolean isLoggin = loginSharedPreferences.getBoolean("isLoggedIn", false);
                    if(isLoggin) {
                        // neu da dang nhap
                        Intent userProfileIntent = new Intent(this, UserProfileActivity.class);
                        startActivity(userProfileIntent);
                    } else {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }
                    return true;
                case R.id.menu_item_home:
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_item_fav:
                    Toast.makeText(this,"Favorite clicked", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

//Home
        HomeBannerList = new ArrayList<>();
        HomeBannerList.add(new BannerMovie( 1,"Đấu la đại lục","https://i0.wp.com/img.media3s.xyz/image/2021/01/dau-la-dai-luc.jpg", "https://drive.google.com/uc?export=download&id=14qvF_7NmoVbH1lXGJYglTPKzjdF5t7u7"));
        HomeBannerList.add(new BannerMovie( 2,"One Piece","https://i0.wp.com/img.media3s.xyz/image/2018/05/one-piece-vua-hai-tac.jpg", "https://www.youtube.com/watch?v=52c8H4l9UkM"));
        HomeBannerList.add(new BannerMovie( 3,"Naruto","https://i0.wp.com/img.media3s.xyz/image/2016/05/naruto-suc-manh-vi-thu.jpg", "https://www.youtube.com/watch?v=52c8H4l9UkM"));
        HomeBannerList.add(new BannerMovie( 4,"Thanh gươm diệt quỷ","https://i0.wp.com/img.media3s.xyz/image/2021/05/thanh-guom-diet-quy-chuyen-tau-vo-tan.jpg", "https://www.youtube.com/watch?v=52c8H4l9UkM"));
        HomeBannerList.add(new BannerMovie( 5,"86","https://i0.wp.com/img.media3s.xyz/image/2021/04/86.jpg", ""));

//TvShows
        TvShowsBannerList = new ArrayList<>();
        TvShowsBannerList.add(new BannerMovie( 1,"Running Man","https://static.fptplay.net/static/img/share/video/18_06_2020/running-man-thu-thach-than-tuong-fpt-play18-06-2020_15g28-27.jpg?w=282&mode=scale", ""));
        TvShowsBannerList.add(new BannerMovie( 2,"Bạn muốn hẹn hò","https://static.fptplay.net/static/img/share/video/18_06_2020/running-man-thu-thach-than-tuong-fpt-play18-06-2020_15g28-27.jpg?w=282&mode=scale", ""));
        TvShowsBannerList.add(new BannerMovie( 3,"Góc nhìn","https://static.fptplay.net/static/img/share/video/07_05_2021/fpt_play_banner_1920x108007-05-2021_10g41-54.jpg?w=282&mode=scale", ""));
        TvShowsBannerList.add(new BannerMovie( 4,"Running Man","https://static.fptplay.net/static/img/share/video/18_06_2020/running-man-thu-thach-than-tuong-fpt-play18-06-2020_15g28-27.jpg?w=282&mode=scale", ""));
        TvShowsBannerList.add(new BannerMovie( 5,"Running Man","https://static.fptplay.net/static/img/share/video/18_06_2020/running-man-thu-thach-than-tuong-fpt-play18-06-2020_15g28-27.jpg?w=282&mode=scale", ""));
 //Movie
        MovieBannerList = new ArrayList<>();
        MovieBannerList.add(new BannerMovie( 1,"Bẫy thời gian","https://static.fptplay.net/static/img/share/video/13_02_2020/3ntlh2hpoujej1uzn6hrelzr5nv13-02-2020_22g04-42.jpg?w=282&mode=scale&fmt=webp", ""));
        MovieBannerList.add(new BannerMovie( 2,"Bạn muốn hẹn hò","https://static.fptplay.net/static/img/share/video/13_02_2020/3ntlh2hpoujej1uzn6hrelzr5nv13-02-2020_22g04-42.jpg?w=282&mode=scale&fmt=webp", ""));
        MovieBannerList.add(new BannerMovie( 3,"Góc nhìn","https://static.fptplay.net/static/img/share/video/13_02_2020/3ntlh2hpoujej1uzn6hrelzr5nv13-02-2020_22g04-42.jpg?w=282&mode=scale&fmt=webp", ""));
        MovieBannerList.add(new BannerMovie( 4,"Running Man","https://static.fptplay.net/static/img/share/video/13_02_2020/3ntlh2hpoujej1uzn6hrelzr5nv13-02-2020_22g04-42.jpg?w=282&mode=scale&fmt=webp", ""));
        MovieBannerList.add(new BannerMovie( 5,"Running Man","https://static.fptplay.net/static/img/share/video/13_02_2020/3ntlh2hpoujej1uzn6hrelzr5nv13-02-2020_22g04-42.jpg?w=282&mode=scale&fmt=webp", ""));
//Kids
        KidsBannerList = new ArrayList<>();
        KidsBannerList.add(new BannerMovie( 1,"Đấu la đại lục","https://i0.wp.com/img.media3s.xyz/image/2021/01/dau-la-dai-luc.jpg", ""));
        KidsBannerList.add(new BannerMovie( 2,"One Piece","https://i0.wp.com/img.media3s.xyz/image/2018/05/one-piece-vua-hai-tac.jpg", ""));
        KidsBannerList.add(new BannerMovie( 3,"Naruto","https://i0.wp.com/img.media3s.xyz/image/2016/05/naruto-suc-manh-vi-thu.jpg", ""));
        KidsBannerList.add(new BannerMovie( 4,"Thanh gươm diệt quỷ","https://i0.wp.com/img.media3s.xyz/image/2021/05/thanh-guom-diet-quy-chuyen-tau-vo-tan.jpg", ""));
        KidsBannerList.add(new BannerMovie( 5,"86","https://i0.wp.com/img.media3s.xyz/image/2021/04/86.jpg", ""));
        setAdapterBanner(HomeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setAdapterBanner(TvShowsBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setAdapterBanner(MovieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setAdapterBanner(KidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setAdapterBanner(HomeBannerList);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //ItemHome1
        ArrayList<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Running Man","https://i0.wp.com/img.media3s.xyz/image/2018/06/running-man.jpg",""));
        homeCatListItem1.add(new CategoryItem(2,"Boruto","https://i0.wp.com/img.media3s.xyz/image/2017/04/boruto-naruto-the-he-tiep-theo.jpg",""));
        homeCatListItem1.add(new CategoryItem(3,"Trường Ca Hành","https://i0.wp.com/img.media3s.xyz/image/2021/03/truong-ca-hanh.jpg",""));
        homeCatListItem1.add(new CategoryItem(4,"Kính Song Thành","https://i0.wp.com/img.media3s.xyz/image/2021/03/kinh-song-thanh.jpg",""));
        homeCatListItem1.add(new CategoryItem(5,"Dư Sinh","https://i0.wp.com/img.media3s.xyz/image/2020/12/du-sinh.jpg",""));
        //ItemHome2
        ArrayList<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Running Man","https://i0.wp.com/img.media3s.xyz/image/2018/06/running-man.jpg",""));
        homeCatListItem2.add(new CategoryItem(2,"Boruto","https://i0.wp.com/img.media3s.xyz/image/2017/04/boruto-naruto-the-he-tiep-theo.jpg",""));
        homeCatListItem2.add(new CategoryItem(3,"Trường Ca Hành","https://i0.wp.com/img.media3s.xyz/image/2021/03/truong-ca-hanh.jpg",""));
        homeCatListItem2.add(new CategoryItem(4,"Kính Song Thành","https://i0.wp.com/img.media3s.xyz/image/2021/03/kinh-song-thanh.jpg",""));
        homeCatListItem2.add(new CategoryItem(5,"Dư Sinh","https://i0.wp.com/img.media3s.xyz/image/2020/12/du-sinh.jpg",""));
        //ItemHome3
        ArrayList<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"Running Man","https://i0.wp.com/img.media3s.xyz/image/2018/06/running-man.jpg",""));
        homeCatListItem3.add(new CategoryItem(2,"Boruto","https://i0.wp.com/img.media3s.xyz/image/2017/04/boruto-naruto-the-he-tiep-theo.jpg",""));
        homeCatListItem3.add(new CategoryItem(3,"Trường Ca Hành","https://i0.wp.com/img.media3s.xyz/image/2021/03/truong-ca-hanh.jpg",""));
        homeCatListItem3.add(new CategoryItem(4,"Kính Song Thành","https://i0.wp.com/img.media3s.xyz/image/2021/03/kinh-song-thanh.jpg",""));
        homeCatListItem3.add(new CategoryItem(5,"Dư Sinh","https://i0.wp.com/img.media3s.xyz/image/2020/12/du-sinh.jpg",""));
        //ItemHome4
        ArrayList<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"Tokyo Revenger","https://i0.wp.com/img.media3s.xyz/image/2021/04/tokyo-revengers.jpg",""));
        homeCatListItem4.add(new CategoryItem(2,"Boruto","https://i0.wp.com/img.media3s.xyz/image/2017/04/boruto-naruto-the-he-tiep-theo.jpg",""));
        homeCatListItem4.add(new CategoryItem(3,"Trường Ca Hành","https://i0.wp.com/img.media3s.xyz/image/2021/03/truong-ca-hanh.jpg",""));
        homeCatListItem4.add(new CategoryItem(4,"Kính Song Thành","https://i0.wp.com/img.media3s.xyz/image/2021/03/kinh-song-thanh.jpg",""));
        homeCatListItem4.add(new CategoryItem(5,"Dư Sinh","https://i0.wp.com/img.media3s.xyz/image/2020/12/du-sinh.jpg",""));


        CateList = new ArrayList<>();
        CateList.add(new AllCategory(1,"PHIM ĐỀ CỬ", homeCatListItem1));
        CateList.add(new AllCategory(2,"PHIM LẺ MỚI CẬP NHẬT",homeCatListItem2));
        CateList.add(new AllCategory(3,"PHIM BỘ MỚI CẬP NHẬT",homeCatListItem3));
        CateList.add(new AllCategory(4,"PHIM HOẠT HÌNH",homeCatListItem4));
        setAdapterRcView(CateList);
    }

    private void initViews() {
        IncaditorTab = findViewById(R.id.indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScroll = findViewById(R.id.nested_Scroll);
        appBar = findViewById(R.id.appbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void setAdapterBanner(ArrayList<BannerMovie> bannerList){
        banner = findViewById(R.id.banner_viewPager);
        AdapterBanner = new BannerMoviesAdapter(this, bannerList);
        banner.setAdapter(AdapterBanner);
        IncaditorTab.setupWithViewPager(banner);
        Timer slider = new Timer();
        slider.scheduleAtFixedRate(new AutoSlider(), 4000,6000);
        IncaditorTab.setupWithViewPager(banner,true);
    }
    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    if(banner.getCurrentItem() < HomeBannerList.size() - 1 ){
                        banner.setCurrentItem(banner.getCurrentItem() + 1);
                    }
                    else{
                        banner.setCurrentItem(0);
                    }
                }
            });
        }
    }
    public void setAdapterRcView(ArrayList<AllCategory> List){
        MainRcView = findViewById(R.id.main_rcview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        MainRcView.setLayoutManager(layoutManager);
        AdapterRcView = new MainRcViewAdapter(this,List);
        MainRcView.setAdapter(AdapterRcView);
    }
    private void setScrollDefaultState(){
        nestedScroll.fullScroll(View.FOCUS_UP);
        nestedScroll.scrollTo(0,0);
        appBar.setExpanded(true);
    }
}