package com.example.user.classroom;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    DBhelper dbHelper;
    TextView tv1,tv2,tv3,tv5,tv6,tv7,tv8,tv9,tv10,endTime1,endTime2;
    ImageButton btDe,back,editData;
    String strs4;
    int a,requestCode,resultCode;
    Intent data;
    Cursor res2;
    int sh;
    int sm;
    int sh2;
    int sm2;
    AlertDialog dialog;
    String D;
    TextInputEditText inputEditText1,inputEditText2,inputEditText3;
    EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dbHelper = new DBhelper(this);
        inputEditText1 = new TextInputEditText(this);
        inputEditText2 = new TextInputEditText(this);
        inputEditText3 = new TextInputEditText(this);
        et1 = new EditText(this);
        et2 = new EditText(this);
        et3 = new EditText(this);
        et4 = new EditText(this);
        et5 = new EditText(this);
        et6 = new EditText(this);
        sh =0;
        sm = 0;
        sh2 =0;
        sm2 = 0;
        D ="";
        Show();
        delete();
        back();
        editDataa();
        onActivityResult(requestCode,resultCode,data);
    }

    public void Show(){
        tv1 = (TextView) findViewById(R.id.textDB1);
        tv2 = (TextView) findViewById(R.id.textDB2);
        tv3 = (TextView) findViewById(R.id.textDB3);
        tv5 = (TextView) findViewById(R.id.dateMidterm);
        tv6 = (TextView) findViewById(R.id.StartMidterm);
        tv7 = (TextView) findViewById(R.id.roomMidterm);
        tv8 = (TextView) findViewById(R.id.dateFinal);
        tv9 = (TextView) findViewById(R.id.StartFinal);
        tv10 = (TextView) findViewById(R.id.roomFinal);
        String strs1 = getIntent().getStringExtra("A");
        String strs2 = getIntent().getStringExtra("B");
        String strs3 = getIntent().getStringExtra("C");
        String strs5 = getIntent().getStringExtra("E");
        String strs6 = getIntent().getStringExtra("F");
        String strs7 = getIntent().getStringExtra("G");
        String strs8 = getIntent().getStringExtra("H");
        String strs9 = getIntent().getStringExtra("Y");
        String strs10 = getIntent().getStringExtra("J");
        strs4 = getIntent().getStringExtra("D");
        tv1.setText(strs1);
        tv2.setText(strs2);
        tv3.setText(strs3);
        tv5.setText(strs5);
        tv6.setText(strs6);
        tv7.setText(strs7);
        tv8.setText(strs8);
        tv9.setText(strs9);
        tv10.setText(strs10);
    }
    public void delete(){
        btDe = (ImageButton) findViewById(R.id.btDelete);
        btDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder popup = new AlertDialog.Builder(DetailActivity.this);
                View view = getLayoutInflater().inflate(R.layout.pop_up_sure,null);
                Button cancle = (Button) view.findViewById(R.id.canclesure);
                Button ok = (Button) view.findViewById(R.id.oksure);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer dataDelete = dbHelper.deleteData(strs4);
                        closePopup();
                        AlertDialog.Builder popup2 = new AlertDialog.Builder(DetailActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.deleted,null);
                        popup2.setView(view);
                        dialog = popup2.create();
                        dialog.show();
                        finish();
                    }
                });
               cancle.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) { closePopup(); }
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
    public void back(){
        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void editDataa(){
        final String strs1 = getIntent().getStringExtra("A");
        final String strs2 = getIntent().getStringExtra("B");
        final String strs3 = getIntent().getStringExtra("C");
        final String strs5 = getIntent().getStringExtra("E");
        final String strs6 = getIntent().getStringExtra("F");
        final String strs7 = getIntent().getStringExtra("G");
        final String strs8 = getIntent().getStringExtra("H");
        final String strs9 = getIntent().getStringExtra("Y");
        final String strs10 = getIntent().getStringExtra("J");
        final String strs11 = getIntent().getStringExtra("K");
        final String strs12 = getIntent().getStringExtra("L");
        final String strs13 = getIntent().getStringExtra("M");
        final String strs14 = getIntent().getStringExtra("N");
        final String strs15 = getIntent().getStringExtra("O");
        strs4 = getIntent().getStringExtra("D");
        editData = (ImageButton)findViewById(R.id.btEdit);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,EditDataActivity.class);
                intent.putExtra("A",strs1);
                intent.putExtra("B",strs2);
                intent.putExtra("C",strs3);
                intent.putExtra("E",strs5);
                intent.putExtra("F",strs6);
                intent.putExtra("G",strs7);
                intent.putExtra("H",strs8);
                intent.putExtra("Y",strs9);
                intent.putExtra("J",strs10);
                intent.putExtra("K",strs11);
                intent.putExtra("L",strs12);
                intent.putExtra("M",strs13);
                intent.putExtra("N",strs14);
                intent.putExtra("O",strs15);
                intent.putExtra("D",strs4);
                startActivity(intent);
            }
        });
    }

}