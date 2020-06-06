package com.example.user.classroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.jetbrains.annotations.NotNull;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setBottomNavigationView();
    }
    public void setBottomNavigationView() {
        //<dimens name="design_navigation_icon_size" tools:override="true">40dp</dimens>
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_pro: {
                        Intent intent = new Intent ( CalendarActivity.this, Login2.class );
                        startActivity ( intent );
                        return true;
                    }

                    case R.id.navigation_table: {
                        Intent intent = new Intent ( CalendarActivity.this, ShowTableActivity.class );
                        startActivity ( intent );
                        return true;
                    }

                    case R.id.navigation_calen: {
                        return true;
                    }

                    case R.id.navigation_set: {
                        Intent intent = new Intent ( CalendarActivity.this, Setting.class );
                        startActivity ( intent );
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
