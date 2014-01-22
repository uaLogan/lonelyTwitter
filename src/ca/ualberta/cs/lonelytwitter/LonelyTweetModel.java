package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class LonelyTweetModel
{
	protected String text;
	protected Date timestamp;
	
	public LonelyTweetModel(String text, Date timestamp){
		super();
		this.text = text;
		this.timestamp = timestamp;
	}	
	
	public LonelyTweetModel(String text){
		this(text, new Date());
	}

	public String getText(){
		return text;
	}

	public abstract void setText(String text) throws Exception; 
	
	public Date getTimestamp(){
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public abstract boolean isImportant();
}