package com.example.simontrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class reviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        /*String[] listArray = new String[20];
        listArray[0] = "2 spooky";
        listArray[1] = "4 me";
        listArray[2] = "3 spooky";
        listArray[3] = "5 me";
        listArray[4] = "2 spooky";
        listArray[5] = "4 me";
        listArray[6] = "3 spooky";
        listArray[7] = "5 me";
        listArray[8] = "2 spooky";
        listArray[9] = "4 me";
        listArray[10] = "3 spooky";
        listArray[11] = "5 me";
        listArray[12] = "2 spooky";
        listArray[13] = "4 me";
        listArray[14] = "3 spooky";
        listArray[15] = "5 me";
        listArray[16] = "2 spooky";
        listArray[17] = "4 me";
        listArray[18] = "3 spooky";
        listArray[19] = "5 me";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listArray);
        ListView listv = (ListView) findViewById(R.id.list1);
        listv.setAdapter(adapter);
        int a = 1;*/
        Intent array = getIntent();
        String[] listArray = array.getStringArrayExtra("array");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listArray);
        ListView list = (ListView) findViewById(R.id.list1);
        list.setAdapter(adapter);
    }
}
