package com.example.user.classroom;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,s1,s2,s3,s4,s5,s6,s7,e1,e2,e3,e4,e5,e6,e7;
    LinearLayout linearLayout,l2,l3,l4,l5,l6,l7;
    ImageButton b1,b2,b3,b4,b5,b6,b7;
    Button back,save;
    TextInputEditText inputEditText1,inputEditText2,inputEditText3;
    EditText et1,et2,et3,et4,et5,et6,endTime1,endTime2;
    String string1;
    DBhelper dBhelper;
    AlertDialog dialog;
    int sh;
    int sm;
    int sh2;
    int sm2;
    String D;
    int hour_x,minute_x,hour_y,minute_y;
    static final int DIALOG_ID = 0;
    static final int DIALOG_ID2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        dBhelper = new DBhelper(this);
        backToHome();
        saveDataToDB();
        showtimepicker();
        showtimepicker2();
        linearLayout = (LinearLayout) findViewById(R.id.hideLayout);
        l2 = (LinearLayout)findViewById(R.id.hideLayout2);
        l3 = (LinearLayout)findViewById(R.id.hideLayout3);
        l4 = (LinearLayout)findViewById(R.id.hideLayout4);
        l5 = (LinearLayout)findViewById(R.id.hideLayout5);
        l6 = (LinearLayout)findViewById(R.id.hideLayout6);
        l7 = (LinearLayout)findViewById(R.id.hideLayout7);
        tv1 = (TextView)findViewById(R.id.monday);
        tv2 = (TextView)findViewById(R.id.tuesday);
        tv3 = (TextView)findViewById(R.id.wednesday);
        tv4 = (TextView)findViewById(R.id.thursday);
        tv5 = (TextView)findViewById(R.id.friday);
        tv6 = (TextView)findViewById(R.id.saturday);
        tv7 = (TextView)findViewById(R.id.sunday);
        b1 = (ImageButton) findViewById(R.id.bdelete1);
        b2 = (ImageButton) findViewById(R.id.bdelete2);
        b3 = (ImageButton) findViewById(R.id.bdelete3);
        b4 = (ImageButton) findViewById(R.id.bdelete4);
        b5 = (ImageButton) findViewById(R.id.bdelete5);
        b6 = (ImageButton) findViewById(R.id.bdelete6);
        b7 = (ImageButton) findViewById(R.id.bdelete7);
        linearLayout.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
        l6.setVisibility(View.GONE);
        l7.setVisibility(View.GONE);
    }

    public void backToHome(){
        back = (Button) findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
    public void hiding1(View view){
        if (linearLayout.getVisibility()== View.GONE){
            linearLayout.setVisibility(View.VISIBLE);
            D = "Mon";
            timePick();
        }if (linearLayout.getVisibility() == View.VISIBLE){
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding2(View view){
        if (l2.getVisibility()== View.GONE){
            l2.setVisibility(View.VISIBLE);
            D = "Tue";
            timePick();
        }if (l2.getVisibility() == View.VISIBLE) {
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l2.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding3(View view){
        if (l3.getVisibility()== View.GONE){
            l3.setVisibility(View.VISIBLE);
            D = "Wed";
            timePick();
        }if (l3.getVisibility() == View.VISIBLE) {
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l3.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding4(View view){
        if (l4.getVisibility()== View.GONE){
            l4.setVisibility(View.VISIBLE);
            D = "Thu";
            timePick();
        }if (l4.getVisibility() == View.VISIBLE) {
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l4.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding5(View view){
        if (l5.getVisibility()== View.GONE){
            l5.setVisibility(View.VISIBLE);
            D = "Fri";
            timePick();
        }if (l5.getVisibility() == View.VISIBLE) {
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l5.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding6(View view){
        if (l6.getVisibility()== View.GONE){
            l6.setVisibility(View.VISIBLE);
            D = "Sat";
            timePick();
        }if (l6.getVisibility() == View.VISIBLE) {
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l6.setVisibility(View.GONE);
                }
            });
        }
    }
    public void hiding7(View view){
        if (l7.getVisibility()== View.GONE){
            l7.setVisibility(View.VISIBLE);
            D = "Sun";
            timePick();
        }if (l7.getVisibility() == View.VISIBLE) {
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l7.setVisibility(View.GONE);
                }
            });
        }
    }
    public void saveDataToDB(){
        save = (Button) findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEditText1 = (TextInputEditText) findViewById(R.id.nameClass);
                inputEditText2 = (TextInputEditText) findViewById(R.id.nameTeacher);
                inputEditText3 = (TextInputEditText) findViewById(R.id.roomset);
                et1 = (EditText) findViewById(R.id.textDate);
                et2 = (EditText) findViewById(R.id.textTime);
                et3 = (EditText) findViewById(R.id.textRoomtest);
                et4 = (EditText) findViewById(R.id.textDate2);
                et5 = (EditText) findViewById(R.id.textTime2);
                et6 = (EditText) findViewById(R.id.textRoomtest2);
                string1 = (inputEditText1.getText().toString());
                if (!string1.isEmpty()) {
                    boolean insert = dBhelper.addData(string1, inputEditText2.getText().toString(), inputEditText3.getText().toString(),
                            et1.getText().toString(), et2.getText().toString(), et3.getText().toString(),
                            et4.getText().toString(), et5.getText().toString(), et6.getText().toString(), D, sh, sm, sh2, sm2);
                    Toast.makeText(AddDataActivity.this, "SAVED DATA", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddDataActivity.this, ShowTableActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(AddDataActivity.this, "PLASE ENTER NAME CLASS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void timePick(){
        s1 = (TextView) findViewById(R.id.h1);
        e1 = (TextView) findViewById(R.id.h2);
        s2 = (TextView) findViewById(R.id.h3);
        e2 = (TextView) findViewById(R.id.h4);
        s3 = (TextView) findViewById(R.id.h5);
        e3 = (TextView) findViewById(R.id.h6);
        s4 = (TextView) findViewById(R.id.h7);
        e4 = (TextView) findViewById(R.id.h8);
        s5 = (TextView) findViewById(R.id.h9);
        e5 = (TextView) findViewById(R.id.h10);
        s6 = (TextView) findViewById(R.id.h11);
        e6 = (TextView) findViewById(R.id.h12);
        s7 = (TextView) findViewById(R.id.h13);
        e7 = (TextView) findViewById(R.id.h14);
        s1.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s1.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s1.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s1.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s1.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s1.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s1.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s1.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s1.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s1.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s1.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s1.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s1.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s1.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s1.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s1.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s1.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s1.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s1.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s1.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s1.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s1.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s1.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s1.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s1.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s1.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s1.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s1.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s1.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s1.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s1.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s1.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s1.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s1.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s1.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s1.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s1.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s1.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s1.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s1.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s1.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s1.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s1.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s1.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s1.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s1.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s1.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s1.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s1.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s1.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s1.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s1.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s1.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s1.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s1.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s1.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s1.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s1.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s1.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s1.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s1.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s1.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s1.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s1.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s1.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s1.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s1.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s1.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s1.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s1.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s1.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s1.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s1.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s1.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s1.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s1.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s1.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s1.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s1.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s1.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s1.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s1.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s1.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s1.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s1.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s1.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s1.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s1.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s1.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s1.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s1.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s1.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s1.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s1.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s1.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s1.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s1.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e1.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e1.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e1.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e1.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e1.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e1.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e1.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e1.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e1.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e1.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e1.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e1.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e1.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e1.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e1.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e1.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e1.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e1.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e1.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e1.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e1.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e1.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e1.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e1.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e1.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e1.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e1.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e1.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e1.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e1.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e1.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e1.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e1.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e1.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e1.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e1.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e1.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e1.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e1.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e1.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e1.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e1.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e1.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e1.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e1.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e1.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e1.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e1.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e1.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e1.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e1.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e1.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e1.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e1.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e1.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e1.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e1.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e1.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e1.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e1.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e1.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e1.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e1.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e1.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e1.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e1.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e1.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e1.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e1.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e1.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e1.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e1.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e1.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e1.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e1.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e1.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e1.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e1.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e1.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e1.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e1.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e1.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e1.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e1.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e1.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e1.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e1.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e1.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e1.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e1.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e1.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e1.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e1.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e1.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e1.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e1.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s2.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s2.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s2.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s2.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s2.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s2.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s2.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s2.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s2.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s2.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s2.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s2.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s2.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s2.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s2.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s2.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s2.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s2.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s2.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s2.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s2.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s2.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s2.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s2.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s2.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s2.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s2.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s2.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s2.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s2.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s2.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s2.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s2.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s2.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s2.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s2.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s2.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s2.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s2.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s2.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s2.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s2.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s2.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s2.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s2.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s2.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s2.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s2.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s2.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s2.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s2.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s2.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s2.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s2.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s2.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s2.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s2.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s2.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s2.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s2.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s2.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s2.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s2.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s2.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s2.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s2.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s2.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s2.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s2.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s2.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s2.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s2.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s2.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s2.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s2.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s2.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s2.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s2.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s2.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s2.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s2.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s2.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s2.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s2.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s2.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s2.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s2.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s2.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s2.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s2.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s2.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s2.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s2.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s2.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s2.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s2.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e2.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e2.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e2.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e2.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e2.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e2.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e2.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e2.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e2.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e2.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e2.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e2.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e2.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e2.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e2.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e2.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e2.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e2.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e2.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e2.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e2.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e2.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e2.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e2.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e2.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e2.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e2.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e2.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e2.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e2.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e2.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e2.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e2.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e2.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e2.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e2.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e2.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e2.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e2.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e2.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e2.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e2.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e2.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e2.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e2.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e2.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e2.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e2.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e2.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e2.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e2.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e2.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e2.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e2.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e2.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e2.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e2.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e2.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e2.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e2.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e2.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e2.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e2.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e2.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e2.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e2.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e2.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e2.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e2.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e2.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e2.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e2.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e2.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e2.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e2.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e2.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e2.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e2.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e2.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e2.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e2.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e2.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e2.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e2.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e2.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e2.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e2.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e2.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e2.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e2.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e2.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e2.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e2.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e2.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e2.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e2.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e2.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s3.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s3.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s3.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s3.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s3.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s3.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s3.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s3.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s3.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s3.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s3.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s3.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s3.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s3.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s3.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s3.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s3.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s3.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s3.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s3.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s1.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s3.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s3.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s3.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s3.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s3.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s3.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s3.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s3.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s3.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s3.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s3.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s3.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s3.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s3.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s3.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s3.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s3.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s3.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s3.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s3.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s3.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s3.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s3.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s3.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s3.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s3.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s3.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s3.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s3.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s3.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s3.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s3.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s3.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s3.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s3.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s3.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s3.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s3.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s3.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s3.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s3.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s3.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s3.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s3.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s3.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s3.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s3.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s3.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s3.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s3.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s3.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s3.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s3.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s3.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s3.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s3.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s3.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s3.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s3.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s3.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s3.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s3.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s3.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s3.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s3.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s3.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s3.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s3.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s3.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s3.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s3.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s3.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s3.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s3.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s3.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e3.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e3.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e3.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e3.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e3.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e3.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e3.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e3.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e3.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e3.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e3.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e3.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e3.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e3.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e3.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e3.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e3.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e3.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e3.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e3.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e3.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e3.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e3.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e3.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e3.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e3.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e3.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e3.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e3.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e3.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e3.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e3.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e3.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e3.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e3.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e3.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e3.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e3.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e3.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e3.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e3.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e3.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e3.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e3.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e3.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e3.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e3.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e3.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e3.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e3.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e3.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e3.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e3.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e3.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e3.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e3.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e3.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e3.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e3.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e3.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e3.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e3.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e3.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e3.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e3.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e3.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e3.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e3.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e3.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e3.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e3.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e3.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e3.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e3.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e3.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e3.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e3.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e3.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e3.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e3.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e3.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e3.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e3.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e3.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e3.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e3.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e3.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e3.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e3.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e3.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e3.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e3.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e3.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e3.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e3.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e3.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e3.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s4.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s4.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s4.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s4.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s4.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s4.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s4.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s4.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s4.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s4.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s4.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s4.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s4.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s4.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s4.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s4.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s4.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s4.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s4.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s4.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s4.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s4.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s4.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s4.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s4.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s4.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s4.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s4.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s4.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s4.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s4.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s4.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s4.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s4.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s4.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s4.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s4.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s4.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s4.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s4.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s4.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s4.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s4.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s4.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s4.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s4.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s4.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s4.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s4.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s4.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s4.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s4.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s4.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s4.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s4.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s4.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s4.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s4.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s4.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s4.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s4.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s4.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s4.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s4.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s4.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s4.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s4.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s4.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s4.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s4.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s4.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s4.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s4.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s4.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s4.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s4.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s4.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s4.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s4.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s4.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s4.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s4.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s4.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s4.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s4.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s4.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s4.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s4.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s4.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s4.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s4.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s4.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s4.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s4.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s4.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s4.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e4.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e4.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e4.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e4.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e1.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e4.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e4.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e4.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e4.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e4.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e4.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e4.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e4.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e4.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e4.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e4.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e4.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e4.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e4.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e4.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e4.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e1.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e4.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e4.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e4.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e4.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e4.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e4.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e4.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e4.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e4.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e4.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e4.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e4.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e4.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e4.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e4.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e4.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e4.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e4.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e4.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e4.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e4.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e4.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e4.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e4.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e4.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e4.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e4.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e4.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e4.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e4.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e4.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e4.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e4.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e4.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e4.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e4.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e4.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e4.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e4.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e4.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e4.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e4.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e4.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e4.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e4.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e4.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e4.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e4.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e4.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e4.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e4.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e4.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e4.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e4.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e4.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e4.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e4.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e4.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e4.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e4.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e4.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e4.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e4.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e4.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e4.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e4.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e4.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e4.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e4.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e4.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e4.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e4.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e4.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e4.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e4.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s5.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s5.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s5.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s5.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s5.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s5.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s5.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s5.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s5.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s5.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s5.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s5.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s5.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s5.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s5.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s5.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s5.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s5.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s5.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s5.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s5.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s5.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s5.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s5.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s5.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s5.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s5.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s5.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s5.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s5.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s5.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s5.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s5.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s5.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s5.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s5.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s5.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s5.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s5.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s5.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s5.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s5.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s5.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s5.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s5.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s5.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s5.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s5.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s5.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s5.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s5.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s5.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s5.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s5.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s5.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s5.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s5.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s5.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s5.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s5.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s5.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s5.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s5.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s5.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s5.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s5.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s5.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s5.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s5.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s5.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s5.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s5.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s5.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s5.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s5.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s5.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s5.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s5.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s5.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s5.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s5.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s5.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s5.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s5.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s5.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s5.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s5.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s5.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s5.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s5.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s5.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s5.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s5.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s5.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s5.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s5.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e5.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e5.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e5.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e1.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e5.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e5.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e5.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e5.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e5.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e5.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e5.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e5.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e5.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e5.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e5.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e5.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e5.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e5.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e5.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e5.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e5.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e5.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e5.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e5.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e5.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e5.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e5.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e1.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e5.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e5.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e5.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e5.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e5.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e5.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e5.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e5.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e5.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e5.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e5.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e5.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e5.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e5.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e5.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e5.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e5.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e5.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e5.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e5.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e5.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e5.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e5.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e5.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e5.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e5.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e5.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e5.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e5.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e5.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e5.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e5.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e5.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e5.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e5.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e5.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e5.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e5.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e5.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e5.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e5.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e5.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e5.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e5.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e5.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e5.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e5.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e5.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e5.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e5.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e5.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e5.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e5.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e5.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e5.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e5.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e5.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e5.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e5.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e5.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e5.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e5.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e5.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e5.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e5.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e5.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e5.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e5.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e5.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s6.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s6.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s6.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s6.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s6.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s6.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s6.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s6.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s6.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s6.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s6.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s6.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s6.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s6.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s6.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s6.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s6.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s6.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s6.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s6.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s6.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s6.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s6.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s6.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s6.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s6.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s6.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s6.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s6.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s6.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s6.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s6.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s6.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s6.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s6.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s6.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s6.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s6.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s6.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s6.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s6.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s6.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s6.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s6.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s6.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s6.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s6.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s6.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s6.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s6.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s6.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s6.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s6.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s6.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s6.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s6.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s6.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s6.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s6.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s6.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s6.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s6.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s6.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s6.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s6.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s6.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s6.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s6.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s6.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s6.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s6.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s6.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s6.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s6.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s6.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s6.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s6.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s6.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s6.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s6.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s6.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s6.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s6.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s6.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s6.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s6.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s6.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s6.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s6.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s6.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s6.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s6.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s6.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s6.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s6.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s6.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s6.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e6.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e6.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e6.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e6.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e6.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e6.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e6.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e6.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e6.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e6.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e6.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e6.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e6.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e6.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e6.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e6.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e6.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e6.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e6.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e6.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e6.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e6.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e6.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e6.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e6.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e6.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e6.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e6.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e6.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e6.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e6.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e6.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e6.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e6.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e6.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e6.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e6.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e6.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e6.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e6.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e6.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e6.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e6.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e6.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e6.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e6.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e6.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e6.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e6.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e6.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e6.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e6.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e6.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e6.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e6.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e6.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e6.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e6.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e6.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e6.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e6.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e6.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e6.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e6.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e6.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e6.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e6.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e6.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e6.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e6.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e6.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e6.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e6.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e6.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e6.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e6.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e6.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e6.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e6.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e6.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e6.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e6.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e6.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e6.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e6.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e6.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e6.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e1.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e6.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e6.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e6.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e6.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e6.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e6.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e6.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e6.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e6.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        s7.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 0;
                                s7.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 5;
                                s7.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 10;
                                s7.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 15;
                                s7.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 20;
                                s7.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 25;
                                s7.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 30;
                                s7.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 35;
                                s7.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 40;
                                s7.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 45;
                                s7.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 50;
                                s7.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 9;
                                sm = 55;
                                s7.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 0;
                                s7.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 5;
                                s7.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 10;
                                s7.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 15;
                                s7.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 20;
                                s7.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 25;
                                s7.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 30;
                                s7.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 35;
                                s7.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 40;
                                s7.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 45;
                                s7.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 50;
                                s7.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 10;
                                sm = 55;
                                s7.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 0;
                                s7.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 5;
                                s7.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 10;
                                s7.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 15;
                                s7.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 20;
                                s7.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 25;
                                s7.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 30;
                                s7.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 35;
                                s7.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 40;
                                s7.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 45;
                                s7.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 50;
                                s7.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 11;
                                sm = 55;
                                s7.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 0;
                                s7.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 5;
                                s7.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 10;
                                s7.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 15;
                                s7.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 20;
                                s7.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 25;
                                s7.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 30;
                                s7.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 35;
                                s7.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 40;
                                s7.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 45;
                                s7.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 50;
                                s7.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 12;
                                sm = 55;
                                s7.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 0;
                                s7.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 5;
                                s7.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 10;
                                s7.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 15;
                                s7.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 20;
                                s7.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 25;
                                s7.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 30;
                                s7.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 35;
                                s7.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 40;
                                s7.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 45;
                                s7.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 50;
                                s7.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 13;
                                sm = 55;
                                s7.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 0;
                                s7.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 5;
                                s7.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 10;
                                s7.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 15;
                                s7.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 20;
                                s7.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 25;
                                s7.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 30;
                                s7.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 35;
                                s7.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 40;
                                s7.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 45;
                                s7.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 50;
                                s7.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 14;
                                sm = 55;
                                s7.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 0;
                                s7.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 5;
                                s7.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 10;
                                s7.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 15;
                                s7.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 20;
                                s7.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 25;
                                s7.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 30;
                                s7.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 35;
                                s7.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 40;
                                s7.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 45;
                                s7.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 50;
                                s7.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 15;
                                sm = 55;
                                s7.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 0;
                                s7.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 5;
                                s7.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 10;
                                s7.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 15;
                                s7.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 20;
                                s7.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 25;
                                s7.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 30;
                                s7.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 35;
                                s7.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 40;
                                s7.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 45;
                                s7.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 50;
                                s7.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh = 16;
                                sm = 55;
                                s7.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
        e7.setOnClickListener(new View.OnClickListener() {
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(AddDataActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_time,null);
                t1 = (TextView) view.findViewById(R.id.am9);
                t2 = (TextView) view.findViewById(R.id.am10);
                t3 = (TextView) view.findViewById(R.id.am11);
                t4 = (TextView) view.findViewById(R.id.am12);
                t5 = (TextView) view.findViewById(R.id.pm1);
                t6 = (TextView) view.findViewById(R.id.pm4);
                t7 = (TextView) view.findViewById(R.id.pm5);
                t8 = (TextView) view.findViewById(R.id.pm6);
                t9 = (TextView) view.findViewById(R.id.m0);
                t10 = (TextView) view.findViewById(R.id.m1);
                t11 = (TextView) view.findViewById(R.id.m2);
                t12 = (TextView) view.findViewById(R.id.m3);
                t13 = (TextView) view.findViewById(R.id.m4);
                t14 = (TextView) view.findViewById(R.id.m5);
                t15 = (TextView) view.findViewById(R.id.m6);
                t16 = (TextView) view.findViewById(R.id.m7);
                t17 = (TextView) view.findViewById(R.id.m8);
                t18 = (TextView) view.findViewById(R.id.m9);
                t19 = (TextView) view.findViewById(R.id.m10);
                t20 = (TextView) view.findViewById(R.id.m11);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 0;
                                e7.setText("09.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 5;
                                e7.setText("09.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 10;
                                e7.setText("09.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 15;
                                e7.setText("09.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 20;
                                e7.setText("09.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 25;
                                e7.setText("09.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 30;
                                e7.setText("09.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 35;
                                e7.setText("09.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 40;
                                e7.setText("09.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 45;
                                e7.setText("09.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 50;
                                e7.setText("09.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 9;
                                sm2 = 55;
                                e7.setText("09.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 0;
                                e7.setText("10.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 5;
                                e7.setText("10.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 10;
                                e7.setText("10.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 15;
                                e7.setText("10.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 20;
                                e7.setText("10.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 25;
                                e7.setText("10.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 30;
                                e7.setText("10.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 35;
                                e7.setText("10.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 40;
                                e7.setText("10.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 45;
                                e7.setText("10.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 50;
                                e7.setText("10.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 10;
                                sm2 = 55;
                                e7.setText("10.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 0;
                                e7.setText("11.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 5;
                                e7.setText("11.05AM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 10;
                                e7.setText("11.10AM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 15;
                                e7.setText("11.15AM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 20;
                                e7.setText("11.20AM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 25;
                                e7.setText("11.25AM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 30;
                                e7.setText("11.30AM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 35;
                                e7.setText("11.35AM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 40;
                                e7.setText("11.40AM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 45;
                                e7.setText("11.45AM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 50;
                                e7.setText("11.50AM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 11;
                                sm2 = 55;
                                e7.setText("11.55AM");
                                closePopup();
                            }
                        });
                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 0;
                                e7.setText("12.00AM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 5;
                                e7.setText("12.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 10;
                                e7.setText("12.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 15;
                                e7.setText("12.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 20;
                                e7.setText("12.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 25;
                                e7.setText("12.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 30;
                                e7.setText("12.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 35;
                                e7.setText("12.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 40;
                                e7.setText("12.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 45;
                                e7.setText("12.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 50;
                                e7.setText("12.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 12;
                                sm2 = 55;
                                e7.setText("12.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 0;
                                e7.setText("13.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 5;
                                e7.setText("13.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 10;
                                e7.setText("13.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 15;
                                e7.setText("13.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 20;
                                e7.setText("13.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 25;
                                e7.setText("13.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 30;
                                e7.setText("13.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 35;
                                e7.setText("13.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 40;
                                e7.setText("13.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 45;
                                e7.setText("13.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 50;
                                e7.setText("13.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 13;
                                sm2 = 55;
                                e7.setText("13.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 0;
                                e7.setText("14.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 5;
                                e7.setText("14.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 10;
                                e7.setText("14.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 15;
                                e7.setText("14.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 20;
                                e7.setText("14.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 25;
                                e7.setText("14.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 30;
                                e7.setText("14.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 35;
                                e7.setText("14.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 40;
                                e7.setText("14.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 45;
                                e7.setText("14.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 50;
                                e7.setText("14.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 14;
                                sm2 = 55;
                                e7.setText("14.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 0;
                                e7.setText("15.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 5;
                                e7.setText("15.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 10;
                                e7.setText("15.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 15;
                                e7.setText("15.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 20;
                                e7.setText("15.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 25;
                                e7.setText("15.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 30;
                                e7.setText("15.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 35;
                                e7.setText("15.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 40;
                                e7.setText("15.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 45;
                                e7.setText("15.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 50;
                                e7.setText("15.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 15;
                                sm2 = 55;
                                e7.setText("15.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                t8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 0;
                                e7.setText("16.00PM");
                                closePopup();
                            }
                        });
                        t10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 5;
                                e7.setText("16.05PM");
                                closePopup();
                            }
                        });
                        t11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 10;
                                e7.setText("16.10PM");
                                closePopup();
                            }
                        });
                        t12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 15;
                                e7.setText("16.15PM");
                                closePopup();
                            }
                        });
                        t13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 20;
                                e7.setText("16.20PM");
                                closePopup();
                            }
                        });

                        t14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 25;
                                e7.setText("16.25PM");
                                closePopup();
                            }
                        });
                        t15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 30;
                                e7.setText("16.30PM");
                                closePopup();
                            }
                        });
                        t16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 35;
                                e7.setText("16.35PM");
                                closePopup();
                            }
                        });
                        t17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 40;
                                e7.setText("16.40PM");
                                closePopup();
                            }
                        });
                        t18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 45;
                                e7.setText("16.45PM");
                                closePopup();
                            }
                        });
                        t19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 50;
                                e7.setText("16.50PM");
                                closePopup();
                            }
                        });
                        t20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sh2 = 16;
                                sm2 = 55;
                                e7.setText("16.55PM");
                                closePopup();
                            }
                        });
                    }
                });
                popup.setView(view);
                dialog = popup.create();
                dialog.show();
            }

            public void closePopup(){
                if(dialog != null) dialog.cancel();
            }
        });
    }
    public void showtimepicker(){
        et2 = (EditText) findViewById(R.id.textTime);
        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }
    public void showtimepicker2(){
        et5 = (EditText) findViewById(R.id.textTime2);
        et5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID2);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            return new TimePickerDialog(AddDataActivity.this,kTimePickerListner,hour_x,minute_x,false);
        }else {
            return new TimePickerDialog(AddDataActivity.this,kTimePickerListner2,hour_x,minute_x,false);
        }
    }
    protected TimePickerDialog.OnTimeSetListener kTimePickerListner =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour_x = hourOfDay;
                    minute_x = minute;
                    et2.setText(hour_x+":"+minute_x);
                }
            };
    protected TimePickerDialog.OnTimeSetListener kTimePickerListner2 =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour_x = hourOfDay;
                    minute_x = minute;
                    et5.setText(hour_x+":"+minute_x);
                }
            };
}
