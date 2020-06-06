package com.example.user.classroom;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private static  final String TAG = "Login";
    private SharedPreferences mPreferences ;
    private CircleImageView profile;
    private ImageView camera;
    private String userChosenTask;
    private EditText editText;

    Button btn;
    Uri imageuri;

    private int REQUEST_CAMERA=0,SELECT_FILE=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_login);
            mPreferences = getSharedPreferences ( "myperference",Activity.MODE_PRIVATE );
            setUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUI(){
        profile = (CircleImageView)findViewById(R.id.imageView );
        editText = (EditText)findViewById(R.id.username);
        camera = (ImageView)findViewById(R.id.imageViewbtn);
        camera.setOnClickListener(this);
        btn=(Button)findViewById(R.id.btnenter);
        if(mPreferences.getBoolean("logged",false)){
            goToMainActivity();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putPreference ();
                goToMainActivity ();
                mPreferences.edit().putBoolean("logged",true).apply();
            }
        });
        getPreference ();

    }


    @Override
    public void onClick (View View){

        switch (View.getId()){

            case R.id.imageViewbtn:

                selectImage();

                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    private void selectImage(){

        final CharSequence[] item = {"กล้อง","เลือกรูปภาพ"};

        AlertDialog.Builder builder= new AlertDialog.Builder(Login.this);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean result= com.example.user.classroom.Utility.checkPermission(Login.this);

                if (item[which].equals("กล้อง")){
                    userChosenTask="กล้อง";
                    if(result)
                        cameraIntent();

                } else if (item[which].equals("เลือกรูปภาพ")){
                    userChosenTask="เลือกรูปภาพ";
                    if(result)
                        galleryIntent();
                }

            }
        });
        builder.show();


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
            editor.putString ("pref_img",path);
            editor.commit();
            loadImageFromStorage (getPreferenceImg ());
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }
    private void putPreference(){
        EditText editText = (EditText)findViewById ( R.id.username );
        String userName = editText.getText ().toString ();

        SharedPreferences.Editor editor = mPreferences.edit ();
        editor.putString ("pref_user",userName );
        editor.commit ();
    }

    private void getPreference(){
        if (mPreferences.contains ( "pref_user" )){
            String userName = mPreferences.getString ( "pref_user","" );
            EditText editText = (EditText)findViewById ( R.id.username );
            editText.setText ( userName );
        }
    }

    public void goToMainActivity(){
        Intent intent = new Intent(Login.this,Login1.class);
        startActivity(intent);
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream (f));
            profile = (CircleImageView)findViewById(R.id.imageView );
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
}
