package com.example.yash.bot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin_Login3 extends AppCompatActivity {
    private Button admin_login;
    private Button admin_signup;
    //private Button admin_signout;
    private EditText e1;
    private EditText e2;
    private FirebaseAuth mAuth;
    private ProgressBar loginprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login3);
        mAuth = FirebaseAuth.getInstance();
        /*admin_signout=(Button)findViewById(R.id.admin_signout);
        admin_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });
        */
        admin_login = (Button) findViewById(R.id.admin_login);
        admin_signup=(Button)findViewById(R.id.admin_signnup);
        loginprogress = (ProgressBar) findViewById(R.id.loginprogress);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        admin_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin_Login3.this,admin_login_signup.class);

                startActivity(i);
            }
        });

        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  proceedwithadmin();


                String loginemail = e1.getText().toString();
                String loginpassword = e2.getText().toString();
                if (!TextUtils.isEmpty(loginemail) && !TextUtils.isEmpty(loginpassword)) {
                    loginprogress.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginemail, loginpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                proceedwithadmin();
                            } else {
                                String errormessage = task.getException().getMessage();
                                Toast.makeText(Admin_Login3.this, "Error" + errormessage, Toast.LENGTH_LONG).show();
                            }
                            loginprogress.setVisibility(View.INVISIBLE);
                        }
                    });
                }

           }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentuser = mAuth.getCurrentUser();
        if (currentuser != null) {

            proceedwithadmin();
        }
    }



    private void proceedwithadmin() {

            Intent i = new Intent(Admin_Login3.this,row_column_grid.class );

            startActivity(i);
            finish();
        }

}



