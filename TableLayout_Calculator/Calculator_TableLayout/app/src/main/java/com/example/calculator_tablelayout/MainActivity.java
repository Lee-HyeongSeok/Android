package com.example.calculator_tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2; // 피연산자를 입력받는 텍스트 에디터
    Button BtnPlus, BtnMinus, BtnMulti, BtnDivide; // 연산자 버튼 4개
    TextView resultText; // 결과 값 출력하는 텍스트 뷰
    String val1, val2; // 피 연산자
    Integer result; // string 형 텍스트 계산 결과를 받기 위한 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");

        // 숫자 버튼 뷰 객체 배열
        final Button[] numButtons = new Button[10];

        // ID를 불러오기 위한 id 배열
        Integer[] numBtnIDs = {R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3, R.id.Btn4,
        R.id.Btn5, R.id.Btn6, R.id.Btn7, R.id.Btn8, R.id.Btn9};


        // 텍스트 에디터 아이디를 통해 뷰 불러오기
        edit1 = (EditText)findViewById(R.id.editor1);
        edit2 = (EditText)findViewById(R.id.editor2);

        // 연산자 버튼 아이디를 통해 뷰 불러오기
        BtnPlus = (Button)findViewById(R.id.plus);
        BtnMinus = (Button)findViewById(R.id.minus);
        BtnMulti = (Button)findViewById(R.id.multi);
        BtnDivide = (Button)findViewById(R.id.divide);

        // 결과 텍스트 뷰 아이디를 통해 뷰 불러오기
        resultText = (TextView)findViewById(R.id.result);

        // 각 연산 버튼 리스너 선언
        BtnPlus.setOnTouchListener(PlusListener);
        BtnMinus.setOnTouchListener(MinusListener);
        BtnMulti.setOnTouchListener(MultiplyListener);
        BtnDivide.setOnTouchListener(DivideListener);


        // 해당하는 숫자 버튼의 아이디를 통해 뷰를 불러온다.
        for(int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(int i=0; i<numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    // 첫 번째 텍스트 에디터에 초점이 맞춰졌다면
                    if(edit1.isFocused() == true){

                        // 버튼에 텍스트를 가져와 string으로 변환 후 val1에 삽입
                        val1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(val1); // 변환된 스트링을 텍스트 에디터에 표현
                    } // 두 번째 텍스트 에디터에 초점이 맞춰졌다면
                    else if(edit2.isFocused() == true){
                        val2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(val2); // 변환된 스트링을 텍스트 에디터에 표현
                    }
                    else{ // 텍스트 입력 외에 연산자 버튼을 눌렀을 경우 잠깐 출력
                        Toast.makeText(getApplicationContext(),
                                "먼저 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    View.OnTouchListener PlusListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) + Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener MinusListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) - Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener MultiplyListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) * Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener DivideListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) / Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
}
