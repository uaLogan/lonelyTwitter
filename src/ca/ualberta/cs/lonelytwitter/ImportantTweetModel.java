package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweetModel extends LonelyTweetModel
{
	public ImportantTweetModel(String text, Date timestamp)
	{
		super(text, timestamp);
	}

	public ImportantTweetModel(String text)
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
