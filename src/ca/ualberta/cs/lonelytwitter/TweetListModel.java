package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListModel
{
	private ArrayList<LonelyTweetModel> list;
	
	public ArrayList<LonelyTweetModel> getList()
	{
		return list;
	}

	public void setList(ArrayList<LonelyTweetModel> list)
	{
		this.list = list;
	}
}
