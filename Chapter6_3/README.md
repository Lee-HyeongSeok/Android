## * 슬라이딩 드로어   (activity_main.xml)
#### * 사용환경 : Android Studio   

#### * SlidingDrawer   
			* 서랍처럼 열고 닫는 동작   
			* handle : 서랍 처럼 여닫는 손잡이 역할, 위젯의 id로 설정한다.   
			* content : 서랍을 열었을 때 보여지는 내용에 해당하는 뷰의 id로 지정한다.   
			* 하나의 layout만 들어가므로 주로 layout으로 설정한다.   

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >

    <SlidingDrawer
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:handle="@id/Btn1"
        android:content="@id/content"
        >
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/Btn1"
            android:text = "button1"
            android:textSize="20sp"
            />
        <LinearLayout
            android:id="@+id/content"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#00FF00"
            android:gravity="center"
            >

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="슬라이딩 드로우의 내용이다."
                android:textSize="20sp"
                android:gravity="center_horizontal"
                />
        </LinearLayout>

    </SlidingDrawer>
</LinearLayout>
```