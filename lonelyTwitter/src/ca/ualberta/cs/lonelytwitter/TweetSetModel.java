package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetSetModel
{
	private int count = 0;
	
	ArrayList<LonelyTweetModel> tweets = new ArrayList<LonelyTweetModel>();

	public Object countTweets()
	{
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel) throws IllegalArgumentException
	{
		for(LonelyTweetModel tweet : tweets)
		{
			if(tweet.equals(normalTweetModel))
				throw new IllegalArgumentException("already added this tweet!");
		}
		
		tweets.add(normalTweetModel);
		count++;
	}

	public LonelyTweetModel[] getTweets()
	{
		return tweets.toArray(new LonelyTweetModel[0]);
	}
}
