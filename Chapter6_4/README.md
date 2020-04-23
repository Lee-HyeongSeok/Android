## * View Flipper   
#### * 사용환경 : Andriod Studio   

#### * View Flipper   
			* View Flipper 안에 여러 개의 뷰를 배치한다.   
			* 화면을 왼쪽, 오른쪽으로 밀어서 뷰를 하나씩 보여준다.   
			* flipper.showNext(), flipper.showPrevious()로 화면을 이동한다.   

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

	
    <TabHost	// 전체 xml을 탭 호스트로 감싸고 그 내부에 리니어 레이아웃을 배치 
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/tabhost1"	// 탭 호스트 아이디 지정 
        >
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TabWidget
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:id="@android:id/tabs"
                />
            <FrameLayout // 실제로 각 레이아웃 마다 필요한 위젯을 배치하면 된다.
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:id="@android:id/tabcontent"
                >
                <LinearLayout	// 탭 1의 화면을 구성하기 위한 리니어 레이아웃 
                    android:id="@+id/tab01"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="#f08000"
                    android:orientation="vertical"
                    >
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center_horizontal"
                        android:text="화면1"
                        android:textSize="20sp"
                        />
                </LinearLayout>
                <LinearLayout	// 탭 2의 화면을 구성하기 위한 리니어 레이아웃 
                    android:id="@+id/tab02"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="#f0f000"
                    android:orientation="vertical"
                    >
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center_horizontal"
                        android:text="화면2"
                        android:textSize="20sp"
                        />
                </LinearLayout>
                <LinearLayout	// 탭 3의 화면을 구성하기 위한 리니어 레이아웃 
                    android:id="@+id/tab03"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="#f00022"
                    android:orientation="vertical"
                    >
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center_horizontal"
                        android:text="화면3"
                        android:textSize="20sp"
                        />
                </LinearLayout>

            </FrameLayout>

        </LinearLayout>
    </TabHost>

</LinearLayout>
```   

```java
public class MainActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	// 탭 호스트 뷰를 지정한다.
        TabHost tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();	

	// 탭 1에 쓰일 글자를 탭 1로 지정, 새로운 탭 스펙 생성 후 탭 화면인 tab01과 연결한다.
        TabHost.TabSpec tspec01 = tabHost.newTabSpec("Tab01");
        tspec01.setIndicator("탭 1"); // 탭 앞에 보여주는 텍스트
        tspec01.setContent(R.id.tab01); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec01); // 탭 호스트에 첫 번째 탭을 추가 -> 탭 1이 생성됨 

	// 탭 2에 쓰일 글자를 탭 2로 지정, 새로운 탭 스펙 생성 후 탭 화면인 tab02과 연결한다.
        TabHost.TabSpec tspec02 = tabHost.newTabSpec("Tab02");
        tspec02.setIndicator("탭 2"); // 탭 앞에 보여주는 텍스트
        tspec02.setContent(R.id.tab02); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec02); // 탭 호스트에 첫 번째 탭을 추가 -> 탭 2가 생성됨 

	// 탭 3에 쓰일 글자를 탭 3로 지정, 새로운 탭 스펙 생성 후 탭 화면인 tab03과 연결한다.
        TabHost.TabSpec tspec03 = tabHost.newTabSpec("Tab03");
        tspec03.setIndicator("탭 3"); // 탭 앞에 보여주는 텍스트
        tspec03.setContent(R.id.tab03); // 화면의 아이디 값을 지정해준다.
        tabHost.addTab(tspec03); // 탭 호스트에 첫 번째 탭을 추가 -> 탭 3이 생성됨
    }
}
```