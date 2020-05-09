## * Android Studio를 활용한 모바일 프로그래밍   
#### * Diary   

#### * 파일 처리   
			1. 내장 메모리에 파일 생성 및 읽기   
					* 저장 위치 : /data/data/패키지명/files 폴더   
					* 파일 쓰기 : Context 클래스의 openFileOutput() 메소드 사용 -> FileOutputStream 반환   
							* java.io.FileOutputStream의 write()를 사용하여 파일에 데이터를 작성한다.   
					* 파일 읽기 : Context 클랫의 openFileInput() 메소드 사용 -> FileInputStream 반환   
							* java.io.FileInputStream의 read()를 사용하여 파일의 내용을 읽는다.   
			2. 일기장 앱 작성   
					* 앱의 레이아웃 구성 : 데이트 피커(날짜 지정), 에디트 텍스트(내용기록)   
					* 데이트 피커 : 캘린더 형태, 스피너 형태   
					* 선택한 날짜에 일기가 있으면 수정하기 버튼, 없으면 새로 저장이라는 텍스트를 버튼 텍스트로 설정한다.   
					* 날짜가 변경될 때마다 해당 파일이 존재하는지 보여줌   
					* 데이트 피커 날짜 변경 시   
							1. 년도_달_일 형식인 파일 이름 설정   
							2. readDiary() 함수 호출, 현재 이미 저장된 일기 파일이 있으면 내용을 읽어서 String으로 전달   
							3. 전달된 string EditText에 출력   
			3. res-raw 폴더에 파일 읽기   

* DatePicker 리스너 구현   
			1. 현재 날짜에 해당하는 파일이 있는지 검사, 있으면 그 내용을 에디트 텍스트에 보여준다.   
			2. 년도_달_일 형식으로 파일 이름 String 객체에 저장   
			3. 데이트 피커의 값이 변했을 때 동작   
			4. 파일에서 읽은 내용을 에디트 텍스트에 표시한다.   

```java
dpicker_main.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            // 현재 날짜에 해당하는 파일이 있는지 검사, 있으면 그 내용을 에디트 텍스트에 보여준다.
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                // 년도_달_일 형식으로 파일 이름 만들어짐
                filename = Integer.toString(year) + "_" +
                        Integer.toString(month) + "_" + Integer.toString(day);
                // 위에서 만든 파일 이름의 파일을 읽는다.
                String str = readDiary(filename);
                // 파일에서 읽은 내용을 에디터 텍스트에 표시한다.
                edText_main.setText(str);
                Btn1_main.setEnabled(true);
            }
        });
```   

* 사용자가 "수정하기"나 "새로 생성" 버튼을 눌렀을 때 리스너   
			1. 버튼 리스너   
			2. 데이트 피커 리스너에서 날짜 선택 시 filename에 해당 년도_달_일 형태로 만들어짐   
			3. openFileOutput() 함수로 파일에 내용 작성   

```java
Btn1_main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 출력하는 부분, FileOutputStream
                FileOutputStream outFs = null;
                // 선택하는 순간 파일 이름이 filename 변수에 이름이 저장된다.
                // 위에서 데이트피커를 선택한 순간 파일 이름을 만들어줬기 때문에
                try {
                    // 해당 파일 이름으로 파일을 연다.
                    outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edText_main.getText().toString();
                    // 바이트 배열 형태로 저장하기 위함
                    // str.getBytes() : str을 바이트 배열로 만들어준다.(저장하기 위함)
                    // 디폴트 char set 형태로 인코딩을 한다.
                    // 예를 들어, 디폴트 : utf-8이면 이 형태로 인코딩을 함
                    outFs.write(str.getBytes());
                    outFs.close(); // 파일 생성
                    Toast.makeText(getApplicationContext(), filename+"이 저장됨",
                            Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
```   

* 파일로부터 내용을 읽을 때   
			1. readDiary() 메소드로 구현   
			2. 파일로부터 읽어서 string을 리턴해준다.   
			3. 바이트 형태 -> string 형태로 변환   

```java
// readDiary 구현
    // 파일로부터 읽어서 string을 리턴해준다.
    String readDiary(String fname) {
        String diaryStr = null;
        FileInputStream inFs=null;
        // 파일 오픈, openFileInput()
        try {
            inFs = openFileInput(fname);
            // 읽어서 바이트 스트림에 저장
            byte[] text = new byte[500]; // 500자 한정
            inFs.read(text);
            inFs.close(); // 파일 닫음
            //text에 있는 바이트 배열을 디코딩하여 새로운 string을 만들어준다.
            //앞뒤 공백을 삭제해 준다.
            diaryStr = (new String(text)).trim();
            Btn1_main.setText("수정 하기");
        } catch (FileNotFoundException e) { // 파일 오픈에서 문제 생길 시, 파일 자체가 없을 때
            // e.printStackTrace();
            edText_main.setHint("해당 날짜에 일기가 없음");
            Btn1_main.setText("새로 저장");
        } catch (IOException e) { // 입출력에서 문제 생길 시, 파일에 내용이 없을 때
            e.printStackTrace();
        }

        return diaryStr;
    }
```