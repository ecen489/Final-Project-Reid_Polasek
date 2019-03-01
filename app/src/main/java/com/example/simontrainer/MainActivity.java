package com.example.simontrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int[][] moveArray;
    String[] listArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveArray = new int[0][0];
        listArray = new String[2];
        listArray[0] = "No data collected.";
        listArray[1] = "Play a game to collect some.";
    }

    public void launchGame(android.view.View a){
        Intent game = new Intent(this, gameActivity.class);
        startActivityForResult(game, 123);
    }

    public void launchReview(android.view.View a){
        Intent review = new Intent(this, reviewActivity.class);

        review.putExtra("array", listArray);
        startActivity(review);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 123) {
            Bundle bundle = intent.getExtras();
            moveArray = (int[][]) bundle.getSerializable("array");
            listArray = new String[0];
            for (int i = 0; i<moveArray.length; i++){
                String[] tempArray = new String[listArray.length+1];
                for (int j=0; j<listArray.length; j++){
                    tempArray[j] = listArray[j];
                }
                listArray = tempArray;

                if (moveArray[i][0]==1){
                    listArray[i]=Integer.toString(i+1)+". Red ("+Integer.toString(moveArray[i][1])+")";
                }
                else if (moveArray[i][0]==2){
                    listArray[i]=Integer.toString(i+1)+". Yellow ("+Integer.toString(moveArray[i][1])+")";
                }
                else if (moveArray[i][0]==3){
                    listArray[i]=Integer.toString(i+1)+". Green ("+Integer.toString(moveArray[i][1])+")";
                }
                else{
                    listArray[i]=Integer.toString(i+1)+". Blue ("+Integer.toString(moveArray[i][1])+")";
                }
            }
        }
    }
}
