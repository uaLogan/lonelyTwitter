package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
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
		
		double c = 0;
		while(c < 800000000.0)
		{
			double a = 2.4;
			double b = 2.6;
			c += a*b;
		}
		
		ImportantTweetModel tweet2 = new ImportantTweetModel("test");
		
		//different time, same text
		assertEquals("different timestamps", tweet1.equals(tweet2), false);
		
		//same time, same text
		tweet2.setTimestamp(tweet1.getTimestamp());
		assertEquals("same timestamps, same text", tweet1.equals(tweet2), true);
		
		//same time, different text
		tweet2.setText("aaaa");
		assertEquals("different text", tweet1.equals(tweet2), false);
		
		//different time, different text
		ImportantTweetModel tweet3= new ImportantTweetModel("aaaa");
		assertEquals("different both", tweet3.equals(tweet2), false);
		
		//assertEquals("same text", tweet1.getText(), tweet2.getText());
		
		//assertEquals("should be the same now", tweet1.equals(tweet2), true);
	}

}
