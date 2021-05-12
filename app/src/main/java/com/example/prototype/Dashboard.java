package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dashboard extends AppCompatActivity {

    //Variables
    ImageView dashButton1;
    ImageView dashButton2;
    ImageView dashButton3;
    ImageView dashButton4;
    ImageView dashButton5;
    ImageView dashButton6;

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


    //Navigation Buttons

        //Book Trip
        dashButton1 = findViewById(R.id.dashButton1);
        dashButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Screen_Payment.ticketYes != true)
                {
                    Intent intent = new Intent(Dashboard.this, Screen_Payment.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Dashboard.this, "Only one ticket per device is allowed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Show Ticket
        dashButton2 = findViewById(R.id.dashButton2);
        dashButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Screen_Payment.ticketYes != true)
                {
                    Toast.makeText(Dashboard.this, "Please purchase a ticket first.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Dashboard.this, QRScreen.class);
                    startActivity(intent);
                }
            }
        });

        //View Trip
        dashButton3 = findViewById(R.id.dashButton3);
        dashButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Screen_Payment.ticketYes != true)
                {
                    Toast.makeText(Dashboard.this, "Please purchase a ticket first.", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (Screen_Payment.ticketViewed != true)
                        Toast.makeText(Dashboard.this, "View Ticket first.", Toast.LENGTH_SHORT).show();
                    else
                    {
                        Intent intent = new Intent(Dashboard.this, Screen_Trip.class);
                        startActivity(intent);
                    }
                }

            }
        });

                    //Check Route (WIP)
                    /*
                    dashButton4 = findViewById(R.id.dashButton4);
                    dashButton4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Dashboard.this, Screen_Route.class);
                            startActivity(intent);
                        }
                    });
                    */

                    //Edit Trip (WIP)
                    /*
                    dashButton5 = findViewById(R.id.dashButton5);
                    dashButton5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Dashboard.this, Screen_Edit.class);
                            startActivity(intent);
                        }
                    });
                    */


        //Log-Out
        dashButton6 = findViewById(R.id.dashButton6);
        dashButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For now, babalik lang sa Login Screen since wala pang Login/Register na module
                Intent intent = new Intent(Dashboard.this, LoginScreen.class);
                startActivity(intent);
            }
        });



    }

    void changeUser() {
        //Use this kapag gagawin na yung Login Module
    }


}