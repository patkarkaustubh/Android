package com.example.kaustubh.archergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView);
    }
    void onClickStart(View view)
    {
        Intent intent= new Intent(MainActivity.this,ChangeMode.class);
        startActivity(intent);

    }
    void OnclickExit(View view)
    {
        finish();
    }
}
