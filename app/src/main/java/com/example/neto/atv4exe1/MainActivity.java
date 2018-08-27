package com.example.neto.atv4exe1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private Button btnProcessar;
    //private Handler handler = new Handler();
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_status);
        btnProcessar = findViewById(R.id.btn_processar);

        myHandler = new MyHandler(textView,btnProcessar);
    }

    private void executarAlgoDemorado(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                /*
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Processamento Finalizado");
                        btnProcessar.setEnabled(true);
                    }
                });
                */
                /*
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Processamento Finalizado");
                        btnProcessar.setEnabled(true);
                    }
                });
                */

                for(int i=10;i>=-1;i--) {
                    Message msg = Message.obtain();
                    msg.what = 100;
                    msg.obj=i;
                    myHandler.sendMessage(msg);
                    SystemClock.sleep(1000);
                    }
                btnProcessar.setEnabled(true);
            }
        }).start();

    }

    public void iniciar(View view) {

        btnProcessar.setEnabled(false);
        System.out.println("OPA");
        this.executarAlgoDemorado();

    }
}
