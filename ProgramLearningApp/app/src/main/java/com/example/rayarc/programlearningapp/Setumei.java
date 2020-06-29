package com.example.rayarc.programlearningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Setumei extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setumei);
    }
    // クリック処理
    public void setumei0( View v){
        Intent intent = new Intent(this,Setumei0.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }

    // クリック処理
    public void setumei2( View v){
        Intent intent = new Intent(this,Setumei2.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }
}
