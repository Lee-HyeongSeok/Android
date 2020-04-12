## * Chapter2 Example 7번 
#### * 출처 : Android studio를 활용한 안드로이드 프로그래밍   

#### * 문제
		* 구성 : EditText, Button 2개, RadioGroup, RadioButton 2개, ImageView, 이미지 2개를 drawable 폴더를 복사
		* 작동
				1. <글자 나타내기> 클릭 시 EditText에 입력한 글자가 잠깐 Toast 메시지로 출력
				2. <홈페이지 열기> 클릭 시 EditText에 입력한 URL이 열림
				3. 처음에는 기본 이미지가 나타나고 라디오버튼 클릭 시 다른 이미지로 변경   
	
#### * string.xml   

<pre>
<code>
<resources>
    <string name="app_name">BaseApp</string>	// 앱 이름
    <string name="button1">글자 나타내기</string>	// 첫 번째 버튼 이름 [글자 나타내기]
    <string name="button2">홈페이지 열기</string>	// 두 번째 버튼 이름 [홈페이지 열기]
    <string name="RadioButton1">아이콘1</string>	// 첫 번째 체크 버튼 이름 
    <string name="RadioButton2">아이콘2</string>	// 두 번째 체크 버튼 이름 
</resources>

</code>
</pre>   


#### * MainActivity.java   

<pre>
<code>
package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 멤버변수 선언
    Button button1;	
    Button button2;

    // 라디오 그룹 객체, 이미지 뷰 객체 private 멤버변수로 선언
    private RadioGroup rg;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	
        setContentView(R.layout.activity_main);

        // 바탕 이미지 보이도록 true로 설정 
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // 바탕 이미지를 R.drawable.ic_launcher_foreground아이콘 이미지로 설정
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);

        // 멤버변수로 선언한 버튼1, 2를 R변수들의 id에서 참조한다.
        button1 = (Button)findViewById(R.id.button1); 
        button2 = (Button)findViewById(R.id.button2);

        // 라디오 그룹 버튼, 이미지 뷰 버튼을 R변수들의 id에서 참조한다.
        rg = (RadioGroup)findViewById(R.id.Rgroup);
        img = (ImageView)findViewById(R.id.imageView);
 
        // 텍스트 입력받는 객체 선언
        final EditText et;	
        et = (EditText)findViewById(R.id.TextEditor);
		
	// 버튼을 눌렀을 때의 동작 
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
	   // getText()를 통해 텍스트 안에 내용을 받아온다.
	   // getText()를 통해 내용을 받아오면 String이 아닌 Charsequence로 되어있다.
	   // toString()을 통해 이 캐릭터시퀀스 형태를 String형태로 변환해준다.
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
	   // getText()와 toString()을 통해 필요한 내용을 String형태로 변환한다.
                String str = et.getText().toString();
	   // 받아온 내용을 url로 사용하는 부분이다.
                Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(mlntent) ;
            }
        });
        // 라디오버튼을 눌렀을 때의 동작
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if(checkedID == R.id.RadioButton1){
                    img.setImageResource(R.drawable.ic_launcher_1);
                }
                else if(checkedID == R.id.RadioButton2){
                    img.setImageResource(R.drawable.ic_launcher_2);
                }
            }
        });

    }
}

</code>
</pre>   

#### * activity_main.xml   

<pre>
<code>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    tools:ignore="ExtraText">
    /**android:orientation="vertical" : 하위 뷰들을 수직방향으로 배치
    /**android:orientation="horizontal" : 하위 뷰들을 수평방향으로 배치

     // 텍스트 입력받는 객체
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/TextEditor"
        ></EditText>
    // 글자 나타내기, 홈페이지 열기 버튼 객체 선언 
    <Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/button1"></Button>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/button2"
        android:text="@string/button2"></Button>
 // 라디오 버튼 1, 2를 그룹으로 묶는다.
<RadioGroup
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:id="@+id/Rgroup">

	// 아이콘 1버튼
    <RadioButton
        android:id="@+id/RadioButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/RadioButton1"></RadioButton>
	// 아이콘 2버튼 
    <RadioButton
        android:id="@+id/RadioButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/RadioButton2"


        ></RadioButton>
</RadioGroup>
    // 이미지 뷰 객체 선언 
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/ic_launcher_foreground"></ImageView>

</LinearLayout>
</code>
</pre>
