package com.example.simontrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Score extends Fragment {
    TextView scoreNum;

    public Score() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    void updateScore(int newScore){
        scoreNum = (TextView) getView().findViewById(R.id.scoreNum);
        scoreNum.setText(Integer.toString(newScore));
    }

}
