package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Dashboard extends AppCompatActivity {

    //Variables
    ImageView dashButton1;
    ImageView dashButton2;
    ImageView dashButton3;
    //ImageView dashButton4;
    //ImageView dashButton5;
    //ImageView dashButton6;

    final int random = new Random().nextInt(999999999) + 1;

    //eto muna habang wala pang login xdddddddddd
    String myUsername = "Guest";
    String txtmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView usertxtview = (TextView) findViewById(R.id.txt_user);
        setContentView(R.layout.activity_dashboard);
        if (myUsername.equals("Guest"))
            myUsername = "Guest" + random;
        else
            changeUser();

        txtmsg = "Welcome, " + myUsername + "!";

        try {
            usertxtview.setText(txtmsg);
        } catch (NullPointerException e) {
            System.out.println("xd");
        }


        //Buttons
        dashButton1 = findViewById(R.id.dashButton1);
        dashButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Screen_Payment.class);
                startActivity(intent);
            }
        });

        dashButton2 = findViewById(R.id.dashButton2);
        dashButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Screen_Ticket.class);
                startActivity(intent);
            }
        });

        dashButton3 = findViewById(R.id.dashButton3);
        dashButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Screen_Trip.class);
                startActivity(intent);
            }
        });
        /*
        dashButton4 = findViewById(R.id.dashButton4);
        dashButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        */

        /*
        dashButton5 = findViewById(R.id.dashButton5);
        dashButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        */

        /*
        dashButton6 = findViewById(R.id.dashButton6);
        dashButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        */


    }

    void changeUser() {
        //kapag may login module na
    }


}