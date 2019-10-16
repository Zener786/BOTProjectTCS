//package com.example.yash.bot;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class data_display extends AppCompatActivity {
//
//    ListView listviewproducts;
//    List<Product> ProductList;
//   DatabaseReference mref;
//    @Override
//    protected void onCreate( Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.data_display);
//        listviewproducts=(ListView)findViewById(R.id.listviewproducts);
//
//        ProductList = new ArrayList<>();
//        mref= FirebaseDatabase.getInstance().getReference("Rack");
//        Log.v("REF",mref.toString());
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        mref.addValueEventListener(new ValueEventListener() {
//
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                ProductList.clear();
//                for(DataSnapshot productsnapshot : dataSnapshot.getChildren()){
//                    Toast.makeText(getApplicationContext(),"No.of Racks:= "+productsnapshot.getChildrenCount(),Toast.LENGTH_SHORT).show();
//                     product p=productsnapshot.getValue(product.class);
//
//                    ProductList.add(p);
//
//                }
//
//                racklist adaptor = new racklist(data_display.this,ProductList);
//                listviewproducts.setAdapter(adaptor);
//            }
//
//            @Override
//            public void onCancelled( DatabaseError databaseError) {
//
//            }
//        });
//    }
//}
