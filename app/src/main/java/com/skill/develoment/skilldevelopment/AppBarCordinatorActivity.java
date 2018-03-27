package com.skill.develoment.skilldevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AppBarCordinatorActivity extends AppCompatActivity {

    private Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_cordinator);
        toolBar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
    }
}
