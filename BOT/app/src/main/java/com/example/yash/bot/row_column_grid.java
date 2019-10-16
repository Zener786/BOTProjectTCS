package com.example.yash.bot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class row_column_grid extends AppCompatActivity {
//EditText r,c;
   // private static final int REQUEST_CODE = 10;
    private Button view_products;
    Button allocation;
    EditText rows;
    EditText cols;
    private Button signout;
    private FirebaseAuth mAuth;
    int nr;
    int nc;
    int check=0;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_column_grid);

        mAuth = FirebaseAuth.getInstance();
        //int analyze_row = Integer.parseInt(row_no.getText().toString());
        rows=(EditText)findViewById(R.id.rows);
        cols=(EditText)findViewById(R.id.cols);
        signout=(Button)findViewById(R.id.signout);
        view_products=(Button)findViewById(R.id.view_products);
        view_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(row_column_grid.this, ProductsActivity.class));
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent i = new Intent(row_column_grid.this, Admin_Login3.class);
                startActivity(i);
            }
        });
       /* r=(EditText)findViewById(R.id.rows);
        c=(EditText)findViewById(R.id.cols);
        Intent i=new Intent();
        i.putExtra("val",r.toString());
        i.putExtra("val",c.toString());
        startActivityForResult(i,REQUEST_CODE);


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode==RESULT_OK && requestCode==REQUEST_CODE)
        {
            if(data.hasExtra("returnKey"));
            {
                String result=data.getExtras().getString("val");
                if(result!=null && result.length()>0)
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


            }
        }
    }*/

       allocation=(Button)findViewById(R.id.allocation);
       allocation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               try {
                        nr = Integer.parseInt(rows.getText().toString());

                       check=1;
                   }
               catch (Exception e){
                   rows.setError("Only Integers are allowed");
               }


                try {
                     nc = Integer.parseInt(cols.getText().toString());

                    check=2;

                }
                catch (Exception e){
                    cols.setError("Only Integers are allowed");
                }
                if(check==2){

                    Intent i=new Intent(row_column_grid.this,grid.class);

                    i.putExtra("nrows", nr);
                    i.putExtra("ncolumns", nc);
//                    db.collection("Rack List").document().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(row_column_grid.this, "Rack list deleted", Toast.LENGTH_LONG).show();
//                                //finish();
//                                //startActivity(new Intent(UpdateProductActivity.this, ProductsActivity.class));
//                            }
//                        }
//                    });
                    startActivity(i);
                }

           }
       });
}}
