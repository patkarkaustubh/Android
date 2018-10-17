package com.example.kaustubhpatkar.colorfun;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {


    private Button background;
    private SeekBar red,blue,green,alpha;
    private TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background=(Button)findViewById(R.id.button);
        red=(SeekBar)findViewById(R.id.seekBar);
        blue=(SeekBar)findViewById(R.id.seekBar2);
        green=(SeekBar)findViewById(R.id.seekBar3);
        alpha=(SeekBar)findViewById(R.id.seekBar4);
        text1=(TextView)findViewById(R.id.textView3);
        text2=(TextView)findViewById(R.id.textView4);
        text3=(TextView)findViewById(R.id.textView7);
        text4=(TextView)findViewById(R.id.textView6);


        SeekBar.OnSeekBarChangeListener first= new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Background();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        SeekBar.OnSeekBarChangeListener second= new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int j, boolean b) {
                Background();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        SeekBar.OnSeekBarChangeListener third= new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int k, boolean b) {
            Background();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        SeekBar.OnSeekBarChangeListener fourth= new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean b) {
                Background();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        red.setOnSeekBarChangeListener(first);
        blue.setOnSeekBarChangeListener(second);
        green.setOnSeekBarChangeListener(third);
        alpha.setOnSeekBarChangeListener(fourth);
    }
    private void Background()
    {
        background.setBackgroundColor(Color.argb(alpha.getProgress(),red.getProgress(),green.getProgress(),blue.getProgress()));

    }
}
