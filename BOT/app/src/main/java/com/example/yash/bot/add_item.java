package com.example.yash.bot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class add_item extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextBrand;
    private EditText editTextDesc;
    private EditText editTextPrice;
    private EditText editTextQty;
    private EditText editTextOffer;
    private TextView textRackName;
    private  Product product;
    private int nitems=1;
    private String TAG="PRODUCT_LIST";
    private FirebaseFirestore db;
    private int rackno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item1);

        db = FirebaseFirestore.getInstance();
        rackno = getIntent().getIntExtra("rack_no",1);
        textRackName=findViewById(R.id.rn);
        editTextName = findViewById(R.id.edittext_name);
        editTextBrand = findViewById(R.id.edittext_brand);
        editTextOffer = findViewById(R.id.edittext_offer);
        editTextDesc = findViewById(R.id.edittext_desc);
        editTextPrice = findViewById(R.id.edittext_price);
        editTextQty = findViewById(R.id.edittext_qty);
        textRackName.setText("Rack"+rackno);
        findViewById(R.id.button_save).setOnClickListener(this);
    }

    private boolean validateInputs(String name, String brand, String offer, String desc, String price, String qty) {
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if (brand.isEmpty()) {
            editTextBrand.setError("Brand required");
            editTextBrand.requestFocus();
            return true;
        }

        if (offer.isEmpty()) {
            editTextOffer.setError("Offer yes/no");
            editTextOffer.requestFocus();
            return true;
        }

        if (desc.isEmpty()) {
            editTextDesc.setError("Description required");
            editTextDesc.requestFocus();
            return true;
        }

        if (price.isEmpty()) {
            editTextPrice.setError("Price required");
            editTextPrice.requestFocus();
            return true;
        }

        if (qty.isEmpty()) {
            editTextQty.setError("Quantity required");
            editTextQty.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        String rackname=textRackName.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String brand = editTextBrand.getText().toString().trim();
        String offer = editTextOffer.getText().toString().trim();
        String desc = editTextDesc.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String qty = editTextQty.getText().toString().trim();

        if (!validateInputs(name, brand, offer, desc, price, qty)) {

           // CollectionReference dbProducts2 = db.collection("Product List");//.document("Rack"+rackno).collection("Product List"+nitems);
                DocumentReference docref=db.collection("Product List").document(name);
             product = new Product(
                    name,
                    rackname,
                    brand,
                     offer,
                    desc,
                    Double.parseDouble(price),
                    Integer.parseInt(qty)
            );

            Toast.makeText(add_item.this, rackname, Toast.LENGTH_LONG).show();

            updateFirestoreInstance(docref);


//            dbProducts2.add(product)
//                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                        @Override
//                        public void onSuccess(DocumentReference documentReference) {
//                            Log.d(TAG, "user details uploaded successfully");
//                            editTextName.setText("");
//                            editTextBrand.setText("");
//                            editTextDesc.setText("");
//                            editTextPrice.setText("");
//                            editTextQty.setText("");
//                            Toast.makeText(add_item.this, "Product Added", Toast.LENGTH_LONG).show();
//                            nitems++;
//
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.d(TAG, "user details failed to upload");
//                            Toast.makeText(add_item.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    });

        }
   }
    public void updateFirestoreInstance(DocumentReference documentReference)
    {
        documentReference.set(product).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "user details uploaded successfully");
                    editTextName.setText("");
                    editTextBrand.setText("");
                    editTextOffer.setText("");
                    editTextDesc.setText("");
                    editTextPrice.setText("");
                    editTextQty.setText("");
                    Toast.makeText(add_item.this, "Product Added", Toast.LENGTH_LONG).show();
                } else {
                    Log.d(TAG, "user details failed to upload");
                    Toast.makeText(add_item.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
