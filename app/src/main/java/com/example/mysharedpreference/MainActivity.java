package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed3;
Button b1;
Switch switch2;
public static final String MyPREFERENCES="MyPrefs";
    public static final String Nombre="nombreKey";
    public static final String Psw ="emailKey";
    public static final String Guardado="noguardado";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Activity2.class);
        ed1=findViewById(R.id.editTextNombre);
        switch2=findViewById(R.id.switch1);
        ed3=findViewById(R.id.editTextPassword);
        b1=findViewById(R.id.button);
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String isShared = sharedPreferences.getString(Guardado,"");
        if(isShared.equals("guardado")) {
            startActivity(intent);
        }


b1.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View v)
    {

        

        String n = ed1.getText().toString();
        String e = ed3.getText().toString();

        if(switch2.isChecked()){
            if(!n.equals(sharedPreferences.getString(Nombre,""))||!e.equals(sharedPreferences.getString(Psw,""))){
                Toast.makeText(MainActivity.this,"Datos Incorrectos", Toast.LENGTH_LONG).show();
            }
        if(n.equals(sharedPreferences.getString(Nombre,""))&&e.equals(sharedPreferences.getString(Psw,""))){


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Guardado, "guardado");
                editor.commit();
            startActivity(intent);
            }

        }
        if(!switch2.isChecked()){
            if(!n.equals(sharedPreferences.getString(Nombre,""))||!e.equals(sharedPreferences.getString(Psw,""))){
                Toast.makeText(MainActivity.this,"Datos Incorrectos", Toast.LENGTH_LONG).show();
            }
            if(n.equals(sharedPreferences.getString(Nombre,""))&&e.equals(sharedPreferences.getString(Psw,""))){


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Guardado, "noguardado");
                editor.commit();
                startActivity(intent);
            }

        }


    }

});


}}