package com.example.careernavigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Sign_up extends AppCompatActivity {

    // ye sab variables hai
    private EditText registerName;
    private EditText registerUsername;
    private EditText registerEmail;
    private EditText registerNumber;
    private EditText registerPassword;

    private Button registerBtn;
    private TextView alredyAccountBtn;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initilizer();// this ismethod which help to identify varibles from our xml file

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checkValidation();
            }
        });

    }

    private void initilizer() {

        registerName=findViewById(R.id.registerName);
        registerUsername=findViewById(R.id.registerUsername);
        registerEmail=findViewById(R.id.registerEmail);
        registerNumber=findViewById(R.id.registerNumber);
        registerPassword=findViewById(R.id.registerPassword);

        registerBtn=findViewById(R.id.registerBtn);
        alredyAccountBtn=findViewById(R.id.alredyAccountBtn);  // te sare varaibles xml file se cannted ho gaye hai
        progressBar=findViewById(R.id.progressbar);

        //firebase auth
        firebaseAuth=FirebaseAuth.getInstance();

    }

    private void checkValidation()
    {
        final String name=registerName.getText().toString();
        String pass=registerPassword.getText().toString();
        String phone=registerNumber.getText().toString();
        String username=registerUsername.getText().toString();
        final String mail=registerEmail.getText().toString();

        if (TextUtils.isEmpty(name))
        {
            registerName.setError("Enter Name");
        }
        else if (TextUtils.isEmpty(pass))
        {
            registerPassword.setError("Enter Password");
        }
        else if (TextUtils.isEmpty(phone))
        {
            registerNumber.setError("Enter Mobile Number");
        }
        else if (TextUtils.isEmpty(mail))
        {
            registerEmail.setError("Enter Email");
        }
        else if (!(pass.length()>=6))
        {
            Toast.makeText(Sign_up.this,"Password must be more than 6",Toast.LENGTH_SHORT).show();
        }
        else if (!(pass.length()>=6))
        {
            Toast.makeText(Sign_up.this,"Password must be more than 6",Toast.LENGTH_SHORT).show();
        }
        else if (!(registerNumber.getText().length()==10))
        {
            Toast.makeText(Sign_up.this,"Mobile Number must be 10",Toast.LENGTH_SHORT).show();
        }
        else if (!(registerEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")))
        {
            registerEmail.setError("Enter Valid email");
        }
        else
        {
            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.createUserWithEmailAndPassword(registerEmail.getText().toString(),registerPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            //store data in firebasefirestore
                            if(task.isSuccessful())
                            {
                                FirebaseDatabase rootNode=FirebaseDatabase.getInstance();
                                DatabaseReference reference=rootNode.getReference("User");

                                UserRegisterHelper helper=new UserRegisterHelper(name,username,mail,phone,pass);
                                reference.child(phone).setValue(helper);
                            }
                            else
                            {
                                progressBar.setVisibility(View.INVISIBLE);
                                String error=task.getException().getMessage();
                                Toast.makeText(Sign_up.this,error,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }


}