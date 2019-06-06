package com.example.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TwitterActivity extends AppCompatActivity{

    private ListView tweetList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("0tauDT6cxwdGQ054c2BH1XEf9", "hGGso4CbEPFlIHaCq05LveymIvaWEGElls7f1RQSIVzOlk3BGa"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        setContentView(R.layout.activity_twitter);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("UCRTAPS")
                .build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        tweetList = findViewById(R.id.tweets);
        tweetList.setAdapter(adapter);



    }
}
