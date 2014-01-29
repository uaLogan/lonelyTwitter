package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;
import android.test.ActivityInstrumentationTestCase2;


public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public TweetSetModelTest()
	{

		super(LonelyTwitterActivity.class);
	}
	
	public void testCount()
	{
		TweetSetModel tweets = new TweetSetModel();
		
		assertEquals("tweet set should start empty", 0, tweets.countTweets());
		
		tweets.addTweet(new NormalTweetModel("test"));
		
		assertEquals("added a tweet, count should be one", 1, tweets.countTweets());
	}

}
