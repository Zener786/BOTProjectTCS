package com.example.yash.bot;
/*
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class rack_entry extends AppCompatActivity {
    private DatabaseReference mDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        HashMap<String, String> map2 = (HashMap<String, String>) intent.getSerializableExtra("map1");


        Bundle extras= getIntent().getExtras();
        Collection<String> racks1 = extras.getStringArrayList("racks");


        for (String s : racks1 ) {
            Intent i = new Intent(rack_entry.this,rack_item_dialog.class);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

}
*/