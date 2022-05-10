package com.example.fragmentcalendar;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class CalendarFragment extends Fragment {
    GridView gv;
    MonthAdapter adt;
    MainActivity act;

    public static CalendarFragment newCalendar() {  //새로운 CalendarFragment 생성
        return new CalendarFragment();
    }

    public void OnAttach(Context context){ //Context를 받아와 프래그먼트를 붙여주는 함수
        super.onAttach(context);
        act = (MainActivity)getActivity();
    }

    public void OnDetach(){ //연결되어있는 프래그먼트를 해제하는 함수
        super.onDetach();
        act = null;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //프래그먼트의 뷰를 메인에서 보여주기위한 함수
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar , container, false);
        //fragment_calendar의 View그룹인 rootView객체 생성
        gv = rootView.findViewById(R.id.monthView); //monthView를 참조하여 GridView 객체 생성
        adt = new MonthAdapter(getContext());       //프래그먼트의 Context를 구하여 MonthAdapter 객체 생성
        gv.setAdapter(adt);                         //GridView 객체에 어뎁터설정
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //GridView 객체 클릭이벤트 설정
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonthItem item = (MonthItem) adt.getItem(i);  //날짜값을 받아올 MonthItem 객체 생성
                if (item.getDay() > 0) { //날짜가 존재한다면(날짜가 존재하지 않으면 날짜값이 0임)
                    Toast.makeText(getActivity().getApplicationContext(), adt.ThisYear + "."
                                    + (adt.ThisMonth + 1) + "." + item.getDay(),
                            Toast.LENGTH_SHORT).show();
                    /*adt 의 년,월 Item 의 날짜값을 토스트메세지로 출력*/
                    if(((MonthItem) adt.getItem(i)).on==false) {
                        view.setBackgroundColor(CYAN);
                        ((MonthItem) adt.getItem(i)).on=true;
                    }
                    else {
                        view.setBackgroundColor(WHITE);
                        ((MonthItem) adt.getItem(i)).on=false;
                    }
                    /*클릭할때마다 아이템의 배경색을 CYAN과 WHITE가 번갈아가며 변경되도록 설정*/
                }
            }
        });
        return rootView;    //뷰 뿌려주기
    }
}