package com.example.user.classroom;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Login1 extends AppCompatActivity {

    Button button;
    private CircleImageView profile;
    private SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1 );
        profile = (CircleImageView)findViewById ( R.id.imageView4 ) ;
        button=(Button)findViewById(R.id.btnskip);
        mPreferences = getSharedPreferences ( "myperference",Activity.MODE_PRIVATE );
        getPreference ();
        loadImageFromStorage ( getPreferenceImg () );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login1.this,Login2.class);
                startActivity(intent);
            }
        });
    }
    private void getPreference(){
        if (mPreferences.contains ( "pref_user" )){
            String userName = mPreferences.getString ( "pref_user","" );
            TextView textView = (TextView)findViewById ( R.id.textView2 );
            textView.setText ( userName );
        }
    }

    private String getPreferenceImg(){
        if (mPreferences.contains ( "pref_img" )){
            String userName = mPreferences.getString ( "pref_img","" );
            return userName;
        }
        return "";
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream (f));
            profile = (CircleImageView)findViewById(R.id.imageView4 );
            profile.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
