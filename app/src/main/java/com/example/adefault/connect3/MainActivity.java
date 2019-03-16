package com.example.adefault.connect3;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.adefault.connect3.R.styleable.DrawerArrowToggle_arrowShaftLength;
import static com.example.adefault.connect3.R.styleable.TextAppearance;
import static com.example.adefault.connect3.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    // 0 yellow , 1 red
    int ap = 0;
    int f = 0;

    boolean game = true;
    int a[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int b[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void dropin(View view) {
        ImageView img = (ImageView) view;
        int tagger = Integer.parseInt(img.getTag().toString());

        if (a[tagger] == 2 && game) {
            a[tagger] = ap;
            img.setTranslationY(-1000f);
            if (ap == 0) {
                img.setImageResource(R.drawable.yellow1);
                ap = 1;
            } else {
                img.setImageResource(R.drawable.red1);
                ap = 0;
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int i = 0; i < 8; i++) {

            if (a[b[i][0]] == a[b[i][1]] && a[b[i][1]] == a[b[i][2]] && a[b[i][0]] != 2) {
                game = false;
                TextView v = (TextView) findViewById(R.id.textView);
                LinearLayout l = (LinearLayout) findViewById(R.id.playagain);
                if (a[b[i][0]] == 0) {
                    v.setText("Yellow Won!");
                    l.setBackgroundColor(Color.YELLOW);
                } else {
                    v.setText("Red Won!");
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
            TextView v = (TextView) findViewById(R.id.textView);
            LinearLayout l = (LinearLayout) findViewById(R.id.playagain);
            l.setVisibility(view.VISIBLE);
            v.setText("DRAW");
            l.setBackgroundColor(Color.GREEN);
            l.setTranslationY(-1000f);
            l.animate().translationYBy(1000f).rotation(360f).setDuration(400);
        }
        f=0;
    }

    public void playagainfun(View view) {
        LinearLayout l = (LinearLayout) findViewById(R.id.playagain);
        l.setVisibility(view.INVISIBLE);
        ap = 0;
        f = 0;

        game = true;
        for (int i = 0; i < 9; i++) {
            a[i] = 2;
        }

        GridLayout g = (GridLayout) findViewById(R.id.grid);
        for (int i = 0; i < g.getChildCount(); i++) {
            ((ImageView) g.getChildAt(i)).setImageResource(0);
        }

    }

    public void restart(View view)
    {
        playagainfun(view);
    }

    public void gomenu(View view)
    {
        Intent j = new Intent(this,Main2Activity.class);
        startActivity(j);
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}

