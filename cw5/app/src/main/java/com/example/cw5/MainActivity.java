package com.example.cw5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int GALLERY_REQ_CODE = 1000;

    EditText name;
    EditText age ;
    Button next ;
    ImageView pic ;
    TextView upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         name = findViewById(R.id.PersonName);
         age = findViewById(R.id.PersonAge);
         next = findViewById(R.id.button1);
         pic = findViewById(R.id.image);
         upload = findViewById(R.id.Uploadimage);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent move = new Intent(MainActivity.this, secondScreen.class);

                String namee = name.getText().toString();
                int year = Integer.parseInt(age.getText().toString());


                move.putExtra("name",namee);
                move.putExtra("age",year);

                startActivity(move);
            }
        });



         //تفعيل الزر اذا تم ادخال البيانات وعدم تفعيله اذا لم يتم ادخال البيانات (بونص)

           TextWatcher info = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String myName = name.getText().toString();
                String myAge = age.getText().toString().trim();

                next.setEnabled(!myAge.isEmpty() && !myName.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        name.addTextChangedListener(info);
        age.addTextChangedListener(info);

        // السماح للمستخدم بتحميل صورة (بونص)

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picLoad = new Intent(Intent.ACTION_PICK);
                picLoad.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(picLoad,GALLERY_REQ_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK);{

            if (resultCode==GALLERY_REQ_CODE);

            pic.setImageURI(data.getData());
        }
    }
}