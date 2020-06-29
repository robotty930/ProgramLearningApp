package com.example.rayarc.programlearningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // クリック処理
    public void programming( View v){
        Intent intent = new Intent(this,Programming.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }

    // クリック処理
    public void execution( View v){
        Intent intent = new Intent(this,Setumei0.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }
}
