package com.example.android.twopageapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtEmail;
    TextView txtUserName;
    TextView txtPassword;
    TextView txtGenderType;
    ImageView imgReceived;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtGenderType = (TextView) findViewById(R.id.txtGender);
        imgReceived = (ImageView) findViewById(R.id.imgAnimalReceived);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("NAME");
        String email = extras.getString("EMAIL");
        String username = extras.getString("USER_NAME");
        String password = extras.getString("PASSWORD");
        String gender = extras.getString("GENDER_TYPE");

        txtName.setText(name);
        txtEmail.setText(email);
        txtUserName.setText(username);
        txtPassword.setText(password);
        txtGenderType.setText(gender);

        byte[] byteArray = extras.getByteArray("picture");
        //0 for receiving complete picture
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        imgReceived.setImageBitmap(bitmap);

    }
}
