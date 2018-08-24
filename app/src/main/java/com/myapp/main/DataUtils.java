package com.myapp.main;

import java.util.ArrayList;

/**
 * Created by jian.shui on 2018/7/27.
 */

public class DataUtils {

    public static ArrayList<String> getMonthList(){
        ArrayList<String> listMonth=new ArrayList<>();
        for(int i=1;i<=12;i++){
            listMonth.add(i+"月");
        }
        return listMonth;
    }

    public static ArrayList<ArrayList<String>> getDayList(){
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        ArrayList<String> listDay=new ArrayList<>();
        for(int i=1;i<=30;i++){
            listDay.add(i+"号");
        }
        list.add(listDay);
        return list;
    }


    public static ArrayList<String> getYearIncome(){
        ArrayList<String> listIncome=new ArrayList<>();
        for(int i=1;i<=30;i++){
            listIncome.add(i+"%");
        }
        return listIncome;
    }

}
