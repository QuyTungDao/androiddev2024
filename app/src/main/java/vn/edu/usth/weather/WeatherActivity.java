package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ViewPager2 viewPager = findViewById(R.id.vp1);
        WeatherPagerAdapter pagerAdapter = new WeatherPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

//        MediaPlayer music = MediaPlayer.create(WeatherActivity.this,R.raw.music);
//        music.start();

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Paris");
                    break;
                case 1:
                    tab.setText("Tokyo");
                    break;
                case 2:
                    tab.setText("London");
                    break;
            }
        }).attach();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            requestNetworkByAsyncTask();
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void requestNetworkByAsyncTask() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected void onPostExecute(Bitmap bitmap) {
                Toast.makeText(getApplicationContext(),
                        "Request Network....", Toast.LENGTH_SHORT).show();
            }
        };
        task.execute();
    }


//        public void simulateNetworkRequest(){
//            Toast.makeText(this,"Refreshing...",Toast.LENGTH_SHORT).show();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        Thread.sleep(2000);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(WeatherActivity.this,"Refresh complete!!!",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//            }).start();
//        }

        @Override
        protected void onPause () {
            super.onPause();
        }

        @Override
        protected void onResume () {
            super.onResume();
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
        }
    }

