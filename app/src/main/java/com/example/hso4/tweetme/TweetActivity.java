/*
Name: Haris Sohail
Date: 08/14/2018
References:
https://github.com/twitter/twitter-kit-android/wiki/Compose-Tweets
*/

package com.example.hso4.tweetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;


public class TweetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obtain current user session
        final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                .getActiveSession();
        //Build new tweet composer activity, mobile native version
        final Intent intent = new ComposerActivity.Builder(TweetActivity.this)
                //Add in custom text and hashtag
                .session(session)
                .text(" ")
                .hashtags("#TweetMeCS496")
                .createIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        //Return to previous screen on stack when done
       finish();

    }
}