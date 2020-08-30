package com.example.fbase_cloudmessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {
    Button Btn, LogBtn, wBtn, infoBtn;
    TextView tView;
    String TAG = "cloud msg : ";
    String u_email=null, u_pass=null;
    String token=null;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn = (Button)findViewById(R.id.Btn);
        LogBtn = (Button)findViewById(R.id.LogBtn);
        wBtn = (Button)findViewById(R.id.write_Btn);
        infoBtn = (Button)findViewById(R.id.info_Btn);
        tView = (TextView)findViewById(R.id.tView);
        mAuth = FirebaseAuth.getInstance();

        // DB에서 사용자 아이디, 비밀번호 가져오기
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("user");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                u_email = snapshot.child("email").getValue(String.class);
                u_pass = snapshot.child("pass").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // 현재 기기 토큰 TextView에 출력
        Btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if(!task.isSuccessful()){
                                    Log.w(TAG, "getInstanceID failed", task.getException());
                                    return;
                                }
                                token = task.getResult().getToken();
                                tView.setText("현 기기 토큰 : " + token);
                                String msg = "FCM token : " + token;
                                Log.d(TAG, msg);
                            }
                        });
            }
        });
        // 로그인
        LogBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Login(u_email, u_pass);
            }
        });

        // 토큰 DB에 쓰기
        wBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("user");
                myRef.child("token").setValue(token);
            }
        });

    }

    // 로그인 메소드
    public void Login(String e, String p){
        mAuth.signInWithEmailAndPassword(e, p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Login success",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Login Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
