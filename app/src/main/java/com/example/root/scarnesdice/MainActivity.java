package com.example.root.scarnesdice;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button roll,hold,reset,exit;
    TextView yourscore,computerscore,ys_tv,cs_tv,curr_score,curr_score_tv,comp_curr_score,comp_curr_score_tv;
    ImageView diceviewer;
    int currscore,totalscore,turn=0;
    int compchoice=0;
    int comp_total_score,compcurrscore;

    Random rand= new Random();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    diceviewer.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
                }
            }
        };


    public void roll(View view){

        int numberrolled=rand.nextInt(6)+1;

        if(numberrolled==1){
            diceviewer.animate().rotationBy(180f);
            diceviewer.setImageResource(R.drawable.dice1);
            currscore=0;
            totalscore+=currscore;
            turn=1;
            curr_score_tv.setText("0");

            ys_tv.setText(Integer.toString(totalscore));

            computerTurn();


        }
        if(numberrolled==2){

            diceviewer.animate().rotationBy(200f);
            diceviewer.setImageResource(R.drawable.dice2);
            currscore=2;
            curr_score_tv.setText("2");
            totalscore+=currscore;
            turn=0;
        }
        if(numberrolled==3){

            diceviewer.animate().rotationBy(200f);
            diceviewer.setImageResource(R.drawable.dice3);
            currscore=3;
            curr_score_tv.setText("3");
            totalscore+=currscore;
            turn=0;
        }
        if(numberrolled==4){

            diceviewer.animate().rotationBy(200f);
            diceviewer.setImageResource(R.drawable.dice4);
            currscore=4;
            curr_score_tv.setText("4");
            totalscore+=currscore;
            turn=0;
        }
        if(numberrolled==5){

            diceviewer.animate().rotationBy(200f);
            diceviewer.setImageResource(R.drawable.dice5);
            currscore=5;
            curr_score_tv.setText("5");
            totalscore+=currscore;
            turn=0;
        }
        if(numberrolled==6){

            diceviewer.animate().rotationBy(200f);
            diceviewer.setImageResource(R.drawable.dice6);
            currscore=6;
            curr_score_tv.setText("6");
            totalscore+=currscore;
            turn=0;
        }


    }

    public void hold(View view){

        ys_tv.setText(Integer.toString(totalscore));
        curr_score_tv.setText("0");
        cs_tv.setText(Integer.toString(comp_total_score));
        comp_curr_score_tv.setText("0");
        turn=1;


        computerTurn();

    }

    public void reset(View view){

        curr_score_tv.setText("0");
        currscore=0;
        ys_tv.setText("0");
        totalscore=0;
        cs_tv.setText("0");
        compcurrscore=0;
        comp_curr_score_tv.setText("0");
        comp_total_score=0;

        roll.setEnabled(true);
        hold.setEnabled(true);

    }

    public void exit(View view){

        moveTaskToBack(true);
        System.exit(1);

    }
    public void computerTurn(){

        roll.setEnabled(false);
        hold.setEnabled(false);


        while(true) {
            compchoice=rand.nextInt(6)+1;
            if (compchoice == 1) {
                break;
              }
            if (compchoice == 2) {

                diceviewer.setImageResource(R.drawable.dice2);
                compcurrscore = 2;
                comp_curr_score_tv.setText("2");
                comp_total_score += compcurrscore;
                turn = 1;

            }
            if (compchoice == 3) {

                diceviewer.setImageResource(R.drawable.dice3);
                compcurrscore = 3;
                comp_curr_score_tv.setText("3");
                comp_total_score += compcurrscore;
                turn = 1;
            }
            if (compchoice == 4) {

                diceviewer.setImageResource(R.drawable.dice4);
                compcurrscore = 4;
                comp_curr_score_tv.setText("4");
                comp_total_score += compcurrscore;
                turn = 1;
            }
            if (compchoice == 5) {

                diceviewer.setImageResource(R.drawable.dice5);
                compcurrscore = 5;
                comp_curr_score_tv.setText("5");
                comp_total_score += compcurrscore;
                turn = 1;
            }
            if (compchoice == 6) {

                diceviewer.setImageResource(R.drawable.dice6);
                compcurrscore = 6;
                comp_curr_score_tv.setText("6");
                comp_total_score += compcurrscore;
                turn = 1;
            }

            if (compcurrscore >= 20) {

                Toast.makeText(this, "Computer selected Hold, Your turn.", Toast.LENGTH_SHORT).show();
                roll.setEnabled(true);
                hold.setEnabled(true);
                break;
            }
        }
        if (compchoice == 1) {

            diceviewer.setImageResource(R.drawable.dice1);
            compcurrscore = 0;
            comp_total_score += compcurrscore;
            turn = 0;

            Toast.makeText(this, "Computer Rolled a 1! Your turn.", Toast.LENGTH_SHORT).show();

            cs_tv.setText(Integer.toString(comp_total_score));

            roll.setEnabled(true);
            hold.setEnabled(true);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll=(Button)findViewById(R.id.roll);
        hold=(Button)findViewById(R.id.hold);
        reset=(Button)findViewById(R.id.reset);
        exit=(Button)findViewById(R.id.exit);
        yourscore=(TextView)findViewById(R.id.yourscore);
        computerscore=(TextView)findViewById(R.id.computerscore);
        ys_tv=(TextView)findViewById(R.id.ys_tv);
        cs_tv=(TextView)findViewById(R.id.cs_tv);
        diceviewer=(ImageView)findViewById(R.id.diceview);
        comp_curr_score=(TextView)findViewById(R.id.curr_comp_score);
        comp_curr_score_tv=(TextView)findViewById(R.id.comp_curr_score_tv);
        curr_score=(TextView)findViewById(R.id.curr_score);
        curr_score_tv=(TextView)findViewById(R.id.curr_score_tv);
    }
}
