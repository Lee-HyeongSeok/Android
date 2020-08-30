package com.example.fbase_remotemessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MainActivity extends AppCompatActivity {

    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    //private FirebaseAuth mAuth;
    Button LogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        LogButton = (Button)findViewById(R.id.LBtn);
        mAuth = FirebaseAuth.getInstance();

         */
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);

        Button fBtn = (Button)findViewById(R.id.fBtn);
        fBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onFetchButton(v);
            }
        });
        LogButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
    public void onFetchButton(View v){
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if(task.isSuccessful()){
                            boolean updated = task.getResult();
                            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                        }
                        displayconfig();
                    }
                });
    }
    private void displayconfig(){
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        TextView tv2 = (TextView)findViewById(R.id.tv2);
        String str=null;
        boolean cheat_enabled = mFirebaseRemoteConfig.getBoolean("cheat_enabled");
        tv1.setText("cheat_enabled");
        long price = mFirebaseRemoteConfig.getLong("your_price");
        tv2.setText("price");
    }
}
