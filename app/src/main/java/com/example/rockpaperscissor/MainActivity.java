package com.example.rockpaperscissor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button r_rock,r_scissor,r_paper,button,button2;
    TextView textView4;
    ImageView imageView,imageView2;

    int HumanScore;
    int cs=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_paper = (Button) findViewById(R.id.r_paper);
        r_scissor = (Button) findViewById(R.id.r_scissor);
        r_rock = (Button) findViewById(R.id.r_rock);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        textView4 = (TextView) findViewById(R.id.textView4);
        button = (Button) findViewById(R.id.button) ;
        button2 = (Button)findViewById(R.id.button2);

        r_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.paper_p);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                textView4.setText("Human score: " + Integer.toString(HumanScore) +" Computer score: " + Integer.toString(cs));
                if (HumanScore==5 || cs==5 ){
                    endgame();

                }

            }
        });
        r_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.rock_p);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                textView4.setText("Human score: " + Integer.toString(HumanScore) +" Computer Score :" + Integer.toString(cs));
                if (HumanScore==5 || cs==5 ){
                    endgame();

                }

            }
        });
        r_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.scissor_p);
                String message = play_turn("scissor");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                textView4.setText("Human score: "+ Integer.toString(HumanScore) +" Computer score: " + Integer.toString(cs));
                if (HumanScore==5 || cs==5 ){
                    endgame();

                }


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to exit ?");
                builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HumanScore=0;
                cs=0;
                textView4.setText("Human score: "+ Integer.toString(HumanScore) +" Computer score: " + Integer.toString(cs));
            }
        });

        }
    public String play_turn (String pc){
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1){
            computer_choice = "rock";
            imageView2.setImageResource(R.drawable.rock_p);

        }else
        if (computer_choice_number == 2){
            computer_choice = "scissor";
            imageView2.setImageResource(R.drawable.scissor_p);
        }
        else
        if ( computer_choice_number == 3 ){
            computer_choice = "paper";
            imageView2.setImageResource(R.drawable.paper_p);

        }
        if (computer_choice == pc){
            return "Draw ";
        }
        else if (pc == "rock" && computer_choice == "scissor" ){
            HumanScore++;
            return " Rock crushes the Scissor ";
        }
        else if (pc == "rock" && computer_choice == "paper"){
            cs++;
            return " Paper covers Rock ";
        }
        else if (pc == "scissor" && computer_choice == "rock"){
            cs++;
            return " Rock crushes Scissor ";
        }
        else if ( pc == "scissor" && computer_choice == "paper"){
            HumanScore++;
            return " Scissors cuts the Paper ";
        }
        else if ( pc == "paper" && computer_choice == "rock"){
            HumanScore++;
            return " Paper covers Rock ";
        }
        else if ( pc == "paper" && computer_choice == "scissor"){
            cs++;
            return "Scissor cuts Paper ";
        }
        else return "Not sure";


    }
    public void endgame(){
        if (HumanScore==5){
            textView4.setText("****YOU WIN !****");
        }
        else
            textView4.setText("***COMPUTER WIN !***");
        HumanScore =0;
        cs =0;
        return;
    }
}