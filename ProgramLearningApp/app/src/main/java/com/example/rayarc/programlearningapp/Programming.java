package com.example.rayarc.programlearningapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Programming extends AppCompatActivity {

    private int maxHazurd = 22;

    int count = 0;
    int now = count;
    int[] tab = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int ifCo;
    int forTimes;
    boolean elseSig = false;
    int[] meirei = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] kakkoNum = new int[maxHazurd];
    int kakko = 0;
    int[] backKakko = new int[maxHazurd];
    int back = 0;
    int[] forWhat = new int[maxHazurd];
    int forfor = 0;

    private String[] comand = {
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

    private TextView textView;

    public static final String KeyWord
//            = "com.example.testactivitytrasdata.MESSAGE";
            = "program";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);
        textView = findViewById(R.id.text_view);
    }

    // クリック処理
    public void return1( View v){
        Intent intent = new Intent(this,MainActivity.class); // 画面指定
        startActivity(intent);                          //  画面を開く
    }

    void henkanHyouji(int num) {
        int f=1;
        if (count < maxHazurd) {
            meirei[count] = num;
            if (count > 0) {
                tab[count + 1] = tab[count];
            }
            count++;
            now = count;
            int i;
            StringBuilder buf = new StringBuilder();
            for (i = 0; i < count; i++) {
                if (i < 9) {
                    String space = "  ";
                    buf.append(space);
                }
                String valueToString = String.valueOf(i + 1);
                buf.append(valueToString);
                String dot = ".";
                buf.append(dot);
                String tab4 = "    ";
                if (tab[i] > 0) {
                    int t;
                    for (t = 0; t < tab[i]; t++) {
                        buf.append(tab4);
                    }
                }
                if (meirei[i] == 8) {
                    String for1 = "for(";
                    buf.append(for1);
                    buf.append(String.valueOf(forWhat[f]+1));
                    f++;
                    String for2 = "){\n";
                    buf.append(for2);
                } else {
                    buf.append(comand[meirei[i]]);
                }
            }
            String tixt = buf.toString();
            textView.setText(tixt);
        } else {
            Toast.makeText(this, "容量が限界です",
                    Toast.LENGTH_SHORT).show();
        }
    }

    void hyoujiGyou(){
        Toast.makeText(this, "指定した行は無効です",
                Toast.LENGTH_SHORT).show();
    }

    // moeveGoメソッド
    public void moveGo(View view){
        //String meirei = "moveGo;\n";
        int meireiNum = 1;
        henkanHyouji(meireiNum);
    }

    // moeveBackメソッド
    public void moveBack(View view){
        //String meirei = "moveBack;\n";
        int meireiNum = 2;
        henkanHyouji(meireiNum);
    }

    // turnLeftメソッド
    public void turnLeft(View view){
        //String meirei = "turnLeft;\n";
        int meireiNum = 3;
        henkanHyouji(meireiNum);
    }

    // turnRigntメソッド
    public void turnRight(View view){
        //String meirei = "turnRight;\n";
        int meireiNum = 4;
        henkanHyouji(meireiNum);
    }

    // booleanCoinメソッド
    public void booleanCoin(View view){
        //String meirei = "if(booleanCoin){\n";
        int meireiNum = 5;
        henkanHyouji(meireiNum);
        tab[count] = tab[count]+1;
        ifCo++;
        kakkoNum[kakko] = meireiNum;
        kakko++;
    }

    // getCoinメソッド
    public void getCoin(View view){
        //String meirei = "getCoin;\n";
        int meireiNum = 6;
        henkanHyouji(meireiNum);
    }

    // forCメソッド
    public void forC(View view){
        final String[] items = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        new AlertDialog.Builder(this)
                .setTitle("繰り返す回数")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        forTimes = which + 1;
                        forfor++;
                        //forMeirei = true;
                        //String meirei = "for\n";
                        int meireiNum = 8;
                        forWhat[forfor] = which ;
                        henkanHyouji(meireiNum);
                        tab[count] = tab[count]+1;
                        kakkoNum[kakko] = meireiNum;

                        kakko++;
                    }
                })
                .show();
    }

    //tojiメソッド
    public void toji(View view){
        if(tab[count] > 0 & kakko > 0){
            tab[count] = tab[count]-1;
            ifCo--;
            elseSig = false;
            //String meirei = "}\n";
            int meireiNum = 9;
            henkanHyouji(meireiNum);
            backKakko[back] = kakkoNum[kakko-1];
            back++;
            kakko--;
        }else{
            Toast.makeText(this, "有効になっているif文、もしくはfor文がないので使用できません",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // jikkouメソッド
    public void jikkou(View view){
        if(count > 0 && tab[count] == 0) {
            Toast.makeText(this, "プログラムを実行します",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Execution.class); // 画面指定
            //情報受け渡し
            intent.putExtra("How", count);
            intent.putExtra("KeyWord", meirei);
            intent.putExtra("times",forWhat);
            //画面を開く
            startActivity(intent);
        }else if(tab[count] != 0){
            Toast.makeText(this, "「}」が足りません",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "プログラムを作ってください",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // delメソッド
    public void del(View view){
        if(count > 0) {
            if (meirei[count - 1] == 7) {
                tab[count - 1] = tab[count];
                ifCo++;
                kakkoNum[kakko] = backKakko[back];
                back--;
                kakko++;
                elseSig = false;
            } else if (meirei[count - 1] == 9) {
                tab[count - 1] = tab[count - 2];
                ifCo++;
                elseSig = true;
                kakkoNum[kakko] = backKakko[back];
                back--;
                kakko++;
            }else if(meirei[count - 1 ] == 8){
                forfor--;
            }
            meirei[count] = 0;
            tab[count] = tab[count - 1];
            count--;
            int i;
            StringBuilder buf = new StringBuilder();
            for (i = 0; i < count; i++) {
                if (i < 9) {
                    String space = "  ";
                    buf.append(space);
                }
                String valueToString = String.valueOf(i + 1);
                buf.append(valueToString);
                String dot = ".";
                buf.append(dot);
                String tab4 = "    ";
                if (tab[i] > 0) {
                    int t;
                    for (t = 0; t < tab[i]; t++) {
                        buf.append(tab4);
                    }
                }
                if (meirei[i] == 8) {
                    String for1 = "for(";
                    buf.append(for1);
                    buf.append(String.valueOf(forTimes));
                    String for2 = "){\n";
                    buf.append(for2);
                } else {
                    buf.append(comand[meirei[i]]);
                }
            }
            String tixt = buf.toString();
            textView.setText(tixt);
        }else{
            Toast.makeText(this, "消せるプログラムがないです",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
