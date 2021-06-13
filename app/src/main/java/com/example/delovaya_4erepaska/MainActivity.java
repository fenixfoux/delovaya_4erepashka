package com.example.delovaya_4erepaska;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private long backPressedTime; //vremea najatia knopki nazad
    private Toast backToast;
    Dialog dialog;
    Dialog dialogEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //верхние кнопки основных категорий и переходы на другие страницы
        ImageView category_one = (ImageView)findViewById(R.id.category_one);
        category_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Category_one.class);
                    startActivity(intent);
                    finish();
                }catch(Exception e){
                    //error may be
                }
            }
        });

        //кнопка создания категории - старт
        Button new_category = (Button)findViewById(R.id.new_category);
        new_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog = new Dialog(this);
                //dialog.setContentView(R.layout.create_new_category);
            }
        });
        //кнопка создания категории - конец


        //кнопка выхода - старт
        Button button_exit = (Button)findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( backPressedTime + 2000 > System.currentTimeMillis()){
                    backToast.cancel();
                    finishAndRemoveTask();
                }else{
                    backToast = Toast.makeText(getBaseContext(), "press again for exit", Toast.LENGTH_SHORT);
                    backToast.show();
                }
                backPressedTime = System.currentTimeMillis();
            }
        });
        //кнопка выхода конец

    }

    @Override
    public void onBackPressed() {
        if( backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
        }else{
            backToast = Toast.makeText(getBaseContext(), "press again for exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}