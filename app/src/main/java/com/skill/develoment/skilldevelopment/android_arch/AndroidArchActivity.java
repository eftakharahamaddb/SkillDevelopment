package com.skill.develoment.skilldevelopment.android_arch;

import android.arch.persistence.room.Room;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.skill.develoment.skilldevelopment.R;
import com.skill.develoment.skilldevelopment.businesslogic.SampleApp;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

public class AndroidArchActivity extends AppCompatActivity {
    ArrayList<User> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_arch);
        AppDatabase db = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class,"user_db_name")
                .build();
        UserDao userDao = db.userDao();

        list.add(new User(1,"Eftakhar","Ahamad"));
        list.add(new User(2,"Amit","Singh"));
        list.add(new User(3,"Rishab","Jain"));
        list.add(new User(4,"Arti","Pandey"));


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                userDao.insertUsers(list);
            }
        });
        t.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> all = userDao.getAll();
                Log.e("Data",""+all);
            }
        });


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                t2.start();
            }
        },4000);

//        SampleApp sampleApp = (SampleApp) getApplication();
//        sampleApp.getControllerComponent().inject(this);

    }
}
