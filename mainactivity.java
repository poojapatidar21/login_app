package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.etname);
        password = (EditText)findViewById(R.id.etpass);
        info = (TextView)findViewById(R.id.tvinfo);
        login = (Button)findViewById(R.id.btnlogin);

        info.setText("no. of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(name.getText().toString(),password.getText().toString());
            }

        });

    }
    private void validate(String username, String userpassword){
        if((username.equals("sarthak")) & ( userpassword.equals("456"))){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("no. of attempt remaining:" +String.valueOf(counter));

            if (counter==0) {
                login.setEnabled(false);
            }
        }
    }
}

