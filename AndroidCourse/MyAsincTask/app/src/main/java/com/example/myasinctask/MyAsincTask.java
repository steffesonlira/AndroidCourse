package com.example.myasinctask;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsincTask extends AsyncTask<Void, Void, Integer> {

    TextView textViewST;

    public MyAsincTask(TextView textSleepingTime){
            this.textViewST = textSleepingTime;
        }

    @Override
    protected Integer doInBackground(Void... voids) {
        int sleepingTime = 5000;

        try{
            Thread.sleep(sleepingTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return sleepingTime;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        textViewST.setText("A Thread dormiu por: "+integer);
    }

//    @Override
//    protected void onProgressUpdate(Void... values) {
//        super.onProgressUpdate(values);
//        //textViewST.setText("Loading...");
//    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textViewST.setText("Sleeping...");
    }
}
