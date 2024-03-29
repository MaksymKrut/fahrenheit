package com.softalp.converter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MyActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {
    TextView celcOutputField;
    SeekBar degreeBar, degreeBarVertical;
    TextView fahrOutputField;
    int celsValue, fahrValue; //1-100


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        celcOutputField = (TextView) findViewById(R.id.celsValueField);
        fahrOutputField = (TextView) findViewById(R.id.fahrValueField);
        degreeBar = (SeekBar) findViewById(R.id.degreeSeekBar); // (0, 1, -40, 60)
        degreeBar.setProgress(0);
        degreeBar.incrementProgressBy(1);
        degreeBar.setMax(100);
        degreeBar.setOnSeekBarChangeListener(this);
    }

    private void setValueToFieldFunction () {
        celsValue = (degreeBar.getProgress() -40);
        fahrValue = celsValue*9/5 + 32; // 9/5 x C + 32
        celcOutputField.setText(String.valueOf(celsValue));
        fahrOutputField.setText(String.valueOf(fahrValue));
    }

    @Override
    public void onProgressChanged(SeekBar degreeBar, int degreeValue, boolean fromUser) {
        setValueToFieldFunction();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
