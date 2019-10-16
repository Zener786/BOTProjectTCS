package com.example.yash.bot;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class grid extends AppCompatActivity
{
    int i,j,a=0,b=0;
    FirebaseFirestore db;
   private DatabaseReference mref;
   DocumentReference docref;
    CollectionReference dbProducts1;
    CollectionReference dbProducts2;
    CollectionReference dbProducts3;

   private int colcount;
   private int rowcount;
    int[][] shopStr;
   private  String TAG = "COORDINATES";
    int k=0;int k1=0;int k2=0;
    RadioButton[] rb = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        ScrollView svv = new ScrollView(this);
        svv.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.WRAP_CONTENT));
        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        GridLayout grd;
        GridLayout.LayoutParams gllop;
        HorizontalScrollView svh;
        db = FirebaseFirestore.getInstance();
       rowcount = getIntent().getIntExtra("nrows", 0);
        colcount = getIntent().getIntExtra("ncolumns", 0);
        shopStr=new int[rowcount][colcount];

        Button[][] btn=new Button[rowcount][colcount];
        Toast.makeText(getBaseContext(), rowcount+"//"+colcount, Toast.LENGTH_SHORT).show();


//        -------------------------------Upper Layout-----------------

        Button title=new Button(this);
        title.setText("Select The block According to Check Box");
        title.setTextColor(Color.RED);
        title.setTextSize(15);


        RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
        rb[0]=new RadioButton(this);
        rb[1]=new RadioButton(this);
        rb[2]=new RadioButton(this);
//        rb[3]=new RadioButton(this);

        rb[0].setText("Blocked Way");
        rb[1].setText("Door");
        rb[2].setText("Racks");
//        rb[3].setText("Delete Current state");

        for(int i=0; i<rb.length; i++)
        {
            rg.addView(rb[i]);
        }
        linLayout.addView(title);
        linLayout.addView(rg);

//--------------------------------------------------------------------------

        for(i = 0; i < rowcount; i++)
        {
            grd = new GridLayout(this);
            grd.setColumnCount(colcount);
            grd.setRowCount(rowcount);
            grd.setBackgroundColor(Color.YELLOW);
            for(j = 0; j < colcount; j++)
            {
                btn[i][j] = new Button(this);
                btn[i][j].setText((i+1) +","+(j+1));

                grd.addView(btn[i][j]);
                btn[i][j].setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        String string= (String)((Button)v).getText();
                        char m=string.charAt(0);
                        int index=string.indexOf(',');

                        a=Integer.valueOf(string.substring(0,index))-1;
                        b=Integer.valueOf(string.substring(index+1))-1;

//                        Toast.makeText(getBaseContext(), string+" Clicked", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(getBaseContext(), a +","+b+" Clicked", Toast.LENGTH_SHORT).show();

                        if(rb[0].isChecked())               //BLOCKED WAY   -1
                        {

                            shopStr[a][b]=-1;
                            v.setBackgroundColor(Color.BLACK);
                            ((Button)v).setTextColor(Color.WHITE);
                             dbProducts1 = db.collection("Blocked List");
                            Coordinate c= new Coordinate((a+1),(b+1));
                            k++;
                            db.collection("Blocked List").document("Blocked"+k).set(c)
                                    .addOnSuccessListener(new OnSuccessListener < Void > () {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(grid.this, "Coordinate Added", Toast.LENGTH_LONG).show();

                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(grid.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                            Log.d("TAG", e.toString());
                                        }
                                    });
                        }
                        else if(rb[1].isChecked())          //DOOR      99
                        {
                            shopStr[a][b] = 99;
                            v.setBackgroundColor(Color.CYAN);

                            Coordinate c = new Coordinate((a + 1), (b + 1));
                            k1++;
                            db.collection("Door List").document("Door" + k1).set(c)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(grid.this, "Coordinate Added", Toast.LENGTH_LONG).show();

                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(grid.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                            Log.d("TAG", e.toString());
                                        }
                                    });
                        }
                        else if(rb[2].isChecked())          //RACK      1
                        {
                            shopStr[a][b]=1;
                            v.setBackgroundColor(Color.RED);
//                            Map<String,Object> coord=new HashMap<>();
//                            coord.put("X",(a+1));
//                            coord.put("Y",(b+1));
// Add a new document with a generated ID
                            Coordinate c= new Coordinate((a+1),(b+1));
                            k2++;
                            db.collection("Rack List").document("Rack"+k2).set(c)
                                    .addOnSuccessListener(new OnSuccessListener < Void > () {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(grid.this, "Coordinate Added", Toast.LENGTH_LONG).show();
                                            Intent i=new Intent(grid.this,add_item.class);
                                            i.putExtra("rack_no",k2);
                                            startActivity(i);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(grid.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                            Log.d("TAG", e.toString());
                                        }
                                    });

//                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                        @Override
//                                        public void onSuccess(DocumentReference documentReference) {
//                                            Toast.makeText(grid.this, "Coordinate Added", Toast.LENGTH_LONG).show();
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            Toast.makeText(grid.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                                        }
//                                    });


//                            docref=db.collection("Rack List").document("Rack"+k);
//                            docref.set(coord);

//                            // Add a new document with a generated ID
//                            db.collection("Rack List").document("Rack"+k).set(coord)
//                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                        @Override
//                                        public void onSuccess(DocumentReference documentReference) {
//                                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            Log.w(TAG, "Error adding document", e);
//                                        }
//                                    });



                        }
//                        else if(rb[3].isChecked())          //RESET,PATH     0
//                        {
//                            shopStr[a][b]=0;
//                            v.setBackgroundResource(android.R.drawable.btn_default);
//                            ((Button)v).setTextColor(Color.BLACK);
//
//                            finish();
//                            startActivity(getIntent());
//                        }
//                        Toast.makeText(getBaseContext(), "value at 0,0--->"+shopStr[0][0], Toast.LENGTH_SHORT).show();

                    }
                });

            }
            svh = new HorizontalScrollView(this);
            svh.addView(grd);
            linLayout.addView(svh);
        }
        svv.addView(linLayout);
        setContentView(svv, linLayoutParam);

        Button nextPage1 = new Button(this);
        nextPage1.setText("RELOAD");
        nextPage1.setTextSize(25);
        nextPage1.setTextColor(Color.BLUE);
        linLayout.addView(nextPage1);

        Button nextPage2=new Button(this);
        nextPage2.setText("Next");
        nextPage2.setTextSize(25);
        nextPage2.setTextColor(Color.BLUE);
        linLayout.addView(nextPage2);

        nextPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Rack List").document().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(grid.this, "Rack List deleted", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                });
                startActivity(getIntent());
            }
        });

//        ---------------------------------------------------------------------------------------------Next Page Intent

        nextPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i =new Intent(grid.this,row_column_grid.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"next page",Toast.LENGTH_LONG).show();
//                Intent i=new Intent(MainActivity.this,AddProductToRack.class);
//
//                String[][] converted = new String[rowcount][colcount];
//                for(int index = 0; index < rowcount; index++)
//                {
//                    converted[index] = new String[colcount];
//                    for(int subIndex = 0; subIndex < colcount; subIndex++)
//                    {
//                        converted[index][subIndex] = Integer.toString(shopStr[index][subIndex]);
//                    }
//                }
//                Bundle mBundle=new Bundle();
//                mBundle.putSerializable("cost", converted);
//                i.putExtras(mBundle);
//                i.putExtra("row",rowcount);
//                i.putExtra("column",colcount);
//
//                startActivity(i);
            }
        });

    }
}
