package com.example.adefault.connect3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    String s2 = "RED";
    int player;
    int cpu;
    int f = 0;
    int def=0;
    int first=0;
    boolean game = true;
    int a[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int c[] = {8,3,6,0,1,5,4,2,7};
    int b[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void setimg(int x)
    {

        GridLayout g1= (GridLayout) findViewById(R.id.grid1);
        if(cpu==0) {
            ImageView e1 = (ImageView) g1.getChildAt(x);
            e1.setTranslationY(-1000f);
            e1.setImageResource(R.drawable.yellow1);
            e1.animate().translationYBy(1000f).setDuration(600);
        }
        else
        {
            ImageView e2 = (ImageView) g1.getChildAt(x);
            e2.setTranslationY(-1000f);
            e2.setImageResource(R.drawable.red1);
            e2.animate().translationYBy(1000f).setDuration(600);

        }
    }

    public void dropai(View view)
    {
        ImageView img = (ImageView) view;
        int tagger = Integer.parseInt(img.getTag().toString());

        if (a[tagger] == 2 && game) {
            a[tagger] = player;
            img.setTranslationY(-1000f);
            if (player == 0) {
                img.setImageResource(R.drawable.yellow1);
            }
            else {
                img.setImageResource(R.drawable.red1);
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        // ai check
        //defense
        outerloop:
        for(int i=0;i<8;i++)
        {
            if(((a[b[i][0]]==a[b[i][1]])&&a[b[i][0]]!=2)|| ((a[b[i][0]]==a[b[i][2]])&&a[b[i][0]]!=2) || ((a[b[i][1]]== a[b[i][2]])&&a[b[i][1]]!=2))
            {

                for(int j=0;j<3;j++)
                {
                    if(a[b[i][j]]==2)
                    {

                       a[b[i][j]]=cpu;
                        for(int k=0;k<9;k++)
                        {
                            System.out.print(a[k]);

                        }
                        System.out.println();
                        setimg(c[b[i][j]]);
                        def=1;
                        break outerloop;
                    }
                    else
                    {

                        def=0;
                    }
                }

            }
            else
            {

                def=0;
            }
        }

        if(def==0)
        {
            if(first==0) {
                if (a[4] == 2) {

                    a[4] = cpu;
                    setimg(1);
                    first = 1;
                } else if (a[4] == player) {
                    first = -1;

                    if (a[0] == 2){

                        a[0]=cpu;
                        setimg(8);
                    }
                    else if(a[2]==2)
                    {
                        a[2]=cpu;
                        setimg(6);
                    }
                    else if(a[6]==2)
                    {
                        a[6]=cpu;
                        setimg(4);
                    }
                    else
                    {
                        a[8]=cpu;
                        setimg(7);
                    }
                }
            }
            else
            {
                if (a[0] == 2){
                    a[0]=cpu;
                    setimg(8);
                }
                else if(a[2]==2)
                {
                    a[2]=cpu;
                    setimg(6);
                }
                else if(a[6]==2)
                {
                    a[6]=cpu;
                    setimg(4);
                }
                else if(a[8]==2)
                {
                    a[8]=cpu;
                    setimg(7);
                }
                else
                {
                    for(int k=0;k<9;k++)
                    {
                        if(a[k]==2)
                        {
                            a[k]=cpu;
                            setimg(c[k]);
                            break;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < 8; i++) {

            if (a[b[i][0]] == a[b[i][1]] && a[b[i][1]] == a[b[i][2]] && a[b[i][0]] != 2) {
                game = false;
                TextView v = (TextView) findViewById(R.id.textView1);
                LinearLayout l = (LinearLayout) findViewById(R.id.playagain1);
                if (a[b[i][0]] == player) {
                    v.setText("You Won!");
                    l.setBackgroundColor(Color.YELLOW);
                } else {
                    v.setText("You Lost!");
                    l.setBackgroundColor(Color.RED);
                }
                l.setVisibility(view.VISIBLE);

                l.setTranslationY(-1000f);
                l.animate().translationYBy(1000f).rotation(360f).setDuration(400);
            }
        }

        System.out.print("\n");
        for (int k = 0; k < 9; k++)
        {
            if (a[k] != 2)
            {
                f++;

            }
        }

        if (f == 9) {
            game = false;
            TextView v = (TextView) findViewById(R.id.textView1);
            LinearLayout l = (LinearLayout) findViewById(R.id.playagain1);
            l.setVisibility(view.VISIBLE);
            v.setText("DRAW");
            l.setBackgroundColor(Color.GREEN);
            l.setTranslationY(-1000f);
            l.animate().translationYBy(1000f).rotation(360f).setDuration(400);
        }
        f=0;
    }

    public void playagainai(View view)
    {
        LinearLayout l = (LinearLayout) findViewById(R.id.playagain1);
        l.setVisibility(view.INVISIBLE);
        f = 0;
        def=0;
        first=0;
        game = true;
        GridLayout g1 = (GridLayout) findViewById(R.id.grid1);
        for(int i=0;i<g1.getChildCount();i++)
        {
            a[i]=2;
            ((ImageView)g1.getChildAt(i)).setImageResource(0);
        }
    }

    public void restart1(View view)
    {
        playagainai(view);
    }

    public void gomenu1(View view)
    {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String s1 = getIntent().getStringExtra("msg");
        if(s1.equals(s2))
        {
            player=1;
            cpu=0;
        }
        else
        {
            player=0;
            cpu=1;
        }
    }
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
