/*
Name: Haris Sohail
Date: 08/14/2018
References:
https://github.com/twitter/twitter-kit-android/wiki/Show-Timelines
*/

package com.example.hso4.tweetme;

import android.app.ListActivity;
import android.os.Bundle;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TimelineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        //Obtain username of currently logged in user passed from intent
        String username = getIntent().getStringExtra("username");
        //Obtain all tweets from the user
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(username)
                .build();
        //Pass those tweets into the adapter
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build();
        setListAdapter(adapter);
    }
}