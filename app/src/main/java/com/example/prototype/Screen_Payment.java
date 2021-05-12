package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
import org.json.JSONStringer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import android.text.format.Time;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
*/


public class Screen_Payment extends AppCompatActivity {



    TextView txtView;
    Spinner dest;
    Spinner dept;
    RadioButton radioButtonA;
    RadioButton radioButtonB;
    ArrayList<String> arrayList_dest;
    ArrayAdapter<String> arrayAdapter_dest;

    // private List<Trip> tripdetails = new ArrayList<>();

    private String destAtimex = "07:25:00";
    private String destAtimey = "17:30:00";

    private String destBtimex = "05:10:00";
    private String destBtimey = "12:00:00";

    private String destCtimex = "07:25:00";
    private String destCtimey = "13:25:00";

    private String destDtimex = "10:00:00";
    private String destDtimey = "14:00:00";

    private String destEtimex = "15:45:00";
    private String destEtimey = "18:00:00";

    static int numOfSeatsA = 30;

    static int numOfSeatsB = 45;
    static int numOfSeatsC = 40;
    static int numOfSeatsD = 25;
    static int numOfSeatsE = 20;

    Integer numSeatsA = new Integer(numOfSeatsA);
    Integer numSeatsB = new Integer(numOfSeatsB);
    Integer numSeatsC = new Integer(numOfSeatsC);
    Integer numSeatsD = new Integer(numOfSeatsD);
    Integer numSeatsE = new Integer(numOfSeatsE);

    ArrayList<String> arrayList_AguinaldoHwyImus,arrayList_GahakKawit,arrayList_SMBacoor,arrayList_ArcadeZapote, arrayList_StDominicMolino;
    ArrayAdapter<String> arrayAdapter_dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_payment);

        radioButtonA = (RadioButton) findViewById(R.id.radioGCash);
        radioButtonB = (RadioButton) findViewById(R.id.radioPaymaya);
        txtView = (TextView) findViewById(R.id.noOfSeats);
        dest = (Spinner) findViewById(R.id.spinner1);
        dept = (Spinner) findViewById(R.id.spinner2);

        //ArrayAdapter<List> adapter = new ArrayAdapter<List>(this, android.R.layout.simple_spinner_dropdown_item, Collections.singletonList(tripdetails));
        //adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        arrayList_dest = new ArrayList<>();
        arrayList_dest.add("Aguinaldo Hwy, Imus");
        arrayList_dest.add("Gahak, Kawit");
        arrayList_dest.add("SM, Bacoor");
        arrayList_dest.add("Arcade, Zapote");
        arrayList_dest.add("St. Dominic, Molino");

        arrayAdapter_dest = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_dest);
        dest.setAdapter(arrayAdapter_dest);

        arrayList_AguinaldoHwyImus = new ArrayList<>();
        arrayList_AguinaldoHwyImus.add(destAtimex);
        arrayList_AguinaldoHwyImus.add(destAtimey);


        arrayList_GahakKawit = new ArrayList<>();
        arrayList_GahakKawit.add(destBtimex);
        arrayList_GahakKawit.add(destBtimey);


        arrayList_SMBacoor = new ArrayList<>();
        arrayList_SMBacoor.add(destCtimex);
        arrayList_SMBacoor.add(destCtimey);


        arrayList_ArcadeZapote = new ArrayList<>();
        arrayList_ArcadeZapote.add(destDtimex);
        arrayList_ArcadeZapote.add(destDtimey);

        arrayList_StDominicMolino = new ArrayList<>();
        arrayList_StDominicMolino.add(destEtimex);
        arrayList_StDominicMolino.add(destEtimey);


        dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_AguinaldoHwyImus);
                    txtView.setText(numSeatsA.toString());

                }

                if (position == 1) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_GahakKawit);
                    txtView.setText(numSeatsB.toString());
                }

                if (position == 2) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_SMBacoor);
                    txtView.setText(numSeatsC.toString());
                }

                if (position == 3) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_ArcadeZapote);
                    txtView.setText(numSeatsD.toString());
                }

                if (position == 4) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_StDominicMolino);
                    txtView.setText(numSeatsE.toString());
                }

                dept.setAdapter(arrayAdapter_dept);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    /*
        CSVReader reader = new CSVReader(new FileReader("data.csv"), ',' , '"' , 1)
        InputStream is = getResources().openRawResource(R.raw.final_bus_schedule);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
    */


     }


    public void onRadioButtonClick(View view)
    {

    }
    public void nextButton(View view){

    }

    /*
    private void checkTrip() {
        CSVReader reader = new CSVReader(new FileReader("data.csv"), ',' , '"' , 1)
        InputStream is = getResources().openRawResource(R.raw.final_bus_schedule);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line="";
        String[] arrayxd = line.split(",");
        try {
            reader.readLine();
            while ( (line = reader.readLine()) != null) {
                Log.d("MyActivity", "Line: " + line);

                Trip trip = new Trip();

                trip.setDestination(arrayxd[0]);
                trip.setBus_company(arrayxd[1]);
                trip.setRemainingseats(Integer.parseInt(arrayxd[2]));
                trip.setTimeofdeparture(arrayxd[3]);

                //System.out.println(arrayxd[0] + arrayxd[1] +  arrayxd[2] +  arrayxd[3]);

                tripdetails.add(trip);

                Log.d("MyActivity", "Created: " + trip);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
    */

}