package com.example.simontrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class gameActivity extends AppCompatActivity {
    int[][] moveArray;
    boolean gameFinished = false;
    Intent intent;
    Bundle arrayBundle;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setup default return array
        moveArray = new int[1][2];
        moveArray[0][0]=1;
        moveArray[0][1]=0;
        intent = new Intent();
        arrayBundle = new Bundle();
        arrayBundle.putSerializable("array", moveArray);
        intent.putExtras(arrayBundle);
        intent.putExtra("arrayBundle", arrayBundle);
        setResult(RESULT_OK, intent);

        //Set onClickListeners for buttons
        Buttons buttonFragment = (Buttons) getSupportFragmentManager().findFragmentById(R.id.Buttons);
        buttonFragment.setup();
    }

    protected void logic(int buttonNo){
        /*moveArray = new int[4][2];
        moveArray[0][0]=1;
        moveArray[0][1]=0;
        moveArray[1][0]=2;
        moveArray[1][1]=1;
        moveArray[2][0]=3;
        moveArray[2][1]=2;
        moveArray[3][0]=4;
        moveArray[3][1]=3;*/

        if (buttonNo==1){
            Toast.makeText(this,"Red Button", Toast.LENGTH_SHORT).show();
        }
        else if (buttonNo==2){
            Toast.makeText(this,"Yellow Button", Toast.LENGTH_SHORT).show();
        }
        else if (buttonNo==3){
            Toast.makeText(this,"Green Button", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Blue Button", Toast.LENGTH_SHORT).show();
        }

        score = score+buttonNo;
        Score scoreFragment =(Score) getSupportFragmentManager().findFragmentById(R.id.ScoreID);
        scoreFragment.updateScore(score);

        //Buttons buttonFragment = (Buttons) getSupportFragmentManager().findFragmentById(R.id.Buttons);
        //buttonFragment.whiteout(1);

        //gameFinished = true;

        if (gameFinished){
            intent = new Intent();
            arrayBundle = new Bundle();
            arrayBundle.putSerializable("array", moveArray);
            intent.putExtras(arrayBundle);
            intent.putExtra("arrayBundle", arrayBundle);
            setResult(RESULT_OK, intent);
            Toast.makeText(this,"Game Over", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
