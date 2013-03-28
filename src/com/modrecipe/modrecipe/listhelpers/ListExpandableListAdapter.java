package com.modrecipe.modrecipe.listhelpers;

import java.util.ArrayList;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.R.id;
import com.modrecipe.modrecipe.R.layout;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Ingredient;
import com.modrecipe.modrecipe.objects.ShoppingCategory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Taken from: http://www.dreamincode.net/forums/topic/270612-how-to-get-started-with-expandablelistview/
 * 
 *
 */
public class ListExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ShoppingCategory> groups;
	public ListExpandableListAdapter(Context context, ArrayList<ShoppingCategory> groups) {
		this.context = context;
		this.groups = groups;
	}

	public void addItem(Ingredient item, ShoppingCategory group) {
		if (!groups.contains(group)) {
			groups.add(group);
		}
		int index = groups.indexOf(group);
		ArrayList<Ingredient> ch = groups.get(index).getIngredientList();
		ch.add(item);
		groups.get(index).setIngredientList(ch);
	}
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		final Ingredient child = (Ingredient) getChild(groupPosition, childPosition);
		child.setCategory(((ShoppingCategory)getGroup(groupPosition)).toString());
		
		if (view == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = infalInflater.inflate(R.layout.list_expandlist_child_item, null);
		}
		final TextView tv = (TextView) view.findViewById(R.id.tvChild);
		tv.setText(child.toString());
		
		tv.setTag(child.getTag());
		
		// TODO Pantry Feature
		//if (childPosition != 1) {
		//	tv.setCompoundDrawablesWithIntrinsicBounds((res.getDrawable(R.drawable.icon_pantry2_blank), null, null, null);
		//}
		//if (childPosition != 1) {
			tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		//}
				
		// Allows user to "strike" off items after they've been found
		if (child.Striked) {
			tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		} else {
			tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
		}
		
		// TODO Strikethrough feature
		tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	if (!child.Striked) { // strike text
            		tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            		child.setStriked(true);
            		
            		// Still buggy, but good enough
            		// Moves ShoppingCategory group to the bottom of the list
            		// if all the items in that group have been striked.
            		DataSingleton.getInstance().checkGroupToBottom(child);
            		
            	} else { // unstrike text
            		tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            		child.setStriked(false);
            		
            		// Still buggy, but good enough
            		// Moves ShoppingCategory group back to the top 
            		// if item unclicked and the group was on the bottom
            		DataSingleton.getInstance().checkGroupToTop(child);
            	}
            }
        });
    		
		return view;
	}

	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.size();

	}

	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groups.get(groupPosition);
	}

	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groups.size();
	}

	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		ShoppingCategory group = (ShoppingCategory) getGroup(groupPosition);
		if (view == null) {
			LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = inf.inflate(R.layout.list_expandlist_group_item, null);
		}
		TextView tv = (TextView) view.findViewById(R.id.tvGroup);
		tv.setText(group.getName());
		// TODO Auto-generated method stub
		return view;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}


