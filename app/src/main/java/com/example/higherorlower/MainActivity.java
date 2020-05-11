/*
    -----------------------------------------------------------------------------------------------
    Higher Or Lower Application
    -----------------------------------------------------------------------------------------------
    Version 1.0
    Author: Parth Sharma
    Date: 10-05-20
    -----------------------------------------------------------------------------------------------
    Application Brief:
    The way this app works is that the app initially selects a random number between 1 and 20. The
    user is supposed to guess numbers and submit, while the app prompts with a toast whether the
    random number is higher, lower, or equal to the random selection.

    Once the number has been guessed, a new random number is selected and the game starts again.
    -----------------------------------------------------------------------------------------------
 */

package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    // method to cross-check user input with number selected by app
    public void checkNumber (View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);

        int guessValue = Integer.parseInt(editText.getText().toString());

        if (guessValue > randomNumber)
        {
            Toast.makeText(this, "Lower!",Toast.LENGTH_LONG).show();
            ImageView image = (ImageView) findViewById(R.id.imgbox);
            image.setImageResource(R.drawable.lower1);
        }

        if (guessValue < randomNumber)
        {
            Toast.makeText(this, "Higher!",Toast.LENGTH_LONG).show();
            ImageView image = (ImageView) findViewById(R.id.imgbox);
            image.setImageResource(R.drawable.higher1);
        }

        if (guessValue == randomNumber)
        {
            Toast.makeText(this, "Congratulations! It was "+randomNumber+"! Try again!!",Toast.LENGTH_LONG).show();
            ImageView image = (ImageView) findViewById(R.id.imgbox);
            image.setImageResource(R.drawable.guessnum1);
            randomNumber = generateRandom();
        }
    }

    // method to generate random number
    public int generateRandom()
    {
       Random rand = new Random();

       // upper limit 20, lower limit 1
       int n = rand.nextInt(20) + 1;

       return n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = generateRandom();
    }
}
