package com.example.pharmacy_health_care;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class ItemDetailActivity extends AppCompatActivity {

    ImageView imageprofile;
    TextView tvname, tvprice, tvmodule, tvsize, tvram, tvrom, tvos, tvfcamera, tvbcamera;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        imageprofile = findViewById(R.id.imgProfile);
        tvname= findViewById(R.id.tvName);
        tvprice= findViewById(R.id.tvPrice);
        tvmodule= findViewById(R.id.tvModule);
        tvsize= findViewById(R.id.tvSize);
        tvram= findViewById(R.id.tvRam);
        tvrom= findViewById(R.id.tvRom);
        tvos = findViewById(R.id.tvOs);
        tvfcamera= findViewById(R.id.tvFcamera);
        tvbcamera= findViewById(R.id.tvBcamera);
        order = findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Commons.showNotification(getApplicationContext(),"Order info","Yu have sucessfully ordered this product.");
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            try {

                URL url = new URL(bundle.getString("image"));
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageprofile.setImageBitmap(bmp);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            tvname.setText(bundle.getString("name"));
            tvprice.setText(bundle.getString("price"));
            tvmodule.setText(bundle.getString("module"));
            tvsize.setText(bundle.getString("size"));
            tvram.setText(bundle.getString("ram"));
            tvrom.setText(bundle.getString("rom"));
            tvos.setText(bundle.getString("os"));
            tvfcamera.setText(bundle.getString("fcamera"));
            tvbcamera.setText(bundle.getString("bcamera"));
        }
    }
}
