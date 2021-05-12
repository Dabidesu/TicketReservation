package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class Screen_Trip extends AppCompatActivity {

    //, , , ;
    TextView detailsDestination;
    TextView detailsDepTime;
    TextView detailsDepBay;
    TextView detailsSeatNo;
    TextView detailsUUID;
    Button homeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_trip);

        detailsDestination = (TextView) findViewById(R.id.tv1);
        detailsDepTime = (TextView) findViewById(R.id.tv2);
        detailsDepBay = (TextView) findViewById(R.id.tv3);
        detailsSeatNo = (TextView) findViewById(R.id.tv4);
        detailsUUID = (TextView) findViewById(R.id.tv5);

        detailsDestination.setText(Screen_Payment.statDest);
        detailsDepTime.setText(Screen_Payment.statDept);
        detailsDepBay.setText(Screen_Payment.statTxtView);
        detailsSeatNo.setText("SN" + Screen_Payment.randomInt);
        detailsUUID.setText(QRScreen.uuid);

        homeBtn = findViewById(R.id.doneBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_Trip.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}