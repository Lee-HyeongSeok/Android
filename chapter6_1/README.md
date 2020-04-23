## * 간단한 날짜, 시간 예약 시스템 만들기   
#### * 사용환경 : Android Studio   
#### * Chapter6   

#### * 어플 이미지   
![Chapter6](D:\Android_WorkSpace\Chapter6_1\Chapter6.PNG)   

#### * 날짜 및 시간 위젯   
1. 아날로그 시계, 디지털 시계 : 시계 위젯 => API 23부터는 지원하지 않는다.   
2. 타임피커, 데이트 피커 : 시간, 날짜를 설정하는 위젯   
		* timePickerMode : spinner, clock 중 하나를 선택   
		* spinner : 상, 하로 돌아가는 시계   
		* clock : 디지털 시계와 같은 시계   
3. 캘린더 뷰 : 달력처럼 일정 날짜를 전체적으로 보는 위젯   
4. 크로나미터 : 타이머, 정밀 시간 측정용 위젯   
		* start(), end(), reset() 메서드를 이용   
		* format() 메소드에서 %s를 시간으로 대체한다.   
		* setBase(SystemClock.elapsedrealtime()) 메소드로 현재 시간을 기반으로 카운팅   

#### * TimePicker 위젯 선언(activity_main.xml)   

```xml
<TimePicker
            android:id="@+id/timePicker1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:timePickerMode="spinner"
            />
```

#### * TimePicker 위젯 사용(MainActivity.java)   

```java
TimePicker tPicker; // TimePicker 객체 선언 
tPicker = (TimePicker)findViewById(R.id.timePicker1); // 뷰에서 불러오기 

// TimePicker 시간 변경 사항 인식 시 동작 
tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1){
	// 토스트 메시지로 설정한 시간 잠깐 출력 
                Toast.makeText(getApplicationContext(),
                        Integer.toString(i) + "시" +
                        Integer.toString(i1) + "분", Toast.LENGTH_SHORT).show();
            }
        });
```   

#### * CalendarView 위젯 선언(activity_main.xml)   

```xml
<CalendarView
            android:id="@+id/calendar1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            />
```   

#### * CalendarView 위젯 사용(MainActivity.java)   

```java
CalendarView CalView; // 캘린더 뷰 위젯 선언
CalView = (CalendarView)findViewById(R.id.calendar1); // 뷰에서 불러오기 

// 캘린더 위젯 내용 변경 인식 시 동작 
CalView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2){
	// 토스트 메시지로 설정한 시간 잠깐 출력 
                Toast.makeText(getApplicationContext(),
                        Integer.toString(i) + "년" +
                        Integer.toString(i1 + 1) + "월" +
                        Integer.toString(i2) + "일", Toast.LENGTH_SHORT).show();
            }
        });
```