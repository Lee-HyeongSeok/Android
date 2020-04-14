package com.example.chater3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 버튼 클래스 객체 생성
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml을 찾아서 setContentView 메소드로 전달
        // 이 파일을 xml parsing을 한다.
        // 내부에 클래스를 생성하는 역할을 한다.
        // 위치, 색상, 속성 등을 조사하여 view를 화면에 보여준다.
        setContentView(R.layout.activity_main);

        // button1에 접근할 수 있게 view에서 가져온다.
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        // 클릭 시 실행하는 메소드 생성
        // 버튼에 대한 onclick 리스너 등록
        button1.setOnClickListener(ButtonListener1);
        button2.setOnClickListener(ButtonListener2);
    }
    // ButtonListener 라는 이름을 부여했다.
    View.OnClickListener ButtonListener1 = new View.OnClickListener(){
       // 오버라이드
        public void onClick(View view){
            // 선택된 view가 넘어온다
            // id를 넘겨받을 수 있다.
            switch(view.getId()){
                case R.id.button1:
                    // Toast 메시지 출력
                    // Length_short : 잠시 보여지는 속성 값
                    Toast.makeText(getApplicationContext(), "버튼 클릭", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    View.OnClickListener ButtonListener2 = new View.OnClickListener(){
      public void onClick(View view){
          switch(view.getId()){
              case R.id.button2:
                  Toast.makeText(getApplicationContext(), "두 번째 버튼 클릭", Toast.LENGTH_SHORT).show();
                  break;
          }
      }
    };
}
