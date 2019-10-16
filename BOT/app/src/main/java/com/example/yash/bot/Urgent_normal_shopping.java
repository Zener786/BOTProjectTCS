package com.example.yash.bot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Urgent_normal_shopping extends AppCompatActivity {
Button b1,b2;
    Intent i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_normal_shopping);
     b1 = (Button)findViewById(R.id.urgentshopping);
     b2 = (Button)findViewById(R.id.normalshopping);


     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
              i2 = new Intent(Urgent_normal_shopping.this,search_product.class);
             startActivity(i2);
         }
     });
    b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i2 = new Intent(Urgent_normal_shopping.this,search_product.class);
                startActivity(i2);
            }
        });

    }
}
