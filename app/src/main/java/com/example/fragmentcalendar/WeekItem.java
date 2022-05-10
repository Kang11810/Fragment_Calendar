package com.example.fragmentcalendar;

public class WeekItem {
    private int day;
    boolean on = false;

    WeekItem(int day){
        this.day =day;
    }

    public int getDay(){
        return day;
    }
}
