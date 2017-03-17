package com.myactivity.dilyana.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button menu;
    private Button help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = (Button) findViewById(R.id.menu);
        help = (Button) findViewById(R.id.help);
        menu.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == menu.getId()){
            startActivity(new Intent(this, MenuActivity.class));
        }
        else if(v.getId() == help.getId()){
            startActivity(new Intent(this, HelpActivity.class));
        }
    }
}

