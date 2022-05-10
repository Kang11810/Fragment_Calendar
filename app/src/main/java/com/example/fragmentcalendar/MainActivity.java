package com.example.fragmentcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar cal;
    int ThisYear;
    int ThisMonth;
    private ViewPager2 vpPager;

    LinearLayout main;
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
                main = (LinearLayout)findViewById(R.id.main);
                main.setPadding(0,0,0,0);
                ArrayList<Fragment> m_fragments = new ArrayList<>();
                m_fragments.add(PreCalendarFragment.newCalendar());
                m_fragments.add(CalendarFragment.newCalendar());
                m_fragments.add(NextCalendarFragment.newCalendar());
                vpPager = findViewById(R.id.container);
                MonthPagerAdapter m_adapter = new MonthPagerAdapter(this,m_fragments);
                vpPager.setAdapter(m_adapter);
                cal.clear();
                ThisMonth=ThisYear=0;
                cal = Calendar.getInstance();
                ThisYear = cal.get(Calendar.YEAR);   //현재연도값
                ThisMonth = cal.get(Calendar.MONTH)+1; //현재월값
                setTitle(ThisYear+"년 "+ThisMonth+"월");
                vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
                    public void onPageSelected(int position){
                        cal.set(Calendar.MONTH,4);
                        if (position==0){
                            cal.set(Calendar.MONTH,3);
                            ThisMonth=cal.get(Calendar.MONTH)+1;
                            setTitle(ThisYear+"년 "+ThisMonth+"월");
                        }
                        if (position==1){
                            if(ThisMonth==4){
                                cal.add(Calendar.MONTH, +1);
                                ThisMonth=cal.get(Calendar.MONTH)+1;
                                setTitle(ThisYear+"년 "+ThisMonth+"월");
                            }
                            else if(ThisMonth==6){
                                cal.add(Calendar.MONTH, -1);
                                ThisMonth=cal.get(Calendar.MONTH)+1;
                                setTitle(ThisYear+"년 "+ThisMonth+"월");
                            }
                        }
                        if (position==2){
                            cal.set(Calendar.MONTH,5);
                            ThisMonth=cal.get(Calendar.MONTH)+1;
                            setTitle(ThisYear+"년 "+ThisMonth+"월");
                        }
                    }
                });
                return true;
            case R.id.week:
                main = (LinearLayout)findViewById(R.id.main);
                main.setPadding(50,0,0,0);
                ArrayList<Fragment> w_fragments = new ArrayList<>();
                w_fragments.add(PreWeekFragment.weekCalendar());
                w_fragments.add(WeekFragment.weekCalendar());
                w_fragments.add(NextWeekFragment.weekCalendar());
                vpPager = findViewById(R.id.container);
                WeekPagerAdapter w_adapter = new WeekPagerAdapter(this,w_fragments);
                vpPager.setAdapter(w_adapter);
                cal.clear();
                ThisMonth=ThisYear=0;
                cal = Calendar.getInstance();
                ThisYear = cal.get(Calendar.YEAR);   //현재연도값
                ThisMonth = cal.get(Calendar.MONTH)+1; //현재월값
                setTitle(ThisYear+"년 "+ThisMonth+"월");
                vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
                    public void onPageSelected(int position){
                        ThisMonth=5;
                        setTitle(ThisYear+"년 "+ThisMonth+"월");
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = (LinearLayout)findViewById(R.id.main);
        main.setPadding(0,0,0,0);
        ArrayList<Fragment> m_fragments = new ArrayList<>();

        m_fragments.add(PreCalendarFragment.newCalendar());
        m_fragments.add(CalendarFragment.newCalendar());
        m_fragments.add(NextCalendarFragment.newCalendar());

        vpPager = findViewById(R.id.container);
        MonthPagerAdapter m_adapter = new MonthPagerAdapter(this,m_fragments);
        vpPager.setAdapter(m_adapter);
        cal = Calendar.getInstance();
        ThisYear = cal.get(Calendar.YEAR);   //현재연도값
        ThisMonth = cal.get(Calendar.MONTH)+1; //현재월값
        setTitle(ThisYear+"년 "+ThisMonth+"월");

        vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            public void onPageSelected(int position){
                if (position==0){
                    cal.add(Calendar.MONTH, -1);
                    ThisMonth=cal.get(Calendar.MONTH)+1;
                    setTitle(ThisYear+"년 "+ThisMonth+"월");
                }
                if (position==1){
                    if(ThisMonth==4){
                        cal.add(Calendar.MONTH, +1);
                        ThisMonth=cal.get(Calendar.MONTH)+1;
                        setTitle(ThisYear+"년 "+ThisMonth+"월");
                    }
                    else if(ThisMonth==6){
                        cal.add(Calendar.MONTH, -1);
                        ThisMonth=cal.get(Calendar.MONTH)+1;
                        setTitle(ThisYear+"년 "+ThisMonth+"월");
                    }
                }
                if (position==2){
                    cal.add(Calendar.MONTH, +1);
                    ThisMonth=cal.get(Calendar.MONTH)+1;
                    setTitle(ThisYear+"년 "+ThisMonth+"월");
                }
            }
        });
    }
}