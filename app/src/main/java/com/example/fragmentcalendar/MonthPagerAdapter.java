package com.example.fragmentcalendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;


public class MonthPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> mFragments;


    public MonthPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList list) {
        //프래그먼트 리스트를 받아 어댑터 생성
        super(fragmentActivity);
        this.mFragments = list;
    }

    // 각 페이지를 나타내는 프래그먼트 반환
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
