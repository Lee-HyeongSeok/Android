## * 자동완성, 멀티 자동완성 텍스트 뷰   
#### * 사용환경 : Android Studio   

#### * 자동 완성 텍스트 뷰   
			* 글자 일부를 입력하면 자동 완성 기능   
			* completion Threshold 속성 : 몇 글자 부터 자동완성 시킬지 정하는 속성   
			* 단어에 해당하는 문자열을 연결할 adapter 설정이 필요하다.   
			* completionHint : 자동완성 창에 나타낼 힌트   
			* hint : 텍스트 창에 나타낼 힌트   

```xml
// 위젯 선언 방법   

 <AutoCompleteTextView
        android:id="@+id/autoText1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:completionThreshold="2"
        android:completionHint="selection"
        android:hint="자동완성 텍스트 뷰"/>
```   

```java
// 어댑터 설정을 위한 string array 선언 
 String[] items = {"cafe-Vincent", "cafe_Paris", "cafe_LA", "University-sh",
    "Uv-as", "Uv-ic"};
// 어댑터 설정 
ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line, items);

// 자동 완성 텍스트 뷰 객체 선언과 동시에 뷰에서 불러온다.
AutoCompleteTextView auto = (AutoCompleteTextView)findViewById(R.id.autoText1);

// 자동완성 기능에 사용할 adapter 리스트 설정  
auto.setAdapter(adapter);
```   

#### * 멀티 자동완성 텍스트 뷰   
			* 쉼표로 구분하여 여러 단어 자동완성   
			* completion threshold 속성 : 몇 글자부터 자동완성 시킬지 설정   
			* tokenizer : 특정 기호를 기준으로 단어를 구현한다.   
			* 단어에 해당하는 문자열을 연결할 Adapter 설정이 필요하다.   
			* completionHint : 자동완성 창에 나타낼 힌트 텍스트 지정   
			* hint : 텍스트 뷰에 나타낼 텍스트 지정   

```xml
 <MultiAutoCompleteTextView
        android:id="@+id/multiText1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="멀티 자동완선 텍스트 뷰"
        android:completionHint="selection"
        android:completionThreshold="2"
        />
```   

```java
MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)findViewById(R.id.multiText1);
 // tocknizer를 설정해야함, 콤마를 기준으로 토큰을 만든다.
MultiAutoCompleteTextView.CommaTokenizer tocken = new MultiAutoCompleteTextView.CommaTokenizer();
multi.setAdapter(adapter);
// 각 토큰에 대해서는 어댑터가 제공하는 string array 값과 비교해서
// 자동완성 기능을 해줄 수 있는 리스트를 뽑아서 사용자에게 보여준다.
multi.setTokenizer(tocken);
```