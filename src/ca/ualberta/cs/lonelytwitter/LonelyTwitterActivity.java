package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

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
	private ArrayAdapter<String> adapter;
	
	private ArrayList<String> tweets = new ArrayList<String>();
	private String textToAdd = "";
	
	private Gson gson;
	
	/** Called when the activity is first created. */
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
				textToAdd = bodyText.getText().toString();
				textToAdd = formatNewTweet(textToAdd);
				adapter.add(textToAdd);
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
			tweets = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}
	
	private String formatNewTweet(String text)
	{
		Date date = new Date(System.currentTimeMillis());
		return date.toString() + " | " + text;
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(isr);
			
/*			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}*/
			
			try
			{
				tweets = gson.fromJson(in, ArrayList.class);
			}
			catch(Exception e)
			{
				//Log.d("MyTag", "except_gen");
				tweets = new ArrayList<String>();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
			
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			//String textToWrite = date.toString() + " | " + text + "\n";
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}