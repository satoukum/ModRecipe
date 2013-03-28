package com.modrecipe.modrecipe.mealshelpers;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.objects.Recipe;

public class JunkAdapter<Recipe> extends ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> {

	private ArrayList<com.modrecipe.modrecipe.objects.Recipe> items;
    private Context context;

    public JunkAdapter(Context context, int layoutResourceId, int textViewResourceId, ArrayList<com.modrecipe.modrecipe.objects.Recipe> items) {
        super(context, layoutResourceId, textViewResourceId, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.meal_dialog_from_list, null);
        }

        com.modrecipe.modrecipe.objects.Recipe item2 = items.get(position);
        if (item2 != null) {
            // My layout has only one TextView
            TextView itemView = (TextView) view.findViewById(R.id.textView1);
            ImageView rscView = (ImageView) view.findViewById(R.id.imageView1);
            if (itemView != null) {
                // do whatever you want with your string and long
            	itemView.setText("" + item2.toString());
                //itemView.setText(String.format("%s %d", item.reason, item.long_val));
            }
            if (rscView != null) {
            	rscView.setImageResource(item2.getImageResource());
            }
         }

        return view;
    }
    
}
