package com.example.baseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    // 멤버변수 선언
    Button button1;
    Button button2;

    private RadioGroup rg;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        rg = (RadioGroup)findViewById(R.id.Rgroup);
        img = (ImageView)findViewById(R.id.imageView);

        final EditText et;
        et = (EditText)findViewById(R.id.TextEditor);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et.getText().toString();
                Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(mlntent) ;
            }

        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if(checkedID == R.id.RadioButton1){
                    img.setImageResource(R.drawable.ic_launcher_1);
                }
                else if(checkedID == R.id.RadioButton2){
                    img.setImageResource(R.drawable.ic_launcher_2);
                }
            }
        });


    }
}
