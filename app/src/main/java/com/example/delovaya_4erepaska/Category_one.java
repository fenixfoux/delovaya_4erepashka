package com.example.delovaya_4erepaska;
//страница уже открытой выбраной категориии на первой странице
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Category_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);//тут указывается макет xml
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //старт:::обработка нажатия кнопки "назад"
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent (Category_one.this, MainActivity.class);
                    startActivity(intent);
                    finish();//закрытие окна
                }catch (Exception e){}
            }
        });
    }
    //старт:::системная кнопка назад
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent (Category_one.this, MainActivity.class);
            startActivity(intent);
            finish();//закрытие окна
        }catch (Exception e){}
    }
    //конец:::системная кнопка назад
}













































