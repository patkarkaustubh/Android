package com.example.kaustubh.archergame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kaustubhpatkar on 11/30/17.
 */

public class Decision extends Activity {
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decision);
        t1=(TextView)findViewById(R.id.textView3);

    }

}
