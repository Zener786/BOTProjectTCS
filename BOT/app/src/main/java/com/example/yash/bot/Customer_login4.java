package com.example.yash.bot;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;




import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class Customer_login4 extends AppCompatActivity {

    private EditText e1;
    private EditText e2;
    private Button googleso;
    FirebaseAuth auth;
    private SignInButton googlesi;
    GoogleSignInClient mGoogleSignInClient;

    private final static int RC_SIGN_IN = 123;
    private static final String TAG = "GoogleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login4);

        auth = FirebaseAuth.getInstance();
        googleso=(Button)findViewById(R.id.googleso);
        googlesi = (SignInButton) findViewById(R.id.googlesi);
        //    customer_login = (Button) findViewById(R.id.customer_login);
        //e1 = (EditText) findViewById(R.id.e1);
        //e2 = (EditText) findViewById(R.id.e2);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        googlesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
//        Intent i=new Intent(Customer_login4.this,search_product.class);
//        i.putExtra("GSO",gso);

        googleso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    /*
        // [START signin]
        private void signIn() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
        // [END signin]
    */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);

            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                Toast.makeText(getApplicationContext(), "Google sign in failed", Toast.LENGTH_SHORT).show();

                // ...
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        final String personName = account.getDisplayName();
        final String personGivenName = account.getGivenName();
        final String personFamilyName = account.getFamilyName();
        final String personEmail = account.getEmail();
        final String personId = account.getId();
        Uri personPhoto = account.getPhotoUrl();


        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = auth.getCurrentUser();




                            Intent i = new Intent(getApplicationContext(), Urgent_normal_shopping.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(), "User Logged In Successfully\n"+" Name:"+personName+"\nID:"+personId, Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "Could not log in", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
   /* @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        firebaseAuthWithGoogle(account);
        Intent i = new Intent(getApplicationContext(), Urgent_normal_shopping.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "User Logged In Successfully", Toast.LENGTH_SHORT).show();


    }

*/
    private void signOut() {
        // Firebase sign out
        auth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), "Logged out successfully", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}

    /*

    private void revokeAccess() {
        // Firebase sign out
        auth.signOut();

        // Google revoke access
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            mStatusTextView.setText(getString(R.string.google_status_fmt, user.getEmail()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.signInButton).setVisibility(View.GONE);
            findViewById(R.id.signOutAndDisconnect).setVisibility(View.VISIBLE);
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.signInButton).setVisibility(View.VISIBLE);
            findViewById(R.id.signOutAndDisconnect).setVisibility(View.GONE);
        }
    }


        public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.signInButton) {
            signIn();
        } else if (i == R.id.signOutButton) {
            signOut();
        } else if (i == R.id.disconnectButton) {
            revokeAccess();
        }

    }
}  */
    /*

        customer_login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String loginemail = e1.getText().toString();
                String loginpassword = e2.getText().toString();
                if (!TextUtils.isEmpty(loginemail) && !TextUtils.isEmpty(loginpassword)) {
                    loginprogress.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(loginemail, loginpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                proceedwithcustomer();
                            } else {
                                String errormessage = task.getException().getMessage();
                                Toast.makeText(Customer_login4.this, "Error" + errormessage, Toast.LENGTH_LONG).show();
                            }
                            loginprogress.setVisibility(View.INVISIBLE);
                        }
                    });
                }

            }
        });
    }
        protected void onStart() {
            super.onStart();

            FirebaseUser currentuser = mAuth.getCurrentUser();
            if (currentuser != null) {

                proceedwithcustomer();
            }


        }



*/