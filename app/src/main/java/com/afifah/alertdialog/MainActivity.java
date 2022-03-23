package com.afifah.alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Alert message
        Button buttonAlert = findViewById(R.id.alertButton);
        buttonAlert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this)
                        .setTitleText("Hi! This is Afifah")
                        .show();
            }
        });

        // 2. Confirmation message
        Button buttonWarning = findViewById(R.id.confirmationButton);
        buttonWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure? Go to Isekai")
                        .setContentText("You will not be able to return to the world!")
                        .setConfirmText("Yes!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });

        // 3. Toast message
        Button buttonToast = findViewById(R.id.toastButton);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Displaying simple Toast message
                Toast.makeText(getApplicationContext(), "Hey! This is Toast", Toast.LENGTH_LONG)
                        .show();
            }
        });


        // 4. Custome message
        Button buttonCustome = findViewById(R.id.customeButton);
        buttonCustome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SweetAlertDialog pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                pDialog.setTitleText("Woops!");
                pDialog.setContentText("Here's an Android Logo.");
                pDialog.setCustomImage(R.drawable.android_developer_logo_170920110556);
                pDialog.show();
            }
        });


        // 5. Loading message
        Button buttonLoading = findViewById(R.id.loadingButton);
        buttonLoading.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SweetAlertDialog pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Go to Isekai...");
                pDialog.setCancelable(true);
                pDialog.show();
            }
        });
    }
}