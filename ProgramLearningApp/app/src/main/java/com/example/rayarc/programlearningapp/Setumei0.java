package com.example.rayarc.programlearningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Setumei0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setumei0);
    }

    // クリック処理
    public void manue( View v){
        Intent intent = new Intent(this,MainActivity.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }

    // クリック処理
    public void setumei( View v){
    Intent intent = new Intent(this,Setumei.class); // 画面指定
    startActivity(intent);                          //  画面を開く
}
}
