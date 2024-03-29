package com.example.yash.bot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class admin_login_signup extends AppCompatActivity implements View.OnClickListener {

        //defining view objects
        private EditText editTextEmail;
        private EditText editTextPassword;
        private Button buttonSignup;
        private ProgressDialog progressDialog;


        //defining firebaseauth object
        private FirebaseAuth firebaseAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_signup);

            //initializing firebase auth object
            firebaseAuth = FirebaseAuth.getInstance();

            //initializing views
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);

            buttonSignup = (Button) findViewById(R.id.buttonSignup);

            progressDialog = new ProgressDialog(this);

            //attaching listener to button
            buttonSignup.setOnClickListener(this);
        }

        private void registerUser(){

            //getting email and password from edit texts
            final String email = editTextEmail.getText().toString().trim();
            final String password  = editTextPassword.getText().toString().trim();

            //checking if email and passwords are empty
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            //creating a new user
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if(task.isSuccessful()){
                                //display some message here
                                Toast.makeText(admin_login_signup.this,"Successfully registered",Toast.LENGTH_LONG).show();


                            }else{
                                //display some message here
                                Toast.makeText(admin_login_signup.this,"Registration Error",Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(admin_login_signup.this,row_column_grid.class );

                        startActivity(i);
                    } else {
                        String errormessage = task.getException().getMessage();
                        Toast.makeText(admin_login_signup.this, "Error" + errormessage, Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

        @Override
        public void onClick(View view) {
            //calling register method on click
            registerUser();
        }
    }

