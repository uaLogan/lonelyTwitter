package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListController
{
	private static TweetListModel tweetListModel = null;

	public TweetListController()
	{
		super();
		if(tweetListModel.equals(null))
			tweetListModel = new TweetListModel();
	}
	
	public void addTweet(String text)
	{
		LonelyTweetModel tweet;
		tweet = new NormalTweetModel(text);
		ArrayList<LonelyTweetModel> list = tweetListModel.getList();
		list.add(tweet);
	}
}
