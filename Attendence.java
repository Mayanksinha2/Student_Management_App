package com.basic.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Attendence extends AppCompatActivity {
    Button ent,exi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);

        ent = (Button) findViewById(R.id.entrance);
        exi = (Button) findViewById(R.id.exit);
        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Attendence.this, Scanner.class));
            }
        });
        exi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Attendence.this, Scanner.class));
            }
        });
    }
}
