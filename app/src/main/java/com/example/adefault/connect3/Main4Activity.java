package com.example.adefault.connect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    public void multip(View view)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_i,R.anim.left_out);
    }

    public void singlepl(View view)
    {
        Intent j = new Intent(this,selector.class);
        startActivity(j);
        overridePendingTransition(R.anim.right_i,R.anim.left_out);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
