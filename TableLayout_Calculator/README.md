## * TableLayout을 이용한 계산기 구현   
#### * 사용환경 : Android Studio   

#### * TableLayout   
		* 주로 위젯을 표 형태로 배치할 때 사용한다.   
		* 행의 수 : TableRow의 수      
		* 열의 수 : TableRow 안의 위젯 수   

#### * TableLayout 속성   
		* <TableLayout 안에 포함된 위젯에 설정하는 속성>   
		* layout_span : 현재 셀부터 지정한 셀을 합쳐서 표시   
		* layout_column : 지정된 열에 현재 위젯을 표시하라는 의미다.   

		* <TableLayout 의 속성>   
		* stretchColumns="*" : 각 셀을 모두 같은 크기로 확장하여 전체 화면이 꽉 차는 효과를 낸다.   
				* 열 번호는 0번부터 시작한다.   


#### * activity_main.xml   
			* 1~2행 : 숫자 입력하는 텍스트 에디터   
			* 3 ~ 5행 : 숫자 버튼   
			* 6 ~ 7행 : 연산자 선택 버튼   
			* 8행 : 계산 결과를 나타내는 텍스트 뷰   

```xml
<TableLayout
xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:layout_weight="2"
    >
    <TableRow> // 1행
        <EditText
            android:id="@+id/editor1"
            android:layout_span="4" // 현재 셀부터 4개의 셀을 합쳐서 보여줌
            android:hint="숫자 1 버튼입력"
            />
    </TableRow>
    
    <TableRow> // 2행
        <EditText
            android:id="@+id/editor2"
            android:layout_span="4" // 현재 셀부터 4개의 셀을 합쳐서 보여줌
            android:hint="숫자 2 버튼 입력"
            />
    </TableRow>
    
    <TableRow> // 3행
        <Button
            android:id="@+id/Btn1"
            android:text="1"/>
        <Button
            android:id="@+id/Btn2"
            android:text="2"/>
        <Button
            android:id="@+id/Btn3"
            android:text="3"/>
        <Button
            android:id="@+id/Btn4"
            android:text="4"/>
    </TableRow>
    
    <TableRow> // 4행
        <Button
            android:id="@+id/Btn5"
            android:text="5"/>
        <Button
            android:id="@+id/Btn6"
            android:text="6"/>
        <Button
            android:id="@+id/Btn7"
            android:text="7"/>
        <Button
            android:id="@+id/Btn8"
            android:text="8"/>
    </TableRow>
    
    <TableRow> // 5행
        <Button
            android:id="@+id/Btn9"
            android:text="9"
            android:layout_span="2" // 현재 셀부터 2개의 셀을 합쳐서 보여줌
            />
        <Button
            android:id="@+id/Btn0"
            android:text="0"
            android:layout_span="2"/> // 현재 셀부터 2개의 셀을 합쳐서 보여줌
    </TableRow>
    
    <TableRow> // 6행
        <Button
            android:id="@+id/plus"
            android:text="더하기"
            android:background="#FF8844" // 연 주황색
            android:layout_span="2" // 현재 셀부터 2개의 셀을 합쳐서 보여줌
            />
        <Button
            android:id="@+id/minus"
            android:text="빼기"
            android:background="#FF0088" // 연분홍색
            android:layout_span="2"/> // 현재 셀부터 2개의 셀을 합쳐서 보여줌
    </TableRow>
    
    <TableRow> // 7행
        <Button
            android:id="@+id/multi"
            android:text="곱하기"
            android:background="#22FF55" // 형광 초록색
            android:layout_span="2"/>
        <Button
            android:id="@+id/divide"
            android:text="나누기"
            android:background="#2288FF" // 연파란색
            android:layout_span="2"/>
    </TableRow>
    
    <TableRow> // 8행
        <TextView
            android:id="@+id/result"
            android:layout_margin="5dp"
            android:layout_span="5"
            android:text="계산 결과 : "
            />
    </TableRow>
</TableLayout>
```   

#### * MainActivity.java   
		* 가독성을 위해 연산자 리스너는 onCeate() 밖에 선언   


```java
public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2; // 피연산자를 입력받는 텍스트 에디터
    Button BtnPlus, BtnMinus, BtnMulti, BtnDivide; // 연산자 버튼 4개
    TextView resultText; // 결과 값 출력하는 텍스트 뷰
    String val1, val2; // 피 연산자
    Integer result; // string 형 텍스트 계산 결과를 받기 위한 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");

        // 숫자 버튼 뷰 객체 배열
        final Button[] numButtons = new Button[10];

        // ID를 불러오기 위한 id 배열
        Integer[] numBtnIDs = {R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3, R.id.Btn4,
        R.id.Btn5, R.id.Btn6, R.id.Btn7, R.id.Btn8, R.id.Btn9};


        // 텍스트 에디터 아이디를 통해 뷰 불러오기
        edit1 = (EditText)findViewById(R.id.editor1);
        edit2 = (EditText)findViewById(R.id.editor2);

        // 연산자 버튼 아이디를 통해 뷰 불러오기
        BtnPlus = (Button)findViewById(R.id.plus);
        BtnMinus = (Button)findViewById(R.id.minus);
        BtnMulti = (Button)findViewById(R.id.multi);
        BtnDivide = (Button)findViewById(R.id.divide);

        // 결과 텍스트 뷰 아이디를 통해 뷰 불러오기
        resultText = (TextView)findViewById(R.id.result);

        // 각 연산 버튼 리스너 선언
        BtnPlus.setOnTouchListener(PlusListener);
        BtnMinus.setOnTouchListener(MinusListener);
        BtnMulti.setOnTouchListener(MultiplyListener);
        BtnDivide.setOnTouchListener(DivideListener);


        // 해당하는 숫자 버튼의 아이디를 통해 뷰를 불러온다.
        for(int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(int i=0; i<numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    // 첫 번째 텍스트 에디터에 초점이 맞춰졌다면
                    if(edit1.isFocused() == true){

                        // 버튼에 텍스트를 가져와 string으로 변환 후 val1에 삽입
                        val1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(val1); // 변환된 스트링을 텍스트 에디터에 표현
                    } // 두 번째 텍스트 에디터에 초점이 맞춰졌다면
                    else if(edit2.isFocused() == true){
                        val2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(val2); // 변환된 스트링을 텍스트 에디터에 표현
                    }
                    else{ // 텍스트 입력 외에 연산자 버튼을 눌렀을 경우 잠깐 출력
                        Toast.makeText(getApplicationContext(),
                                "먼저 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    View.OnTouchListener PlusListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) + Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener MinusListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) - Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener MultiplyListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) * Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
    View.OnTouchListener DivideListener = new View.OnTouchListener(){
        public boolean onTouch(View arg0, MotionEvent arg1){
            val1 = edit1.getText().toString();
            val2 = edit2.getText().toString();
            result = Integer.parseInt(val1) / Integer.parseInt(val2);
            resultText.setText("계산 결과 : " + result.toString());
            return false;
        }
    };
}
```