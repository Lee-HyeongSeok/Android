## * RelativeLayout   
#### * 출처 : Android Studio를 활용한 안드로이드 프로그래밍   


#### * RelativeLayout
			* orientation 속성 설정이 필요 없다.   
			* 내부 위젯을 기준으로 상대적인 배치가 이루어진다.   

#### * 전체 레이아웃에 대한 배치   

			* alignParentTop : 레이아웃의 top 위치에 정렬   

			* centerHorizontal : 수평적으로 중앙   

			* alignParentLeft : 레이아웃의 left 선에 정렬(선 안쪽에 위치)   

			* alignParentRight : 레이아웃의 right 선에 정렬(선 안쪽에 위치)   


#### * 기준 위젯에 대한 배치   

			* 기준 위젯이 id를 가지고 있어야 다른 위젯들이 위치를 참조할 수 있다.   

			* layout_alignTop : 기준 위젯의 위쪽 라인 참조(선 안쪽에 위치)   

			* layout_alignRight : 기준 위젯 오른쪽 선의 안쪽에 위치   

			* layout_alignLeft : 기준 위젯 왼쪽 선의 안쪽에 위치   

			* layout_toLeftOf : 기준 위젯의 왼쪽 선의 바깥쪽에 위치   

			* layout_toRightOf : 기준 위젯의 오른쪽 선의 바깥쪽에 위치   

			* layout_above : 기준 위젯의 위쪽(바깥쪽으로 위치)

```xml
// 기준 선의 바깥쪽에 위치(왼쪽)
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="기준-밖왼"
        android:layout_below="@id/Btn"
        android:layout_toLeftOf="@id/Btn"	// toLeftOf
        />

// 기준 선의 안쪽에 위치(왼쪽)
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="기준-하왼"
        android:layout_below="@id/Btn"
        android:layout_alignLeft="@id/Btn"	// alignLeft
        />

// 기준 선의 바깥쪽에 위치(오른쪽)
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="기준-밖오"
        android:layout_below="@id/Btn"
        android:layout_toRightOf="@id/Btn"
        />
//기준 선의 안쪽에 위치(왼쪽)
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="기준-하오"
        android:layout_below="@id/Btn"
        android:layout_alignRight="@id/Btn"
        />
```