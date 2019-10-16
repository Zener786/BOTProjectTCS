package com.example.yash.bot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateProductActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextBrand;
    private EditText editTextDesc;
    private EditText editTextPrice;
    private EditText editTextQty;
    private EditText editTextOffer;
    private TextView textViewRackName;

    private FirebaseFirestore db;

    private Product product;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        product = (Product) getIntent().getSerializableExtra("product");
        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.edittext_name);
        textViewRackName=findViewById(R.id.rackname);
        editTextBrand = findViewById(R.id.edittext_brand);
        editTextOffer = findViewById(R.id.edittext_offer);
        editTextDesc = findViewById(R.id.edittext_desc);
        editTextPrice = findViewById(R.id.edittext_price);
        editTextQty = findViewById(R.id.edittext_qty);


        textViewRackName.setText(product.getRackname());
        editTextName.setText(product.getName());
        editTextBrand.setText(product.getBrand());
        editTextOffer.setText(product.getOffer());
        editTextDesc.setText(product.getDescription());
        editTextPrice.setText(String.valueOf(product.getPrice()));
        editTextQty.setText(String.valueOf(product.getQty()));


        findViewById(R.id.button_update).setOnClickListener(this);
        findViewById(R.id.button_delete).setOnClickListener(this);
    }

    private boolean hasValidationErrors(String name, String brand, String offer, String desc, String price, String qty) {
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


    private void updateProduct() {
        String name = editTextName.getText().toString().trim();
        String rackname = textViewRackName.getText().toString().trim();
        String brand = editTextBrand.getText().toString().trim();
        String offer = editTextOffer.getText().toString().trim();
        String desc = editTextDesc.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String qty = editTextQty.getText().toString().trim();

        if (!hasValidationErrors(name, brand, offer, desc, price, qty)) {

            Product p = new Product(
                    name,rackname, brand, offer, desc,
                    Double.parseDouble(price),
                    Integer.parseInt(qty)
            );


                       db.collection("Product List").document(product.getId())
            //db.collection("Rack List").document("Rack1").collection("Products").document(product.getId())
                    //.set(p)
                    .update(
                            "brand", p.getBrand(),
                            "description", p.getDescription(),
                            "name", p.getName(),
                            "offer",p.getOffer(),
                            "price", p.getPrice(),
                            "qty", p.getQty()
                    )
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UpdateProductActivity.this, "Product Updated", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(UpdateProductActivity.this, ProductsActivity.class));
                        }
                    });
//            db.collection("Rack List").document("Rack2").collection("Products").document(product.getId())
//                    //.set(p)
//                    .update(
//                            "brand", p.getBrand(),
//                            "description", p.getDescription(),
//                            "name", p.getName(),
//                            "price", p.getPrice(),
//                            "qty", p.getQty()
//                    )
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(UpdateProductActivity.this, "Product Updated", Toast.LENGTH_LONG).show();
//                            finish();
//                            startActivity(new Intent(UpdateProductActivity.this, ProductsActivity.class));
//                        }
//                    });
        }
    }

    private void deleteProduct() {
        db.collection("Product List").document(product.getId()).delete()
        //db.collection("Rack List").document("Rack1").collection("Products").document(product.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(UpdateProductActivity.this, "Product deleted", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(UpdateProductActivity.this, ProductsActivity.class));
                        }
                    }
                });
//        db.collection("Rack List").document("Rack2").collection("Products").document(product.getId()).delete()
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(UpdateProductActivity.this, "Product deleted", Toast.LENGTH_LONG).show();
//                            finish();
//                            startActivity(new Intent(UpdateProductActivity.this, ProductsActivity.class));
//                        }
//                    }
//                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_update:
                updateProduct();
                finish();
                break;
            case R.id.button_delete:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure about this?");
                builder.setMessage("Deletion is permanent...");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteProduct();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();

                break;
        }
    }
}
