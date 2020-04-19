package com.example.chapter5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_main);

        // 레이아웃 속성 값 설정
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.rgb(0x00, 0xFF, 0x00));
        layout.setGravity(Gravity.CENTER); // 중앙에 배치

        LinearLayout.LayoutParams param01 =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        Button button01 = new Button(this);
        button01.setText("button1");
        button01.setBackgroundColor(Color.rgb(0xFF, 0xFF, 0x00));
        // 버튼이 만들어질 때 상위 부모(리니어 레이아웃)에 버튼의 크기를 이렇게 만들어 달라는 의미
        button01.setLayoutParams(param01); // 버튼의 크기를 부모에게 알려줌
        layout.addView(button01); // 레이아웃에 버튼 추가

        button01.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Toast.makeText(getApplicationContext(), "clicked button01",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );

        setContentView(layout);
    }
}
