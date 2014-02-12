package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public IntentReaderActivityTests()
	{
		super(IntentReaderActivity.class);
	}

	public void testSendText()
	{
	Intent intent = new Intent();
	String text = "hello";
	intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
	setActivityIntent(intent);
	IntentReaderActivity activity = getActivity();
	
	assertNotNull(activity);
	assertEquals("IntentReaderActivity should get text from intent", text, activity.getText());
	}
	
	public void testDoubleText()
	{
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivity should get doubled text from intent", text + text, activity.getText());
	}
	
	public void testDisplayTest()
	{
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		TextView textview = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertEquals("IntentReaderActivity should get text from TextView", text, textview.getText().toString());
	}
	
}
