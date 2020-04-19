## * 레이아웃과 속성(LinearLayout)   
#### * Android studio를 활용한 안드로이드 프로그래밍

* 레이아웃 종류
		* LinearLayout : 수직 또는 수평으로 레이아웃을 차례로 배치한다.   
				* 수직 : 위->아래   
				* 수평 : 왼쪽->오른쪽   
		* RelativeLayout : 특정 위젯을 기준으로 배치한다(다른 위젯으로부터 상대적인 위치를 결정)   
		* FrameLayout : 영상에서 주로 사용하며 겹쳐서 배치한다.   
				* Frame_1 : 사람, Frame_2 : 배경 => 겹쳐서 배경에 사람이 존재하듯이 하는 기능   
		* TableLayout : 테이블 형태로 배치한다.   
		* GridLayout : TableLayout과 비슷하지만 행 또는 열 확장 기능이 있다.   
		* ConstrainLayout : 디자인 개념을 섬세하게 할 수 있게 위치 관계를 지정할 수 있다.(drag & drop)   

* Layout의 속성   
		* Orientatioin : 배치 방향   
				* vertical : 수직 방향   
				* horizontal : 수평 방향   
		* gravity : 좌측, 우측, 중앙으로 정렬 방향 설정   
				* right : 오른쪽 상단   
				* left : 왼쪽 상단   
				* right|bottom : 오른쪽 하단   
				* top|center : 상단 중앙   
				* center : 중앙 등등   
		* layout_gravity : 각 위젯마다 적용되는 정렬 방향 설정   
				* right : 버튼의 밖에 있는 레이아웃에게 우측 정렬 요청   
				* left : 버튼의 밖에있는 레이아웃에게 좌측 정렬 요청   
		* padding : 레이아웃 안에 위젯들과의 여백 설정   
		* layout_weight : 레이아웃이 전체화면에서 차지하는 비중 설정   
		* baselineAligned : 서로 크기가 다른 위젯 정렬   
				* true : 글씨의 밑에 라인 기준에 맞춰진다.   
				* false : 위젯의 top 기준에 맞춰진다.   

* 중복 Layout(LinearLayout)   
		* layout_weight 속성을 통해 화면을 차지하는 비율로 나뉜다.
		
```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" // 위에서 아래 방향으로 레이아웃을 배치(전체적인 레이아웃)
    >
    <LinearLayout	
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1" // 전체 레이아웃의 비율의 1 차지 
        android:orientation="horizontal" // 현재 자신의 레이아웃을 수평으로 배치 
        >
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"	// 나누어진 레이아웃에서 비율의 1을 차지(큰 왼쪽 레이아웃)
            android:background="#0000FF"
            >
	
            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="button1"	
                android:textSize="20sp"
                ></Button>
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1" // 나누어진 오른쪽 큰 레이아웃의 비율
            android:background="#00FF00"
            android:orientation="vertical" // 위에서 아래 방향으로 레이아웃을 배치한다.
            >
            <LinearLayout	// 상위 레이아웃의 자식 레이아웃
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background="#004455"
                >
                <Button
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="button2"
                    android:textSize="20sp"
                    ></Button>
            </LinearLayout>
            <LinearLayout	// 상위 레이아웃의 자식 레이아웃 
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background="#443322"
                >
                <Button
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="button3"
                    android:textSize="20sp"
                    ></Button>
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>

    <LinearLayout	// 처음 화면의 1/3을 차지하는 레이아웃과 반대되는 2/3를 차지하는 레이아웃
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="2"
        android:background="#FF5500"
        >
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="button4"
            android:textSize="20sp"
            ></Button>
    </LinearLayout>

</LinearLayout>
```