package com.example.gome.myfragmentbestpractics;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

/*    public static void startAction(Context context, String newsTitle, String newsContent){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_BOOT_COMPLETED);
        intent.setAction(Intent.ACTION_MANAGE_NETWORK_USAGE);
        sendBroadcast(intent);
    }


}
