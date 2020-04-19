## * TableLayout, GridLayout, FrameLayout   
#### * Andriod Studio를 활용한 안드로이드 프로그래밍   

#### * TableLayout(배열의 index로 생각한다.)   
			* 화면의 폭에 맞게 셀들을 조절한다.   
			* 테이블 형태로 View를 배치할 때 유용하다.   
			* 버튼마다 넓이, 높이를 지정하지 않아도 된다.   

#### * TableLayout의 속성   
			* stretch columns : 화면에 다 차도록 각 버튼이 스케일링 된다.   
					* 값으로 *를 주면 column들 전체를 한 행에 채운다.   
			* TableRow 뷰   
					* TableRow에 선언된 위젯들은 넓이, 높이를 설정하지 않아도 된다.   
					* wrap_content와 같이 자동으로 스케일링 된다.   
			* layout_Span : 현재 셀부터 숫자 갯수만큼 확장한다.   
					* 확장 방향은 행 방향이다.   
			* layout_column : 지정된 숫자의 열에 셀을 표시한다.   
					* layout_column="1" : 두 번째 위치부터 셀을 표시한다.   

#### * GridLayout   
			* TableLayout보다 직관적인 특성이 있다.   
					* TableLayout : 2를 지정하면 2번째 index 부터 셀을 표시한다.   
					* GridLayout : 2를 지정하면 2번째 부터 셀을 표시한다.   
			* Android 4.0(API 14)부터 지원한다.   
			* rowSpan : 행 단위로 확장이 된다.(n번 째 행까지 확장)   
			* layout_gravity   
					* fill_vertical 값 : 수직 방향으로 확장된 셀 만큼 차지한다.   
					* fill_horizontal 값 : 수평 방향으로 확장된 셀 만큼 차지한다.   
			* orientatioin   
					* vertical : 위젯 배치 기준을 수직 우선 방향   
					* horizontal : 위젯 배치 기준을 수평 우선 방향   

#### * FrameLayout   
			* 레이아웃 내 위젯들을 왼쪽 상단을 기준으로 겹쳐서 표시한다.   
			* foreground : 배경 설정   
			* foregroundGravity : 배경 위젯의 위치 설정   

