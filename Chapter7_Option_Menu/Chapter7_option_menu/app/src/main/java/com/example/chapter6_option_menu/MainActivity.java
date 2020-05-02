package com.example.chapter6_option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = (LinearLayout)findViewById(R.id.linear01);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //xml파일을 뷰로 생성
        //MenuInflater mInflater = getMenuInflater();
        //mInflater.inflate(R.menu.menu1, menu);

        // java 코드로 메뉴 생성하기
        // 그룹, 아이디, 순서, 항목에 표시할 string 인자로 전달
        menu.add(0, 1, 0, "메뉴-항목01");
        menu.add(0, 2, 0, "메뉴-항목02");
        menu.add(0, 3, 0, "메뉴-항목03");

        SubMenu smenu = menu.addSubMenu("메뉴-항목04");
        smenu.add(0, 4, 0,"메뉴-항목04-1");
        smenu.add(0, 5, 0,"메뉴-항목04-2");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);

        // 선택된 아이템에 따라 LinearLayout의 배경색을 바꾸는 동작
        switch(item.getItemId()){
            // 자바 코드로 메뉴 조작
            case 1:
                linear.setBackgroundColor(Color.RED);
                break;
            case 2:
                linear.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                linear.setBackgroundColor(Color.GRAY);
                break;
                // xml을 이용한 메뉴 조작
                /*
            case R.id.item01:
                linear.setBackgroundColor(Color.RED);
                break;
            case R.id.item02:
                linear.setBackgroundColor(Color.GREEN);
                break;
            case R.id.item03:
                linear.setBackgroundColor(Color.BLUE);
                break;
            case R.id.item05:
                linear.setBackgroundColor(Color.CYAN);
                break;
            case R.id.item06:
                linear.setBackgroundColor(Color.MAGENTA);
                break;
                */

        }
        return true;
    }
}
