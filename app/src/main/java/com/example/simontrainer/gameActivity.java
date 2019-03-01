package com.example.simontrainer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class gameActivity extends AppCompatActivity {
    int[][] moveArray;
    boolean gameFinished = false;
    Intent intent;
    Bundle arrayBundle;
    int score = 0;
    boolean started = false;
    Random r = new Random();
    int guessLocation = 0;
    int numFails = 0;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setup default return array
        moveArray = new int[1][2];
        moveArray[0][0]=0;
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

        //Prompt user for input
        Toast.makeText(this,"Press any button to start", Toast.LENGTH_SHORT).show();
    }

    protected void logic(int buttonNo){
        musicPlayer(buttonNo);

        if (!started){
            moveArray[0][0]=r.nextInt(4)+1;
            started = true;
            colorDecoder(moveArray[0][0]);
        }
        else{
            //
            if (buttonNo == moveArray[guessLocation][0]){
                guessLocation = guessLocation+1;
                if (guessLocation >= moveArray.length){
                    guessLocation = 0;
                    Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show();
                    //player = MediaPlayer.create(this,R.raw.aggiewarhymn);
                    numFails = 0;
                    score = score+1;
                    Score scoreFragment =(Score) getSupportFragmentManager().findFragmentById(R.id.ScoreID);
                    scoreFragment.updateScore(score);
                    newNum();
                }
            }
            else {
                moveArray[guessLocation][1]=moveArray[guessLocation][1]+1;
                guessLocation = 0;
                Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show();
                numFails = numFails + 1;
            }
        }

        if (numFails > 2){
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

    protected void newNum(){
        int[][] tempArray = new int[moveArray.length+1][2];
        for (int i=0; i<moveArray.length; i++){
            tempArray[i][0] = moveArray[i][0];
            tempArray[i][1] = moveArray[i][1];
        }
        tempArray[moveArray.length][1] = 0;
        moveArray = tempArray;
        moveArray[moveArray.length-1][0] = r.nextInt(4)+1;

        for (int i = 0; i<moveArray.length; i++){
            colorDecoder(moveArray[i][0]);
        }
    }

    protected void colorDecoder(int color){
        if (color==1){
            Toast.makeText(this,"Red Button", Toast.LENGTH_SHORT).show();
        }
        else if (color==2){
            Toast.makeText(this,"Yellow Button", Toast.LENGTH_SHORT).show();
        }
        else if (color==3){
            Toast.makeText(this,"Green Button", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Blue Button", Toast.LENGTH_SHORT).show();
        }
    }

    protected void musicPlayer(int tune){
        if(player != null){
            if(player.isPlaying()){
                player.stop();
            }
            player.release();
        }
        if (tune==1){
            player = MediaPlayer.create(this,R.raw.pianoa);//Red note
        }
        else if (tune==2){
            player = MediaPlayer.create(this,R.raw.pianoc);//Yellow note
        }
        else if (tune==3){
            player = MediaPlayer.create(this,R.raw.lowe);//Green note
        }
        else{
            player = MediaPlayer.create(this,R.raw.pianoe);//Blue note
        }
        player.start();
    }
}
