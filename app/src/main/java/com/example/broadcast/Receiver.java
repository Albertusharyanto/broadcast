package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends MainActivity{
    public void onReceive (Context context,Intent intent){
        Toast.makeText(context,"Broadcast diterima",Toast.LENGTH_SHORT).show();
    }
}
