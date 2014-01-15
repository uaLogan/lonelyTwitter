package ca.ualberta.cs.lonelytwitter;


public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LonelyTweetModel tweet)
	{
		return tweet.getTimestamp().toString() + " ||| " + tweet.getText();
	}

}
