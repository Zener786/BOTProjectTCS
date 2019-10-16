
package com.example.yash.bot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin_Customer_Page2 extends AppCompatActivity {

    Button admin,customer,bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__customer__page2);
        admin = (Button)findViewById(R.id.admin);
        customer= (Button)findViewById(R.id.customer);
        bluetooth=(Button)findViewById(R.id.bluetooth);
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Admin_Customer_Page2.this,bluetooth_send.class);
                startActivity(i1);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent i = new Intent(Admin_Customer_Page2.this,Admin_Login3.class );

                                         startActivity(i);

                                     }



        });


        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_Customer_Page2.this,Customer_login4.class );
                startActivity(i);

            }



        });


    }


}
