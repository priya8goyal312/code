package com.example.careernavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    // jo id vaha par liki thi uske liye variable assisg karenge

    private TextView signUpTextView;  // ye sirf declare kiya hai

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // onCretae method same as main metod hoti hai jo ki sabse pahle run hoti hai
        // so us variable ko yaha par get karenge xml file se

        signUpTextView=findViewById(R.id.signUpTextView); // yaha par usko xml file se finde kar liya hai with the help of findviewby id method se

        // ab us par clcik kare to khuch action ho uske liye click lishner use karte hai

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // ab is method ke ander jo action karna ho vo kar sakte hai

                Intent goToSigUpPage=new Intent(SignIn.this,Sign_up.class);
                startActivity(goToSigUpPage);

            }
        });



    }
}