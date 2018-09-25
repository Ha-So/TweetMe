/*
Name: Haris Sohail
Date: 08/14/2018
References:
*/


package com.example.hso4.tweetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Creates a main hub of buttons to lead to various activities
public class HubActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        //Obtain username passed by main activity
        final String username = getIntent().getStringExtra("username");
        Button timelineAct = (Button) findViewById(R.id.button_timeline);
        timelineAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pass username to TimelineActivity
                Intent intent = new Intent(HubActivity.this, TimelineActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        //Compose a custom tweet
        Button tweetAct = (Button) findViewById(R.id.button_tweet);
        tweetAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HubActivity.this, TweetActivity.class);
                startActivity(intent);

            }
        });

        //Tweet out your numeric lat and lon coordinates
        Button tweetGPSAct = (Button) findViewById(R.id.button_tweet_gps);
        tweetGPSAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HubActivity.this, GPSActivity.class);
                startActivity(intent);


            }
        });

        //Tweet out a written address of your current location
        Button tweetLocAct = (Button) findViewById(R.id.button_tweet_add);
        tweetLocAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HubActivity.this, TweetAddActivity.class);
                startActivity(intent);


            }
        });

        //Logout or switch accounts
        Button logoutAct = (Button) findViewById(R.id.button_logout);
        logoutAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HubActivity.this, MainActivity.class);
                intent.putExtra("logOut","logOut");
                startActivity(intent);


            }
        });

    }
}
