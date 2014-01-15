package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class normalTweetModel extends lonelyTweetModel
{

	public normalTweetModel(String text, Date timestamp)
	{
		super(text, timestamp);
	}

	public normalTweetModel(String text)
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
