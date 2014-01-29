package ca.ualberta.cs.lonelytwitter;


public class TweetSetModel
{
	private int count = 0;

	public Object countTweets()
	{
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel)
	{
		count++;
	}

}
