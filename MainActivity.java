package com.basic.studentmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    TextView textView,forg,signupText;

    String u_name,pass;   String emailAddress;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        try {
//            String data = mAuth.getCurrentUser().getEmail();
//
//            if (!data.equals(""))
//                startActivity(new Intent(MainActivity.this,Welcome.class));
//        } catch (Exception e) {
//            Toast.makeText(this, "you are not logged in", Toast.LENGTH_SHORT).show();
//        }




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u_name = username.getText().toString().trim();
                pass =  password.getText().toString().trim();

                signIn(u_name,pass);
                Intent intent = new Intent(MainActivity.this, Screen3.class);
                startActivity(intent);

            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });


        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                    try {
                emailAddress = mAuth.getCurrentUser().getEmail();
                if(emailAddress.equals(""))
//                        emailAddress = "sksuman66@gmail.com";
//                    } catch (Exception e) {

                {
                    Toast.makeText(MainActivity.this, "Email not found", Toast.LENGTH_SHORT).show();}
//                    }


                mAuth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(MainActivity.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }


    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            startActivity(new Intent(MainActivity.this, Welcome.class));


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        // [END sign_in_with_email]
    }


    public void init()
    {
        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        loginButton =(Button) findViewById(R.id.loginButton);
        textView =(TextView) findViewById(R.id.loginText);
        forg =(TextView) findViewById(R.id.forgTV);
        signupText =(TextView) findViewById(R.id.signupText);
        mAuth = FirebaseAuth.getInstance();
    }
}