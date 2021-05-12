package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.UUID;

public class QRScreen extends AppCompatActivity {
    String uniqueId;
    String sText;
    EditText input;
    Button btnGenerate;
    Button showRandomId;
    ImageView qr;
    TextView txtUUID;

    boolean alreadyExecuted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscreen);
        txtUUID = (TextView) findViewById(R.id.showUUID);
        input = findViewById(R.id.input);
        btnGenerate = findViewById(R.id.btnGenerate);
        qr = findViewById(R.id.output);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sText = input.getText().toString().trim();
                MultiFormatWriter writer = new MultiFormatWriter();
                if (!sText.isEmpty()) {
                        try {
                            BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE, 350, 350);
                            BarcodeEncoder encoder = new BarcodeEncoder();
                            Bitmap bitmap = encoder.createBitmap(matrix);
                            qr.setImageBitmap(bitmap);
                            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            manager.hideSoftInputFromWindow(input.getApplicationWindowToken(), 0);
                        } catch (WriterException e) {
                            e.printStackTrace();
                        }

                        sText = uniqueId;
                         if(!alreadyExecuted)
                         {
                             uniqueId = UUID.randomUUID().toString();
                             int duration = Toast.LENGTH_SHORT;
                             Toast toast = Toast.makeText(getBaseContext(), uniqueId, duration);
                             toast.show();
                             alreadyExecuted = true;
                         }

                    txtUUID.setText("UUID: " + uniqueId);
                }
                else
                {
                    int i = 0;
                    Toast.makeText(QRScreen.this, "bruh at least put something in the Text Field", Toast.LENGTH_LONG).show();
                }


            }
        });






    }
}



