package com.example.pratik.myclicktimer;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.sql.Time;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Pratik on 02-03-2018.
 */

public class MyClick extends ViewModel {
    private long initialTime;
    private Timer timer;
    private MutableLiveData<Long> elapsedTime = new MutableLiveData<>();
    MyClick(){
        initialTime= SystemClock.elapsedRealtime();
        timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        elapsedTime.setValue(newValue);

                    }
                });
            }
        },1000,1000);
    }

    public LiveData<Long> gettimer(){
        return elapsedTime;
    }



}
