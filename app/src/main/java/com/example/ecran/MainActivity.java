package com.example.ecran;



import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecran.MyViews.Termometro;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Termometro t;
    SensorManager manager;
    private Sensor temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.temp = this.manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        this.manager.registerListener(this,temp,SensorManager.SENSOR_DELAY_NORMAL);
        t = new Termometro(this,100);
        setContentView(t);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        t.setValini((int) sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}