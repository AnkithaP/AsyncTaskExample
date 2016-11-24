package com.aryaan.ankitha.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mainList;
    String[] texts = {"abandon","ability","able","above","absent","accept","account","act","add","adopt",
                        "baby","bag","bad","bake","ball","bar","bed","barrel","base","bat",
                        "cab","cabin","cafe","cake","call","camera","cancel","candle","cap","cape",
                        "daily","dam","damage","diary","dance","dark","day","date","daughter","dirt",
                        "eagle","ear","earn","easy","east","eat","eclipse","echo","edge","education",
                        "face","fail","fade","fabric","fair","faithful","fate","fake","fall","family",
                        "game","gallery","gate","gas","gear","genius","gentle","gaze","genuine","gem"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);//10000
        setContentView(R.layout.activity_main);
        mainList = (ListView)findViewById(R.id.listView);
        mainList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void,String,Void>{

        private ArrayAdapter<String> adapter;
        private int count = 0;
        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) mainList.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String item : texts){
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            setProgress((int)(((double)count/texts.length)*10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
            Message.toastMessage(MainActivity.this,"All the items were added successfully");

        }
    }
}
