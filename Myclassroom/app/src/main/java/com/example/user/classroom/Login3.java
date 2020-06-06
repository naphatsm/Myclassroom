package com.example.user.classroom;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
public class Login3 extends AppCompatActivity {

    private CircleImageView profile;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private String userChosenTask;
    private TextView mTextMessage;
    private SharedPreferences mPreferences;
    private int REQUEST_CAMERA=0,SELECT_FILE=1;
    private TextInputEditText textInputEditText;
    private Button button;
    private SharedPreferences.Editor editor;
    String input_text;
    Uri imageuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login3 );
        mPreferences = getSharedPreferences ( "myperference",Activity.MODE_PRIVATE );
        getPreference ();
        loadImageFromStorage ( getPreferenceImg () );
        mTextMessage = (TextView) findViewById ( R.id.message );
        BottomNavigationView bottomnavigation = (BottomNavigationView) findViewById ( R.id.bottomnavigationView );
        bottomnavigation.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener );

        NavigationView navigationView = (NavigationView) findViewById ( R.id.navigation );
        navigationView.setNavigationItemSelectedListener ( mNavigationItemSelectedListener );

        dl = (DrawerLayout) findViewById ( R.id.drawer );
        abdt = new ActionBarDrawerToggle ( this, dl, R.string.open, R.string.close );
        dl.addDrawerListener ( abdt );
        abdt.syncState ();
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        profile = (CircleImageView) findViewById ( R.id.imageView3 );

        button ();
        if(mPreferences.getBoolean("note",false)){
            getSharedPreferences ();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener () {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            switch (Item.getItemId ()) {
                case R.id.navigation_pro: {
                    Intent intent = new Intent ( Login3.this, Login2.class );
                    startActivity ( intent );
                    return true;
                    }

                case R.id.navigation_table: {
                    Intent intent = new Intent ( Login3.this, ShowTableActivity.class );
                    startActivity ( intent );
                    return true;
                    }
                case R.id.navigation_calen: {
                    Intent intent = new Intent ( Login3.this, CalendarActivity.class );
                    startActivity ( intent );
                    return true;
                }
                case R.id.navigation_set: {
                    Intent intent = new Intent ( Login3.this, Setting.class );
                    startActivity ( intent );
                    return true;
                }
            }
            return false;
        }

    };

    private NavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener () {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            int id = Item.getItemId ();

            if (id == R.id.edit_profile) {
                mPreferences.edit().putBoolean("logged",false).apply();
                Intent i = new Intent ( Login3.this,Login.class );
                startActivity ( i );

            }
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected ( item )) {
            return true;
        }
        return super.onOptionsItemSelected ( item );
    }

    private void galleryIntent(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent,"Select File"),SELECT_FILE);

    }

    private void cameraIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CAMERA);

    }


    @Override

    public void onRequestPermissionsResult (int requestCode,String [] permissions,int [] grantResults){
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if(grantResults.length>0&& grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (userChosenTask.equals("กล้อง"))
                        cameraIntent();
                    else if (userChosenTask.equals("เลือกรูปภาพ"))
                        galleryIntent();
                }else {
                    //code for deny
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode== Activity.RESULT_OK) {
            if(requestCode==SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if(requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data) ;
        }
    }

    public void onCaptureImageResult(Intent data)  {
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        SharedPreferences.Editor editor = mPreferences.edit ();
        String path = saveToInternalStorage ( bitmap );
        editor.putString ("pref_img",path);
        editor.commit();
        loadImageFromStorage (getPreferenceImg ());
    }

    private void onSelectFromGalleryResult(Intent data){

        imageuri=data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageuri);
            SharedPreferences.Editor editor = mPreferences.edit ();
            String path = saveToInternalStorage ( bitmap );
            editor.putString ( "pref_img",path);
            editor.commit();
            loadImageFromStorage ( getPreferenceImg () );
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
    private void getPreference(){
        if (mPreferences.contains ( "pref_user" )){
            String userName = mPreferences.getString ( "pref_user","" );
            TextView textView = (TextView)findViewById ( R.id.textView4 );
            textView.setText ( userName );
        }
    }
    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream (f));
            profile = (CircleImageView)findViewById(R.id.imageView3 );
            profile.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper (getApplicationContext ());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir1", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
    private String getPreferenceImg(){
        if (mPreferences.contains ( "pref_img" )){
            String userName = mPreferences.getString ( "pref_img","" );
            return userName;
        }
        return "";
    }

    private void getSharedPreferences(){
        if(mPreferences.contains ( "text" )){
            input_text = mPreferences.getString ( "text","" );
            textInputEditText = (TextInputEditText)findViewById ( R.id.etMessage );
            textInputEditText.setText ( input_text );
        }
    }

    private void button(){
        button = (Button)findViewById ( R.id.btnnote );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                textInputEditText = (TextInputEditText)findViewById ( R.id.etMessage );
                input_text = textInputEditText.getText ().toString ();
                editor = mPreferences.edit ();
                editor.putString ( "text",input_text );
                editor.commit ();
                mPreferences.edit().putBoolean("note",true).apply();
            }
        } );
    }
}
