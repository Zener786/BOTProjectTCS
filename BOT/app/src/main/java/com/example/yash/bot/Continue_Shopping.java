package com.example.yash.bot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Continue_Shopping extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue__shopping);
        b1=(Button)findViewById(R.id.NOPE);
        b2=(Button)findViewById(R.id.YUP);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Continue_Shopping.this, search_product.class);

                startActivity(i);
            }
        });
    }
}


