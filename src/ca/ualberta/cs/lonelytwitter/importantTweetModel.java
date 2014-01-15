package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class importantTweetModel extends lonelyTweetModel
{
	public importantTweetModel(String text, Date timestamp)
	{
		super(text, timestamp);
	}

	public importantTweetModel(String text)
	{
		super(text);
	}
	
	@Override
	public void setText(String text)
	{
		this.text = text;
	}
}
