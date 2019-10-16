package com.example.yash.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class add extends AppCompatActivity{
    private Button adding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        adding =(Button)findViewById(R.id.adding);
        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(add.this,add_item.class);
                startActivity(i);
            }
        });


    }
}
