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
	public void setText(String text) throws Exception
	{
		if(text.equals("")){throw new IllegalArgumentException();}
		
		this.text = text;
	}

	@Override
	public boolean isImportant()
	{
		return true;
	}
}
