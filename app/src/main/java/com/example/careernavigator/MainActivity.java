package com.example.careernavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() { // mujhe kya run karna hai and time
            @Override
            public void run()
            {
                Intent goToSininPage = new Intent(MainActivity.this,SignIn.class);   // yaha par time lagay hai ki 3000 mili sec me means 3 sec me mainactivity se singin page par jayge
                startActivity(goToSininPage);
            }
        },3000);

    }
}