package com.example.yash.bot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductsAdapter adapter;
    private List<Product> productList;
    private ProgressBar progressBar;
    int counter;

    private List<DocumentSnapshot> list;
    private FirebaseFirestore db;
    private int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        progressBar = findViewById(R.id.progressbar);

        recyclerView = findViewById(R.id.recyclerview_products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        adapter = new ProductsAdapter(this, productList);

        recyclerView.setAdapter(adapter);


        db = FirebaseFirestore.getInstance();

        //ans=getIntent().getIntExtra("pos",0);
        //ans=ans+1;
        db.collection("Rack List").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                counter = documentSnapshots.size();
                Toast.makeText(ProductsActivity.this, counter + " Racks ", Toast.LENGTH_LONG).show();

            }
        });


//        db.collection("cities").get().then(function(querySnapshot) {
//            console.log(querySnapshot.size);
//        });
//        int z = 1;
//        while (z <= counter) {
//
//            db.collection("Rack List").document("Rack" + String.valueOf(z)).collection("Products").get()
//                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//
//
//                            if (!queryDocumentSnapshots.isEmpty()) {
//
//                                list = queryDocumentSnapshots.getDocuments();
//
//                            }
//                        }
//
//                    });
//            z++;
//        }
//
//        for (DocumentSnapshot d : list) {
//
//            Product p = d.toObject(Product.class);
//            p.setId(d.getId());
//            productList.add(p);
//
//
//        }
//        progressBar.setVisibility(View.GONE);
//
//
//        adapter.notifyDataSetChanged();


        //-------------

            db.collection("Product List").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            progressBar.setVisibility(View.GONE);

                            if (!queryDocumentSnapshots.isEmpty()) {

                                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                                for (DocumentSnapshot d : list) {

                                    Product p = d.toObject(Product.class);
                                    p.setId(d.getId());
                                    productList.add(p);


                                }

                                adapter.notifyDataSetChanged();

                            }


                        }

                    });




    }
}
////-------------
//
//        db.collection("Rack List").document("Rack2").collection("Products").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//
//                        progressBar.setVisibility(View.GONE);
//
//                        if (!queryDocumentSnapshots.isEmpty()) {
//
//                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//
//                            for (DocumentSnapshot d : list) {
//
//                                Product p = d.toObject(Product.class);
//                                p.setId(d.getId());
//                                productList.add(p);
//
//
//                            }
//
//                            adapter.notifyDataSetChanged();
//
//                        }
//
//
//
//                    }
//
//                });


        //adapter.notifyDataSetChanged();


