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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    private Button btnMap;
    private ImageView imgLiquid, imgTablets, imgCapsule, imgInjection, imgInhalers, imgDrops;
//    private DrawerLayout mDrawerlayout;
//    private ActionBarDrawerToggle mToggle;
    private Object MenuItem;
    private SensorManager sensorManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnMap = findViewById(R.id.btnMap);
        imgLiquid = findViewById(R.id.imgLiquid);
        imgCapsule = findViewById(R.id.imgCapsule);
        imgInjection = findViewById(R.id.imgInjection);
        imgTablets = findViewById(R.id.imgTablets);
        imgDrops = findViewById(R.id.imgDrops);
        imgInhalers = findViewById(R.id.imgInhalers);



        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, GoogleMapsActivity.class);
                startActivity(intent);

            }
        });

        imgLiquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Liquid");
                startActivity(intent);

            }
        });

        imgCapsule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Capsule");
                startActivity(intent);


            }
        });

        imgInjection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Injection");
                startActivity(intent);

            }
        });

        imgTablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Tablets");
                startActivity(intent);

            }
        });

        imgDrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Drops");
                startActivity(intent);

            }
        });
        imgInhalers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MedicineDetailActivity.class);
                intent.putExtra("selectedName", "Inhalers");
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
