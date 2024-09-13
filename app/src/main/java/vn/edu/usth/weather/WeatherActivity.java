package vn.edu.usth.weather;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    private ViewPager2 viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        viewpager2 = findViewById(R.id.vp1);
        WeatherPagerAdapter WeatherPagerAdapter = new WeatherPagerAdapter(this);
        WeatherPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Paris");
        WeatherPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Tokyo");
        WeatherPagerAdapter.addFragment(new WeatherAndForecastFragment(),"London");
        viewpager2.setAdapter(WeatherPagerAdapter);

        Log.i(TAG, "ON_CREATE");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ON_RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ON_PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ON_DESTROY");
    }

}