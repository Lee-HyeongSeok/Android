## * Context Menu   
#### * 출처 : Android Studio를 활용한 안드로이드 프로그래밍   

#### * 메뉴   
			1. 옵션 메뉴 : 앱 화면의 우측에 메뉴 아이콘으로 표시   
					- xml 파일을 통해 생성, java 코드에서 호출하는 방식   
					- java 코드만으로 생성   
					- 메뉴 아이콘을 눌러서 표시, 메뉴 항목이 리스트 형태로 나열   
			2. 콘텍스트 메뉴   
					- 콘텍스트(버튼, 에디트 텍스트 등의 위젯) 일부를 길게 눌러서 표시   

#### * 컨텍스트 메뉴   
			- 2개의 xml 파일 생성, 각 버튼 마다 컨텍스트 메뉴로 등록   
			- onCreateContextMenu()는 activity가 시작될 때 호출되는 메소드   
			- 컨텍스트 메뉴 객체 생성   
			- Inflater는 xml로 정의된 View를 객체화 하는 역할을 수행한다.   
			- 위젯을 눌러 컨텍스트 메뉴를 표시하고자 하는 시스템에서 해당 위젯(위젯의 id)을 파라메터로 onCreateContextMenu()를 호출

#### * menu01.xml   
			- 첫 번째 메뉴와 관련된 xml 파일

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item01"
        android:title="menu list01"
        />
    <item
        android:id="@+id/item02"
        android:title="menu list02"
        />
    <item
        android:id="@+id/item03"
        android:title="menu list03"
        />
</menu>
```   

#### * menu02.xml   
			- 두 번째 메뉴와 관련된 xml 파일   
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item04_1"
        android:title="menu list04-1"
        />
    <item
        android:id="@+id/item04_2"
        android:title="menu list04-2"
        />
</menu>
```   

#### * activity_main.xml   
			- 메뉴가 비추어질 버튼 생성   
			- 바탕 색 변환 동작을 위한 LinearLayout id부여   


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/linear01"
    android:orientation="vertical"
    >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="click menu button"
        android:textSize="20sp"
        />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/Btn1"
        android:text="button01"
        android:textSize="20sp"
        android:layout_gravity="center_horizontal"
        />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/Btn2"
        android:text="button02"
        android:textSize="20sp"
        android:layout_gravity="center_horizontal"
        />
</LinearLayout>
```   

#### * MainActivity.java   

```java
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
```