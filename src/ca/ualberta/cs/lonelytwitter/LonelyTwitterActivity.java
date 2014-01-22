package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private NormalTweetAdapter adapter;
	
	private ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
	private NormalTweetModel tweetToAdd;
	
	private Gson gson;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				tweetToAdd = new NormalTweetModel(bodyText.getText().toString());
				adapter.add(tweetToAdd);
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});
		
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				adapter.clear();
				adapter.notifyDataSetChanged();
				
				try
				{
					openFileOutput(FILENAME,
							Context.MODE_PRIVATE);
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		gson = new GsonBuilder().create();
	}

	@Override
	protected void onResume() {
		super.onStart();
		loadFromFile();
		if(tweets == null)
			tweets = new ArrayList<NormalTweetModel>();
		adapter = new NormalTweetAdapter(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}
	
	private String formatNewTweet(String text)
	{
		Date date = new Date(System.currentTimeMillis());
		return date.toString() + " | " + text;
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(isr);
			
			try
			{ 
				Type myType = new TypeToken<ArrayList<NormalTweetModel>>(){}.getType();
				tweets = gson.fromJson(in, myType);
			}
			catch(Exception e)
			{
				//Log.d("MyTag", "except_gen");
				tweets = new ArrayList<NormalTweetModel>();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void saveInFile() {
		try {
			
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}