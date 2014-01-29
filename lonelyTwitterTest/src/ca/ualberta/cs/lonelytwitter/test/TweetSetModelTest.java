package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
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
		/*
		TweetSetModel tweets = new TweetSetModel();
		
		assertEquals("tweet set should start empty", 0, tweets.countTweets());
		
		tweets.addTweet(new NormalTweetModel("test"));
		
		assertEquals("added a tweet, count should be one", 1, tweets.countTweets());
		*/
		
		ImportantTweetModel tweet1 = new ImportantTweetModel("test");
		
		//stall for time
		double c = 0;
		while(c < 800000000.0)
		{
			double a = 2.4;
			double b = 2.6;
			c += a*b;
		}
		
		ImportantTweetModel tweet2 = new ImportantTweetModel("test");
		
		//different time, same text
		assertEquals("different timestamps", false, tweet1.equals(tweet2));
		
		//same time, same text
		tweet2.setTimestamp(tweet1.getTimestamp());
		assertEquals("same timestamps, same text", true, tweet1.equals(tweet2));
		
		//same time, different text
		tweet2.setText("aaaa");
		assertEquals("different text", false, tweet1.equals(tweet2));
		
		//different time, different text
		ImportantTweetModel tweet3= new ImportantTweetModel("aaaa");
		assertEquals("different both", false, tweet3.equals(tweet2));
		
		ImportantTweetModel tweet4 = new ImportantTweetModel("a");
		NormalTweetModel tweet5 = new NormalTweetModel("a");
		tweet4.setTimestamp(tweet5.getTimestamp());
		
		assertEquals("different class", false, tweet4.equals(tweet5));
	}

}
