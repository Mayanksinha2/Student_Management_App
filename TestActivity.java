package com.basic.studentmanagementsystem;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

    //    FirebaseFirestore db;
    String currentDateTime,currentDate,email;
    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

//        db = FirebaseFirestore.getInstance();
        currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
        currentDate = new SimpleDateFormat("dd-MM-yyyy ", Locale.getDefault()).format(new Date());
        d = (int) System.currentTimeMillis()/1000;
        Toast.makeText(this, currentDate, Toast.LENGTH_SHORT).show();
        Map<String,Object> data = new HashMap<>();
        data.put("InTime",currentDateTime);
        data.put("OutTime","");

//        db.collection("user").document(email).collection("Attendance")
//                .document(String.valueOf(currentDate)).set(data)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(TestActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
//
//                        drt();
//
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(TestActivity.this, e+"", Toast.LENGTH_SHORT).show();
//
//                    }
//                });

    }

//    public void drt()
//    {
//        DocumentReference dataupdate = db.collection("user").document(email)
//                .collection("Attendance").document(currentDate);
//        dataupdate .update("OutTime",currentDateTime)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });
    }
//}
