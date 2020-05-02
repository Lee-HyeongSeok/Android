package com.example.chapter7_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 = (Button)findViewById(R.id.Btn1);
        // 온클릭 리스너에 등록해주는 동작
        button01.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == button01){
            Toast msg = Toast.makeText(MainActivity.this, "Toast message", Toast.LENGTH_SHORT);

            // WINDOW_SERVICE : 윈도우 매니저 리턴
            // 화면의 크기를 알기위한 코드
            // Math.random() : 0~1사이의 임의의 값 리턴
            Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            int x_offset = (int)Math.random() * display.getWidth();
            int y_offset = (int)Math.random() * display.getHeight();
            // 해당 x_offset, y_offset 위치에 메시지 표시
            msg.setGravity(Gravity.TOP | Gravity.LEFT, x_offset, y_offset);
            msg.show();
        }
    }
}
