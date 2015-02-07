package com.jackmiddlebrook.modernartui;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    SeekBar colorControl;
    TextView block3_1;
    TextView block3_2;
    TextView block5;
    TextView block6;
    TextView block7_1;
    TextView block7_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block3_1 = (TextView) findViewById(R.id.block3_1);
        block3_2 = (TextView) findViewById(R.id.block3_2);
        block5 = (TextView) findViewById(R.id.block5);
        block6 = (TextView) findViewById(R.id.block6);
        block7_1 = (TextView) findViewById(R.id.block7_1);
        block7_2 = (TextView) findViewById(R.id.block7_2);

        colorControl = (SeekBar) findViewById(R.id.seekBar);

        colorControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                updateBackgrounds(progress*2);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void updateBackgrounds(int progress) {

        float[] hsvBlock3 = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.block3), hsvBlock3);

        float hue3 = (hsvBlock3[0] + progress) % 360;
        hsvBlock3[0] = hue3;
        int newBlock3 = Color.HSVToColor(hsvBlock3);
        block3_1.setBackgroundColor(newBlock3);
        block3_2.setBackgroundColor(newBlock3);

        float[] hsvBlock5 = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.block5), hsvBlock5);

        float hue5 = (hsvBlock5[0] + progress) % 360;
        hsvBlock5[0] = hue5;
        int newBlock5 = Color.HSVToColor(hsvBlock5);
        block5.setBackgroundColor(newBlock5);

        float[] hsvBlock6 = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.block6), hsvBlock6);

        float hue6 = (hsvBlock6[0] + progress) % 360;
        hsvBlock6[0] = hue6;
        int newBlock6 = Color.HSVToColor(hsvBlock6);
        block6.setBackgroundColor(newBlock6);

        float[] hsvBlock7 = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.block7), hsvBlock7);

        float hue7 = (hsvBlock7[0] + progress) % 360;
        hsvBlock7[0] = hue7;
        int newBlock7 = Color.HSVToColor(hsvBlock7);
        block7_1.setBackgroundColor(newBlock7);
        block7_2.setBackgroundColor(newBlock7);
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
        if (id == R.id.more_information) {
            DialogFragment dialog = new MoreInfoAlertDialog();
            dialog.show(getFragmentManager(), "more_info");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
