package com.example.kaustubhpatkar.mywidgets;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView text1,text2,text3,text4,text5,text6;
    CheckBox chk1;
    Switch switch1;
    RadioButton rb1,rb2,rb3;
    SeekBar slider1;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView)findViewById(R.id.textView1);
        text2=(TextView)findViewById(R.id.textView2);
        chk1=(CheckBox)findViewById(R.id.checkBox);
        switch1=(Switch)findViewById(R.id.switch1);
        text2.setText("This checkbox is: unchecked");
        text3=(TextView)findViewById(R.id.textView3);
        text4=(TextView)findViewById(R.id.textView4);
        text5=(TextView)findViewById(R.id.textView5);
        text3.setText("This switch is: OFF");
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        slider1=(SeekBar)findViewById(R.id.seekBar);
        text4.setText("Radio1 Selected");
        text5.setText(String.valueOf(slider1.getProgress()));
        edit1=(EditText)findViewById(R.id.editText);
        text6=(TextView)findViewById(R.id.textView6);
        rb3.setChecked(true);
        if(switch1!=null)
        {
            switch1.setOnCheckedChangeListener(this);
        }
        if(rb1!=null)
        {
            rb1.setOnCheckedChangeListener(this);
        }
        if(rb2!=null)
        {
            rb2.setOnCheckedChangeListener(this);
        }
        if(rb3!=null)
        {
            rb3.setOnCheckedChangeListener(this);
        }
        slider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue=0;
            @Override

            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    progressValue=i;
                text5.setText(String.valueOf(progressValue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        chk1.setOnCheckedChangeListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }



    public void buttonPressed(View view)
    {
        text1.setText("Button Clicked");
    }

    public void buttonclick(View view)
    {
        text6.setText(edit1.getText());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(chk1.isChecked())
        {
            text2.setText("This checkbox is: checked");
        }
        else
        {
            text2.setText("This checkbox is: unchecked");
        }
        if(switch1.isChecked())
        {
            text3.setText("This switch is: ON");
        }
        else
        {
            text3.setText("This switch is: OFF");
        }
        switch (compoundButton.getId()){
            case R.id.radioButton:
                if(isChecked) {
                    text4.setText("Radio3 Selected");
                }
                break;
            case R.id.radioButton2:
                if(isChecked) {
                    text4.setText("Radio2 Selected");
                }
                break;
            case R.id.radioButton3:
                if(isChecked) {
                    text4.setText("Radio1 Selected");
                }
                break;
        }
    }
}
