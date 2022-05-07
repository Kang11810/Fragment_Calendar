package com.example.fragmentcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    int year = 2022;
    int month = 5;
    String year_month = "";
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        menu.findItem(R.id.month).setChecked(true);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.month:
                ViewPager2 vpPager = findViewById(R.id.container);
                FragmentStateAdapter adapter = new PagerAdapter(this);
                vpPager.setAdapter(adapter);
                vpPager.setCurrentItem(1);
                vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            month = 4;
                            year_month = year+"년 "+month+"월";
                            setTitle(year_month);
                        case 1:
                            month = 5;
                            year_month = year+"년 "+month+"월";
                            setTitle(year_month);
                        case 2:
                            month = 6;
                            year_month = year+"년 "+month+"월";
                            setTitle(year_month);
                    }
                }
            });
                return true;
            case R.id.week:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 vpPager = findViewById(R.id.container);
        PagerAdapter adapter = new PagerAdapter(this);
        vpPager.setAdapter(adapter);
        vpPager.setCurrentItem(1);
        year_month = year+"년 "+month+"월";
        setTitle(year_month);
        vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        month = 4;
                        year_month = year+"년 "+month+"월";
                        setTitle(year_month);
                    case 1:
                        month = 5;
                        year_month = year+"년 "+month+"월";
                        setTitle(year_month);
                    case 2:
                        month = 6;
                        year_month = year+"년 "+month+"월";
                        setTitle(year_month);
                }
            }
        });
    }
}