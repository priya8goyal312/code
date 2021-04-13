package com.example.careernavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Sign_up2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private int num;
    private Spinner selectClassSpinner; //variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        variableFinder();
//        INT A=20;

        ArrayAdapter<CharSequence> classAdapter= ArrayAdapter.createFromResource(this,R.array.classes, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        selectClassSpinner.setAdapter(classAdapter);

        selectClassSpinner.setOnItemSelectedListener(this);
    }

    private void variableFinder() {

//        num=3;
        selectClassSpinner=findViewById(R.id.selectClassSpinner);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String className=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), className, Toast.LENGTH_SHORT).show();
        //class
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}