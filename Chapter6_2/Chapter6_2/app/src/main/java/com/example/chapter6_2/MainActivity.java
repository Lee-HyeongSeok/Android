package com.example.chapter6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    String[] items = {"cafe-Vincent", "cafe_Paris", "cafe_LA", "University-sh",
    "Uv-as", "Uv-ic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView auto = (AutoCompleteTextView)findViewById(R.id.autoText1);

        // 어댑터는 동일하게 사용
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)findViewById(R.id.multiText1);
        // tocknizer를 설정해야함, 콤마를 기준으로 토큰을 만든다.
        MultiAutoCompleteTextView.CommaTokenizer tocken = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setAdapter(adapter);
        // 각 토큰에 대해서는 어댑터가 제공하는 string array 값과 비교해서
        // 자동완성 기능을 해줄 수 있는 리스트를 뽑아서 사용자에게 보여준다.
        multi.setTokenizer(tocken);
    }
}
