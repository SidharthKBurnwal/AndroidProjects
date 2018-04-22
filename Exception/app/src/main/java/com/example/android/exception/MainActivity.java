package com.example.android.exception;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtRates = (TextView)findViewById(R.id.txtRates);
        TextView txtNumberOfStars = (TextView) findViewById(R.id.txtNumberOfStars);
        String oldTxtRatesValue;
        String oldTxtNumOfStars;

        int[] peopleRates = {1,2,2,3,3,5,2,3,4,4,4,6};
        int[] occurence = new int[6];

        for(int respond = 0 ; respond< peopleRates.length; respond++){
            try {
                occurence[peopleRates[respond]]++;
            }catch (ArrayIndexOutOfBoundsException e){
                Log.i("Log", e.toString());
            }

        }

        for(int amount = 1; amount<occurence.length; amount++){
            oldTxtRatesValue = txtRates.getText().toString();
            oldTxtNumOfStars = txtNumberOfStars.getText().toString();

            txtRates.setText(oldTxtRatesValue + amount + "\n");
            txtNumberOfStars.setText(oldTxtNumOfStars + occurence[amount] + "\n");

        }

    }


}
