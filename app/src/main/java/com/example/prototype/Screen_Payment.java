package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screen_Payment extends AppCompatActivity {

    Spinner dest;
    Spinner dept;
    ArrayList<String> arrayList_dest;
    ArrayAdapter<String> arrayAdapter_dest;


    ArrayList<String> arrayList_AguinaldoHwyImus,arrayList_GahakKawit,arrayList_SMBacoor,arrayList_ArcadeZapote, arrayList_StDominicMolino;
    ArrayAdapter<String> arrayAdapter_dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_payment);

        dest = (Spinner) findViewById(R.id.spinner1);
        dept = (Spinner) findViewById(R.id.spinner2);

        arrayList_dest = new ArrayList<>();
        arrayList_dest.add("Aguinaldo Hwy- Imus");
        arrayList_dest.add("Gahak- Kawit");
        arrayList_dest.add("SM- Bacoor");
        arrayList_dest.add("Arcade- Zapote");
        arrayList_dest.add("St. Dominic- Molino");

        arrayAdapter_dest = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_dest);
        dest.setAdapter(arrayAdapter_dest);

        arrayList_AguinaldoHwyImus = new ArrayList<>();
        arrayList_AguinaldoHwyImus.add(173000);
        arrayList_AguinaldoHwyImus.add(072500);

        arrayList_GahakKawit = new ArrayList<>();
        arrayList_GahakKawit.add(120000);
        arrayList_GahakKawit.add(051000);

        arrayList_SMBacoor = new ArrayList<>();
        arrayList_SMBacoor.add(132500);
        arrayList_SMBacoor.add(072500);

        arrayList_ArcadeZapote = new ArrayList<>();
        arrayList_ArcadeZapote.add(100000);
        arrayList_ArcadeZapote.add(140000);

        arrayList_StDominicMolino = new ArrayList<>();
        arrayList_StDominicMolino.add(18000);
        arrayList_StDominicMolino.add(154500);

        dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_AguinaldoHwyImus);
                }

                if (position == 1) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_GahakKawit);
                }

                if (position == 2) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_SMBacoor);
                }

                if (position == 3) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_ArcadeZapote);
                }

                if (position == 4) {
                    arrayAdapter_dept = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_StDominicMolino);
                }

                dept.setAdapter(arrayAdapter_dept);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


};