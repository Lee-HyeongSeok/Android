package com.example.chapter3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;
    EditText et1, et2;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main에 있는 전체 뷰(xml)을 가져온다.
        setContentView(R.layout.activity_main);

        // Button 개별뷰를 연결한다.
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);

        // 버튼 동작에 대한 메서드 정의
        button1.setOnClickListener(ButtonListener1);
        button2.setOnClickListener(ButtonListener2);
        button3.setOnClickListener(ButtonListener3);
        button4.setOnClickListener(ButtonListener4);

         // EditText 개별뷰를 연결한다.
        et1 = (EditText)findViewById(R.id.TextEditor1);
        et2 = (EditText)findViewById(R.id.TextEditor2);

        // TextView 개별뷰를 연결한다.
        t = (TextView)findViewById(R.id.textView);
    }

    View.OnClickListener ButtonListener1 = new View.OnClickListener(){
        // 더하기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            int result = Integer.parseInt(str1) + Integer.parseInt(str2);
            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener2 = new View.OnClickListener(){
       // 빼기
        public void onClick(View view){
            int result;
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            if((Integer.parseInt(str1) > Integer.parseInt(str2))){
                result = Integer.parseInt(str1) - Integer.parseInt(str2);
            } else {
                result = Integer.parseInt(str2) - Integer.parseInt(str1);
            }

            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener3 = new View.OnClickListener(){
        // 곱하기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            int result = Integer.parseInt(str1) * Integer.parseInt(str2);
            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener4 = new View.OnClickListener(){
       // 나누기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            double result = Double.parseDouble(str1) / Double.parseDouble(str2);
            if((result) == 0){
                t.setText("몫은 0, 나누기 불가능");
            }
            else{
                t.setText(String.valueOf(result));
            }
        }
    };
}
