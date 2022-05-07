package com.example.fragmentcalendar;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class NextCalendarFragment extends Fragment {
    GridView gv;
    MonthAdapter adt;
    int height;
    MainActivity act;

    Display dis;
    public void OnAttach(Context context){
        super.onAttach(context);
        act = (MainActivity)getActivity();
    }

    public void OnDetach(){
        super.onDetach();
        act = null;
    }


    public NextCalendarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //프래그먼트 메인을 인플레이트해주고 컨테이너에 붙여달라는 뜻임
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar , container, false);
        gv = (GridView)rootView.findViewById(R.id.monthView);
        adt = new MonthAdapter(getContext());
        adt.setNextMonth();
        gv.setAdapter(adt);
        return rootView;
    }
}