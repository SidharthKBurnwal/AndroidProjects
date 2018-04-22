package com.example.android.twopageapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    EditText edtName;
    EditText edtEmail;
    EditText edtUserName;
    EditText edtPassword;
    ImageView imgAnimal;
    RadioGroup radioGroup;
    Button btnAdd;
    String genderType;
    final int IMAGE_REQUEST_CODE = 1000;
    String photoPath = "";
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtUserName  = (EditText) findViewById(R.id.edtUserName);
        edtPassword  = (EditText) findViewById(R.id.edtPassword);
        imgAnimal = (ImageView) findViewById(R.id.imgAnimal);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnAdd =(Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(MainActivity.this);

        radioGroup.setOnCheckedChangeListener(MainActivity.this);

        imgAnimal.setOnClickListener(MainActivity.this);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tiger);
        imgAnimal.setImageBitmap(bitmap);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAdd:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAME", edtName.getText().toString());
                intent.putExtra("EMAIL", edtEmail.getText().toString());
                intent.putExtra("USER_NAME", edtUserName.getText().toString());
                intent.putExtra("PASSWORD", edtPassword.getText().toString());
                intent.putExtra("GENDER_TYPE" , genderType);

                //pass the image from this activity to another activity
                //convert the image into byte array
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100,stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("picture" , byteArray);

                //starting the second activity
                startActivity(intent);

                break;

            case R.id.imgAnimal:
                //access the image inside the device's photo application
                Intent intentImage = new Intent(Intent.ACTION_GET_CONTENT);
                intentImage.setType("image/*");
                // specific code for that particular image
                startActivityForResult(intentImage, IMAGE_REQUEST_CODE);

                //to end the app there, app will close if you press back
                finish();
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        super.onActivityResult(requestCode,resultCode,data);

        switch (requestCode){
            case IMAGE_REQUEST_CODE:
                //if a image is succefully selected from device
                if(resultCode == RESULT_OK){
                    Uri chosenImage = data.getData();
                    try{
                        bitmap = MediaStore.Images.Media.getBitmap
                                (getContentResolver(),chosenImage);
                        imgAnimal.setImageBitmap(bitmap);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.radioMale:
                genderType = "MALE";
                break;
            case R.id.radioFemale:
                genderType = "FEMALE";
                break;
        }

    }
}
