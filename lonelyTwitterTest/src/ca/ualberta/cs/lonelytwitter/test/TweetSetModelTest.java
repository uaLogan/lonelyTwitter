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
	
//	public void testCount()
//	{
//		/*
//		TweetSetModel tweets = new TweetSetModel();
//		
//		assertEquals("tweet set should start empty", 0, tweets.countTweets());
//		
//		tweets.addTweet(new NormalTweetModel("test"));
//		
//		assertEquals("added a tweet, count should be one", 1, tweets.countTweets());
//		*/
//		
//		ImportantTweetModel tweet1 = new ImportantTweetModel("test");
//		
//		try
//		{
//			Thread.sleep(2000);
//		} catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		ImportantTweetModel tweet2 = new ImportantTweetModel("test");
//		
//		//different time, same text
//		assertEquals("different timestamps", false, tweet1.equals(tweet2));
//		
//		//same time, same text
//		tweet2.setTimestamp(tweet1.getTimestamp());
//		assertEquals("same timestamps, same text", true, tweet1.equals(tweet2));
//		
//		//same time, different text
//		tweet2.setText("aaaa");
//		assertEquals("different text", false, tweet1.equals(tweet2));
//		
//		//different time, different text
//		ImportantTweetModel tweet3= new ImportantTweetModel("aaaa");
//		assertEquals("different both", false, tweet3.equals(tweet2));
//		
//		ImportantTweetModel tweet4 = new ImportantTweetModel("a");
//		NormalTweetModel tweet5 = new NormalTweetModel("a");
//		tweet4.setTimestamp(tweet5.getTimestamp());
//		
//		assertEquals("different class", false, tweet4.equals(tweet5));
//	}

	
	public void testGetTweets()
	{
		TweetSetModel setModel = new TweetSetModel();
		
		NormalTweetModel tweet1 = new NormalTweetModel("a");
		setModel.addTweet(tweet1);
		
		LonelyTweetModel tweets[] = setModel.getTweets();
		
		assertEquals("one tweet in list", tweets.length, 1);
		assertEquals("same tweet", true, tweets[0].equals(tweet1));
		assertEquals("same tweet", true, tweet1.equals(tweets[0]));
		
		NormalTweetModel tweet2 = new NormalTweetModel("b");
		NormalTweetModel tweet3 = new NormalTweetModel("c");
		
		setModel.addTweet(tweet2);
		setModel.addTweet(tweet3);
		
		tweets = setModel.getTweets();
		
		assertEquals("one tweet in list", tweets.length, 3);
		assertEquals("same tweet", true, tweets[1].equals(tweet2));
		assertEquals("same tweet", true, tweet3.equals(tweets[2]));
		
		NormalTweetModel tweet4 = new NormalTweetModel("d");
		NormalTweetModel tweet5 = new NormalTweetModel("d");
		tweet4.setTimestamp(tweet5.getTimestamp());
		
		setModel.addTweet(tweet4);
		
		try
		{
		setModel.addTweet(tweet5);
		fail("Expected excepton");
		}
		catch(IllegalArgumentException e)
		{	
			assertEquals("check exception message", "already added this tweet!", e.getMessage());
		}
		
	}
}
