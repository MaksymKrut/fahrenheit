package com.kribel.fahrenheit;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

    TextView celcOutputField;
    SeekBar degreeBar, degreeBarVertical;
    TextView fahrOutputField;
    int celsValue, fahrValue; //1-100


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
