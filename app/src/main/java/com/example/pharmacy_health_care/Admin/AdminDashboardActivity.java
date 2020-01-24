package com.example.pharmacy_health_care.Admin;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmacy_health_care.AddItemActivity;
import com.example.pharmacy_health_care.LoginActivity;
import com.example.pharmacy_health_care.MainActivity;
import com.example.pharmacy_health_care.R;

public class AdminDashboardActivity extends AppCompatActivity {

  private Button add, update, viewall, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

            add=findViewById(R.id.Addbutton);
            update = findViewById(R.id.updateButton);
            viewall = findViewById(R.id.viewItemButton);

            logout = findViewById(R.id.logoutButton);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminDashboardActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminDashboardActivity.this, AddItemActivity.class);
                    startActivity(intent);
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminDashboardActivity.this, UpdateActivity.class);
                    startActivity(intent);
                }
            });

            viewall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminDashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });


    }
}
