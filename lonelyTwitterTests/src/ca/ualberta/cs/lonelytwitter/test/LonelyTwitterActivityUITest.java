package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
@SuppressLint("NewApi")
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	LonelyTwitterActivity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = (LonelyTwitterActivity)getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testAddTweet() throws Throwable{
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				ArrayAdapter<NormalTweetModel> adapter = activity.getAdapter();
				
				int size = adapter.getCount();
				
				makeTweet("hi there #testing");
				
				int newSize = adapter.getCount();
				
				assertEquals("Adapter size should have increased by one", size + 1, newSize);
				
				Object object = adapter.getItem(size);
				
				assertEquals("new thing in adapter should be NormalTweetModel", object.getClass(), NormalTweetModel.class);
				
				NormalTweetModel tweet = (NormalTweetModel) object;
				
				assertEquals("new NormalTweetModel should have the text we passed in", tweet.getText(), "hi there #testing");
				
				EditText body = activity.getBodyText();
				
				assertEquals("Body text should be cleared after making tweet", body.getText().toString(), "");
				
			}
		});
	}
	
	
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
