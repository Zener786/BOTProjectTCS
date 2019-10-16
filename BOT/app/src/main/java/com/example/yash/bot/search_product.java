package com.example.yash.bot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;



public class search_product extends AppCompatActivity  implements View.OnClickListener{
    CheckBox jeans1;
    CheckBox tops1;
    CheckBox jewellery1;
    FirebaseAuth auth;
    private FirebaseFirestore db;
    private DocumentReference docRef;
    private Product p;
    private Coordinate c;
    private int x,y,qty;
    private  double price;
    private String rackname,product,offer;
    private Button signout;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;

CheckBox watch1,crockery1,nailpaint1,ethnic1,skirt1,shoes1;
private ArrayList<String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_search_product);
        jeans1 = (CheckBox) findViewById(R.id.jeans1);
        tops1 = (CheckBox) findViewById(R.id.tops1);
        jewellery1 = (CheckBox) findViewById(R.id.jewellery1);
        watch1 = (CheckBox) findViewById(R.id.watch1);
        crockery1 = (CheckBox) findViewById(R.id.crockery1);
        nailpaint1 = (CheckBox) findViewById(R.id.nailpaint1);
        ethnic1 = (CheckBox) findViewById(R.id.ethnic1);
        skirt1 = (CheckBox) findViewById(R.id.skirts1);
        shoes1 = (CheckBox) findViewById(R.id.shoes1);
        signout=(Button)findViewById(R.id.signout);

        item = new ArrayList<>();

        jeans1.setOnClickListener(this);
        tops1.setOnClickListener(this);
        jewellery1.setOnClickListener(this);
        watch1.setOnClickListener(this);
        crockery1.setOnClickListener(this);
        nailpaint1.setOnClickListener(this);
        ethnic1.setOnClickListener(this);
        skirt1.setOnClickListener(this);
        shoes1.setOnClickListener(this);
        signout.setOnClickListener(this);

    }


        public void onClick(View view) {


            switch (view.getId()) {
                case R.id.jeans1:
                    if (jeans1.isChecked()) {
                        coordinate_result("jeans");

                    }
                    break;
                case R.id.tops1:
                    if (tops1.isChecked()) {
                         coordinate_result("tops");
                        item.add("tops");
                    }
                    break;
                case R.id.jewellery1:
                    if (jewellery1.isChecked()) {
                        coordinate_result("jewellery");
                        item.add("jewellery");
                    }
                    break;
                case R.id.watch1:
                    if (watch1.isChecked()) {
                        coordinate_result("watch");
                        item.add("watch");
                    }
                    break;
                case R.id.crockery1:
                    if (crockery1.isChecked()) {
                        coordinate_result("crockery");
                        item.add("crockery");
                    }
                    break;
                case R.id.nailpaint1:
                    if (nailpaint1.isChecked()) {
                        coordinate_result("nailpaint");
                        item.add("nailpaint");
                    }
                    break;
                case R.id.ethnic1:
                    if (ethnic1.isChecked()) {
                        coordinate_result("ethnic");
                        item.add("ethnic");
                    }
                    break;
                case R.id.shoes1:
                    if (shoes1.isChecked()) {
                        coordinate_result("shoes");   item.add("shoes");
                    }
                    break;
                case R.id.skirts1:
                    if (skirt1.isChecked()) {
                        coordinate_result("skirts");
                        item.add("skirts");
                    }
                    break;
                case R.id.signout:
                    Intent i=new Intent(search_product.this,Customer_login4.class);
                    startActivity(i);
                 break;
            }
        }




    private void coordinate_result(String value) {
        docRef = db.collection("Product List").document(value);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                p = documentSnapshot.toObject(Product.class);
                rackname=p.getRackname();
                product=p.getName();
                offer=p.getOffer();
                qty=p.getQty();
                price=p.getPrice();
                docRef = db.collection("Rack List").document(rackname);
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot1) {
                        c = documentSnapshot1.toObject(Coordinate.class);
                        x=c.getX();
                        y=c.getY();
                        Toast.makeText(search_product.this,rackname+" \n||Product Name: "+product+" \n||Offer: "+offer+"||\n||Qty: "+qty+"||\n||Price: "+price+"||\n||x: "+x+" // y: "+y,Toast.LENGTH_LONG).show();
                    }
                });
                //Toast.makeText(search_product.this,rackname,Toast.LENGTH_LONG).show();
            }
        });
    }


}



