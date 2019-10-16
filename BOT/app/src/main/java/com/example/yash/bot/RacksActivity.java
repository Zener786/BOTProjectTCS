//package com.example.yash.bot;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RacksActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private RackAdapter adapter;
//    private List<Coordinate> rackList;
//    private ProgressBar progressBar;
//    int counter;
//
//    private FirebaseFirestore db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_racks);
//
//        progressBar = findViewById(R.id.progressbar);
//
//        recyclerView = findViewById(R.id.recyclerview_rackss);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        rackList = new ArrayList<>();
//        adapter = new RackAdapter(this, rackList);
//
//        recyclerView.setAdapter(adapter);
//
//
//        db = FirebaseFirestore.getInstance();
////        db.collection("Rack List").addSnapshotListener(new EventListener<QuerySnapshot>() {
////            @Override
////            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
////
////                counter = documentSnapshots.size();
////                Toast.makeText(RacksActivity.this, counter+" Racks ", Toast.LENGTH_LONG).show();
////
////            }
////        });
//
////        db.collection("cities").get().then(function(querySnapshot) {
////            console.log(querySnapshot.size);
////        });
//        //   for (int z = 0; z < counter; z++) {
//        db.collection("Rack List").get()
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
//                                Coordinate c = d.toObject(Coordinate.class);
//                                c.setId(d.getId());
//                                rackList.add(c);
//
//
//                            }
//
//                            adapter.notifyDataSetChanged();
//
//                        }
//
//
//                    }
//
//                });
//
//    }
//    //adapter.notifyDataSetChanged();
//
//}
