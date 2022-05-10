package com.example.fragmentcalendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

public class WeekItemView extends AppCompatTextView {
        private WeekItem item; //item 이라는 WeekItem 객체 생성

        public WeekItemView(Context context){
            super(context);
            init();
        }

        public WeekItemView(Context context, AttributeSet attrs){
            super(context, attrs);
            init();
        }
        /*WeekItemView 클래스 생성 (WeekItem 을 보여주기 위한 클래스)*/
        private void init(){
            setBackgroundColor(Color.WHITE); //배경색을 하얀색으로 설정(초기화)
        }

        public void setItem(WeekItem item){
            //item 값을 설정하는 함수
            this.item = item;
            int day = item.getDay(); //날자를 받아옴

            if (day != 0) {
                setText(String.valueOf(day));
                setGravity(Gravity.CENTER);
                setTextColor(Color.BLACK);
                setTextSize(20);
            }
            else{
                setText("");
            }
            /*날짜 값이 0이라면 ""을, 아니라면 각 날짜를 View 의 Text 에 입력*/
        }
}
