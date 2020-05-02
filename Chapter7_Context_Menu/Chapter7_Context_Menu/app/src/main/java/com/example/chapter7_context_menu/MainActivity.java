package com.example.chapter7_context_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button button01, button02;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater(); // 인플레이터 객체 가져옴
        // 인플레이터 객체를 이용하여 xml 파일 경유, xml파일의 뷰 사용

        // view가 button1일 경우
        if(v == button01)
            mInflater.inflate(R.menu.menu01, menu); // 인플레이터에 등록
        else if(v == button02) // view가 button2일 경우
            mInflater.inflate(R.menu.menu02, menu); // 인플레이터에 등록
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.item01:
                linear.setBackgroundColor(Color.RED);
                break;
            case R.id.item02:
                linear.setBackgroundColor(Color.GREEN);
                break;
            case R.id.item03:
                linear.setBackgroundColor(Color.GRAY);
                break;
            case R.id.item04_1:
                linear.setBackgroundColor(Color.CYAN);
                break;
            case R.id.item04_2:
                linear.setBackgroundColor(Color.MAGENTA);
                break;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = (LinearLayout)findViewById(R.id.linear01);

        // 컨텍스트 메뉴가 생기도록 등록
        // 해당 버튼을 컨텍스트 메뉴로 등록하는 동작
        button01 = (Button)findViewById(R.id.Btn1);
        registerForContextMenu(button01);

        button02 = (Button)findViewById(R.id.Btn2);
        registerForContextMenu(button02);
    }
}
