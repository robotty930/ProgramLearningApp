package com.example.rayarc.programlearningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Setumei2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setumei2);
    }
    // クリック処理
    public void programmingGo( View v){
        Intent intent = new Intent(this,Programming.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }

    // クリック処理
    public void setumeiX( View v){
        Intent intent = new Intent(this,Setumei.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }
}
