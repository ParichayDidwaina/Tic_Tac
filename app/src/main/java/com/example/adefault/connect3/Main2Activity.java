package com.example.adefault.connect3;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {


    public void play(View view)
    {
        Intent i = new Intent(this,Main4Activity.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_i,R.anim.left_out);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
