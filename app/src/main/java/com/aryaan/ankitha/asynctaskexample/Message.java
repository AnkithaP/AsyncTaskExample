package com.aryaan.ankitha.asynctaskexample;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ankitha on 11/24/2016.
 */
public class Message {
    public static void logMessage(String message){
        Log.d("ANKI",message);
    }
    public static void toastMessage(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
