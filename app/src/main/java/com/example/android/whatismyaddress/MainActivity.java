package com.example.android.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
     EditText emailText;
     Button saveEmailButton;
     Button openButton;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = (EditText) findViewById(R.id.emailText);
        saveEmailButton = (Button) findViewById(R.id.saveButton);
        openButton = (Button) findViewById(R.id.openButton);

        sp = getSharedPreferences("Address_Shared_Preferences", MODE_PRIVATE);

        saveEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("Address_Shared_Preferences", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.commit();

                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
                finish();
            }
        });
    }

    void loginCheck(){
        if(emailText.getText().toString().equals("Address_Shared_Preferences")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("Address_Shared_Preferences","");
            e.commit();
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
    }
}
}
