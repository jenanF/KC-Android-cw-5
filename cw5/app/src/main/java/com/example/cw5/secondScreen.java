package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);


        TextView n = findViewById(R.id.myName);
        TextView old = findViewById(R.id.myAge);
        Button back = findViewById(R.id.button2);
        ImageView photo = findViewById(R.id.picture);
        TextView hi = findViewById(R.id.firsttextView);

        Bundle profile = getIntent().getExtras();

        String na = profile.getString("name");
          n.setText(na);

          hi.setText("Hi! "+na);

        int agge = profile.getInt("age");
         old.setText(String.valueOf(agge));




         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent goBack = new Intent(secondScreen.this, MainActivity.class);

                 startActivity(goBack);
             }
         });





    }
}