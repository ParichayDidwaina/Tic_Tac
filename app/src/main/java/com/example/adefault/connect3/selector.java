package com.example.adefault.connect3;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class selector extends AppCompatActivity {

    public void selection(View view)
    {
        ImageView e1 = (ImageView) findViewById(R.id.imageView14);
        ImageView e2 = (ImageView) findViewById(R.id.imageView13);
        ImageView e3 = (ImageView) findViewById(R.id.imageView12);
        TextView t = (TextView) findViewById(R.id.textView3);
        if(e2.getAlpha()==0)
        {
            e2.setAlpha(1f);
            e2.setVisibility(view.VISIBLE);
            e1.setAlpha(0f);
            e1.setVisibility(view.INVISIBLE);
            e3.setImageResource(R.drawable.yellow1);
            t.setText("YELLOW");

        }
        else if(e1.getAlpha()==0)
        {
            e1.setAlpha(1f);
            e1.setVisibility(view.VISIBLE);
            e2.setAlpha(0f);
            e2.setVisibility(view.INVISIBLE);
            e3.setImageResource(R.drawable.red1);
            t.setText("RED");
        }

    }

    public void selected(View view)
    {
        Intent k = new Intent(this,Main3Activity.class);
        TextView t = (TextView) findViewById(R.id.textView3);
        String s = t.getText().toString();
        k.putExtra("msg",s);
        startActivity(k);
        overridePendingTransition(R.anim.right_i,R.anim.left_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
