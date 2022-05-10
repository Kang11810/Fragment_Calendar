package com.example.fragmentcalendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;


public class WeekPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> mFragments;


    public WeekPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList list) {
        super(fragmentActivity);
        this.mFragments = list;
    }

    // 각 페이지를 나타내는 프래그먼트 반환
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments.get(position);
    }
    // 전체 페이지 개수 반환
    @Override
    public int getItemCount() {
        return mFragments.size();
    }

}
