package com.example.fragmentcalendar;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class PreCalendarFragment extends Fragment {
    Calendar cal;
    GridView gv;
    MonthAdapter adt;
    MainActivity act;
    int year;
    int month;

    public static PreCalendarFragment newCalendar() {
        PreCalendarFragment fragment = new PreCalendarFragment();
        return fragment;
    }

    public void OnAttach(Context context){
        super.onAttach(context);
        act = (MainActivity)getActivity();
    }

    public void OnDetach(){
        super.onDetach();
        act = null;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //프래그먼트 메인을 인플레이트해주고 컨테이너에 붙여달라는 뜻임
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar , container, false);
        gv = rootView.findViewById(R.id.monthView);
        adt = new MonthAdapter(getContext());
        adt.setPreviousMonth();
        gv.setAdapter(adt);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonthItem item = (MonthItem) adt.getItem(i);  //날짜값을 받아올 MonthItem 객체 생성
                if (item.getDay() > 0) { //날짜가 존재한다면(날짜가 존재하지 않으면 날짜값이 0임)
                    Toast.makeText(getActivity().getApplicationContext(), adt.ThisYear + "."
                                    + (adt.ThisMonth + 1) + "." + item.getDay(),
                            Toast.LENGTH_SHORT).show();
                    if(((MonthItem) adt.getItem(i)).on==false) {
                        view.setBackgroundColor(CYAN);
                        ((MonthItem) adt.getItem(i)).on=true;
                    }
                    else {
                        view.setBackgroundColor(WHITE);
                        ((MonthItem) adt.getItem(i)).on=false;
                    }
                    /*adt 의 년,월 Item 의 날짜값을 토스트메세지로 출력*/
                }
            }
        });
        return rootView;
    }

}