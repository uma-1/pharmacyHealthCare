package com.example.pharmacy_health_care;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    private ImageView imgSamsung, imgIphone, imgColor, imgCarbon, imgHawei, imgMarco;
//    private DrawerLayout mDrawerlayout;
//    private ActionBarDrawerToggle mToggle;
    private Object MenuItem;
    private SensorManager sensorManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imgSamsung = findViewById(R.id.imgSamsung);
        imgCarbon = findViewById(R.id.imgColor);
        imgColor = findViewById(R.id.imgColor);
        imgIphone = findViewById(R.id.imgIphone);
        imgHawei = findViewById(R.id.imgHawaei);
        imgMarco = findViewById(R.id.imgColor);



        imgSamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Samsung");
                startActivity(intent);

            }
        });

        imgCarbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Carbon");
                startActivity(intent);


            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Color");
                startActivity(intent);

            }
        });

        imgIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Iphone");
                startActivity(intent);

            }
        });

        imgMarco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Lenovo");
                startActivity(intent);

            }
        });
        imgHawei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MobileDetailActivity.class);
                intent.putExtra("selectedName", "Huawei");
                startActivity(intent);

            }
        });


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                if (values[1] > 0){

                    Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if (sensor != null) {
            sensorManager.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "No Sensor Found", Toast.LENGTH_SHORT).show();
        }


//        mDrawerlayout = (DrawerLayout)findViewById(R.id.drawer);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
//        mDrawerlayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.search) {

            Intent navHome = new Intent(this, SearchActivity.class);
            this.startActivity(navHome);
            return true;
        }

        if (id ==R.id.logout){
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
