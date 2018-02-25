package com.tropchop.food.delivery.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cedex on 6/23/2017.
 */

public class StringHandler {


    public static List<String> ArrayToString(String[] strings){

        List<String> stringList = new ArrayList<>();
        for (String string:strings){
            stringList.add(string);
        }

        return stringList;
    }

    public static List<String> filter(List<String> rawList,String filter) {
        List<String> filteredList = new ArrayList<>();
        Iterator<String> iterator = rawList.iterator();
        while (iterator.hasNext()){
            String raw = iterator.next();
            Pattern pattern = Pattern.compile("\\b"+filter+"\\b");
            Matcher matcher = pattern.matcher(raw);

            while (matcher.find()){
                filteredList.add(raw);
                break;
            }
        }
        return filteredList;
    }

    public static <T> String view(List<T> list){
        String listString = "";
        for (T t:list){
            listString += view(t)+"\n";
        }
        return listString;
    }

    public static <T> String view(T t){
        Gson gson = new Gson();
        return gson.toJson(t);
    }
}
