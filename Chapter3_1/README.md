## * Chapter3 간단한 계산기 만들기
#### * 안드로이드 프로그래밍
#### * 사용 환경 : Android Studio

#### * 구성 요소
		* EditText 2개를 통해 피연산자 2개를 입력 받는다.
		* 버튼 4개를 통해 사칙연산을 선택한다.
		* 버튼 선택의 결과가 맨 아래 TextView에 표시된다.   
		* xml에서 LinearLayout으로 순차적인 형식으로 위젯을 배치한다.
		* android:orientation="vertical" 속성을 부여하여 위에서 아래로 배치한다.

#### * activity_main.xml
		* 피연산자를 입력받기 위한 EditText 객체 2개 생성
		* 더하기, 빼기, 곱하기, 나누기 동작을 위한 버튼 4개 생성
		* 결과를 나타내기 위한 TextView 객체 생성   

```xml
<EditText
        android:layout_width="130dp"
        android:layout_height="wrap_content"
        android:id="@+id/TextEditor1"/>
    <EditText
        android:layout_width="130dp"
        android:layout_height="wrap_content"
        android:id="@+id/TextEditor2"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btn1"
        android:text="더하기"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btn2"
        android:text="빼기"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btn3"
        android:text="곱하기"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btn4"
        android:text="나누기"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/textView"
        />
```   

#### * MainActivity.java   

```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main에 있는 전체 뷰(xml)을 가져온다.
        setContentView(R.layout.activity_main);

        // Button 개별뷰를 연결한다.
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);

        // 버튼 동작에 대한 메서드 정의
        button1.setOnClickListener(ButtonListener1);
        button2.setOnClickListener(ButtonListener2);
        button3.setOnClickListener(ButtonListener3);
        button4.setOnClickListener(ButtonListener4);

         // EditText 개별뷰를 연결한다.
        et1 = (EditText)findViewById(R.id.TextEditor1);
        et2 = (EditText)findViewById(R.id.TextEditor2);

        // TextView 개별뷰를 연결한다.
        t = (TextView)findViewById(R.id.textView);
}

```

```java
View.OnClickListener ButtonListener1 = new View.OnClickListener(){
        // 더하기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            int result = Integer.parseInt(str1) + Integer.parseInt(str2);
            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener2 = new View.OnClickListener(){
       // 빼기
        public void onClick(View view){
            int result;
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            if((Integer.parseInt(str1) > Integer.parseInt(str2))){
                result = Integer.parseInt(str1) - Integer.parseInt(str2);
            } else {
                result = Integer.parseInt(str2) - Integer.parseInt(str1);
            }

            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener3 = new View.OnClickListener(){
        // 곱하기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            int result = Integer.parseInt(str1) * Integer.parseInt(str2);
            t.setText(String.valueOf(result));
        }
    };
    View.OnClickListener ButtonListener4 = new View.OnClickListener(){
       // 나누기
        public void onClick(View view){
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            double result = Double.parseDouble(str1) / Double.parseDouble(str2);
            if((result) == 0){
                t.setText("몫은 0, 나누기 불가능");
            }
            else{
                t.setText(String.valueOf(result));
           }
       }
  };
```