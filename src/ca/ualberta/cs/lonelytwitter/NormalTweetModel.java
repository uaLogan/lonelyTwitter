package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class NormalTweetModel extends LonelyTweetModel
{

	public NormalTweetModel(String text, Date timestamp)
	{
		super(text, timestamp);
	}

	public NormalTweetModel(String text)
	{
		super(text);
	}

	@Override
	public void setText(String text) throws Exception
	{
		this.text = text;
	}

	@Override
	public boolean isImportant()
	{
		return false;
	}

}
