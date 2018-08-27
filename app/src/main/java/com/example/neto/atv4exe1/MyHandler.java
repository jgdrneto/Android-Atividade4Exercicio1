package com.example.neto.atv4exe1;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class MyHandler extends Handler {

    private TextView textView;
    private Button button;

    public MyHandler(TextView nTextView, Button nButton){
        this.button = nButton;
        this.textView = nTextView;
    }

    @Override
    public void handleMessage(Message msg) {
        if(msg.what==100){

            if(!msg.obj.toString().equals("-1")) {
                textView.setText(msg.obj.toString());
            }else{
                textView.setText("10");
                button.setEnabled(true);
            }
        }
    }
}
