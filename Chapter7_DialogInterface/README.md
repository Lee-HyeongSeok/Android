## * 대화상자   
		* 화면에 미시지 표시, 사용자로부터 확인 또는 취소 동작이 필요한 경우 사용   
		* 기본 대화상자   
			1. 사용자에게 메시지 표시, 선택 수신이 목적   
			2. 생성시 AlertDialog.Builder 클래스 사용   
			3. .show()를 통해 화면에 표시   
		* 목록 대화상자   
				* 기본 목록 대화상자   
					1. 리스트 타입의 목록을 보여줌, 그 중 하나를 선택 가능   
					2. setItems()를 사용하여 선택 리스트를 대화상자에 표시   
				* 단일 체크박스 목록 대화상자   
					1. 항목 선택과 동시에 대화상자가 닫힌다.   
					2. 체크박스 타입의 목록 리스트를 보여주고 선택   
					3. 선택 후 대화상자를 닫기 위해 setSingleChoiceItems() 메소드 사용   
				* 다중 체크박스 목록 대화상자   
					1. 다중 선택이 가능하기 위해서는 setMultiChoiceItems()를 사용한다.   
					2. 현재 선택된 항목을 true로 표시하기 위한 boolean 배열을 사용한다.   
					3. DialogInterface의 메소드로는 OnMultiChoiceClickListener()를 사용한다.   
		* 뷰 대화상자   
			1. xml 레이아웃 파일을 대화상자 뷰 화면으로 표시   
			2. dialog1.xml 레이아웃 파일 내용을 뷰로 생성하여 보여줌   
			3. setView() 메소드 사용, xml 레이아웃 파일을 통해 생성된 뷰를 대화상자 화면으로 표시   

* 기본 대화상자 리스너 등록   

```java
Btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 대화 상자 객체인 빌더 객체 생성, 인자로 MainActivity 현 객체를 전달
                AlertDialog.Builder mydlg =  new AlertDialog.Builder(MainActivity.this);
                // 대화 상자 제목 설정
                mydlg.setTitle("기본 대화상자");
                // 대화 상자에 표시할 메시지 설정
                mydlg.setMessage("기본 대화상자 입니다.");

                // 확인 버튼 생성 및 DialogInterface의 리스너 메소드 호출
                mydlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    // 확인 버튼 클릭 시 동작
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인 선택", Toast.LENGTH_SHORT).show();
                    }
                });

                // 취소 버튼 생성 및 DialogInterface의 리스너 메소드 호출
                mydlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    // 취소 버튼 클릭 시 동작
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 선택", Toast.LENGTH_SHORT).show();
                    }
                });
                // 대화상자 왼쪽에 보여지는 아이콘 설정
                mydlg.setIcon(R.mipmap.ic_launcher);
                // 대화상자 출력 메소드 호출
                mydlg.show();
            }
        });
```   

* 단일 체크박스 목록 대화상자 리스너 등록   

```java
Btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final String[] List = new String[]{"list01", "list02", "list03", "list04", "list05"};
                AlertDialog.Builder mydlg = new AlertDialog.Builder(MainActivity.this);
                mydlg.setTitle("체크박스 목록 대화상자");

                // 배열, 디폴트 인덱스, 온클릭 리스너
                // 체크박스 형태 목록 클릭에 대한 리스너 선언
                mydlg.setSingleChoiceItems(List, 0, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i){
                        // 리스너가 호출되면서 어떤 아이템이 선택됬는지 화면에 표시
                        Toast.makeText(MainActivity.this, "선택된 목록 : " + List[i], Toast.LENGTH_SHORT).show();
                    }
                });
                mydlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소 버튼 선택", Toast.LENGTH_SHORT).show();
                    }
                });
                mydlg.setIcon(R.mipmap.ic_launcher);
                mydlg.show();
            }
        });
```   

* 다중 체크박스 목록 대화상자 리스너 등록   

```java
Btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 목록 인수를 배열로 지정(boolean 수와 같아야 함)
                final String[] List = new String[]{"list01", "list02", "list03"};
                // 목록 중 초기에 선택된 다중 항목을 true, false 배열로 지정
                final boolean[] ListCheck = new boolean[]{true, false, false};
                AlertDialog.Builder mydlg = new AlertDialog.Builder(MainActivity.this);
                mydlg.setTitle("다중 체크박스 목록 대화상자");

                // 다중 선택이 가능하기 위해서는 setMultiChoiceItems() 사용
                // 선택된 항목의 인덱스와 check 여부를 true, false로 전달
                // 배열, 체크여부 boolean 값, OnMultiChoiceClickListener() 전달
                // 항목과 해당 목록의 boolean 값을 표시
                mydlg.setMultiChoiceItems(List, ListCheck, new DialogInterface.OnMultiChoiceClickListener(){
                    public void onClick(DialogInterface dialog, int i, boolean b){
                        Toast.makeText(MainActivity.this, "선택한 목록 : " +
                                List[i]+ "-" + b, Toast.LENGTH_SHORT).show();
                    }
                });

                mydlg.setIcon(R.mipmap.ic_launcher);
                mydlg.setPositiveButton("닫기", null);
                mydlg.show();
            }
        });
```   

* 뷰 대화상자 리스너 등록   
		* R.layout에 사용자 정의 뷰를 보여주기 위한 xml 파일 두 개 생성   
				* toast01.xml   
				* dialog1.xml   

```java
Btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // 대화 상자를 만든다.
                // 대화 상자 뷰를 xml 레이아웃으로 보여준다.
                // view의 inflate 이용, Main의 Context, 어떤 파일로 뷰를 생성할지
                dlg_view = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder mydlg = new AlertDialog.Builder(MainActivity.this);
                mydlg.setIcon(R.mipmap.ic_launcher);
                mydlg.setView(dlg_view);
                mydlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText ed_name = (EditText)dlg_view.findViewById(R.id.Edit_name);
                        EditText ed_email = (EditText)dlg_view.findViewById(R.id.Edit_email);

                        tv_name.setText(ed_name.getText().toString());
                        tv_email.setText(ed_name.getText().toString());
                    }
                });
                mydlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        tv_view = (View)View.inflate(MainActivity.this, R.layout.toast01, null);
                        tv_msg = (TextView)tv_view.findViewById(R.id.tv_msg); // 메시지 부분 수정
                        tv_msg.setText("취소");
                        toast.setView(tv_view); // 현재 만든 뷰 등록, 토스트 메시지 띄울 때 해당 view가 뜬다.
                        toast.show();
                    }
                });
                mydlg.show();
            }
        });
```
