package com.example.android.customizelistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class FirstActivity extends AppCompatActivity {

    ListView lstView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        lstView = (ListView) findViewById(R.id.lstView);
        CustomizedListView adapter = new CustomizedListView(FirstActivity.this);

        //set customized.xml to first_activity.xml
        lstView.setAdapter(adapter);


    }

}
