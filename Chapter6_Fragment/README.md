## * ActionBar & Fragment   
#### * 출처 : Android Studio를 활용한 안드로이드 프로그래밍   
#### * activity_main 사용 안함   

#### * ActionBar   
			* 화면 상단에 위치   
			* 타이틀 표시, 버튼 표시 가능   
			* OS에서 지원하는 ActionBar(android.cpp.ActionBar) 보다는 라이브러리에서 제공하는 ActionBar 사용 권장   
			* OS 지원 ActionBar는 OS 버전에 따라 다르게 동작하기 때문이다.   

#### * Fragment   
			* Activity 보다 작은 단위의 화면, 화면 분할 사용 가능   
			* 실행 중 화면을 동적으로 추가 또는 삭제 가능   


#### * MainActivity.java

```java
package com.example.chapter6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

@SuppressWarnings("deprecation") // 컴파일러에게 더 이상 업그레이드 지원 불가 표시 안나오게 하는 것
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    ActionBar.Tab tab01, tab02, tab03; // create value to stored tab

    // create array to stored fragment
    myFragment frags[] = new myFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // 현재 액티비티와 관련된 액션바를 가져옴
        ActionBar bar01 = getSupportActionBar();
        // 탭 호스트에서 처럼 탭들이 보이게 설정한다.
        bar01.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // 탭 생성, 액션바에 탭 추가하는 부분
        tab01 = bar01.newTab(); // create tab
        tab01.setText("Tab01"); // show on the tab
        tab01.setTabListener(this); // this object including tab listener
        // supplement tab01 in action bar
        bar01.addTab(tab01); // input created tab01 in bar01

        // same motion
        // using bar01's getSupportActionBar() method
        tab02 = bar01.newTab();
        tab02.setText("Tab02");
        tab02.setTabListener(this);
        bar01.addTab(tab02);

        tab03 = bar01.newTab();
        tab03.setText("Tab03");
        tab03.setTabListener(this);
        bar01.addTab(tab03);
    }
    // using library Fragment for extends
    public static class myFragment extends Fragment{
        String tabName;
        // method to execute when creating a fragment
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            // declare Bundle variable value
            // getArguments : get communicable arguments from fragment
            Bundle data = getArguments();
            // get the value corresponding to the tab name
            tabName = data.getString("tabName");
        }
        // Method called at view creation time
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                   LinearLayout.LayoutParams.MATCH_PARENT,
                   LinearLayout.LayoutParams.MATCH_PARENT
           );

            // create linear layout
            // orientation : set vertical
            // width, height : set match_parent
            LinearLayout linear = new LinearLayout(super.getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            linear.setLayoutParams(params);

            if(tabName == "Tab01")
                linear.setBackgroundColor(Color.RED);
            else if(tabName == "Tab02")
                linear.setBackgroundColor(Color.GREEN);
            else if(tabName == "Tab03")
                linear.setBackgroundColor(Color.BLUE);
            return linear; // return created linear layout
        }
    }
    // calling part when tab is clicked
    // 탭이 어떤게 눌렸는지 확인
    // 해당 탭이 눌렸을 때 현재 생성된 프래그먼트가 없으면 새로 생성
    // 생성된 프래그먼트가 있으면 그 프래그먼트로 화면으로 보여주는 동작
    // 생성된 프로그먼트를 저장할 공간 필요
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        myFragment myfrag = null;
        // frags에 저장된 배열이 null인지 확인
        // 사용자가 선택한 탭의 위치를 가져온다.
        if(frags[tab.getPosition()] == null){
            myfrag = new myFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myfrag.setArguments(data);
            // 만든 값을 배열에 삽입
            frags[tab.getPosition()] = myfrag;
        }else{ // 아니면 화면 뷰에 보이도록 하는 동작
            // 사용자가 선택한 탭의 위치를 가져온다.
            myfrag = frags[tab.getPosition()];
        }
        // 현재 컨텐트 뷰를 표시할 위치를 나타낸다
        // 현재 만든 프래그먼트를 가지고 대체시킨다.
        // 해당 탭 선택 시 대응되는 프래그먼트를 화면에 보여준다.
        ft.replace(android.R.id.content, myfrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
```