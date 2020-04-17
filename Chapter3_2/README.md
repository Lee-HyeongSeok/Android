## * RadioButton, RadioGroup, ImageView 위젯 사용
#### * 출처 : Android Studio를 활용한 안드로이드 프로그래밍   

#### * activity_main.xml   
		* 일반 RadioButton   
				* 독립적인 동작으로 동시 선택이 가능하다.   
				* RadioGroup과 같이 여러 위젯 중 하나만을 선택하려면 위젯이 선택되었을 때 선택된 위젯 이외는 setChecked(false)로 안보이게 설정해야 한다.
						* ex ) RBtn1, RBtn2 둘 중 RBtn1을 선택했을 때 
						* RBtn1.setChecked(true);
						* RBtn2.setChecked(false); 
```xml
<RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="산"
        android:textSize="20sp"
        android:id="@+id/RadioBtn1"
        />
    <RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="바다"
        android:textSize="20sp"
        android:id="@+id/RadioBtn2"
        />
```

		* RadioGroup을 통한 그룹 지정 버튼   
				* 동시 지정이 아닌 하나의 위젯만 지정된다.
				* 그룹 객체 선언을 통해 하나의 그룹 객체에서 리스너를 통해 뷰를 생성한다.   
				* ex) MainActivity.java에서   
				* RadioGroup rGroup;   
				* rGroup = (RadioGroup)findViewById(R.id.RGroup1); // activity_main에서의 그룹 아이디를 가져온다.   
				* RadioGroup.OnCheckedChangeListener rGroupListener = new RadioGroup.OnCheckedChangeListener()...   
```xml
<RadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/RGroup1" // 라디오 그룹 아이디 지정, MainActivity에서 그룹 위젯 객체 만들 때 사용
        android:orientation="vertical"
        >
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="사과"
            android:id="@+id/rButton1_apple"
            android:textSize="20sp"
            />
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="포도"
            android:id="@+id/rButton1_grape"
            android:textSize="20sp"
            />
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="딸기"
            android:id="@+id/rButton1_berry"
            android:textSize="20sp"
            />
</RadioGroup>
```   

		* ImageView 위젯   
				* 불러온 아이콘 사진을 출력한다.
				* fitXY = 가로, 세로가 정해진 사이즈에 맞게 맞추어진다.

```xml
<ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_launcher_foreground" // res/drawable에 있는 아이콘 불러오기
        />
```   

		* ImageButton   
				* 불러온 아이콘 이미지로 되어있는 버튼 객체를 만든다.
```xml
<ImageButton
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_launcher_foreground"
        />
```

#### * 전체 activity_main.xml 코드

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#0000FF"
    >

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="라디오 버튼"
        android:textAlignment="center"
        android:textSize="20sp"
        android:gravity="center_horizontal" />

    <RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="산"
        android:textSize="20sp"
        android:id="@+id/RadioBtn1"
        />
    <RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="바다"
        android:textSize="20sp"
        android:id="@+id/RadioBtn2"
        />
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="라디오 그룹 버튼"
        android:textAlignment="center"
        android:textSize="20sp"
        android:gravity="center_horizontal" />
    <RadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/RGroup1"
        android:orientation="vertical"
        android:text="라디오 그룹 버튼"

        >
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="사과"
            android:id="@+id/rButton1_apple"
            android:textSize="20sp"
            />
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="포도"
            android:id="@+id/rButton1_grape"
            android:textSize="20sp"
            />
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="딸기"
            android:id="@+id/rButton1_berry"
            android:textSize="20sp"
            />


    </RadioGroup>
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_launcher_foreground"
        />
    <ImageButton
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_launcher_foreground"
        />

</LinearLayout>
```   

#### * 전체 MainActivity.java 코드

```java
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

```