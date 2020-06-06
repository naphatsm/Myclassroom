package com.example.user.classroom;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ShowTableActivity extends AppCompatActivity {

    ImageButton chageName, plusData;
    TextView tv1;
    String string1;
    AlertDialog dialog;
    DBhelper dBhelper;
    Cursor res2;
    int maxLength = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_show_table );
        dBhelper = new DBhelper ( this );
        chageNameTable ();
        addData ();
        showData ();
        addTable ();
        setBottomNavigationView ();


    }

    public void addData() {
        plusData = (ImageButton) findViewById ( R.id.addData );
        plusData.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent ( ShowTableActivity.this, AddDataActivity.class );
                startActivity ( intent );
            }
        } );
    }


    @Override
    public void onRestart() {
        super.onRestart ();
        finish ();
        startActivity ( getIntent () );
    }

    public void chageNameTable() {
        chageName = (ImageButton) findViewById ( R.id.editNametable );
        chageName.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                tv1 = (TextView) findViewById ( R.id.headNameBar );
                AlertDialog.Builder popup = new AlertDialog.Builder ( ShowTableActivity.this );
                View view = getLayoutInflater ().inflate ( R.layout.set_name_table, null );
                final EditText setName = (EditText) view.findViewById ( R.id.nameText );
                Button cancle = (Button) view.findViewById ( R.id.cancle );
                Button ok = (Button) view.findViewById ( R.id.ok );
                ok.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        string1 = setName.getText ().toString ();
                        if (string1.isEmpty ()) {
                            Toast.makeText ( ShowTableActivity.this, "Please Enter Name", Toast.LENGTH_LONG ).show ();
                        } else if (string1.length () > maxLength) {
                            Toast.makeText ( ShowTableActivity.this, "Do not exceed 8 characters", Toast.LENGTH_LONG ).show ();
                        } else {
                            Toast.makeText ( ShowTableActivity.this, "Changed Name", Toast.LENGTH_LONG ).show ();
                            tv1.setText ( string1 );
                            boolean inserted = dBhelper.addName ( string1 );//save ลง DB
                            boolean updatename = dBhelper.updateName ( string1 );
                            closePopup ();
                        }
                    }
                } );
                cancle.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        closePopup ();
                    }
                } );
                popup.setView ( view );
                dialog = popup.create ();
                dialog.show ();
            }

            public void closePopup() {
                if (dialog != null) dialog.cancel ();
            }

        } );
    }

    public void showData() {
        tv1 = (TextView) findViewById ( R.id.headNameBar );
        Cursor res = dBhelper.getNameTable ();
        if (res.getCount () == 0) {
            return;
        }
        StringBuffer buffer = new StringBuffer ();
        while (res.moveToNext ()) {
            buffer.append ( res.getString ( 1 ) );
        }
        tv1.setText ( buffer.toString () );
    }


    public void addTable() {
        int i = 0;
        double y = 0;
        double y1 = 0;
        double y2 = 0;
        int x = 0;
        res2 = dBhelper.getDataTable ();
        TextView[] tv = new TextView[100];
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) findViewById ( R.id.ablayout );
        while (res2.moveToNext ()) {
            final StringBuffer[] buffer = new StringBuffer[100];
            final StringBuffer buffer1 = new StringBuffer ();
            final StringBuffer buffer2 = new StringBuffer ();
            final StringBuffer buffer3 = new StringBuffer ();
            final StringBuffer buffer5 = new StringBuffer ();
            final StringBuffer buffer6 = new StringBuffer ();
            final StringBuffer buffer7 = new StringBuffer ();
            final StringBuffer buffer8 = new StringBuffer ();
            final StringBuffer buffer9 = new StringBuffer ();
            final StringBuffer buffer10 = new StringBuffer ();
            final StringBuffer buffer4 = new StringBuffer ();
            final StringBuffer day = new StringBuffer ();
            final StringBuffer sh = new StringBuffer ();
            final StringBuffer sm = new StringBuffer ();
            final StringBuffer eh = new StringBuffer ();
            final StringBuffer em = new StringBuffer ();
            buffer[i] = new StringBuffer ();
            tv[i] = new TextView ( this );
            tv[i].setBackgroundColor ( Color.CYAN );
            tv[i].setGravity ( Gravity.CENTER );
            day.append ( res2.getString ( 10 ) );

            if (day.toString ().equals ( "Mon" )) {
                x = 142;
            } else if (day.toString ().equals ( "Tue" )) {
                x = 273;
            } else if (day.toString ().equals ( "Wed" )) {
                x = 405;
            } else if (day.toString ().equals ( "Thu" )) {
                x = 536;
            } else if (day.toString ().equals ( "Fri" )) {
                x = 668;
            } else if (day.toString ().equals ( "Sat" )) {
                x = 799;
            } else if (day.toString ().equals ( "Sun" )) {
                x = 931;
            }


            sh.append ( res2.getString ( 11 ) );
            sm.append ( res2.getString ( 12 ) );
            eh.append ( res2.getString ( 13 ) );
            em.append ( res2.getString ( 14 ) );

            if (sh.toString ().equals ( "9" )) {
                y1 = 0;
            } else if (sh.toString ().equals ( "10" )) {
                y1 = 178;
            } else if (sh.toString ().equals ( "11" )) {
                y1 = 357;
            } else if (sh.toString ().equals ( "12" )) {
                y1 = 536;
            } else if (sh.toString ().equals ( "13" )) {
                y1 = 715;
            } else if (sh.toString ().equals ( "14" )) {
                y1 = 894;
            } else if (sh.toString ().equals ( "15" )) {
                y1 = 1073;
            } else if (sh.toString ().equals ( "16" )) {
                y1 = 1252;
            } else if (sh.toString ().equals ( "17" )) {
                y1 = 1431;
            }

            if (sm.toString ().equals ( "0" )) {
                y1 = y1 + 0;
            } else if (sm.toString ().equals ( "5" )) {
                y1 = y1 + 14.9;
            } else if (sm.toString ().equals ( "10" )) {
                y1 = y1 + 29.8;
            } else if (sm.toString ().equals ( "15" )) {
                y1 = y1 + 44.7;
            } else if (sm.toString ().equals ( "20" )) {
                y1 = y1 + 59.6;
            } else if (sm.toString ().equals ( "25" )) {
                y1 = y1 + 74.5;
            } else if (sm.toString ().equals ( "30" )) {
                y1 = y1 + 89.4;
            } else if (sm.toString ().equals ( "35" )) {
                y1 = y1 + 104.3;
            } else if (sm.toString ().equals ( "40" )) {
                y1 = y1 + 119.2;
            } else if (sm.toString ().equals ( "45" )) {
                y1 = y1 + 134.1;
            } else if (sm.toString ().equals ( "50" )) {
                y1 = y1 + 149;
            } else if (sm.toString ().equals ( "55" )) {
                y1 = y1 + 163.9;
            }


            if (eh.toString ().equals ( "9" )) {
                y1 = 0;
            } else if (eh.toString ().equals ( "10" )) {
                y2 = 178;
            } else if (eh.toString ().equals ( "11" )) {
                y2 = 357;
            } else if (eh.toString ().equals ( "12" )) {
                y2 = 536;
            } else if (eh.toString ().equals ( "13" )) {
                y2 = 715;
            } else if (eh.toString ().equals ( "14" )) {
                y2 = 894;
            } else if (eh.toString ().equals ( "15" )) {
                y2 = 1073;
            } else if (eh.toString ().equals ( "16" )) {
                y2 = 1252;
            } else if (eh.toString ().equals ( "17" )) {
                y2 = 1431;
            }

            if (em.toString ().equals ( "0" )) {
                y2 = y2 + 0;
            } else if (em.toString ().equals ( "5" )) {
                y2 = y2 + 14.9;
            } else if (em.toString ().equals ( "10" )) {
                y2 = y2 + 29.8;
            } else if (em.toString ().equals ( "15" )) {
                y2 = y2 + 44.7;
            } else if (em.toString ().equals ( "20" )) {
                y2 = y2 + 59.6;
            } else if (em.toString ().equals ( "25" )) {
                y2 = y2 + 74.5;
            } else if (em.toString ().equals ( "30" )) {
                y2 = y2 + 89.4;
            } else if (em.toString ().equals ( "35" )) {
                y2 = y2 + 104.3;
            } else if (em.toString ().equals ( "40" )) {
                y2 = y2 + 119.2;
            } else if (em.toString ().equals ( "45" )) {
                y2 = y2 + 134.1;
            } else if (em.toString ().equals ( "50" )) {
                y2 = y2 + 149;
            } else if (em.toString ().equals ( "55" )) {
                y2 = y2 + 163.9;
            }

            y = y2 - y1;

            tv[i].setLayoutParams ( new AbsoluteLayout.LayoutParams ( 131, (int) y, x, (int) y1 ) );
            buffer[i].append ( res2.getString ( 1 ) + "\n" );
            buffer1.append ( res2.getString ( 1 ) );
            buffer[i].append ( res2.getString ( 2 ) + "\n" );
            buffer2.append ( res2.getString ( 2 ) );
            buffer[i].append ( res2.getString ( 3 ) + "\n" );
            buffer3.append ( res2.getString ( 3 ) );
            buffer5.append ( res2.getString ( 4 ) );
            buffer6.append ( res2.getString ( 5 ) );
            buffer7.append ( res2.getString ( 6 ) );
            buffer8.append ( res2.getString ( 7 ) );
            buffer9.append ( res2.getString ( 8 ) );
            buffer10.append ( res2.getString ( 9 ) );
            tv[i].setText ( buffer[i].toString () );
            absoluteLayout.addView ( tv[i] );
            buffer4.append ( res2.getInt ( 0 ) + "\n" );
            tv[i].setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent ( ShowTableActivity.this, DetailActivity.class );
                    intent.putExtra ( "A", buffer1.toString () );
                    intent.putExtra ( "B", buffer2.toString () );
                    intent.putExtra ( "C", buffer3.toString () );
                    intent.putExtra ( "E", buffer5.toString () );
                    intent.putExtra ( "F", buffer6.toString () );
                    intent.putExtra ( "G", buffer7.toString () );
                    intent.putExtra ( "H", buffer8.toString () );
                    intent.putExtra ( "Y", buffer9.toString () );
                    intent.putExtra ( "J", buffer10.toString () );
                    intent.putExtra ( "D", buffer4.toString () );
                    intent.putExtra ( "K", day.toString () );
                    intent.putExtra ( "L", sh.toString () );
                    intent.putExtra ( "M", sm.toString () );
                    intent.putExtra ( "N", eh.toString () );
                    intent.putExtra ( "O", em.toString () );
                    startActivity ( intent );
                }
            } );
            i++;
        }
    }

    public void setBottomNavigationView() {
        //<dimens name="design_navigation_icon_size" tools:override="true">40dp</dimens>
        BottomNavigationView bottomNavigationView = findViewById ( R.id.navigationView );
        bottomNavigationView.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId ()) {
                    case R.id.navigation_pro: {
                        Intent intent = new Intent ( ShowTableActivity.this, Login2.class );
                        startActivity ( intent );
                        return true;
                    }
                    case R.id.navigation_table: {
                        return true;
                    }

                    case R.id.navigation_calen: {
                        Intent intent = new Intent ( ShowTableActivity.this, CalendarActivity.class );
                        startActivity ( intent );
                        return true;
                    }

                    case R.id.navigation_set: {
                        Intent intent = new Intent ( ShowTableActivity.this, Setting.class );
                        startActivity ( intent );
                        return true;
                    }
                }
                    return false;
                }
        });
    }
}

