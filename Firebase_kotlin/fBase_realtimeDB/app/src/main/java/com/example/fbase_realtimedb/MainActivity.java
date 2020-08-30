package com.example.fbase_realtimedb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    Button wBtn, rBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wBtn = (Button)findViewById(R.id.writeBtn);
        rBtn = (Button)findViewById(R.id.readBtn);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        wBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //signIn();
                //MakeData();
                MakeData2();
            }
        });
        rBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
    public void onStart(){
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            onAuthSuccess(mAuth.getCurrentUser());
        }
    }
    private void signIn(){
        String email = "kea7111@gmail.com";
        String password = "jjhh0515";

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            onAuthSuccess(task.getResult().getUser());
                            Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void onAuthSuccess(FirebaseUser user){
        String username = usernameFromEmail(user.getEmail());
        writeNewUser(user.getUid(), username, user.getEmail());
    }
    private String usernameFromEmail(String email){
        if(email.contains("@")){
            return email.split("@")[0];
        }
        else{
            return email;
        }
    }
    private void writeNewUser(String userID, String name, String email){
        User user = new User(name, email);
        mDatabase.child("users").child(userID).setValue(user);
    }

    public class User{
        public String username;
        public String email;

        public User(){

        }
        public User(String username, String email){
            this.username = username;
            this.email = email;
        }
    }
    public void MakeData(){
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("posts");
        String key = mDatabase.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("uid", "aloverlace");
        postValues.put("author", "Ada Lovelace");
        postValues.put("title", "hello post");
        postValues.put("body", "hello body");
        postValues.put("startCount", 0);

        mDatabase.child(key).setValue(postValues);
    }
    public void MakeData2(){
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database1.getReference("post1");
        String key = myRef.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("name", "holly");
        postValues.put("number", "3333-3333");
        postValues.put("title", "king");
        myRef.child(key).setValue(postValues);
    }
    public void transaction1(){
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database1.getReference("posts/-MCBMuFChVbpsG6bfgR0");
        myRef.runTransaction(new Transaction.Handler(){

            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                Long startCount = currentData.child("startCount").getValue(Long.class);
                startCount++;
                currentData.child("startCount").setValue(startCount);
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
