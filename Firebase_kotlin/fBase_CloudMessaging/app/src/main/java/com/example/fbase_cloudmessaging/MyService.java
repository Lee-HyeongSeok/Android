package com.example.fbase_cloudmessaging;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyService extends FirebaseMessagingService {
    private String TAG = "msg : ";

    public void onNewToken(String token){
        Log.d(TAG, "Refreshed token : " + token);
    }
    public void onMessageReceived(RemoteMessage remoteMessage){
        if(remoteMessage.getData().size() > 0){
            Log.d(TAG, "Message data payload : " + remoteMessage.getData());
        }
        if(remoteMessage.getNotification() != null){
           Log.d(TAG, "Message Notification Body : "+ remoteMessage.getNotification().getBody());
        }
    }

}
