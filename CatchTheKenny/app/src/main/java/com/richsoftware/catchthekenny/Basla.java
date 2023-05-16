package com.richsoftware.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Basla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basla);
    }
    public void normal(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void hard(View view){
        Intent intent=new Intent(getApplicationContext(),Level2.class);
        startActivity(intent);
    }
}