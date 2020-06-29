package com.example.rayarc.programlearningapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Execution extends AppCompatActivity {

     int times = 0;
     int maxHazerd  = 100;
     int[] meirei;
     int[] forTimes;
     int [] forLine = new int[maxHazerd];
     int forfor = 0;
     private TextView textView;
     private TextView textCoin;
     int count;
     int getsCoin;
     int[] backFor = new int[maxHazerd];
     int dir = 0;
     int beforDec=0;
     private String[] siji = {
            "\n",
            "moveGo;\n",
            "moveBack;\n",
            "turnLeft;\n",
            "turnRight\n",
            "if(booleanCoin){\n",
            "getCoin;\n",
            "}else{\n",
            "for(x){\n",
            "}\n"
    };
     int[] tabWhat = new int[maxHazerd];
     int tabNow = 1;
    public synchronized void delay(long msec)
    {
        try
        {
            wait(msec);
        }catch(InterruptedException e){}
    }

    private  float miniXON = 0.18f;
    private  float miniYON = 0.06f;
    private  float maxXON = 0.7f;
    private  float maxYON = 0.455f;
    private ImageView imageView;
    private TranslateAnimation translateAnimation;
    private float syokiX = miniXON;
    private float syokiY = miniYON;
    private float moveX = miniXON;
    private float moveY = miniYON;
    private  float xmasu= (maxXON-miniXON)/2.0f;
    private  float ymasu = (maxYON-miniYON)/2.0f;
    int moveTime = 1500;
    int[] mapRobo = {0,0};
    int[] ifCount = new int[maxHazerd];
    int intif = 0;
    int[][] coinMap = { {0,1,1},
                        {0,1,0},
                        {1,0,1} };

    private void startTranslate(int sec){//前後の移動アニメーション
        if(moveX > maxXON + 0.1 || moveX < miniXON - 0.1 || moveY > maxYON + 0.1 || moveY < miniYON - 0.1){
            moveX = syokiX;
            moveY = syokiY;
            Toast.makeText(this, "ダメです",
                    Toast.LENGTH_SHORT).show();
        }else {
            translateAnimation = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, syokiX,
                    Animation.RELATIVE_TO_PARENT, moveX,
                    Animation.RELATIVE_TO_PARENT, syokiY,
                    Animation.RELATIVE_TO_PARENT, moveY);
            // animation時間 msec
            translateAnimation.setDuration(sec);
            // 繰り返し回数
            translateAnimation.setRepeatCount(0);
            // animationが終わったそのまま表示にする
            translateAnimation.setFillAfter(true);
            //アニメーションの開始
            syokiX = moveX;
            syokiY = moveY;
            imageView.startAnimation(translateAnimation);
        }
    }

    private void RotateAnimation(int sec,int go){//左右回転アニメーション
        ((ImageView)findViewById(R.id.image_view)).setRotation(beforDec-go);    // 中心回転
        beforDec = beforDec-go;
    }

    void dirMove(String goback){//前後移動座標定義
        switch (goback) {
            case "go":
                switch (dir) {
                    case 0:
                        //下に1マス
                        moveX += 0.0f;
                        moveY += ymasu;
                        if (mapRobo[0] < 2 && mapRobo[0] >= 0) {
                            mapRobo[0] = mapRobo[0] + 1;
                        }
                        break;
                    case 1:
                        //左に１マス
                        moveX -= xmasu;
                        moveY += 0.0f;
                        if (mapRobo[1] <= 2 && mapRobo[1] > 0) {
                            mapRobo[1] = mapRobo[1] - 1;
                        }
                        break;
                    case 2:
                        //上に１マス
                        moveX += 0.0f;
                        moveY -= ymasu;
                        if (mapRobo[0] <= 2 && mapRobo[0] > 0) {
                            mapRobo[0] = mapRobo[0] - 1;
                        }
                        break;
                    case 3:
                        //右に1マス
                        moveX += xmasu;
                        moveY += 0.0f;
                        if (mapRobo[1] < 2 && mapRobo[1] >= 0) {
                            mapRobo[1] = mapRobo[1] + 1;
                        }
                        break;
                }
                break;
            case "back":
                switch (dir) {
                    case 0:
                        //上に１マス
                        moveX += 0.0f;
                        moveY -= ymasu;
                        if (mapRobo[0] <= 2 && mapRobo[0] > 0) {
                            mapRobo[0] = mapRobo[0] - 1;
                        }
                        break;
                    case 1:
                        //右に１マス
                        moveX += xmasu;
                        moveY += 0.0f;
                        if (mapRobo[1] < 2 && mapRobo[1] >= 0) {
                            mapRobo[1] = mapRobo[1] + 1;
                        }
                        break;
                    case 2:
                        //下に１マス
                        moveX += 0.0f;
                        moveY += ymasu;
                        if (mapRobo[0] < 2 && mapRobo[0] >= 0) {
                            mapRobo[0] = mapRobo[0] + 1;
                        }
                        break;
                    case 3:
                        //左に1マス
                        moveX -= xmasu;
                        moveY += 0.0f;
                        if (mapRobo[1] <= 2 && mapRobo[1] > 0) {
                            mapRobo[1] = mapRobo[1] - 1;
                        }
                        break;
                }
        }
    }

    void jikkou(int s,int i){//プログラミング実行処理
        switch (meirei[i]) {
            case 0://何もなし
                Toast.makeText(this, "実行を完了しました",
                        Toast.LENGTH_SHORT).show();
                break;
            case 1://moveGo
                dirMove("go");
                startTranslate(s);
                Log.v("tag", "直進");
                break;
            case 2://moveBack
                dirMove("back");
                startTranslate(s);
                Log.v("tag", "後進");
                break;
            case 3://turnLeft
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
                RotateAnimation(s, -90);
                Log.v("tag", "左");
                break;
            case 4://turnRight
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
                RotateAnimation(s, 90);
                Log.v("tag", "右");
                break;
            case 5://if
                if (coinMap[mapRobo[0]][mapRobo[1]] == 1) {
                    tabWhat[tabNow] = 0;
                    tabNow++;
                    Log.v("tag", "コインあり");
                } else {
                    Toast.makeText(this, "コインはありません",
                            Toast.LENGTH_SHORT).show();
                    Log.v("tag", "コインなし");
                    ifCount[intif] = times;
                    intif++;
                    while (meirei[times] != 9) {
                        times++;
                    }
                    //times--;
                }
                break;
            case 6://getCoin
                if(mapRobo[1] == 0){
                    if(mapRobo[0] == 2){
                        findViewById(R.id.coin0).startAnimation(AnimationUtils.loadAnimation(this, R.anim.kieru));
                        coinMap[mapRobo[0]][mapRobo[1]] = 0;
                        getsCoin++;
                    }else {
                        Toast.makeText(this, "取得できるコインはありません",
                                Toast.LENGTH_SHORT).show();
                    }
                }else if(mapRobo[1] == 1){
                    if(mapRobo[0] == 0){
                        findViewById(R.id.coin1).startAnimation(AnimationUtils.loadAnimation(this, R.anim.kieru));
                        coinMap[mapRobo[0]][mapRobo[1]] = 0;
                        getsCoin++;
                    }else if(mapRobo[0] == 1){
                        findViewById(R.id.coin2).startAnimation(AnimationUtils.loadAnimation(this, R.anim.kieru));
                        coinMap[mapRobo[0]][mapRobo[1]] = 0;
                        getsCoin++;
                    }
                }else if(mapRobo[1] == 2){
                    if(mapRobo[0] == 0){
                        findViewById(R.id.coin3).startAnimation(AnimationUtils.loadAnimation(this, R.anim.kieru));
                        coinMap[mapRobo[0]][mapRobo[1]] = 0;
                        getsCoin++;
                    }else if(mapRobo[0] == 2){
                        findViewById(R.id.coin4).startAnimation(AnimationUtils.loadAnimation(this, R.anim.kieru));
                        coinMap[mapRobo[0]][mapRobo[1]] = 0;
                        getsCoin++;
                    }
                }
                break;
            case 7://幻のelse
                break;
            case 8://for
                forfor++;
                backFor[forfor] = forTimes[forfor];
                forLine[forfor] = times;
                tabWhat[tabNow] = 1;
                tabNow++;
                break;
            case 9://}
                if(tabWhat[tabNow-1] == 0){
                    tabNow--;
                }
                if(tabWhat[tabNow-1] == 1) {
                    if (backFor[forfor] > 0) {
                        times = forLine[forfor];
                        backFor[forfor]--;
                    } else if (backFor[forfor] == 0 && forfor > 0) {
                        forfor--;
                        tabNow--;
                    }
                }
                break;
        }
        comand();
    }

    void comand(){//命令文の表示
        StringBuilder buf = new StringBuilder();
        buf.append(String.valueOf(times + 1));
        String dot = ".";
        buf.append(dot);
        if(meirei[times] == 8){
            buf.append("for(");
            buf.append(forTimes[times+1]+1);
            buf.append(")\n");
        }
        else{
            buf.append(siji[meirei[times]]);
        }
        buf.append("map:");
        buf.append(String.valueOf(mapRobo[0]));
        buf.append(",");
        buf.append(String.valueOf(mapRobo[1]));
        String tixt = buf.toString();
        textView.setText(tixt);
        textView.setTextSize(30.0f);
        textCoin.setText(String.valueOf(getsCoin));
        textCoin.setTextSize(25.0f);
        //textView.setTextSize(15.0f);
    }

    void error(){//エラー表記
        Toast.makeText(this, "これ以上実行できるプログラムはございません",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execution);
        textView = findViewById(R.id.text_view);
        textCoin = findViewById(R.id.coingetTxt);

        Intent intent = getIntent();
        //情報受け取り
        count = intent.getIntExtra("How", 0);
        meirei = intent.getIntArrayExtra("KeyWord");
        forTimes = intent.getIntArrayExtra("times");
        times = 0;
        imageView = findViewById(R.id.image_view);
        startTranslate(moveTime);
        comand();

        Button right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(times < count) {
                    jikkou(moveTime, times);
                    times++;
                    Log.v("tag", "進む");
                }else{
                    error();
                }
            }
        });
    }
}
