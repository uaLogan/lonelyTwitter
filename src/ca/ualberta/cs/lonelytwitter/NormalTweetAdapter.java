package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//Mostly adapted from http://stackoverflow.com/questions/2265661/how-to-use-arrayadaptermyclass
//Retrieved January 21, 2014

public class NormalTweetAdapter extends ArrayAdapter<NormalTweetModel>
{
	private Context context;

    public NormalTweetAdapter(Context context, int textViewResourceId, ArrayList<NormalTweetModel> items)
    {
        super(context, textViewResourceId, items);
        this.context = context;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        NormalTweetModel item = getItem(position);
        
        if (item!= null)
        {
            //only one TextView
            TextView itemView = (TextView) view.findViewById(R.id.oldTweetsText);
            if (itemView != null)
            {
                //format view
                itemView.setText(String.format("%s | %s", item.getTimestamp().toString(), item.getText()));
            }
         }

        return view;
    }
}
