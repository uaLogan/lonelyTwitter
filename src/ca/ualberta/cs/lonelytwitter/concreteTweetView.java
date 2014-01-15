package ca.ualberta.cs.lonelytwitter;


public class concreteTweetView implements tweetView
{

	public String formatTweet(lonelyTweetModel tweet)
	{
		return tweet.getTimestamp().toString() + " | " + tweet.getText();
	}

}
