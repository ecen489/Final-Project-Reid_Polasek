package com.example.simontrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchGame(android.view.View a){
        Intent game = new Intent(this, gameActivity.class);
        //startActivityForResult(game);
        startActivity(game);
    }

    public void launchReview(android.view.View a){
        Intent review = new Intent(this, reviewActivity.class);
        startActivity(review);
    }
}
