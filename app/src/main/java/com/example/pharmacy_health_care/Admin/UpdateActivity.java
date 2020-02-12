package com.example.pharmacy_health_care.Admin;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmacy_health_care.R;

import API.API;
import model.Items;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import reusable.Reusable;

public class UpdateActivity extends AppCompatActivity {

    private EditText id,etname, etprice, etdescription;
    private Button search, update, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id = findViewById(R.id.etSearchID);
        etname = findViewById(R.id.etUName);
        etprice = findViewById(R.id.etUPrice);
        etdescription = findViewById(R.id.etUdes);

        delete = findViewById(R.id.Delete);
        search = findViewById(R.id.btnSearchID);
        update = findViewById(R.id.Update);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem();
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchItem();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });


    }

    private void deleteItem() {
        API api = Reusable.getInstance().create(API.class);
        Call<Void> voidCall = api.deleteItem(Integer.parseInt(id.getText().toString()));
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateActivity.this, "successfully deleted" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "error:" +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void SearchItem() {




        API api  = Reusable.getInstance().create(API.class);
        Call<Items> ListCall = api.getItemById(Integer.parseInt(id.getText().toString()));
        ListCall.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {


                etname.setText(response.body().getName());
                etprice.setText(Double.toString(response.body().getPrice()));
                etdescription.setText(response.body().getDescription());

            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "error:" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }



    private void updateItem() {

        API api = Reusable.getInstance().create(API.class);


        Call<Void> listcall = api.updateItem(Integer.parseInt(id.getText().toString()),etname.getText().toString(),etdescription.getText().toString());
        listcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateActivity.this, "update successfully", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Error:" +t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
