package com.example.user.classroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class Setting extends AppCompatActivity {
    TextView reset,faqClick;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        resetpopup();
        setBottomNavigationView();
        faq();
    }
    public void resetpopup(){
        reset = (TextView) findViewById(R.id.resetClick);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder popup = new AlertDialog.Builder(Setting.this);
                View view = getLayoutInflater().inflate(R.layout.setting_popup,null);
                Button ok = (Button) view.findViewById(R.id.ok);
                Button cancel = (Button) view.findViewById(R.id.cancel);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ลบข้อมูลทั้งหมด
                        popupclose();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupclose();
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }
            public void popupclose(){dialog.dismiss();}
        });
    }

    public void faq(){
        faqClick = (TextView)findViewById ( R.id.faqClick );
        faqClick.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( Setting.this,FAQs.class );
                startActivity ( intent );
            }
        } );

    }
    public void setBottomNavigationView() {
        //<dimens name="design_navigation_icon_size" tools:override="true">40dp</dimens>
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_pro: {
                        Intent intent = new Intent ( Setting.this, Login2.class );
                        startActivity ( intent );
                        return true;
                    }
                    case R.id.navigation_table: {
                        Intent intent = new Intent ( Setting.this, Login2.class );
                        startActivity ( intent );
                        return true;
                    }
                    case R.id.navigation_calen: {
                        Intent intent = new Intent ( Setting.this, CalendarActivity.class );
                        startActivity ( intent );
                        return true;
                    }
                    case R.id.navigation_set: {

                        return true;
                    }
                }
                return false;
            }
        });
    }
}
