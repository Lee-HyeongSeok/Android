## * Option Menu   
#### * 출처 : Android Studio를 활용한 안드로이드 프로그래밍   

#### * 메뉴   
			1. 옵션 메뉴   
					- xml파일을 통해 생성한다.   
					- java 코드에서 호출하는 방식   
					- 메뉴 아이콘을 눌러서 표시, 메뉴 항목이 리스트 형태로 나열   
			2. 콘텍스트 메뉴   
					- 콘텍스트(버튼, 에디트 텍스트 등의 위젯) 일부를 길게 눌러서 표시   

#### * 옵션 메뉴   
			- 여러 개의 기능 중 하나를 선택하는 용도   
			- onCreateOptionMenu() : activity 시작될 때 호출되는 메소드   
						- 이 곳에서 메뉴 객체를 생성해야 한다.   
						- 부모 클래스의 동일 메소드 호출, 부모 쪽에서 처리할 일이 있는지 확인하고 수행   
						- 메뉴 Inflater 객체 getMenuInflater로 생성한다.   
						- xml로 menu를 정의, xml 파일로부터 menu 객체를 생성하기 위해 MenuInflater 사용   

		* MainActivity.java
```java
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
```   

		* activity_main.xml   
				- LinearLayout 바탕색을 바꾸기 위해 참조할 아이디 부여
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/linear01"
    android:orientation="vertical">


</LinearLayout>
```   

		* res-make menu directory - menu1.xml   
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item01"
        android:title="menu - list01"
        />
    <item
        android:id="@+id/item02"
        android:title="menu - list02"
        />
    <item
        android:id="@+id/item03"
        android:title="menu - list03"
        />
    <item
        android:id="@+id/item04"
        android:title="menu - list04"
        >
        <menu>
            <item
                android:id="@+id/item05"
                android:title="menu - list4-1"
                />
            <item
                android:id="@+id/item06"
                android:title="menu - list4-2"
                />
        </menu>
    </item>

</menu>
```