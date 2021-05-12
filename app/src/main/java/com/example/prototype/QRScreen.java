package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

    public static String uuid;
    String uniqueId;
    ImageView qr;
    TextView txtUUID;
    Button homeBtn;
    String[] aaa = {Screen_Payment.statDest, Screen_Payment.statDept, Screen_Payment.statTxtView};
    String combined;
    boolean alreadyExecuted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscreen);
        homeBtn = (Button) findViewById(R.id.btnHome);
        txtUUID = (TextView) findViewById(R.id.showUUID);
        qr = findViewById(R.id.output);

                combined = aaa[0] + "\n" + aaa[1] + "\n" + aaa[2];
                MultiFormatWriter writer = new MultiFormatWriter();
                        try {
                            BitMatrix matrix = writer.encode(combined, BarcodeFormat.QR_CODE, 350, 350);
                            BarcodeEncoder encoder = new BarcodeEncoder();
                            Bitmap bitmap = encoder.createBitmap(matrix);
                            qr.setImageBitmap(bitmap);
                        } catch (WriterException e) {
                            e.printStackTrace();
                        }
                         combined = uniqueId;
                         if(!alreadyExecuted)
                         {
                             uniqueId = UUID.randomUUID().toString();
                             //int duration = Toast.LENGTH_SHORT;
                             //Toast toast = Toast.makeText(getBaseContext(), uniqueId, duration);
                             //toast.show();
                             alreadyExecuted = true;
                             Screen_Payment.ticketViewed = true;
                         }

                    txtUUID.setText("UUID: " + uniqueId);
                    uuid = uniqueId;


                homeBtn = findViewById(R.id.btnHome);
                homeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRScreen.this, Dashboard.class);
                        startActivity(intent);
                    }
                });



    }
}



