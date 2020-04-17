package com.example.chapter3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        RadioButton Rbtn1, Rbtn2;
        RadioGroup rGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rbtn1 = (RadioButton)findViewById(R.id.RadioBtn1);
        Rbtn2 = (RadioButton)findViewById(R.id.RadioBtn2);

        Rbtn1.setOnClickListener(RbtnListener);
        Rbtn2.setOnClickListener(RbtnListener);

        rGroup = (RadioGroup)findViewById(R.id.RGroup1);
        rGroup.setOnCheckedChangeListener(rGroupListener);
    }
    RadioGroup.OnCheckedChangeListener rGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            // 라디오 그룹 id와 같다면
            if(radioGroup.getId() == R.id.RGroup1){
                switch(i){
                    case R.id.rButton1_apple:
                        Toast.makeText(getApplicationContext(), "사과 선택",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rButton1_berry:
                        Toast.makeText(getApplicationContext(), "딸기 선택",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rButton1_grape:
                        Toast.makeText(getApplicationContext(), "포도 선택",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    };
    View.OnClickListener RbtnListener = new View.OnClickListener(){
      public void onClick(View view){
          switch(view.getId()){
              case R.id.RadioBtn1:
                  Toast.makeText(getApplicationContext(), "산 선택",
                          Toast.LENGTH_SHORT).show();
                  // 라디오 그룹을 사용하는 것 처럼의 동작 구현
                  Rbtn1.setChecked(true);
                  Rbtn2.setChecked(false);
                  break;
              case R.id.RadioBtn2:
                  Toast.makeText(getApplicationContext(), "바다 선택",
                          Toast.LENGTH_SHORT).show();
                  // 라디오 그룹을 사용하는 것 처럼의 동작 구현
                  Rbtn1.setChecked(false);
                  Rbtn2.setChecked(true);
                  break;
          }
      }
    };
}
