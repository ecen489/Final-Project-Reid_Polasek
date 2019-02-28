package com.example.simontrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class gameActivity extends AppCompatActivity {
    int[][] moveArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        moveArray = new int[4][2];
        setup();
    }

    protected void setup(){
        moveArray[0][0]=1;
        moveArray[0][1]=0;
        moveArray[1][0]=2;
        moveArray[1][1]=1;
        moveArray[2][0]=3;
        moveArray[2][1]=2;
        moveArray[3][0]=4;
        moveArray[3][1]=3;

        Intent intent = new Intent();
        Bundle arrayBundle = new Bundle();
        arrayBundle.putSerializable("array", moveArray);
        intent.putExtras(arrayBundle);
        intent.putExtra("arrayBundle", arrayBundle);
        setResult(RESULT_OK, intent);
    }
}
