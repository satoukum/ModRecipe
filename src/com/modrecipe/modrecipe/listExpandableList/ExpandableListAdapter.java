package com.modrecipe.modrecipe.listExpandableList;

import java.util.ArrayList;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.RecipeActivity;
import com.modrecipe.modrecipe.R.id;
import com.modrecipe.modrecipe.R.layout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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
public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ExpandableListGroup> groups;
	public ExpandableListAdapter(Context context, ArrayList<ExpandableListGroup> groups) {
		this.context = context;
		this.groups = groups;
	}
	
	public void addItem(ExpandableListChild item, ExpandableListGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
		}
		int index = groups.indexOf(group);
		ArrayList<ExpandableListChild> ch = groups.get(index).getItems();
		ch.add(item);
		groups.get(index).setItems(ch);
	}
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		ArrayList<ExpandableListChild> chList = groups.get(groupPosition).getItems();
		return chList.get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		final ExpandableListChild child = (ExpandableListChild) getChild(groupPosition, childPosition);
		child.setExpandableListGroup((ExpandableListGroup)getGroup(groupPosition));
		
		if (view == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = infalInflater.inflate(R.layout.expandlist_child_item, null);
		}
		final TextView tv = (TextView) view.findViewById(R.id.tvChild);
		tv.setText(child.getName().toString());
		tv.setTag(child.getTag());
		//System.out.println("child: " + child.getName() + "... is striked? " + child.getStriked());
		
		// TODO fix up srikethrough to make less messy!!
		if (child.isStriked()) {
			tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		} else {
			tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
		}
		
		// TODO Strikethrough feature
		tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if (!child.isStriked()) { // strike text
            		tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            		
            		child.setStrike(true);
            		
            		//TODO add method to collapse groups once everything is selected
            		boolean moveToBottom = true;
            		for (ExpandableListChild elc : child.getExpandableListGroup().getItems()) {
            			if (!elc.isStriked()) {
            				System.out.println("child striked: " + elc.isStriked());
            				moveToBottom = false;
            			}
            		}
            		if (moveToBottom) {
            			//System.out.println("Need to figure out how to move down the list...");
            		}
            		
            	} else { // unstrike text
            		tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            		child.setStrike(false);
            	}
            }
        });
    		
		// TODO Auto-generated method stub
		return view;
	}

	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		ArrayList<ExpandableListChild> chList = groups.get(groupPosition).getItems();
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
		ExpandableListGroup group = (ExpandableListGroup) getGroup(groupPosition);
		if (view == null) {
			LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = inf.inflate(R.layout.expandlist_group_item, null);
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


