package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Screen_Payment extends AppCompatActivity {

    Spinner dest;
    Spinner dept;
    private List<Trip> tripdetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_payment);
        checkTrip();

        dest = findViewById(R.id.spinner1);
        dept = findViewById(R.id.spinner2);

        ArrayAdapter<List> adapter = new ArrayAdapter<List>(this, android.R.layout.simple_spinner_dropdown_item, Collections.singletonList(tripdetails));
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

    }

        private void checkTrip() {

            InputStream is = getResources().openRawResource(R.raw.trips__051021_);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );

            String line = "";

                try {
                    reader.readLine();
                    while ( (line = reader.readLine()) != null) {
                        Log.d("MyActivity", "Line: " + line);
                        String[] arrayxd = line.split(",");
                        Trip trip = new Trip();
                        trip.setBus_company(arrayxd[0]);
                        trip.setDestination(arrayxd[1]);
                        trip.setRemainingseats(Integer.parseInt(arrayxd[2]));
                        trip.setTimeofdeparture(arrayxd[3]);
                        tripdetails.add(trip);

                        Log.d("MyActivity", "Created: " + trip);
                    }
                } catch (IOException e) {
                    Log.wtf("MyActivity", "Error reading data file on line " + line, e);
                    e.printStackTrace();
                }

            }

}