package com.example.ankita.rentalproperty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button AptFinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AptFinder = (Button) findViewById(R.id.button);
        AptFinder.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ApartmentFinder.class));
            }
        });

    }
}
