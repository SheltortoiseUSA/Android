package com.sheltortoiseusa.asynctaskcounter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Integer count;
    public boolean isWorking;

    public TextView countTextView;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        isWorking = false;
        countTextView = (TextView) findViewById(R.id.textView);
    }
    public void workItOut(View view) {
        if(view.getId() == R.id.stopBtn) {
            isWorking = false;
        }
        else {
            isWorking = true;

            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(count);
        }
    }
    public class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {
        private Integer count;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            count = 0;
        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            count = integers[0];

            while(isWorking) {
                try {
                    Thread.sleep(500);

                    count++;
                    publishProgress(count);
                }
                catch(InterruptedException e) {
                    Log.i("ERROR", e.getMessage());
                }
            }
            return count;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            countTextView.setText(" " + values[0].toString());
        }
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }
}
