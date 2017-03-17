package com.myactivity.dilyana.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == home.getId()){
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(HelpActivity.this, "You pressed the home button", Toast.LENGTH_SHORT).show();
        }
    }
}
