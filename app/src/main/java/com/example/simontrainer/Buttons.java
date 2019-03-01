package com.example.simontrainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Buttons extends Fragment {


    public Buttons() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }

    public void whiteout(int buttonNo){
        if (buttonNo == 1){
            //scoreNum = (TextView) getView().findViewById(R.id.scoreNum);
            Button colorButton = (Button) getView().findViewById(R.id.redButton);
            colorButton.setVisibility(View.INVISIBLE);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            colorButton.setVisibility(View.VISIBLE);
        }
    }

    public void setup(){
        //Set onClickListeners for buttons
        Button rB = (Button) getView().findViewById(R.id.redButton);
        rB.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Toast.makeText(getActivity(),"Red Button", Toast.LENGTH_SHORT).show();
                ((gameActivity)getActivity()).logic(1);
            }
        });
        Button yB = (Button) getView().findViewById(R.id.yellowButton);
        yB.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Toast.makeText(getActivity(),"Yellow Button", Toast.LENGTH_SHORT).show();
                ((gameActivity)getActivity()).logic(2);
            }
        });
        Button gB = (Button) getView().findViewById(R.id.greenButton);
        gB.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Toast.makeText(getActivity(),"Green Button", Toast.LENGTH_SHORT).show();
                ((gameActivity)getActivity()).logic(3);
            }
        });
        Button bB = (Button) getView().findViewById(R.id.blueButton);
        bB.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Toast.makeText(getActivity(),"Blue Button", Toast.LENGTH_SHORT).show();
                ((gameActivity)getActivity()).logic(4);
            }
        });
    }
}
