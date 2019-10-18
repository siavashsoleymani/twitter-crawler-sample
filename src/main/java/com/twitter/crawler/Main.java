package com.twitter.crawler;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) throws TwitterException, InterruptedException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("xxxxxxxxxxxxxxxxxxxxxxxxx")
                .setOAuthConsumerSecret("xxxxxxxxxxxxxxxxxxxxxx")
                .setOAuthAccessToken("xxxxxxxxxxxxxxxxxxxxxxxx")
                .setOAuthAccessTokenSecret("xxxxxxxxxxxxxxxxxxxxxxxx");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline(new Paging(1, 20));
        System.out.println(homeTimeline.size());
        for (Status status : homeTimeline) {
            if (status.getText().contains("ام")) {
                System.out.println(status.getText());
            }
        }

    }
}
