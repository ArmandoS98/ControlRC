package aesc.dev.controlrc;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity /*implements SensorEventListener */ {

    /**
     * Constants for sensors
     */
    /*private long last_update = 0, last_movement = 0;
    private float prevX = 0, prevY = 0, prevZ = 0;
    private float curX = 0, curY = 0, curZ = 0;

    /**
     * The sounds to play when a pattern is detected
     */
    /*private static MediaPlayer soundAcc;
    private static MediaPlayer soundGyro;

    /**
     * Sensors
     */
    /*private SensorManager mSensorManager;
    private Sensor mSensorAcc;
    private Sensor mSensorGyr;
    private long mShakeTime = 0;
    private long mRotationTime = 0;

    /**
     * UI
     */
    private TextView mGyrox;
    private TextView mGyroy;
    private TextView mGyroz;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private SensorEventListener mSensorEventListener;

    private int bandera = 0;
    private int bandera1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (mSensor == null)
            finish();

        mSensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0]; // EJE X
                float y = event.values[1]; // EJE Y
                float z = event.values[2]; // EJE Z

                //DERECHA - IZQUIERDA
                if (x < -5) {
                    Toast.makeText(MainActivity.this, "Derecha", Toast.LENGTH_SHORT).show();
                } else if (x > 5) {
                    Toast.makeText(MainActivity.this, "Izquierda", Toast.LENGTH_SHORT).show();
                }

                // ARRIBA ABAJO
                if (z < -5) {
                    Toast.makeText(MainActivity.this, "ATRAS", Toast.LENGTH_SHORT).show();
                } else if (z > 5) {
                    Toast.makeText(MainActivity.this, "ADELANTE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        start();

        mGyrox = (TextView) findViewById(R.id.gyro_x);
        mGyroy = (TextView) findViewById(R.id.gyro_y);
        mGyroz = (TextView) findViewById(R.id.gyro_z);

    }

    private void start() {
        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop() {
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    /*public boolean checkSensorAvailability(int sensorType) {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(sensorType) != null) {
            Toast.makeText(this, "Positivo", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Negativo", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            sm.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onStop() {
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (this) {
            long current_time = event.timestamp;

            curX = event.values[0];
            curY = event.values[1];
            curZ = event.values[2];

            if (prevX == 0 && prevY == 0 && prevZ == 0) {
                last_update = current_time;
                last_movement = current_time;
                prevX = curX;
                prevY = curY;
                prevZ = curZ;
            }

            long time_difference = current_time - last_update;
            if (time_difference > 0) {
                float movement = Math.abs((curX + curY + curZ) - (prevX - prevY - prevZ)) / time_difference;
                int limit = 1500;
                float min_movement = 1E-6f;
                if (movement > min_movement) {
                    if (current_time - last_movement >= limit) {
                        Toast.makeText(getApplicationContext(), "Hay movimiento de " + movement, Toast.LENGTH_SHORT).show();
                    }
                    last_movement = current_time;
                }
                prevX = curX;
                prevY = curY;
                prevZ = curZ;
                last_update = current_time;
            }


            ((TextView) findViewById(R.id.gyro_x)).setText("Aceler—metro X: " + curX);
            ((TextView) findViewById(R.id.gyro_y)).setText("Aceler—metro Y: " + curY);
            ((TextView) findViewById(R.id.gyro_z)).setText("Aceler—metro Z: " + curZ);
        }

    }*/
}
