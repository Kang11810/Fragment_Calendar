package com.example.fragmentcalendar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class PagerAdapter extends FragmentStateAdapter {
    int month ;
    private static int NUM_ITEMS=3;

    PreCalendarFragment pre = new PreCalendarFragment();
    CalendarFragment now = new CalendarFragment();
    NextCalendarFragment next = new NextCalendarFragment();

    public PagerAdapter(FragmentActivity fa) {
        super(fa);
    }


    // 각 페이지를 나타내는 프래그먼트 반환
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return pre;
            case 1:
                return now;
            case 2:
                return next;
            default:
                return null;
        }
    }
    // 전체 페이지 개수 반환
    @Override
    public int getItemCount() {
        return NUM_ITEMS;
    }

}
