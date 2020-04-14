## * 안드로이드 프로그래밍 View 속성
#### * 개발환경 : Android studio

#### * Activity_main.xml
		** < 폭과 높이 >
		* width : 위젯의 폭
		* height : 위젯의 높이
		* match_parent : 부모 또는 레이아웃의 폭과 높이에 맞춘다.
		* wrap_content : 내부 내용의 폭과 높이에 맞춰진다. (ex : 텍스트..)

		* 해상도 : 화면 공간안에 있는 픽셀의 수로 표현한다.
		** < 화면 밀도 >
		* ldpi(저밀도) < mdpi(중밀도) < hdpi(고밀도) < xhdpi(초고밀도) < xxhdpi(초초고밀도) < xxxhdpi(초초초고밀도)
		* 단위
			* in : 인치
			* mm : 밀리미터
			* px : 픽셀
				* px = dp * (dpi/160) 수식으로 1dp가 몇 px인지 계산한다.
			* dp : desity independent pixels
				* 1dp = 160dpi화면에서의 픽셀 하나를 의미한다.
			* sp : scale independent pixels
				* 텍스트 크기의 단위로 많이 사용한다.
				* 배율에 무관하게 텍스트 크기를 나타낸다.
				* dp인 경우 시스템 배율이 변경되면 따라서 크기가 변경된다.
```xml
// LinearLayout : 위젯의 순차적인 배열을 의미한다.

<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"	// 위에서부터 아래로 배치한다.
    >
    <Button
        android:id="@+id/button1"	// 버튼 클래스 접근을 위한 객체 아이디 생성
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼1"
        />
    <Button
        android:id="@+id/button2"
        android:layout_width="400px"
        android:layout_height="190px"
        android:text="버튼2"
        android:textSize="20sp"
        />
</LinearLayout>

```