/*
Name: Haris Sohail
Date: 08/14/2018
References:
https://github.com/twitter/twitter-kit-android/wiki/Log-In-with-Twitter
*/

package com.example.hso4.tweetme;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;



public class MainActivity extends AppCompatActivity {
    //Creates a login button that utilizes oauth
    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize the session and set layout
        if(getIntent().getStringExtra("logOut") != null)
        {
            Toast.makeText(MainActivity.this, "Switching Accounts", Toast.LENGTH_LONG).show();
        }
        Twitter.initialize(this);
        setContentView(R.layout.activity_main);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            //Upon session authorization the API can now be accessed
            public void success(Result<TwitterSession> result) {
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                String username = session.getUserName();
                Intent intent = new Intent(MainActivity.this, HubActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }

            @Override
            //Display error message for failure
            public void failure(TwitterException exception) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Authentication result is passed back to the button to handle
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
