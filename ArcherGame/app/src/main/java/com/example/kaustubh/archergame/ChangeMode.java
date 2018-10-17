package com.example.kaustubh.archergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by kaustubhpatkar on 11/24/17.
 */

public class ChangeMode extends Activity {

       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changemode);

    }
    public void onClickEasy(View view)

    {
        Intent intent = new Intent(ChangeMode.this,SpriteSheetAnimation.class);
        startActivity(intent);


    }
    public void onClickMedium(View view)
    {
        Intent intent = new Intent(ChangeMode.this,MediumMode.class);
        startActivity(intent);
    }
}
