## * Android Studio를 활용한 안드로이드 프로그래밍   
#### * 파일 처리(읽기/쓰기)   

* 파일처리   
	1. 내장 메모리에 파일 생성 및 읽기   
		* 저장 위치 : /data/data/패키지명/files폴더   
		* 파일 쓰기 : Context 클래스의 openFileOutput() 메소드 사용 -> FileOutputStream 반환   
		* java.io.FileOutputStream의 write() 사용하여 파일에 데이터를 쓴다.   
		* 파일 읽기 : Context 클래스의 openfileInput() 메소드 사용 -> FileInputStream 반환   
		* java.io.FileInputStream의 read() 사용하여 파일에 데이터를 읽는다.   
	2. 일기장 앱 작성   
	3. res-raw 폴더에 파일 읽기   

* MainActivity.java   

```java
public class MainActivity extends AppCompatActivity{

    Button btnWrite, btnRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 어플 제목 설정
        setTitle("내장 메모리 읽기/쓰기");

        btnWrite = (Button)findViewById(R.id.BtnWrite);
        btnRead = (Button)findViewById(R.id.BtnRead);

        btnWrite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 파일 이름, 모드
                // OutputStream 리턴
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "내장 메모리 저장할 내용입니다.";
                    outFs.write(str.getBytes()); // 인코딩을 통해 바이트 스트림으로 출력
                    outFs.close(); // 실제적으로 파일이 생성된다.
                    Toast.makeText(getApplicationContext(), "file.txt 파일 생성",
                            Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(); // 파일이 없으면 해당되는 에러 출력
                } catch (IOException e) { // I/O 에러 발생 시 에러 출력
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[100]; // input 한 것을 저장할 바이트 배열
                    inFs.read(txt);
                    // 디폴트 char set을 기반으로 디코딩한다.
                    String str = new String(txt); // 바이트 배열을 디코딩 하기 위함
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                } catch (FileNotFoundException e) {
                    //e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "파일 읽기 실패",
                            Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

```