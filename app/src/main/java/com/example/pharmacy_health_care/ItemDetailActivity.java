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
    TextView tvname, tvprice, tvDes;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        imageprofile = findViewById(R.id.imgProfile);
        tvname= findViewById(R.id.tvName);
        tvprice= findViewById(R.id.tvPrice);
        tvDes= findViewById(R.id.tvDes);
        order = findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Commons.showNotification(getApplicationContext(),"Order info","You have sucessfully ordered this product.");
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
            tvDes.setText(bundle.getString("Des"));
        }
    }
}
