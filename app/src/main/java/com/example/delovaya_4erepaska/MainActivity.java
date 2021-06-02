package com.example.delovaya_4erepaska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //верхние кнопки основных категорий и переходы на другие страницы
        ImageView category_one = (ImageView)findViewById(R.id.category_one);
        category_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Layout_category_one.class);
                    startActivity(intent);
                    finish();
                }catch(Exception e){
                    //error may be
                }
            }
        });

        //Button bt_category_one = (Button)findViewById(R.id.category_one);
    }
}