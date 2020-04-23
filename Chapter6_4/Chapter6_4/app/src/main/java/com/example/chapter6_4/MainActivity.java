package com.example.chapter6_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.ViewFlipper;

public class MainActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();

        TabHost.TabSpec tspec01 = tabHost.newTabSpec("Tab01");
        tspec01.setIndicator("탭 1"); // 탭 앞에 보여주는 텍스트
        tspec01.setContent(R.id.tab01); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec01); // 탭 호스트에 첫 번째 탭을 추가

        TabHost.TabSpec tspec02 = tabHost.newTabSpec("Tab02");
        tspec02.setIndicator("탭 2"); // 탭 앞에 보여주는 텍스트
        tspec02.setContent(R.id.tab02); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec02); // 탭 호스트에 첫 번째 탭을 추가

        TabHost.TabSpec tspec03 = tabHost.newTabSpec("Tab03");
        tspec03.setIndicator("탭 3"); // 탭 앞에 보여주는 텍스트
        tspec03.setContent(R.id.tab03); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec03); // 탭 호스트에 첫 번째 탭을 추가
    }
}
