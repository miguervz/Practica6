package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
Button btn;
    public static final String MyPREFERENCES="MyPrefs";

    public static final String Guardado="noguardado";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btn=findViewById(R.id.button2);
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

   btn.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View v)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Guardado, "noguardado");
            editor.commit();
            Toast.makeText(Activity2.this,"Datos Borrados", Toast.LENGTH_LONG).show();


        }



    });}
}