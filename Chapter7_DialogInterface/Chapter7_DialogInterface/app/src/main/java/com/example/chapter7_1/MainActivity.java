package com.example.chapter7_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Btn1, Btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("대화상자");
        Btn1 = (Button)findViewById(R.id.Btn01);
        Btn2 = (Button)findViewById(R.id.Btn02);

        Btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder mydlg1 = new AlertDialog.Builder(MainActivity.this);

                mydlg1.setTitle("기본 대화상자");
                mydlg1.setIcon(R.mipmap.ic_launcher);
                mydlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인 선택", Toast.LENGTH_SHORT).show();
                    }
                });
                mydlg1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 선택", Toast.LENGTH_SHORT).show();
                    }
                });
                mydlg1.setIcon(R.mipmap.ic_launcher);
                mydlg1.show();
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 보여지는 목록을 위한 리스트
                final String[] arrList = {"Item01", "Item02", "Item03", "Item04", "Item05"};
                AlertDialog.Builder mydlg = new AlertDialog.Builder(MainActivity.this);

                // 대화상자 제목 설정
                mydlg.setTitle("목록 대화상자");

                // 대화상자 목록들에 대한 설정, 클릭시 반응하는 리스너 호출
                mydlg.setItems(arrList, new DialogInterface.OnClickListener() {
                    @Override
                    // 클릭시 동작 정의, i는 선택한 리스트 인덱스
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "선택 : "+arrList[i], Toast.LENGTH_SHORT).show();
                    }
                });

                // 화면 왼쪽에 보여지는 아이콘 설정
                mydlg.setIcon(R.mipmap.ic_launcher);
                // 대화상자 취소 버튼
                mydlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 선택", Toast.LENGTH_SHORT).show();
                    }
                });
                // 설정한 대화상자 보여지는 동작
                mydlg.show();
            }
        });
    }
}
