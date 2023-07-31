package com.basic.studentmanagementsystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Screen3 extends AppCompatActivity {

    CardView attend, payment, video, study_mat;
    Intent intent;

    FirebaseAuth mauth;
    EditText data1, data2, data3, data4;
    //    FirebaseFirestore db;
    String d1, d2, d3, d4, email, userLocation;
    private int LOCATION_PERMISSION_CODE = 1;
    private int BACKGROUND_LOCATION_PERMISSION_CODE = 2;

    FusedLocationProviderClient fc;

    BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        attend = (CardView) findViewById(R.id.dence);

        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen3.this, Attendence.class);
                startActivity(intent);

            }
        });


        payment = (CardView) findViewById(R.id.ment);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen3.this, Payment.class);
                startActivity(intent);

            }
        });


        video = (CardView) findViewById(R.id.lecture);

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen3.this, VideoLecture.class);
                startActivity(intent);

            }
        });

        study_mat = (CardView) findViewById(R.id.material);

        study_mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen3.this, StudyMaterial.class);
                startActivity(intent);

            }
        });



        fc = LocationServices.getFusedLocationProviderClient(this);


        init();
//        checkPermission();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.about){
                    intent = new Intent(Screen3.this,About.class);
                    startActivity(intent);
                }
//                    Toast.makeText(Screen3.this, "About", Toast.LENGTH_SHORT).show();
                if(item.getItemId() == R.id.contact){
                    intent = new Intent(Screen3.this,Contact.class);
                    startActivity(intent);
                }
//                    Toast.makeText(Screen3.this, "Contact Us", Toast.LENGTH_SHORT).show();
                if(item.getItemId() == R.id.logout){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder((Screen3.this));
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Do you really want to close the app");
                    alertDialog.setIcon(R.drawable.ques);
                    alertDialog.setCancelable(false);

                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alertDialog.setNeutralButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = alertDialog.create();
                    alert.show();
                }


//                    Toast.makeText(Screen3.this, "Log out", Toast.LENGTH_SHORT).show();


                return true;
            }
        });




    }
    public void init() {



        mauth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
    }
}
