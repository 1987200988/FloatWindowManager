package com.yinhuidata.mytest;

import android.graphics.Canvas;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.yinhuidata.mytest.bean.MessageData;
import com.yinhuidata.mytest.yhao.floatwindow.FloatWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RingtoneManager mRingtoneManager;
    private int mOriginalVolume;
    private Uri mDefaultUri;
    public static final String TAG = "MainActivity";
    List<MessageData> list = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter;
    private RecyclerView recyclerView;
    private View inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContextManager.setContext(getApplicationContext());

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MessageData messageData1 = new MessageData();

                FloatWindowManager.getInstance().showRightTopTemperatureMsg(messageData1);



            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FloatWindowManager.getInstance().hideRightTopTemperatureMsg();
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!FloatWindow.get("one").isShowing()){
                    FloatWindow.get("one").show();
                }

                final MessageData messageData2 = new MessageData();
                messageData2.type = 1;

                FloatWindowManager.getInstance().showRightTopTemperatureMsg(messageData2);

            }
        });
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!FloatWindow.get("one").isShowing()){
                    FloatWindow.get("one").show();
                }


                MessageData messageData2 = new MessageData();
                messageData2.type = 4;
                FloatWindowManager.getInstance().showRightTopTemperatureMsg(messageData2);



            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
