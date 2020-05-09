package com.example.chapter8_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dpicker_main;
    EditText edText_main;
    Button Btn1_main;

    // 파일 이름을 저장하기 위한 string 변수
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Diary");

        dpicker_main = (DatePicker)findViewById(R.id.datapicker1);
        edText_main = (EditText)findViewById(R.id.edText01);
        Btn1_main = (Button)findViewById(R.id.Btn01);

        // 데이트 피커 초기화
        // 년도, 달, 일, onDateChangedListener()
        // 먼저 날짜를 가져와야 함

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR); // 년도
        int month = cal.get(Calendar.MONTH); // 달
        int day = cal.get(Calendar.DAY_OF_MONTH); // 일

        // 데이트피커의 값이 변했을 때
        dpicker_main.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            // 현재 날짜에 해당하는 파일이 있는지 검사, 있으면 그 내용을 에디트 텍스트에 보여준다.
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                // 년도_달_일 형식으로 파일 이름 만들어짐
                filename = Integer.toString(year) + "_" +
                        Integer.toString(month) + "_" + Integer.toString(day);
                // 위에서 만든 파일 이름의 파일을 읽는다.
                String str = readDiary(filename);
                // 파일에서 읽은 내용을 에디터 텍스트에 표시한다.
                edText_main.setText(str);
                Btn1_main.setEnabled(true);
            }
        });
        //사용자가 수정하기나 새로 생성 버튼을 눌렀을 때
        Btn1_main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 출력하는 부분, FileOutputStream
                FileOutputStream outFs = null;
                // 선택하는 순간 파일 이름이 filename 변수에 이름이 저장된다.
                // 위에서 데이트피커를 선택한 순간 파일 이름을 만들어줬기 때문에
                try {
                    // 해당 파일 이름으로 파일을 연다.
                    outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edText_main.getText().toString();
                    // 바이트 배열 형태로 저장하기 위함
                    // str.getBytes() : str을 바이트 배열로 만들어준다.(저장하기 위함)
                    // 디폴트 char set 형태로 인코딩을 한다.
                    // 예를 들어, 디폴트 : utf-8이면 이 형태로 인코딩을 함
                    outFs.write(str.getBytes());
                    outFs.close(); // 파일 생성
                    Toast.makeText(getApplicationContext(), filename+"이 저장됨",
                            Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // readDiary 구현
    // 파일로부터 읽어서 string을 리턴해준다.
    String readDiary(String fname) {
        String diaryStr = null;
        FileInputStream inFs=null;
        // 파일 오픈, openFileInput()
        try {
            inFs = openFileInput(fname);
            // 읽어서 바이트 스트림에 저장
            byte[] text = new byte[500]; // 500자 한정
            inFs.read(text);
            inFs.close(); // 파일 닫음
            //text에 있는 바이트 배열을 디코딩하여 새로운 string을 만들어준다.
            //앞뒤 공백을 삭제해 준다.
            diaryStr = (new String(text)).trim();
            Btn1_main.setText("수정 하기");
        } catch (FileNotFoundException e) { // 파일 오픈에서 문제 생길 시, 파일 자체가 없을 때
            // e.printStackTrace();
            edText_main.setHint("해당 날짜에 일기가 없음");
            Btn1_main.setText("새로 저장");
        } catch (IOException e) { // 입출력에서 문제 생길 시, 파일에 내용이 없을 때
            e.printStackTrace();
        }

        return diaryStr;
    }
}
